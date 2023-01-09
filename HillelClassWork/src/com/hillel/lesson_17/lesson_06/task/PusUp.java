package com.hillel.lesson_17.lesson_06.task;

public class PusUp {
    /*
    Человек подтягивается, делает подходы лесенкой начиная с 1 раза
    - подсчитать сколько он всего подтянеться за N подходов, N задано с клавиатуры
    N = 4 -> 1 + 2 + 3 + 4 = 10

    - вывести общее время выполнения упражнения (10:45)
    каждое подтягивание занимает 5с, первый перерыв между подхлдами 60с,
    каждый следующий перерыв на 20% больше предыдущего.
     */
    public static void main(String[] args) {

        int numberOfTurn = 3;
        double timeRest = 60;
        int timePush = 5;
        double totalTime = 0;
        int totalPush = 0;

        for (int i = 1; i <= numberOfTurn; i++){
            for (int j = 1; j <=i; j++){
                System.out.print("#");
                totalTime += timePush;
            }
            totalPush += i;
            if (i != numberOfTurn){
                totalTime +=timeRest;
                timeRest = timeRest*1.2;
            }
            System.out.println();
        }
        System.out.println("totalPush -> " + totalPush);
        int tt = (int )totalTime;
        System.out.println("totalTime [mm:ss] -> " + tt/60 + ":" + tt%60);



    }
}
