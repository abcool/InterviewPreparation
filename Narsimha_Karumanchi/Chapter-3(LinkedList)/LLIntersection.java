class LLIntersection{

    static ListNode headA;
    static ListNode headB;
    public static void main(String[] args) {

        // 4-1
        headA = new ListNode(4);
        var n1A = new ListNode(1);
        headA.next=n1A;

        var n8 = new ListNode(8);
        var n4 = new ListNode(4);
        var n5 = new ListNode(5);

        n1A.next=n8;

        headB = new ListNode(5);
        var n6 = new ListNode(6);
        var n1B = new ListNode(1);

        headB.next=n6;
        n6.next=n1B;

        n1B.next=n8;

        System.out.println("Intersection of list A and B is "+ intersection(headA, headB).val);

    }

    // 2 pointer approach

    static ListNode intersection(ListNode headA, ListNode headB){
       ListNode ptr1 = headA;
       ListNode ptr2 = headB;
        if(ptr1==null || ptr2==null) return null;
       while(ptr1!=ptr2){
        if(ptr1==null)
            ptr1=headB;
        else
            ptr1=ptr1.next;

        if(ptr2==null)
            ptr2=headA;
        else
            ptr2=ptr2.next;
       }
       return ptr1;
    }


    // length approach
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode ptr1=headA;
    //     ListNode ptr2=headB;
    //     int len1=0;
    //     int len2=0;
    //     while(ptr1!=null){
    //         len1++;
    //         ptr1=ptr1.next;
    //     }
    //     while(ptr2!=null){
    //         len2++;
    //         ptr2=ptr2.next;
    //     }
    //     ptr1=headA;
    //     ptr2=headB;
    //     if(len1>len2){
    //         int diff = len1-len2;
    //         while(diff>0){
    //             ptr1=ptr1.next;
    //             diff--;
    //         }
    //     }
    //     if(len2>len1){
    //         int diff = len2-len1;
    //         while(diff>0){
    //             ptr2=ptr2.next;
    //             diff--;
    //         }
    //     }
    //     while(ptr1!=ptr2){
    //         ptr1=ptr1.next;
    //         ptr2=ptr2.next;
    //     }
    //     return ptr1;
    // }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val=val;
    }
    
}
