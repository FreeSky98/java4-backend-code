package com.study.demo2;

public class LoginController {

    /**
     * 用户登录
     * @param username 用户账号
     * @param password 用户密码
     * @return
     */
    public ApiResult login(String username,String password) {
        if(! "admin".equalsIgnoreCase(username)) {
            return ApiResult.fail(ApiCodeEnum.INVALID_ACCOUNT);
        }
        else {
            if(!"admin888".equals(password)) {
                return ApiResult.fail(ApiCodeEnum.PWD_ERROR);
            }
            else {
                return ApiResult.success("登录成功");
            }
        }
    }

}
