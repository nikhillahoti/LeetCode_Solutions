
def removeNthFromEnd(head, n):
    """
    :type head: ListNode
    :type n: int
    :rtype: ListNode
    """

    p1 = head
    p2 = None

    while n > 1:
        n -= 1
        p1 = p1.next

    p2 = head

    while p1:
        p1 = p1.next
        p2 = p2.next

    p2.next = p2.next.next
    return head
