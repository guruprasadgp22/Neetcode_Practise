class Solution {
    public int countPrimes(int n) {
        int count = 0;
        if(n < 2) {
            return count;
        }
        for(int i = 2;i<n;i++) {
            if(isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    public boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }

        if(num == 2 || num == 3) {
            return true;
        }

        if(num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for(int i=5;i*i<=num;i+=6) {
            if(num % i == 0 || num % (i+2) == 0) {
                return false;
            }
        }

        return true;
    }
}