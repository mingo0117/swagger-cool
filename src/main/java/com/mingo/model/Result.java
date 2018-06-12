package com.mingo.model;

import com.mingo.constant.Global;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * Author:mingo
 * Date:2018/5/25 10:47
 * Description: 统一结果返回对象
 */
@ApiModel(value = "result",description = "返回结果")
public class Result<T> implements Serializable {
    @ApiModelProperty(value="返回码", example = "success")
    private String code;
    @ApiModelProperty(value="错误详情", example = "null or detail when error")
    private String msg;
    @ApiModelProperty(value="结果数据")
    private T data;

    public static Result success(Object data){
        return new Result(Global.SUCCESS,null, data);
    }

    public static Result error(String code, String msg){
        return new Result(code,msg, null);
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code) {
		this.code = code;
	}

	public Result(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

