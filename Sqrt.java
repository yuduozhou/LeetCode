public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        double pivot = x/2;
        int up = (int) pivot;
        int down = 0;
        while (up >= down){
            if (pivot * pivot > x){
                if((pivot - 1) * (pivot -1) <= x){
                    return (int)pivot - 1;
                }
                up = (int) pivot;
                pivot = (up - down )/2;
            }
            else if (pivot * pivot < x){
                if((pivot + 1) * (pivot + 1) > x){
                    return (int) pivot;
                }
                if((pivot + 1) * (pivot + 1) == x){
                    return (int) pivot + 1;
                }
                down = (int) pivot;
                pivot += (up - down)/2;
            }
            else {
                return (int) pivot;
            }
        }
        return down;
    }
}