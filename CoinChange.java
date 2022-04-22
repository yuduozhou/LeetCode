class Solution {
    public int coinChange(int[] coins, int amount) {
      if (amount == 0) return 0;
      int[] change = new int[amount+1];
      change[0] = 0;
      for (int c : coins) {
        if (c <= amount)
          change[c] = 1;
      }
      for (int i = 1; i <= amount; i++) {
        if (change[i] == 1) continue;
        int min = -1;
        for (int c:coins) {
          if (i - c>0 && change[i-c] != -1) {
            int withC = change[i-c] + 1;
            min = min < 0 ? withC : Math.min(withC, min);
          }
        }
        change[i] = min;
      }
      return change[amount];
    }
}
