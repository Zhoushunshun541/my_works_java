package com.idiotic.common.expection;
import com.idiotic.common.utils.ResultCode;
import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class CommonExpection extends Exception  {

    private ResultCode resultCode;

    public CommonExpection(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
