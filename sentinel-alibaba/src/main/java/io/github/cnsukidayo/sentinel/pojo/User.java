package io.github.cnsukidayo.sentinel.pojo;

/**
 * @author guyuanjie
 * @date 2024/1/11 14:30
 */
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
