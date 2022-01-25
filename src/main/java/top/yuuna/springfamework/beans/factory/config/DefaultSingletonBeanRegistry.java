package top.yuuna.springfamework.beans.factory.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NGinko
 * @date 2022-01-24 23:39
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * 实现SingletonBeanRegistry的getSingleton方法
     * 同时实现一个受保护的addSingleton方法，此方法可以被继承此类的其他方法初始化时调用：
     * -- 包括DefaultListableBeanFactory和AbstractBeanFactory
     */

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
