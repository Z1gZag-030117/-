package com.wjh.www.util;

import com.wjh.www.util.constant.Constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wjh
 */
public class BaseUtils {
    /**
     * 方法名：getTime
     * 作用：调用该方法用于获取当前时间
     *
     * @return 返回表示时间的字符串
     */
    public static String getTime() {
        //JDK1.8新增LocalDateTime
        return DateTimeFormatter.ofPattern(Constants.TIME_FORMAT).format(LocalDateTime.now());
    }

}
