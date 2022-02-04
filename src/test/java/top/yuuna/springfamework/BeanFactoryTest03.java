package top.yuuna.springfamework;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;
import top.yuuna.springfamework.beans.factory.config.BeanDefinition;
import top.yuuna.springfamework.beans.factory.support.DefaultListableBeanFactory;
import top.yuuna.springfamework.springframework.test.bean.LearningService;

import java.lang.reflect.Constructor;

/**
 * @author NGinko
 * @date 2022-02-04 17:23
 */
public class BeanFactoryTest03 {


    @Test
    public void testDefaultBeanFactory() {
        //1.init BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.register bean
        BeanDefinition beanDefinition = new BeanDefinition(LearningService.class);
        String beanName = "learningService";
        beanFactory.registerBeanDefinition(beanName, beanDefinition);

        //3.get bean
        LearningService chineseLearning = (LearningService) beanFactory.getBean(beanName, "chinese");
        System.out.println(chineseLearning.learningRemind());
    }

    @Test
    public void testCglibBeanFactory() {
        //1.init BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory("Cglib");

        //2.register bean
        BeanDefinition beanDefinition = new BeanDefinition(LearningService.class);
        String beanName = "learningService";
        beanFactory.registerBeanDefinition(beanName, beanDefinition);

        //3.get bean
        LearningService chineseLearning = (LearningService) beanFactory.getBean(beanName, "chinese1");
        System.out.println(chineseLearning.learningRemind());
    }



    @Test
    public void testSimpleConstructor() throws Exception {
        Constructor<LearningService> declaredConstructor = LearningService.class.getDeclaredConstructor(String.class);
        LearningService learningConstructor = declaredConstructor.newInstance("构造函数");
        System.out.println(learningConstructor.learningRemind());
    }

    @Test
    public void testParameterType() throws Exception {
        //获取构造函数的信息，选择对应的实例化
        Class<LearningService> learningServiceClass = LearningService.class;
        Constructor<?>[] declaredConstructor = learningServiceClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructor[0];
        Constructor<LearningService> learningConstructor = learningServiceClass.getDeclaredConstructor(constructor.getParameterTypes());
        LearningService conTest = learningConstructor.newInstance("构造函数2");
        System.out.println(conTest.learningRemind());
    }

    @Test
    public void testCglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(LearningService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        LearningService constructLearning = (LearningService) enhancer.create(new Class[]{String.class}, new Object[]{"构造函数3"});
        System.out.println(constructLearning.learningRemind());

    }
}
