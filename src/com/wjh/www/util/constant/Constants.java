package com.wjh.www.util.constant;

/**
 * @author wjh
 */
public class Constants {
    /**
     * 时间的格式
     */
    public final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /*
    数据库连接池的初始（最小）连接数
     */
    public final static int POOL_INIT_SIZE=2;

    /*
    数据库连接池的最大连接数
     */
    public final static int POOL_MAX_SIZE=10;

    /*
    数据库连接池的自动增加连接的连接数
     */
    public final static int POOL_INCREMENTAL_SIZE=2;
}
