package top.yuuna.springfamework;

/**
 * Bean的定义，目前只有Object存放Bean对象
 * @author NGinko
 * @date 2022-01-23 20:56
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }


}
