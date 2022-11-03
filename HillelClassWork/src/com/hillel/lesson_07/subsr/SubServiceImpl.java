package com.hillel.lesson_07.subsr;

public class SubServiceImpl implements SubService{
    @Override
    public Sub[] getSubByAge(Sub[] arr, int age) {
        int count = 0;

        for (Sub s : arr) {
            if (s.getAge() == age) count++;
        }

        Sub[] result = new Sub[count];
        count = 0;
        for (Sub s : arr) {
            if (s.getAge() == age) {
                result[count] = s;
                count++;
            }
        }
        return result;
    }
}
