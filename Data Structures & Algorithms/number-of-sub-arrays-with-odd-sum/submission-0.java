class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int odd = 0;
        int even = 1;
        int res = 0;
        int MOD = 1_000_000_007;
        long sum = 0;
        for(int i=0;i<n;i++) {
            sum += arr[i];
            if(sum % 2 == 0) {
                even++;
                res = (res + odd) % MOD;
            } else {
                odd++;
                res = (res + even) % MOD;
            }
        }
        return res;
    }
}