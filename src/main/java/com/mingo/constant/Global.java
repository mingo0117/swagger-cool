package com.mingo.constant;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Author:mingo
 * Date:2018/5/25 21:48
 * Description:全局变量
 */
public class Global {

    public final static Map<String, String> SPRING_PROPERTIES = Maps.newHashMap();

    //返回code的几种commonType（对错误要求不高可直接返回这些，一个code可对应多个msg）。具体是什么错在msg中详细说明（内容和国际化文件的key对应）
    public final static String SUCCESS = "success";     //成功
    public final static String SYS_ERR = "sys_err";     //系统错误，主要指一些未知的异常
    public final static String REQ_ERR = "req_err";     //请求错误
    public final static String BIZ_ERR = "biz_err";     //业务异常

    //调用方需要针对某一类型错误特殊处理时（一个code对应一个msg）,规则：commonType_接口类型_具体错误，力求简短，一目了然（相对数字错误码）
    public final static String BIZ_ERR_USER_BLACKLIST = "biz_err_user_blacklist"; //例如调用方需要对注册用户为黑名单的特殊处理

}
