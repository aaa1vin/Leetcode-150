package ArrayString;

public class TrappingRainWater_42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};


        int count = 0;
        int size = height.length;
/*        // O(n) method
        int[] lm = new int[size];
        int[] rm = new int[size];

        lm[0] = height[0];
        for (int l=1; l<size; l++) {
            lm[l] = Math.max(height[l-1],lm[l-1]);
        }
        rm[size-1] = height[size-1];
        for (int r=size-2; r>=0; r--) {
            rm[r] = Math.max(lm[r+1],height[r]);
        }

        for (int i=0; i<size; i++) {
            int validMax = Math.min(lm[i],rm[i]);
            count += (validMax-height[i]);
        }*/

        // O(1) method
        int l=0, r=size-1;
        int lMax = height[0];
        int rMax = height[size-1];
        while (l<r) {
            if (lMax< rMax) {
                l+=1;
                lMax = Math.max(lMax, height[l]);
                count += lMax - height[l];
            } else {
                r-=1;
                rMax = Math.max(rMax, height[r]);
                count += rMax - height[r];
            }
        }
        System.out.println(count);
    }
}