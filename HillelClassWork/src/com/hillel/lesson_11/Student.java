package com.hillel.lesson_11;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Student {
    private long id = 0;
    private String name;
    private int age = 0;

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
