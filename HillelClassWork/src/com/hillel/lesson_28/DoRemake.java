package com.hillel.lesson_28;

import java.util.Arrays;
import java.util.List;

/*
        Create a function (doRemake) that takes a string of words and

        -Move the first letter of each word to the end of the word.
        -Add "ay" to the end of the word.
        -Words starting with a vowel (a,e,i,o,u, A, E, I, O, U) simply have "way" appended to the end.


        Examples:
        doRemake("Cats are great pets.")
        returns "Atscay areway reatgay etspay."

        doRemake("Tom got a small piece of pie.")
        returns "Omtay otgay away allsmay iecepay ofway iepay."

        doRemake("He told us a very exciting tale.")
        returns "Ehay oldtay usway away eryvay excitingway aletay."
 */
public class DoRemake {
    public static void main(String[] args) {
        System.out.println(doRemake("Cats are great pets"));

    }

    public static String doRemake(String text){
        String[] strArray = text.split(" ");
        for (int i = 0; i < strArray.length; i++){
            strArray[i] = moveFirst(strArray[i]);
        }
        return Arrays.deepToString(strArray);
    }

    private static String moveFirst(String text){
        String ch = String.valueOf(text.charAt(0));
        List<String> let = List.of("a","e","i","o","u","A","E","I","O","U");
        if (let.contains(ch)){
            return text.concat("way");
        } else {
            return text.replace(ch, "").concat(ch).concat("ay");
        }
    }
}
