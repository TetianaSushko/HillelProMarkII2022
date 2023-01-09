package com.hillel.lesson_17.lesson_06.absrt;

public class Student extends Human {
    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        super.toString();
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", group='" + group + '\'' +
                '}';
    }
}
