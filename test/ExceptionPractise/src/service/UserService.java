package service;

import dao.UserDao;
import entity.User;
import exception.IncorrectPasswordException;
import exception.LockedAccountException;
import exception.UnknownAccountException;

public class UserService {

    private final UserDao userDao = new UserDao();
    /**
     * 用户登录业务方法
     * @param account 账号
     * @param password 密码
     * @return 登录成功：返回用户对象，登录失败：返回null
     */
    public User login(String account,String password) throws
            IncorrectPasswordException,
            LockedAccountException,
            UnknownAccountException {
        User currentUser = userDao.getUserByAccount(account);
        if(currentUser == null) {
            throw new UnknownAccountException("登录失败：账号不存在！");
        }
        else
        {
            if(! currentUser.getPassword().equals(password)){
                throw new IncorrectPasswordException("登录失败：密码错误！");
            }
            else if(currentUser.getStatus()) {
                throw new LockedAccountException("登录失败：账号已被锁定，请联系管理员！");
            }
            else {
                System.out.println("登录成功，Hello！欢迎" + account + "登录系统！");
                return currentUser;
            }
        }
    }
}
