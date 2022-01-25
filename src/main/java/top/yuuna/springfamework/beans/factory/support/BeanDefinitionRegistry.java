package top.yuuna.springfamework.beans.factory.support;

import top.yuuna.springfamework.beans.factory.config.BeanDefinition;

/**
 * @author NGinko
 * @date 2022-01-25 21:21
 */
public interface BeanDefinitionRegistry {

    /**
     * 向表中注册BeanDefinition
     * @param beanName -
     * @param beanDefinition -
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
