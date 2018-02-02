package com.lbh.handle;

import com.lbh.enums.ResultEnum;

/**
 * 异常处理类
 * Created by Advancer on 2018/1/15 11:28.
 * auth: lbh
 */
public class UserException extends RuntimeException {
    // 继承RuntimeException 有事务回滚，Exception 事务提交不会自动回滚

    private Integer code ;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     * @param code
     */
    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
