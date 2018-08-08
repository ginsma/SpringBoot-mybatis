package com.gin.exception;

import com.gin.enums.ResultEnum;

/**
 * Created by Jean .
 * 2018/8/3
 */
//RuntimeException才进行事物回滚
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
