package com.mingo.exception;

/**
 * Author:mingo
 * Date:2018/5/28 10:38
 * Description: 自定义业务类异常
 */
public class BizException extends Exception{

    public BizException(String msg) {
        super(msg);
    }
}
