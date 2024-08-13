package com.booleanuk;

import java.util.ArrayList;
import java.util.HashMap;

public class Scrabble {
    int scoreHolder = 0;
    int wordMultiplier = 1;
    public Scrabble(String word) {
        HashMap<Character, Integer> scoreList = scoreList();
        char[] charArray = word.toUpperCase().toCharArray();
        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (char c : charArray) {
            if(scoreList.containsKey(c)){
                characterArrayList.add(c);
            }else break;
        }

        characterArrayList = checkDoubleTripleWord(characterArrayList);
        this.scoreHolder += checkDoubleTripleLetter(characterArrayList);
    }
 /*
  for (char c: word.toUpperCase().toCharArray()) {
            if(scoreList.containsKey(c)) {
                this.scoreHolder += scoreList.get(c);
            }
        }
  */
    public int score() {
        return this.scoreHolder * this.wordMultiplier;
    }


    public ArrayList<Character> checkDoubleTripleWord(ArrayList<Character> list) {
        if(!list.isEmpty()) {
            if (list.getFirst().equals('[') && list.getLast().equals(']')) {
                list.removeFirst();
                list.removeLast();
                this.wordMultiplier = 3;
                return list;
            } else if (list.getFirst().equals('{') && list.getLast().equals('}')) {
                list.removeFirst();
                list.removeLast();
                this.wordMultiplier = 2;
                return list;
            }
        }
        return list;
    }

    public int checkDoubleTripleLetter(ArrayList<Character> list) {
        int charScore = 0;
        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals('[') && list.get(i + 2).equals(']')) {
                    if (list.contains(list.get(i + 1))) {
                        charScore += scoreList().get(list.get(i + 1)) * 3;
                        i += 2;
                    }
                } else if (list.get(i).equals('{') && list.get(i + 2).equals('}')) {
                    if (list.contains(list.get(i + 1))) {
                        charScore += scoreList().get(list.get(i + 1)) * 2;
                        i += 2;
                    }
                } else {
                    if (list.get(i).equals('[') || list.get(i).equals(']') || list.get(i).equals('{') || list.get(i).equals('}')) {
                        //Set to 0 if the brackets are wrong
                        charScore = 0;
                        this.scoreHolder = 0;
                        break;
                    } else {
                        charScore += scoreList().get(list.get(i));
                    }
                }
            }
        }
        return charScore;
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
        list.put('[', 0);
        list.put(']', 0);
        list.put('{', 0);
        list.put('}', 0);

        return list;
    }
}
