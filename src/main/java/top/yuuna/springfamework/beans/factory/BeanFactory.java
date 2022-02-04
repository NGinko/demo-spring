package top.yuuna.springfamework.beans.factory;

import top.yuuna.springfamework.beans.BeansException;
import top.yuuna.springfamework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean工厂
 *
 * @author NGinko
 * @date 2022-01-23 20:57
 */
public interface BeanFactory {

    /**
     * 获取bean的对象
     * @param name -
     * @return -
     * @throws BeansException -
     */
    Object getBean(String name) throws BeansException;

    /**
     * 重载一个可以传递具体构造函数的getBean，可以通过传入构造函数来实例化了
     * @param beanName
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String beanName, Object... args) throws BeansException;

}

