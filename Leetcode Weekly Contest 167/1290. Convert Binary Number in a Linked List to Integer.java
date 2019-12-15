/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans;
    public int getDecimalValue(ListNode head) {
        ans = 0;
        pow(head);
        return ans;
    }
    
    public int pow(ListNode head) {
        if(head == null) return 0;
        int pow = pow(head.next);
        if(head.val == 1) ans += Math.pow(2, pow);
        return 1 + pow;
    }
}