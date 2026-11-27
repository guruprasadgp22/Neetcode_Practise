class Solution {
    public int maxArea(int[] heights) {
        int maxFill = 0;
        int left = 0;
        int right = heights.length-1;

        while(left < right) {
            maxFill = Math.max(maxFill, (right - left) * Math.min(heights[left], heights[right]));

            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxFill;
    }
}
