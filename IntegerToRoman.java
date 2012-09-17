public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num == 0) return "";
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        setup(map);
        int[] dig = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String result = "";
        for (int i = 0; i < dig.length; i++){
            int pivot = dig[i];
            while(num - pivot >= 0){
                result += map.get(pivot);
                num -= pivot;
            }
        }
        return result;        
    }
    public void setup(HashMap<Integer, String> map) {
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
	}
}
