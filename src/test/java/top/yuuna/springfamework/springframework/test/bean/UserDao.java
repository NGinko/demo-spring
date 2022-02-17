package top.yuuna.springfamework.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NGinko
 * @date 2022-02-17 21:35
 */
public class UserDao {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("10001", "杏仁");
        map.put("10002", "军师");
        map.put("10003", "千水");
    }


    public String queryUserName(String userId){
        return map.get(userId);
    }

}
