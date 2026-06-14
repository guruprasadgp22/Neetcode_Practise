/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode curr = head;
        ArrayList<Integer> arr = new ArrayList<>();

        while(curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int max = 0;
        int left = 0;
        int right = arr.size() - 1;

        while(left < right) {
            max = Math.max(max, arr.get(left++) + arr.get(right--));
        }

        return max;
    }
}