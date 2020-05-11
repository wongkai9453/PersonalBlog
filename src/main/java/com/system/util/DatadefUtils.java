package com.system.util;

/**
 * @ClassName DatadefUtils
 * @Description TODO
 * @Author wk
 * @Date 2020/5/9 0009 10:02
 * @Version 1.0
 */
public class DatadefUtils {
    //登陆状态
    public static  final short PD_YS = 1; //密码正确
    public static  final short PD_NO = 0; //密码错误
    public static  final short PD_ERROR = -1; //为查询到用户
    public static  final short PD_NULL = -2; //未输入密码
    public static  final short LOGIN = -3; //登陆报错

}
