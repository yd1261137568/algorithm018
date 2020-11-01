package week02.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T49 {
    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        for (List<String> list : groupAnagrams(arr)) {
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        String[] prime = {"2", "3", "5", "7", "11", "13", "17", "19", "23", "29", "31", "37", "41", "43", "47", "53", "59", "61", "67", "71", "73", "79", "83", "89", "97", "101"};

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            BigInteger bigInteger = new BigInteger("1");

            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i) - 'a';
                bigInteger = bigInteger.multiply(new BigInteger(prime[c]));
            }

            if (map.containsKey(bigInteger.toString())) {
                map.get(bigInteger.toString()).add(str);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                map.put(bigInteger.toString(), strings);
            }

        }
        return new ArrayList<>(map.values());

    }
}
