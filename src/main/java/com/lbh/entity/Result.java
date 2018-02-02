package com.lbh.entity;

/**
 * 错误消息提示类
 * Created by Advancer on 2018/1/14 18:51.
 * auth: lbh
 */
public class Result<T> {

    private Integer code;  //错误码
    private String msg;    //错误消息
    private T data;        //具体内容

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
