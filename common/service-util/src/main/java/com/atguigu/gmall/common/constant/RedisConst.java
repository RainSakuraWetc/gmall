package com.atguigu.gmall.common.constant;

/**
 * @author wentao.xie
 * @date 2022/1/23 16:16
 * @Verssion 1.0
 * @Desc Redis常量配置类
 */
public class RedisConst {

    public static final String SKUKEY_PREFIX = "sku:";
    public static final String SKUKEY_SUFFIX = ":info";
    /**
     * 单位：秒
     */
    public static final long SKUKEY_TIMEOUT = 24 * 60 * 60;


    /**
     * // 商品如果在数据库中不存在那么会缓存一个空对象进去，但是这个对象是没有用的，所以这个对象的过期时间应该不能太长，
     * // 如果太长会占用内存。
     * // 定义变量，记录空对象的缓存过期时间
     */
    public static final long SKUKEY_TEMPORARY_TIMEOUT = 10 * 60;

    public static final String SKULOCK_SUFFIX = "";
    public static final long SKULOCK_EXPIRE_PX2 = 0L;
    public static final long SKULOCK_EXPIRE_PX1 = 0L;
    public static final String USER_LOGIN_KEY_PREFIX = "";
    public static final long USERKEY_TIMEOUT = 0L;
    public static final String USER_KEY_PREFIX = "";
    public static final String USER_CART_KEY_SUFFIX = "";
}