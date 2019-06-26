import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList();
        if (s.isEmpty() || words == null || words.length == 0) {
            return res;
        }
        int wordCount = words.length;
        int wordLen = words[0].length();

        Map<String, Integer> wordsMap = new HashMap<>();
        for(String w : words) {
            wordsMap.put(w, wordsMap.getOrDefault(w, 0) + 1);
        }
        
        int i = 0;
        while(i <= s.length() - wordCount * wordLen) {
            int j = 0, k = i;
            Map<String, Integer> splitWordMap = new HashMap<>();
            for(; j < wordCount; j++) {
                String w = s.substring(k, k + wordLen);
                k += wordLen;
                if (wordsMap.containsKey(w)) {
                    splitWordMap.put(w, splitWordMap.getOrDefault(w, 0) + 1);
                    if (splitWordMap.get(w) > wordsMap.get(w)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j == wordCount) {
                res.add(i);
            }
            i++;
        }
        return res;
    }
}

