package com.lbh.util;

import com.lbh.entity.Result;

/**
 * Created by Advancer on 2018/1/14 19:08.
 * auth: lbh
 */
public class ResultUtils {

    public static Result success(Object obj){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功！");
        result.setData(obj);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
