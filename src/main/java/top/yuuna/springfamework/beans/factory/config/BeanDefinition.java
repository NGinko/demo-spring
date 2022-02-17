package top.yuuna.springfamework.beans.factory.config;

import top.yuuna.springfamework.beans.PropertyValues;

/**
 * 知识用来保存Bean的定义
 * 将Object bean替换为Class，如此可以把Bean的实例化操作放到容器中做，不需要再做初始化。
 * Bean定义的时候需要加上相关的注册信息
 * @author NGinko
 * @date 2022-01-23 20:56
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
