//3217. Delete Nodes From Linked List Present in Array
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        ListNode dummy=new ListNode(0,head);
        ListNode prev=dummy;
        for(int i=0;i<nums.length;i++) mp.put(nums[i],1);
        while(head!=null)
        {
            if(mp.containsKey(head.val)) prev.next=head.next;
            else prev=head;
            head=head.next;
        }
        return dummy.next;
    }
}
