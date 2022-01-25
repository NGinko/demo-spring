package top.yuuna.springfamework.beans;

import java.beans.Beans;

/**
 * @author NGinko
 * @date 2022-01-25 20:58
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
