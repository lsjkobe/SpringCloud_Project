package com.leoli.distributed_lock.utils.locks;

public interface Lock<T> {
    boolean Lock(String key, T t);

    boolean unLock(String key);
}
