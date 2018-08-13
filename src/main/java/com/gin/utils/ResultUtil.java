package com.gin.utils;

import com.gin.domain.Result;

/**
 * Created by Jean .
 * 2018/8/3
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setContent(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setContent(null);
        return result;
    }
}
