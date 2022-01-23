package top.yuuna.springfamework;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import top.yuuna.springfamework.springframework.test.bean.LearningService;


public class BeanFactoryTest {

    @Test
    public void testBeanFactory() {
        //1.define BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        //2.init Bean define，and then register to bean factory
        String beanName = "learningService";
        BeanDefinition beanDefinition = new BeanDefinition(new LearningService());
        beanFactory.registerBeanDefinition(beanName, beanDefinition);

        //3.get bean
        LearningService learningService = (LearningService) beanFactory.getBean(beanName);
        Assert.assertEquals("今天你学习了吗?",learningService.learningRemind());
    }

}