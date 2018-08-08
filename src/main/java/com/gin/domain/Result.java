package com.gin.domain;

/**
 * http请求返回的最外层对象
 * Created by Jean .
 * 2018/8/3
 */
public class Result<T> {

    /** 错误码 **/
    public Integer code;

    /** 提示信息 **/
    public String msg;

    /** 具体的内容 **/
    public T content;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
