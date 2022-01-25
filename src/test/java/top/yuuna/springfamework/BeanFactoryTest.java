package top.yuuna.springfamework;

import org.junit.Assert;
import org.junit.Test;
import top.yuuna.springfamework.beans.factory.config.BeanDefinition;
import top.yuuna.springfamework.beans.factory.support.DefaultListableBeanFactory;
import top.yuuna.springfamework.springframework.test.bean.LearningService;


public class BeanFactoryTest {

    @Test
    public void testBeanFactory() {

        /**
         * 主要流程包括：初始化Bean工厂，注册Bean，获取Bean
         */
        //1.init BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //2.create beanDefinition and register bean
        String learningServiceBeanName = "userService";
        BeanDefinition beanDefinition = new BeanDefinition(LearningService.class);
        beanFactory.registerBeanDefinition(learningServiceBeanName, beanDefinition);
        //3.first get bean
        LearningService learningService = (LearningService) beanFactory.getBean(learningServiceBeanName);
        System.out.println(learningService.learningRemind());

        //4.get singleton bean
        LearningService single_learningService = (LearningService) beanFactory.getBean(learningServiceBeanName);
        System.out.println(single_learningService.learningRemind());
        //check two object value
        Assert.assertEquals(single_learningService, learningService);



    }

}