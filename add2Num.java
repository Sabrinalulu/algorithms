class Solution {
    // Definition for singly-linked list
    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        
        while(l1 != null || l2!= null){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int addition = x+y+carry; // add previous carry
            
            carry = addition/10; // new carry
            current.next = new ListNode(addition%10);
            current = current.next;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        // add on the last digit to last node
        if(carry > 0){
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void printListNode(ListNode res){
        ListNode curr = res;
        while(curr != null){
            System.out.print(curr.val);
            curr = curr.next;
        }
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);

        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(2);

        ListNode res = addTwoNumbers(l1, l2);
        printListNode(res);
    }
}