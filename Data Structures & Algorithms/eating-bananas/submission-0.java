class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int ele: piles) {
            max = Math.max(ele, max);
        }

        return binarySearch(1, max, h, piles);
    }

    private int binarySearch(int left, int right, int h, int[] piles) {
        while(left < right) {
            int mid = left + (right - left)/2;

            if(canEat(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canEat(int[] arr, int mid, int h){
        int hour = 0;

        for(int ele: arr) {
            hour += ele/mid;
            if(ele % mid != 0) {
                hour++;
            }
        } 

        return hour <= h;
    }
}
