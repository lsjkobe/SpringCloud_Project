package com.leoli.distributed_lock.services;

import com.leoli.distributed_lock.utils.RedisUtil;
import com.leoli.distributed_lock.utils.locks.DistributedLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpikeService {

    @Autowired
    DistributedLock distributedLock;


    @Autowired
    RedisUtil redisUtil;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    public boolean spike(String id) {
        long startTime1 = System.currentTimeMillis();
//        distributedLock.lockByRedisson("spike-resource", 5);
        distributedLock.Lock("spike-resource", 5000L);
        long endTime1 = System.currentTimeMillis();

//        RLock rLock = redissonClient.getLock("spike-resource");
//        rLock.lock(10, TimeUnit.SECONDS);

        int count = (int) redisUtil.get(id);
        long startTime3 = 0;
        long endTime3 = 0;
        long startTime2 = System.currentTimeMillis();
        if (count > 0) {
            count--;
            startTime3 = System.currentTimeMillis();
            redisUtil.set("leotest", count);
            endTime3 = System.currentTimeMillis();
        }
        long startTime4 = System.currentTimeMillis();
//        distributedLock.unlockByRedisson("spike-resource");
        distributedLock.unLock("spike-resource");
        long endTime4 = System.currentTimeMillis();
        System.out.println("库存：" + count + "-----时间：" + (endTime1 - startTime1) + ":" + (startTime3 - startTime2) + ":" + (endTime3 - startTime3) + ":" + (endTime4 - startTime4));
        return true;
    }
}
