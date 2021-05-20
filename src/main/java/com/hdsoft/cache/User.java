package com.hdsoft.cache;

public class User {
    private final String name;
    private final String contact;

    public User(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
