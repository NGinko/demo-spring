package top.yuuna.springfamework.test04;

import org.junit.Test;
import top.yuuna.springfamework.beans.PropertyValue;
import top.yuuna.springfamework.beans.PropertyValues;
import top.yuuna.springfamework.beans.factory.config.BeanDefinition;
import top.yuuna.springfamework.beans.factory.config.BeanReference;
import top.yuuna.springfamework.beans.factory.support.DefaultListableBeanFactory;
import top.yuuna.springfamework.springframework.test.bean.UserDao;
import top.yuuna.springfamework.springframework.test.bean.UserService;

/**
 * @author NGinko
 * @date 2022-02-17 21:34
 */
public class BeanFactoryTest04 {


    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        //通过填充的属性查询
        System.out.println(userService.queryUserInfoByUserId());

    }
}
