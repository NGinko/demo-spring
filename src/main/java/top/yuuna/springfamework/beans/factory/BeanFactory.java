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

}

