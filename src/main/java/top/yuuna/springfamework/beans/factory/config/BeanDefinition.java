package top.yuuna.springfamework.beans.factory.config;

/**
 * 知识用来保存Bean的定义
 * 将Object bean替换为Class，如此可以把Bean的实例化操作放到容器中做，不需要再做初始化。
 * @author NGinko
 * @date 2022-01-23 20:56
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
