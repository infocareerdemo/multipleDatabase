package com.demo.secondary;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "manager")
public class Manager {

    @Id
    private String id;
    private String name;
    private Float salary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
}

