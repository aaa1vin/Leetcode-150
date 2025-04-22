package Blind75.Sequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

//    public static int[][] merge(int[][] intervals) {
//        int max = 0;
//        // Find max in first column of every row
//        for (int i = 0; i < intervals.length; i++) {
//            max = Math.max(intervals[i][0], max);
//        }
//
//        int start, end;
//        int[] mp = new int[max + 1];
//
//        for (int i = 0; i < intervals.length; i++) {
//            start = intervals[i][0];
//            end = intervals[i][1];
//            mp[start] = Math.max(end + 1, mp[start]);
//        }
//
//        int idx = 0;
//        start = -1;
//        end = -1;
//
//        for (int i = 0; i < mp.length; i++) {
//            if (mp[i] != 0) {
//                if (start == -1) start = i;
//
//                end = Math.max(mp[i] - 1, end);
//            }
//
//            // update in-place
//            if (end == i) {
//                intervals[idx++] = new int[] { start, end };
//                start = -1;
//                end = -1;
//            }
//        }
//
//        if (start != -1) {
//            intervals[idx++] = new int[] { start, end };
//        }
//
//        if (intervals.length == idx) {
//            return intervals;
//        }
//
//        int[][] res = new int[idx][];
//        for (int i = 0; i < idx; i++) {
//            res[i] = intervals[i];
//        }
//
//        return res;
//    }

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];

        for (int i = 1; i<n; i++) {
            if (temp[1] >= intervals[i][0]) {
                // Update the ending time
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                // Push temp value in case of no overlap
                result.add(temp);
                temp = intervals[i];
            }
        }

        result.add(temp);
        return result.toArray(new int[result.size()][]);
    }

//    public int[][] merge(int[][] intervals) {
//        if (intervals == null || intervals.length == 0) return new int[0][];
//
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//        List<int[]> list = new ArrayList<>();
//
//        int start = intervals[0][0];
//        int end = intervals[0][1];
//        for (int i = 1; i < intervals.length; i++) {
//            int l =  intervals[i][0];
//            int r = intervals[i][1];
//            if (l >= start && l <= end && r > end) {
//                end = r;
//            } else if (l > end) {
//                list.add(new int[]{start, end});
//                start = l;
//                end = r;
//            }
//        }
//        list.add(new int[]{start, end});
//        return list.toArray(new int[0][0]);
//    }
}