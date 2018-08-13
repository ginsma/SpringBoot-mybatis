package com.gin.exception;

import com.gin.enums.ResultEnum;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━━━━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　━　　　   ┃
 * ┃　┳┛　┗┳　   ┃
 * ┃　　　　　　　┃
 * ┃　　┻　　　   ┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━━━━┛
 * 　┃　　　┃神兽保佑
 * 　┃　　　┃代码无BUG！
 * 　┃　　　┗━━━┓
 * 　┃　　　　　 ┣┓
 * 　┃　　　　　┏┛
 * 　┗┓┓┏━━┳┓┏┛
 * 　 ┃┫┫　┃┫┫
 * 　 ┗┻┛　┗┻┛
 * Created by Jean .
 * 2018/8/3
 * RuntimeException才进行事物回滚
 */

public class MyRuntimeException extends RuntimeException {
    /** 错误码 **/
    private Integer code;

    public MyRuntimeException(ResultEnum resultEnum) {
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
