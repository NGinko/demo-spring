package top.yuuna.springfamework.beans;

/**
 * @author NGinko
 * @date 2022-02-15 21:59
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
