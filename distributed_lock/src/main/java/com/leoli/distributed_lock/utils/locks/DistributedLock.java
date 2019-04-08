package com.leoli.distributed_lock.utils.locks;


import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class DistributedLock implements Lock<Long> {


    private ValueOperations<String, Object> operations;

    private RedisTemplate<String, Object> redisTemplate;


    private RedissonClient redissonClient;

    public void setTryTime(int tryTime) {
        this.tryTime = tryTime;
    }

    private int tryTime = 0;

    @Autowired
    public DistributedLock(RedisTemplate<String, Object> redisTemplate, RedissonClient redissonClient) {
        this.redisTemplate = redisTemplate;
        operations = redisTemplate.opsForValue();
        this.redissonClient = redissonClient;
    }

    @Override
    public boolean Lock(String key, Long time) {
        long expireTime = System.currentTimeMillis() + time;
        int curTryTime = 0 ;
        while (!operations.setIfAbsent(key, expireTime)){

            if(curTryTime != 0 && ++curTryTime > tryTime){
                break;
            }
            Long curExpireTime = (Long) operations.get(key);
            if(curExpireTime != null){
                if(System.currentTimeMillis() > curExpireTime){
                    long oldExpireTime  = (long) operations.getAndSet(key, expireTime);
                    if(oldExpireTime == curExpireTime){
                        break;
                    }
                }
            }
            expireTime = System.currentTimeMillis() + time;
        }
        return curTryTime <= tryTime;
    }

    @Override
    public boolean unLock(String key) {
        long exprieTime = Long.parseLong(String.valueOf(operations.get(key)));
        if(exprieTime > System.currentTimeMillis()){
            redisTemplate.delete(key);
        }
        return true;
    }

    public void lockByRedisson(String key, int time) {
        RLock rLock = redissonClient.getLock(key);
        rLock.lock(time, TimeUnit.SECONDS);
    }

    public void unlockByRedisson(String key) {
        RLock rLock = redissonClient.getLock(key);
        rLock.unlock();
    }
}
