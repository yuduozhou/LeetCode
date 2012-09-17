// This is from heartfire.cc.
import java.util.Stack;
public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
         
        //for every i, height[0...i] is a subproblem
        int i = 0, max = 0;
        Stack<Ele> st = new Stack<Ele>();
        while (i < height.length) {
            if (st.empty() || height[i] > st.peek().height) {
                st.push(new Ele(height[i], i));
            }
            else if (st.peek().height > height[i]){ //need to ignore the case where st.peek().height == height[i]
                int prev = 0;
                while (!st.empty() && st.peek().height > height[i]) {
                    Ele e = st.pop();
                    prev = e.index;
                    max = Math.max(max, e.height * (i - e.index));
                }   
                st.push(new Ele(height[i], prev));
            }
            i++;
        }
 
        //stack may contain a series of ascending heights
        while (!st.empty()) {
            Ele e = st.pop();
            max = Math.max(max, e.height*(i - e.index));
        }
 
        return max;
    }
 
    private class Ele {
        int height;
        int index;
 
        public Ele (int h, int i) {
            this.height = h;
            this.index = i;
        }
    }
}

// My recursive version, but cannot pass large test.
public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (height.length < 1){
            return 0;
        }
        if (height.length == 1){
            return height[0];
        }
        int l = 0;
        int r = height.length - 1;
        return findLargestRectangle(height, l, r);
    }

    public int findLargestRectangle(int[] height, int l, int r){
        if (l == r){
            return height[l];
        }
        int min = extractMin(height, l, r);
        int combine = (r - l + 1) * height[min];
        int left = (l < min) ? findLargestRectangle(height, l, min - 1) : height[l];
        int right = (min < r) ? findLargestRectangle(height, min + 1, r) : height[r];
        int bigger = (left > right)?left:right;
        return (combine > bigger)?combine : bigger;
    }

    // return the index of the minimum element between l and r, inclusive.
    public int extractMin(int[] height, int l, int r){
        int min = l;
        for (int i = l + 1; i <= r; i++){
            if (height[i] < height[min]){
                min = i;
            }
        }
        return min;
    }
}