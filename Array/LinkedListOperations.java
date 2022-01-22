import java.util.*;
public class LinkedListOperations
{
    Node head;
    int size;
    LinkedListOperations()
    {
        size = 0;
    }

    public class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        size++;
        if(head == null)        //if list is empty
        {
            head = newNode;
        }
        else
        {
            newNode.next = head;    //Linking the newNode with reference of old head node
            head = newNode;         //Storing the new head node
        }
    }

    public void addMiddle(int data, int location)
    {
        Node newNode = new Node(data);
        int i = 0;
        Node currNode = head;
        if(head == null)        //if list is empty
        {
            head = newNode;
            size++;
        }
        else if(location == 0)      //adding at beginning
        {
            addFirst(data);
        }
        else if(location < size)    //adding at middle
        {
            while(i < location-1)
            {
                currNode = currNode.next;
                i++;
            }
            newNode.next = currNode.next;
            currNode.next = newNode;
            size++;
        }
        else if(location == size)   //adding at last
        {
            addLast(data);
        }
        else
        {
            System.out.println("Invalid Position");
        }
    }

    public void addLast(int data)
    {
        Node newNode = new Node(data);
        size++;
        if(head == null)        //if list is empty
        {
            head = newNode;
        }
        else
        {
            Node currNode = head;       //We are not directly using head node, to avoid loss of data at the beginning of the list
            while(currNode.next != null)
            {
                currNode = currNode.next;       //traversing through the list till last node, i.e, when next is null
            }
            currNode.next = newNode;    //Linking the currNode with reference of newNode
        }
    }

    public void deleteFirst()
    {
        if(head == null)        //if list is empty
        {
            System.out.println("List is empty!");
        }
        else
        {
            head = head.next;
            size--;
        }
    }

    public void deleteMiddle(int location)
    {
        if(head == null)    //if list is empty
        {
            System.out.println("List is empty");
        }
        else if(location == 0)  //deletion at beginning
        {
            deleteFirst();
        }
        else if(location < size)    //deletion at middle
        {
            int i = 0;
            Node prevNode = head;
            Node currNode = head.next;
            while(i < location-1)
            {
                prevNode = currNode;
                currNode = currNode.next;
                i++;
            }
            prevNode.next = currNode.next;  //element at i-1 th position is linked to i+1 th position
            size--;
        }
        else if(location == size)   //deletion at end
        {
            deleteLast();
        }
        else
        {
            System.out.println("Invalid Position");
        }
    }

    public void deleteLast()
    {
        if(head == null)        //if list is empty
        {
            System.out.println("List is empty!");
        }
        else if(head.next == null)      //if list has only one element
        {
            head = null;
            size--;
        }
        else
        {
            Node secondLastNode = head;
            Node lastNode = head.next;
            while(lastNode.next != null)
            {
                secondLastNode = secondLastNode.next;
                lastNode = lastNode.next;
            }
            secondLastNode.next = null;
            size--;
        }
    }

    public Node delN(Node head, int n)
    {
        if(head == null)
        {
            return null;
        }
        Node currNode = head;
        int i = 1;
        while(i < size-n)
        {
            currNode = currNode.next;
            i++;
        }
        currNode.next = currNode.next.next;
        return head;
    }

    public int getSize()
    {
        return size;
    }

    public int searchItem(int item)
    {
        Node currNode = head;
        int pos = 1;
        while(currNode != null)
        {
            if(currNode.data == item)
            {
                return pos;
            }
            currNode = currNode.next;
            pos++;
        }
        return -1;
    }

    public Node iterativeReverse()
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        else
        {
            Node prevNode = head;
            Node currNode = head.next;
            while(currNode != null)
            {
                Node nextNode = currNode.next;      //prevNode will store i-1 th element, currNode will store i th element, nextNode will store i+1 th element.
                currNode.next = prevNode;       //we will make current node point to previous node, instead of next node, so as to reverse it.
                
                prevNode = currNode;        //we keep on updating/storing the reversed list in previous node.
                currNode = nextNode;        //currNode will have the next element, that was present in next node.
            }
            head.next = null;   //in the original list, the first element is still pointing to the original second element, so removing that link
            head = prevNode;    //storing the reversed node inside the main list or head node
            return head;
        }
    }

    public Node recursiveReverse(Node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        else
        {
            Node newHead = recursiveReverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

    public void printList()
    {
        Node currNode = head;
        while(currNode != null)
        {
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        LinkedListOperations ll = new LinkedListOperations();
        while(true)
        {
            System.out.println("\n1. Insertion at Beginning");
            System.out.println("2. Insertion at Middle");
            System.out.println("3. Insertion at End");
            System.out.println("4. Deletion at Beginning");
            System.out.println("5. Deletion at Middle");
            System.out.println("6. Deletion at End");
            System.out.println("7. Length");
            System.out.println("8. Search");
            System.out.println("9. Reverse");
            System.out.println("10. Delete Nth Node from End");
            System.out.println("11. Print");
            System.out.println("12. Exit");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            int item = 0, location = 0;
            switch(choice)
            {
                case 1:
                System.out.println("Enter number to add:");
                item = sc.nextInt();
                ll.addFirst(item);
                ll.printList();
                break;
                case 2:
                System.out.println("Enter number to add:");
                item = sc.nextInt();
                System.out.println("Enter location:");
                location = sc.nextInt();
                ll.addMiddle(item, location);
                ll.printList();
                break;
                case 3:
                System.out.println("Enter number to add:");
                item = sc.nextInt();
                ll.addLast(item);
                ll.printList();
                break;
                case 4:
                ll.deleteFirst();
                ll.printList();
                break;
                case 5:
                System.out.println("Enter location:");
                location = sc.nextInt();
                ll.deleteMiddle(location);
                ll.printList();
                break;
                case 6:
                ll.deleteLast();
                ll.printList();
                break;
                case 7:
                System.out.println("Length: "+ll.getSize());
                break;
                case 8:
                System.out.println("Enter element to search");
                item = sc.nextInt();
                System.out.println("Position: "+ll.searchItem(item));
                break;
                case 9:
                ll.head = ll.recursiveReverse(ll.head);
                ll.printList();
                break;
                case 10:
                System.out.println("Enter nth node from end to be deleted:");
                int n = sc.nextInt();
                ll.head = ll.delN(ll.head, n);
                ll.printList();
                break;
                case 11:
                ll.printList();
                break;
                case 12:
                System.exit(0);
                default:
                System.out.println("Invalid Choice");
            }
        }
    }
}