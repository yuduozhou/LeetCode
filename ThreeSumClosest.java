public class Solution {
    public static int closest;
    public static int threeSum;
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        closest = Integer.MAX_VALUE;
        threeSum = Integer.MIN_VALUE;
        if (num.length < 3) return 0;

        Arrays.sort(num);

        for (int i = 0; i < num.length; i++){
            calculateTuples(num, target, i);
            if (threeSum == target) return threeSum;
            while (i + 1 < num.length && num[i + 1] == num[i]){
                i++;
            }
        }
        return threeSum;
    }
    public void calculateTuples(int[] num, int target, int i){
        int lp = i + 1;
        int rp = num.length - 1;
        while(lp < rp){
            int sum = num[i] + num[lp] + num[rp];
            update3Sum(i, lp, rp, target, num);
            if (sum == target){
                while (lp + 1 < rp && num[lp + 1] == num[lp]) {
                    lp ++;
                }
                lp ++;
                while (rp - 1 > lp && num[rp - 1] == num[rp]) {
                    rp --;
                }
                rp --;
            }
            else if (sum < target){
                lp ++;
            }
            else{
                rp --;
            }
        }
    }
    
    public void update3Sum(int i, int lp, int rp, int target, int[] num){
        int sum = num[lp] + num[rp] + num[i];
        int diff = Math.abs(target - sum);
        if (diff < closest){
            closest = diff;
            threeSum = sum;
        }
    }
}