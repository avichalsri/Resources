# https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        #prev stores last distinct value that we've found
        dummy = ListNode(0, head) 
        prev = dummy
        while head:
            if head.next and head.val == head.next.val:
                while head.next and head.val == head.next.val:
                    head = head.next 
                    
                prev.next = head.next 
                
            else:
                prev = prev.next 
                
            head = head.next 
            
        return dummy.next
