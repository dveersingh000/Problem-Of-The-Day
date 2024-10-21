class Solution {
    public int power(int x, int y, int p) {
        int result = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1)
                result = (result * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return result;
    }

    public int countgroup(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        int xs = 0;
        for (int num : arr) {
            xs ^= num;
        }
        if (xs == 0) {
            return (power(2, n - 1, mod) - 1 + mod) % mod;
        }
        return 0;
    }
}
