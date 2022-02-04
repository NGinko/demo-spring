package top.yuuna.springfamework.beans.factory.support;

import top.yuuna.springfamework.beans.BeansException;
import top.yuuna.springfamework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口类
 *
 * @author NGinko
 * @date 2022-02-02 17:20
 */
public interface InstantiationStrategy {

    /**
     * 实例化具体接口
     *
     * @param beanDefinition -
     * @param beanName       -
     * @param ctor           Constructor类，包含了类的必要信息，可以拿到符合入参对应的构造函数
     * @param args           入参信息
     * @return -
     * @throws BeansException -
     */
    Object instantiation(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
