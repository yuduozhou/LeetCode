import java.util.*;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++){
            myMap.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++){
            if (myMap.containsKey(target - numbers[i])){
                int j = myMap.get(target - numbers[i]) +1;
                i++;
                result[0] = (i < j) ? i : j;
                result[1] = (i < j) ? j : i;
                return result;
            }
        }
        return result;
    }
}