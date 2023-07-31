package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    private long dog_id;
    private String name;
    private long age;

    @Id
    @Column(name = "dog_id", nullable = false)
    public long getDog_id() {
        return dog_id;
    }

    public void setDog_id(long dog_id) {
        this.dog_id = dog_id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age", nullable = false)
    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
