package com.example.sangameswaran.practice;

/**
 * Created by Sangameswaran on 09-05-2017.
 */

public class EnterIntoDBModelClass {
    String name;
    String age;

    EnterIntoDBModelClass(String name,String age)
    {
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
