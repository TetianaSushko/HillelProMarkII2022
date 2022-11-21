package subscriber;

import java.util.ArrayList;

public class SubscriberGenerator {
    public static ArrayList<Subscriber> getSubscriber() {
        Subscriber subscriber1 = new Subscriber(1, "Vadym", "Alekseevich", "Polyvianoi", "Odessa", 423423423, 4444555,
                348234, 11, 0, 153.22);
        Subscriber subscriber2 = new Subscriber(2, "Katya", "Ignatovna", "Katina", "Odessa", 346346334, 44446666,
                412412, 15, 42, 1553.22);
        Subscriber subscriber3 = new Subscriber(3, "Polina", "Aleksandrovna", "Tarasova", "Odessa", 1212412412, 4444534,
                -10,  51, 27, 15653.22);
        Subscriber subscriber4 = new Subscriber(4, "Sergey", "Sergeevich", "Sergeev", "Odessa", 124124124, 34534634,
                424324, 12, 23, 1533.22);
        Subscriber subscriber5 = new Subscriber(5, "Kostya", "Konstantinovich", "Kostin", "Odessa", 342342323, 3463453,
                235325,  10, 0, 112353.22);
        Subscriber subscriber6 = new Subscriber(6, "Vladimir", "Vladimirovich", "Vladimirov", "Odessa", 2342342, 2435225,
                -5,  23, 54, 154223.22);
        Subscriber subscriber7 = new Subscriber(7, "Artem", "Artemovich", "Artemov", "Odessa", 234234234, 5236262,
                235235,  12, 22, 15123.22);
        Subscriber subscriber8 = new Subscriber(8, "Sasha", "Aleksandrovich", "Aleksandrov", "Odessa", 423423423, 2352362,
                -20,  9, 0, 15243.22);
        Subscriber subscriber9 = new Subscriber(9, "Petr", "Petrovich", "Petrov", "Odessa", 234523523, 2352362,
                235235,  32, 44, 15243.22);
        Subscriber subscriber10 = new Subscriber(10, "Vasiliy", "Vasilievich", "Vasiliev", "Odessa", 235234243, 23523623,
                -11,  12, 32, 551.411);
        Subscriber subscriber11 = new Subscriber(11, "Ignat", "Ignatovich", "Ignatov", "Odessa", 523524235, 23236235,
                235235,  51, 0, 15243.2522);
        Subscriber subscriber12 = new Subscriber(12, "Artur", "Arturovich", "Arturov", "Odessa", 235235235, 326236235,
                235235,  34, 76, 15213.2112);
        Subscriber subscriber13 = new Subscriber(13, "Ivan", "Ivanovich", "Ivanov", "Odessa", 62453234, 62362352,
                2352352,  34, 0, 1531.22);
        Subscriber subscriber14 = new Subscriber(14, "Arni", "Arnievich", "Arnievov", "Odessa", 342352362, 23623235,
                352352, 124, 232, 14453.22);
        Subscriber subscriber15 = new Subscriber(15, "Taras", "Tarasovich", "Tarasov", "Odessa", 23423623, 523262362,
                252352, 12, 33, 15123.22);


        ArrayList<Subscriber> subscriber = new ArrayList<>();
        subscriber.add(subscriber1);
        subscriber.add(subscriber2);
        subscriber.add(subscriber3);
        subscriber.add(subscriber4);
        subscriber.add(subscriber5);
        subscriber.add(subscriber6);
        subscriber.add(subscriber7);
        subscriber.add(subscriber8);
        subscriber.add(subscriber9);
        subscriber.add(subscriber10);
        subscriber.add(subscriber11);
        subscriber.add(subscriber12);
        subscriber.add(subscriber13);
        subscriber.add(subscriber14);
        subscriber.add(subscriber15);


        return subscriber;
    }
}

