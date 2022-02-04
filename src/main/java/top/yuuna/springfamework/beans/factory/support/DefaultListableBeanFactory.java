package top.yuuna.springfamework.beans.factory.support;

import top.yuuna.springfamework.beans.BeansException;
import top.yuuna.springfamework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * listable adj.可列举的
 * 接口定义的注册、获取都被集中在DefaultListableBeanFactory中
 * @author NGinko
 * @date 2022-01-25 21:19
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public DefaultListableBeanFactory() {

    }

    public DefaultListableBeanFactory(String methodInstance) {
        super(methodInstance);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (null == beanDefinition) {
            throw new BeansException("No bean named '" + beanName + "'is defined");
        }
        return beanDefinition;

    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
