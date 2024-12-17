package DailyQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit {
    public static void main(String[] args) {
        String s = "aababab";
        int repeatLimit = 2;

        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            //ASCII code comparison
            freq[c - 'a']++;
        }
        System.out.println(Arrays.toString(freq));

        // Greedy approach - set the order of priority first
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                // add to queue if val > 0
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        // if pq still has values
        while (!maxHeap.isEmpty()) {
            //retrieve element of the highest priority
            int[] curr = maxHeap.poll();
            char currChar = (char) ('a' + curr[0]);
            int count = Math.min(curr[1], repeatLimit);
            for (int i = 0; i < count; i++) {
                sb.append(currChar);
            }
            curr[1] -= count;

            if (curr[1] > 0) {
                if (maxHeap.isEmpty()) break;

                int[] next = maxHeap.poll();
                char nextChar = (char) ('a' + next[0]);
                sb.append(nextChar);
                next[1]--;

                if (next[1] > 0) {
                    maxHeap.offer(next);
                }
                maxHeap.offer(curr);
            }
        }
        System.out.println(sb.toString());
    }
}