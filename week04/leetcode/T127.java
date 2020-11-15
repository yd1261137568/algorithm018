package week04.leetcode;

import java.util.*;

/**
 * 题目:127. 单词接龙
 * 地址:https://leetcode-cn.com/problems/word-ladder/
 * 说明:
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 */
public class T127 {
    public static void main(String[] args) {

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
//        wordList.add("dot");
        wordList.add("dog");
//        wordList.add("lot");
//        wordList.add("log");
//        wordList.add("cog");

        int i = ladderLength("hot", "dog", wordList);
        System.out.println(i);

    }

    /**
     * 广度优先遍历
     * 时间复杂度:O(N×C^2)
     * 空间复杂度:O(N×C^2)
     * 解题思路:
     * 通过构造给定单次的所有字母组合 来取字典中关联的单词,形成图,同时利用bfs取最短路径
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //构造字典Hash表
        Set<String> set = new HashSet<>();

        for (String word : wordList) {
            if(!word.equals(beginWord)){
                set.add(word);
            }
        }

        if (!set.contains(endWord)) {
            return 0;
        }
        //bfs使用队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        //定义去重Hash表 防止无限循环
        Set<String> setWord = new HashSet<>();
//        setWord.add(beginWord);

        //步数
        int step = 1;
        while (!queue.isEmpty()) {
            System.out.println(queue + "\t" + step);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                getWords(word, queue, setWord, set);
                if(word.equals(endWord)){
                    return step++;
                }
            }

            step++;
        }
        return 0;
    }

    /**
     * 找出给定单词在字典中能够转换的单词
     *
     * @param word
     * @param queue
     * @param setWord
     * @param set
     */
    private static void getWords(String word, Queue<String> queue, Set<String> setWord, Set<String> set) {
        for (int i = 0; i < word.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (word.charAt(i) != j) {
                    String newWord = word.substring(0, i) + String.valueOf(j) + word.substring(i + 1, word.length());
                    if (set.contains(newWord) && !setWord.contains(newWord)) {
                        queue.add(newWord);
                        setWord.add(newWord);
                    }
                }
            }
        }
    }
}
