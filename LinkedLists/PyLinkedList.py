#node class
class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
        self.prev = None
    def __str__(self):
        node = self
        output =""
        while node:
            output += str(node.value) + " "
            node = node.next
        return output

def list2linkedlist(l):
    if l == []:
        return None
    head = Node(l[0])
    n = head
    for i in range(1,len(l)):
        new = Node(l[i])
        n.next = new
        n = n.next
    return head

def reverse(node):
    prev = None
    cur = node
    while cur:
        tmp = cur.next
        cur.next = prev
        prev = cur
        cur = tmp
    return prev
        

def rev(node):
    if node == None:
        return node
    if node.next == None:
        return node
    newNode = rev(node.next)
    node.next.next = node
    node.next = None
    return newNode
    


if __name__=='__main__':
    l1 = [1,3,5,7,9]
    l2 =[2,4,6,8,10,11]
    n1 = list2linkedlist(l1)
    n2 = list2linkedlist(l2)
    #print(n1)
    print(n2)
    new = rev(n2)
    print(new)
