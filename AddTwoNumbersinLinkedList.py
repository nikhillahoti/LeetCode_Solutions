
class ListNode(object):
     def __init__(self, x):
         self.val = x
         self.next = None


def addTwoNumbers(l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """

    curr = None
    head = None
    node = None
    remainder = 0

    while l1 and l2:
        sum = l1.val + l2.val + remainder
        remainder = sum / 10
        sum %= 10

        node = ListNode(sum)

        if head is None:
            head = node
            curr = node
        else:
            curr.next = node
            curr = curr.next

        l1 = l1.next
        l2 = l2.next

    if l1 is None:
        while l2:
            sum = l2.val + remainder
            remainder = sum / 10
            sum %= 10

            node = ListNode(sum)

            curr.next = node
            curr = curr.next
            l2 = l2.next

    if l2 is None:
        while l1:
            sum = l1.val + remainder
            remainder = sum / 10
            sum %= 10

            node = ListNode(sum)

            curr.next = node
            curr = curr.next
            l1 = l1.next

    if l1 is None and l2 is None and remainder > 0:
        node = ListNode(remainder)
        curr.next = node

    return head



