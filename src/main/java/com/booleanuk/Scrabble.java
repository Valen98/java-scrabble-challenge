package com.booleanuk;

import java.util.ArrayList;
import java.util.HashMap;

public class Scrabble {
    int scoreHolder = 0;
    public Scrabble(String word) {
        HashMap<Character, Integer> scoreList = scoreList();


        for (char c: word.toUpperCase().toCharArray()) {
            if(scoreList.containsKey(c)) {
                this.scoreHolder += scoreList.get(c);
            }
            //charArray.add(c);

        }



    }

    public int score() {
        return this.scoreHolder;
    }




    public HashMap<Character, Integer> scoreList() {
        HashMap<Character, Integer> list = new HashMap<>();
        list.put('A', 1);
        list.put('E', 1);
        list.put('I', 1);
        list.put('O', 1);
        list.put('U', 1);
        list.put('L', 1);
        list.put('N', 1);
        list.put('R', 1);
        list.put('S', 1);
        list.put('T', 1);
        list.put('D', 2);
        list.put('G', 2);
        list.put('B', 3);
        list.put('C', 3);
        list.put('M', 3);
        list.put('P', 3);
        list.put('F', 4);
        list.put('H', 4);
        list.put('V', 4);
        list.put('W', 4);
        list.put('Y', 4);
        list.put('K', 5);
        list.put('J', 8);
        list.put('X', 8);
        list.put('Q', 10);
        list.put('Z', 10);

        return list;
    }
}
