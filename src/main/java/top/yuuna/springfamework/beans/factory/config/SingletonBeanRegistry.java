package top.yuuna.springfamework.beans.factory.config;

/**
 * 单例注册接口
 *
 * @author NGinko
 * @date 2022-01-24 23:37
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例对象
     * @param beanName -
     * @return -
     */
    Object getSingleton(String beanName);
}
