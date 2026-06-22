class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int ele: prices) {
            if(ele < minPrice) {
                minPrice = ele;
            } else {
                maxProfit = Math.max(maxProfit, ele - minPrice);
            }
        }

        return maxProfit;
    }
}
