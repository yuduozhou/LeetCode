public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n < 3) return 0;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = A[0];
        for (int i = 1; i < n; i++){
            lmax[i] = (lmax[i - 1] > A[i]) ? lmax[i - 1] : A[i];
        }
        rmax[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--){
            rmax[i] = (rmax[i + 1] > A[i]) ? rmax[i + 1] : A[i];
        }
        int total = 0;
        for (int i = 1; i < n - 1; i++){
            int low = (lmax[i - 1] < rmax[i + 1]) ? lmax[i - 1] : rmax[i + 1];
            total += (low > A[i]) ? (low - A[i]) : 0;
        }
        return total;
    }
}


/* Recursion */
public class Solution {
    public static int trap(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		if(n <3){
			return 0;
		}

		int capacity = 0;
		int max = 0;
		for (int i = 0; i < n; i++){
			if (A[i] > A[max]){
				max = i;
			}
		}

		capacity = calculateVolume(0, max, A) + calculateVolume(max, n - 1, A);

		return capacity;
	}

	public static int calculateVolume(int l, int r, int[] A){
		// Suppose i <= j
		if ((l - r) * (r - l) == -1 ||l==r ){
			return 0;
		}
		int capacity = 0;
		int max = -1;
		if (A[l] < A[r]){
			max = l;
			for (int i = l; i < r; i++){
				if (A[i] > A[max]){
					max = i;
				}
			}
			// Calcualate volume between max and A[r]
			for (int i = max + 1; i < r; i++){
				capacity += A[max] - A[i];
			}
			capacity += calculateVolume(l, max, A);
			return capacity;
		}
		else{ // A[l] >= A[r], right half
			max = r;
			for (int i = r; i > l; i--){
				if (A[i] > A[max]){
					max = i;
				}
			}
			// Calcualate volume between max and A[r]
			for (int i = max - 1; i > l; i--){
				capacity += A[max] - A[i];
			}
			capacity += calculateVolume(max, r, A);
			return capacity;
		}
	}
}