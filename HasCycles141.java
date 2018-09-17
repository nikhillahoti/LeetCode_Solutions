 public boolean hasCycle(ListNode head) {
       
        if(head == null) return false;
       
        ListNode head1 = head;
        ListNode head2 = head.next;
       
        while(head2 != null && head2.next != null){
            if(head1.val == head2.val){
                return true;
            }
            head1 = head1.next;
            head2 = head2.next.next;
        }
        return false;
    }


