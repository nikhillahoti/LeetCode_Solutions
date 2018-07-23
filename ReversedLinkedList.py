class ListNode(object):
     def __init__(self, x):
         self.val = x
         self.next = None

def reverseList(head, m, n):

    temp = ListNode(-1)
    temp.next = head
    head = temp
    count = 1
    while count < m:
        temp = temp.next
        count += 1


    left = None
    right = None
    curr = temp.next
    head2 = curr
    count = m - 1

    while curr != None and count < n:
        right = curr.next
        curr.next = left
        left = curr
        curr = right
        count += 1

    temp.next = left
    head2.next = curr

    return head.next

def printLinkedList(left):
    while left != None:
        print(left.val)
        left = left.next

l1 = ListNode(1)
l2 = ListNode(2)
l3 = ListNode(3)
l4 = ListNode(4)
l5 = ListNode(5)
l6 = ListNode(6)

l1.next = l2
l2.next = l3
l3.next = l4
l4.next = l5
l5.next = l6

printLinkedList(reverseList(l1, 3, 5))
