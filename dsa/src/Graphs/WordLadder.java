package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    // https://www.geeksforgeeks.org/problems/word-ladder/1
    class Pair {
        String word;
        int value;

        Pair(String word, int value) {
            this.word = word;
            this.value = value;
        }
    }

    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.length; i++) {
            set.add(wordList[i]);
        }
        queue.add(new Pair(startWord, 0));

        while (!queue.isEmpty()) {
            String word = queue.peek().word;
            int count = queue.peek().value;
            queue.remove();
            if (word.equals(targetWord))
                return count + 1;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String replaceWord = new String(charArray);
                    if (set.contains(replaceWord)) {
                        set.remove(replaceWord);
                        queue.add(new Pair(replaceWord, count + 1));
                    }
                }
            }
        }

        return 0;
    }
}
