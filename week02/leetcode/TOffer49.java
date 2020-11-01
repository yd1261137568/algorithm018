package week02.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TOffer49 {
    public static void main(String[] args) {

        System.out.println(nthUglyNumber(5));
    }

    public static int nthUglyNumber(int n) {
        int index = 1;

        int num = 1;

        while (index < n) {

            Set<Integer> set = new HashSet<>();
            num++;
            for (int i = 2; i <=num ; i++) {
                if (num % i == 0) {
                    set.add(i);
                }
            }

            if (set.size() == 1 && (set.contains(2) || set.contains(3) || set.contains(5))) {
                index++;
            } else if (set.size() == 2 && ((set.contains(2) && set.contains(3)) || (set.contains(2) && set.contains(5) || (set.contains(3) && set.contains(5))))) {
                index++;
            } else if (set.size() == 3 && set.contains(2) && set.contains(3) && set.contains(5)) {
                index++;
            }
        }

        return num;
    }
}
