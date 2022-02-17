package top.yuuna.springfamework.springframework.test.bean;

/**
 * @author NGinko
 * @date 2022-02-17 21:35
 */
public class UserService {

    private String userId;

    private UserDao userDao;

    public String queryUserInfoByUserId() {
        return userDao.queryUserName(userId);
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
