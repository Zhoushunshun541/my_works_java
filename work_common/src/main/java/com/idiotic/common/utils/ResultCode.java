package com.idiotic.common.utils;

/**
 * 公共的返回码
 *    返回码code：
 *      成功：10000
 *      失败：10001
 *      未登录：10002
 *      未授权：10003
 *      抛出异常：99999
 */
public enum ResultCode {

    SUCCESS(true,200,"操作成功！"),
    //---系统错误返回码-----
    FAIL(false,400,"操作失败"),
    UNAUTHENTICATED(false,401,"您还未登录"),
    UNAUTHORISE(false,403,"权限不足"),
    SERVER_ERROR(false,500,"抱歉，系统繁忙，请稍后重试！"),

    //---用户操作返回码  2xxxx----
    MOBILEORPASSWORDERROR(false,403,"用户名或密码错误"),
    NOTUSER(false,403,"查无此用户"),
    EMPTYDATA(false,220,"暂无数据");
    //---用户操作返回码  3xxxx----
    //---权限操作返回码----
    //---其他操作返回码----

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String msg;

    ResultCode(boolean success,int code, String msg){
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return msg;
    }

}