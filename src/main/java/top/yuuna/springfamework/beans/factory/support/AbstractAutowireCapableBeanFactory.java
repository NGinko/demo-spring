package top.yuuna.springfamework.beans.factory.support;

import top.yuuna.springfamework.beans.BeansException;
import top.yuuna.springfamework.beans.factory.config.BeanDefinition;

/**
 * 这里只做Bean的实例化操作
 * @author NGinko
 * @date 2022-01-25 21:13
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean ;
        try {
            /*
             * 还需要考虑使用具体构造函数初始化的方式
             */
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        //实例化之后，添加到容器当中
        addSingleton(beanName, bean);
        return bean;

    }
}
