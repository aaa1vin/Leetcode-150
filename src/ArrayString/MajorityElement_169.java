package ArrayString;

public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        /*
        Approach 1a: Sorting method
         */
        int n = nums.length;
//        Arrays.sort(nums);
//
//        int count=0;
//        if (n<2) return nums[0];
//        for (int i=1; i<n; i++) {
//            if (nums[i] == nums[i-1]) {
//                count++;
//            }
//
//            if ((count+1) > (n/2)) {
//                return nums[i];
//            }
//        }
//        return -1;

        /*
        Approach 1b: Sorting method
         */
//        return nums[n/2];

        /*
        Approach 2: Hashmap
         */
//        Map<Integer,Integer> hm = new HashMap<>();
//        for (int i=0; i<n; i++) {
//            //if key exist, else create
//            if (hm.containsKey(nums[i])) {
//                hm.put(nums[i], hm.get(nums[i]) +1);
//            } else {
//                hm.put(nums[i],1);
//            }
//        }
//
//        for (var entry: hm.entrySet()) {
//            if (entry.getValue() > n/2) {
//                return entry.getKey();
//            }
//        }
//        return 0;

        /*
        Approach 3: Moore Voting Algorithm
         */
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
