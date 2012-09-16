public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int area = 0;
        if (height.length < 2){
            return area;            
        }
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int h = (height[left] < height[right]) ? height[left] : height[right];
            int currentArea = h * (right - left);
            area = (currentArea > area) ? currentArea : area;
            if (height[left] < height[right]){
                left ++;
            }
            else {
                right --;                
            }
        }
        return area;
    }
}