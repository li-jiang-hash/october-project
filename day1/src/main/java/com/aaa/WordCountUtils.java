package com.aaa;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class WordCountUtils {
    public static void main(String[] args) {
        System.out.println(wordCount("sdasd asd ad as d sa dsa dasd as dsad sa da  sc ascsa ad sad a sdsa sfdsafa sd sad asd as d asd sas  "));
    }

    public static Map<String, Integer> wordCount(String words) {
        Map<String, Integer> resultMap = new HashMap<>();

        String[] wordArray = words.split(" ");
        for (String word : wordArray) {
            if (resultMap.containsKey(word)) {
                Integer count = resultMap.get(word);

                count++;
                System.out.print(count);
                resultMap.put(word, count);
            } else {
                resultMap.put(word, 1);
            }
        }


        return resultMap;
    }
}
