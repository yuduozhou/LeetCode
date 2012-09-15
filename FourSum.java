import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> hSet = new HashSet<ArrayList<Integer>>();
        int n = num.length;
        Arrays.sort(num);
        for (int i = 0; i < n - 3; i++){
            for (int j = i + 1; j < n - 2; j ++){
                int p = j + 1;
                int q = n - 1;
                while (p < q){
                    int sum = num[i] + num[j] + num[p] + num[q];
                    if (sum == target){
                        ArrayList<Integer> quadtuple = new ArrayList<Integer>();
                        quadtuple.add(num[i]);
                        quadtuple.add(num[j]);
                        quadtuple.add(num[p]);
                        quadtuple.add(num[q]);
                        hSet.add(quadtuple);
                        while (p + 1 < q && num[p + 1] == num[p]) {
                            p ++;
                        }
                
                        while (q - 1 > p && num[q - 1] == num[q]) {
                            q --;
                        }

                        p ++;
                        q --;
                    } 
                    else if(sum < target){
                        p ++;
                    }
                    else{
                        q --;
                    }
                }
                while (j + 1 < n - 2 && num[j + 1] == num[j]){
                    j ++;
                }
            }
            while (i + 1 < n - 3 && num[i + 1] == num[i]){
                    i ++;
            }
        }
        result = new ArrayList<ArrayList<Integer>>(hSet);
        return result;
    }
}