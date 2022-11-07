package com.hillel.lesson_08;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DZ {
    public static void main(String[] args) {
        Sub[] subs = new Sub[3];

        subs[0] = new Sub("1", 0);
//        subs[1] = new Sub("2", -100);
        subs[1] = new Sub("3", 123);
        subs[2] = new Sub("4", 134);
//        subs[4] = new Sub("5", -45);

        new SubService().infoNegativeBalance(subs);
    }
}


class SubService {

    private final String STR_1 = "Список абонентов с отрицательным балансом: ";
    private final String STR_2 = "Абоненты, с отрицательным балансом отсутствуют: ";

    public void infoNegativeBalance(Sub[] subscribers) {
        Object[] arr = getNegativeBalanceSubs(subscribers);
        String message = arr.length != 0 ? STR_1 : STR_2;
        System.out.println(message);
        for (Object s : arr) {
            System.out.println(s);
        }
    }

    private Object[] getNegativeBalanceSubs(Sub[] subscribers) {
        List<Sub> list = new ArrayList<Sub>();
        for (Sub s : subscribers) {
            if (s.getBalance() < 0) {
                list.add(s);
            }
        }
        return list.toArray();
    }
}

class Sub {
    private String name;
    private int balance;

    public Sub(String name, int balance) {
        this.name = Objects.requireNonNullElse(name, "Default");
        this.balance = balance;
    }

    public Sub(int balance) {
        this.name = "Default";
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Sub{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}