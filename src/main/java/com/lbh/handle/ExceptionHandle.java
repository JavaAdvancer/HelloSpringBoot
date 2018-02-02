package com.lbh.handle;

import com.lbh.entity.Result;
import com.lbh.entity.User;
import com.lbh.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Advancer on 2018/1/15 11:09.
 * auth: lbh
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<User> handle(Exception e){
        if (e instanceof UserException){
            UserException userException = (UserException) e;
            return ResultUtils.error(userException.getCode(), userException.getMessage());
        }else {
            logger.info("【系统异常】{}", e);
            return ResultUtils.error(-1, "未知错误！");
        }
    }

}
