package top.yuuna.springfamework.beans.factory.config;

/**
 * bean的对象类型
 * @author NGinko
 * @date 2022-02-17 21:16
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
