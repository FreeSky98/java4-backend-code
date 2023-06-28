package controller;

import exception.IncorrectPasswordException;
import exception.LockedAccountException;
import exception.UnknownAccountException;
import service.UserService;

public class UserController {
    private static final UserService userService = new UserService();

    public static void testLogin(String username, String password) throws Exception {
        try {
            userService.login(username, password);
        } catch (IncorrectPasswordException e) {
            //e.printStackTrace();
            throw new Exception("用户密码错误！",e);
        } catch (LockedAccountException e) {
            //e.printStackTrace();
            throw new Exception("用户账号已被封禁！",e);
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            throw new Exception("用户名错误！",e);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new Exception("未知其他错误！",e);
        }
    }


    public static void main(String[] args) throws Exception {
        testLogin("admin","123456");
    }
}

