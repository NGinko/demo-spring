package top.yuuna.springfamework.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import top.yuuna.springfamework.beans.BeansException;
import top.yuuna.springfamework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Cglib实例化
 *
 * @author NGinko
 * @date 2022-02-03 11:53
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiation(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) {
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);

    }
}
