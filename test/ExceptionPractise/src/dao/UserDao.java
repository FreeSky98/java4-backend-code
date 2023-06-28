package dao;

import entity.User;


public class UserDao {
    //用户对象数组
    private static User[] users = new User[2];

    static {
        // 给用户对象数组初始化
        users[0] = new User("admin", "123456", false);
        users[1] = new User("guest", "000000", true);
    }

    //根据账号查询用户信息
    public User getUserByAccount(String account) {
        for (User user : users) {
            if(user != null && user.getAccount().equals(account)){
                return user;
            }
        }
        return null;
    }
}
