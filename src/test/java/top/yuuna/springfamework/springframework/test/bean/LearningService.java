package top.yuuna.springfamework.springframework.test.bean;

/**
 * @author NGinko
 * @date 2022-01-23 20:58
 */
public class LearningService {

    private String className;

    public LearningService(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String learningRemind() {
        return "今天你学习了吗?"+ className;
    }


    @Override
    public String toString() {
        return "LearningService{" +
                "className='" + className + '\'' +
                '}';
    }
}
