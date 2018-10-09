package com.adc.da.myutil.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCache{

    /**
     * @Author: liyunqiang
     * @Date: 2018/7/31 0031 15:55
     * @param null
     * @Description:声明cache
     */
    final static Cache<Object, Object> cache = CacheBuilder.newBuilder()
            //设置cache的初始大小为10，要合理设置该值
            .initialCapacity(10)
            //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
            .concurrencyLevel(5)
            //设置cache中的数据在写入之后的存活时间为60秒
            .expireAfterWrite(60, TimeUnit.SECONDS)
            //构建cache实例
            .build();

    /**
     * @Author: liyunqiang
     * @Date: 2018/7/31 0031 16:18
     * @param key
     * @Description:cache的get方法
     *
     */
    public static Object get2(Object key) throws Exception {

        Object var = cache.get(key, new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("如果没有值,就执行其他方式去获取值");
                String var = "Google.com.sg";
                return var;
            }
        });
        return var;
    }
    /**
     * @Author: liyunqiang
     * @Date: 2018/7/31 0031 16:18
     * @param key
     * @param value
     * @Description:cache的put方法
     *
     */
    public static void put(Object key, Object value) {
        cache.put(key, value);

    }
    /**
     * @Author: liyunqiang
     * @Date: 2018/7/31 0031 16:18
     * @param key
     * @Description:cache的get方法（没有返回null）
     *
     */
    public static Object get(Object key) {
        try {
            Object var = cache.get(key, new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    System.out.println("如果没有值,就执行其他方式去获取值");
                    return null;
                }
            });
            return var;
        } catch (Exception e) {
            return null;
        }
    }
}
