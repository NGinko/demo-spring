package top.yuuna.springfamework.beans.factory.support;

import top.yuuna.springfamework.beans.BeansException;
import top.yuuna.springfamework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * JDK方式实例化Bean对象
 *
 * @author NGinko
 * @date 2022-02-02 17:24
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    /*
       1.通过beanDefinition获取Class信息，这个Class信息是Bean定义的时候传进去的
       2.判断ctor是否为空，如果为空就说明无参构造函数就能初始化，否则就需要有构造函数的实例化
       3.通过getDeclaredConstructor获取对应参数的构造函数实例化对象。将入参交给newInstance进行实例化。
     */


    @Override
    public Object instantiation(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
                /**
                 * note: getDeclaredConstructor会根据指定的参数返回对应的构造器
                 * 包括public和非public的，当然可以通过setAccessible来使用非public的
                 */
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
