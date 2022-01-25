package top.yuuna.springfamework.beans.factory.support;

import top.yuuna.springfamework.beans.BeansException;
import top.yuuna.springfamework.beans.factory.BeanFactory;
import top.yuuna.springfamework.beans.factory.config.BeanDefinition;
import top.yuuna.springfamework.beans.factory.config.DefaultSingletonBeanRegistry;

/**
 * 抽象类定义模板方法
 * 因为继承了DefaultSingletonBeanRegistry所以就具备了使用单例注册类方法的能力
 * 从getBean中可以看出，针对不同的实现方式，可以在实现具体的方法。所以getBeanDefinition和createBean没有具体的实现
 * @author NGinko
 * @date 2022-01-25 20:55
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 这里先做懒加载，如果没初始化好就做下初始化操作
     * @param name -
     * @return -
     * @throws BeansException -
     */
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (null != bean) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    /**
     * 通过bean的名词获取BeanDefinition的定义
     * @param beanName -
     * @return -
     * @throws BeansException -
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;


    /**
     * creatBean
     * @param beanName       -
     * @param beanDefinition -
     * @return -
     * @throws BeansException -
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
