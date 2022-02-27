package com.luoluo89.consumer;

public final class ProduceUtil {
    private static Long aa = 1000l;

    public synchronized static Long produce(){
        return aa++;
    }
}
