import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length < 3) return result;

        Arrays.sort(num);

        for (int i = 0; i < num.length; i++){
            int target = - num[i];
            twoSumWithHole(num, target, i, result);            
            while (i + 1 < num.length && num[i + 1] == num[i]){
                i++;
            }
        }
        return result;
    }
    public void twoSumWithHole(int[] num, int target, int i, ArrayList<ArrayList<Integer>> result){
        int lp = i + 1;
        int rp = num.length - 1;
        while(lp < rp){
            int sum = num[lp] + num[rp];
            if (sum == target){
                ArrayList<Integer> couple = new ArrayList<Integer>();
                couple.add(num[i]);
                couple.add(num[lp]);
                couple.add(num[rp]);
                result.add(couple);
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
}