//Data Structures and Algorithms
//Edilberto Carrizales

//Generic Linked List

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GenLinkedList<T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    //addFront
    public void addFront(T data)
    {
        if (head == null) //if our head is null, then our list must be empty
        {
            //If our list is empty, then we just have to add a new node with our data (d) and set our pointer to null
            head = new Node<>(data, null);

            //and our tail will be equal to our head (since we only want one node)
            tail = head;
        }
        else //else if there are already some nodes in the list
        {
            //then we want the new head be a new node of d (data) pointing to the old head "head"
            //the right side is the old value, the left side is the new value being set to
            head = new Node<>(data, head);
        }
        size++; //our size will increase since we added a new node
    } // end of public void addFront

    //addEnd
    public void addEnd(T data)
    {
        if (head == null) // if our tail is null, then our list must also be empty
        {
            //If our list is empty, then we just have to add a new node with our data (d) and set our pointer to null
            head = new Node<>(data, null);

            //and our tail will be equal to our head (since we only want one node)
            tail = head;
        }
        else //else if there are already some nodes in the list
        {
            //tail.next will make a new tail after our current tail
            tail.next = new Node<>(data, null);

            tail = tail.next; //will move our "current tail" to the one we just created by assigning it to it
        }
        size++; //our size will increase since we added a new node
    } //end of public void addEnd

    //removeFront
    public void removeFront()
    {
        if(head == null) // if our list is empty
        {
            //We throw an exception since there is nothing to remove
            throw new NoSuchElementException();
        }
        else if(head == tail) // when head an tail are the same we know that means there is one node
        {
            // we set both the head and tail to null so that there is nothing else in this node (its like setting them to nothing)
            head = null;
            tail = null;
        }
        else //else there must be more than one node in the list
        {
            //we assign our current data in our head to a variable named old data (as this node will be removed and it will thus become old data)
            head = head.next; //we set our "current head" to the next head meaning it was removed
        }
        size--; //reduce the size of the list since we removed one element
    } //end of public T removeFront

    //removeEnd

    public void removeEnd()
    {
        if(head == null)
        {
            //we throw an exception since there is nothing to remove
            throw new NoSuchElementException();
        }
        else if(head == tail) // when the head is equal to the tail we know that means there is only one node
        {
            //We set both the head and the tail to null to remove the node
            head = null;
            tail = null;
        }
        else //else there must be more than one node in the list
        {
            Node<T> node = head; //we will use this as a variable name to traverse the while loop and set tail, etc, it doesn't have to be named node, it can be named anything its just easier for me to visualize with same name

            while(node.next != tail)
            {
                node = node.next; //this will allow us to traverse the linked list until our node.next is our tail (until it is equal to our tail)
            }

            //At this point node.next is equal to our tail since we traversed with the while until it was equal to tail.
            //Thus we can set node.next to null and it will be the same thing as setting our current tail to null, meaning removing it
            node.next = null;

            //Since our current tail was set to null using node.next, now we need a new tail, the node before node.next, is just node, so we can set our new tail equal to node
            tail = node;

            //TIP from past me to future me: to understand this more easily, draw a picture of a linked list and traverse it using the code

        }
        size--;
    } // end of public T removeEnd

    //get
    public T get(int i)
    {
        Node<T> node = head;

        if(i < 0 || i > size -1) //range check to make sure that i is inside our linked list
        {
            throw new ArrayIndexOutOfBoundsException("index " + i + " size " + size); // we write inside the exception to tell the user more information about the exception/error
        }
        else
        {
            //loop used to traverse the linked list until we find the index of the node we are looking for this is why Linked lists are O(n) unlike arrays
            for(int k = 0; k < i; k++)
            {
                node = node.next;
            }
            return node.data;
        }
    } // end of public T get

    //set
    public void set(int i, T data)
    {
        Node<T> node = head;

        if (i < 0 || i > size -1)
        {
            throw new ArrayIndexOutOfBoundsException("index " + i + " size " + size); // we write inside the exception to tell the user more information
        }
        else
        {
            //loop used to traverse the linked list until we find the index of the node we are looking for this is why Linked lists are O(n) unlike arrays
            for(int k = 0; k < i; k++)
            {
                node = node.next;
            }
            node.data = data; //we set the data of our node to our new data that we passed in
        }
    } // end of public void set

    //swap
    public void swap (int index1, int index2)
    {
        //Throw exceptions if any of the indexes is out of bounds
        if (index1 < 0 || index1 > size -1)
        {
            throw new ArrayIndexOutOfBoundsException("index " + index1 + " size " + size); // we write inside the exception to tell the user more information
        }
        else if (index2 < 0 || index2 > size -1)
        {
            throw new ArrayIndexOutOfBoundsException("index " + index2 + " size " + size); // we write inside the exception to tell the user more information
        }
        else
        {
            //temporary nodes to pass around the nodes
            Node<T> temp = null;
            Node<T> temp1 = null;
            Node<T> temp2 = null;

            temp = head;

            //loop swap the nodes as we traverse the linked list
            for(int i = 0; i< size; i++)
            {
                if(i == index1)
                {
                    temp1 = temp;
                }
                if(i == index2)
                {
                    temp2 = temp;
                }
                temp = temp.next;
            }
            //Swap the data
            T data = temp1.data;

            temp1.data = temp2.data;
            temp2.data = data; //we set the data of our node to our first data from temp1.data
        }
    } //end of public void swap

    //shift
    public void shift(int shifting)
    {
        //Will will give us the floor remainder of the argument we are passed
        //for example if our passed value is -1 this will turn it into 2
        //If we are passed -2 this will turn it into 1 which is exactly the shifting we need
        shifting = Math.floorMod(shifting,size);

        //loop to keep removing adding to the end and removing to the front, kind of like an iteration until our shifting value that was
        //passed is equal to 0. This will basically help us rotate values
        while (shifting-- != 0)
        {
            addEnd(head.data);
            removeFront();
        }
    }

    //removeMatching
    public void removeMatching(T data)
    {
        Node<T> node = head;
        Node<T> prevNode = null;

        int checkElement = size; // we can use this variable to check whether an element was found or not in our list

        //If our linked list is empty we can throw an exception
        if(head == null)
        {
            //we throw an exception since there is nothing to remove
            throw new NoSuchElementException();
        }
        while (node != null)
        {
            //if our node contains our data we can enter the conditional statement
            if (node.data == data)
            {
                if (node == head)
                {
                    head = head.next; //move to the next node
                }
                if (node == tail)
                {

                    tail = prevNode; //assign our tail to our previous node
                }
                //this is used skip a node to remove it
                prevNode.next = node.next;
                node = prevNode.next;
                size--; //reduce size of the list
            }
            else
            {
                //If no data is found in the current node we simply move on to the next node
                prevNode = node;
                node = node.next;
            }
        }

        //if we compare the initial size to the final size, we can check whether we found an element in the linked list or not
        //if the size does not decrease it means the element given was not found in the list and thus we can throw an exception
        if (checkElement == size)
        {
            throw new NoSuchElementException();
        }
    } // end of public void removeMatching

    //erase
    public void erase(int index, int numElements)
    {
        Node<T> node = head;
        Node<T> prevNode = null;

        //Used to check the index and throw an exception when we are out of bounds
        if (index < 0 || index > size -1 || numElements > size)
        {
            throw new ArrayIndexOutOfBoundsException("index " + index + " size " + size); // we write inside the exception to tell the user more information
        }
        while (index-- != 0)  //Here we can use a while loop to traverse the linked list
        {
            prevNode = node;
            node = node.next;
        }

        // When the node is equal to the head
        Node<T> tempNode = prevNode;

        //loop to remove the nodes according to the number of elements that were passed
        while(numElements-- != 0 )
        {
            if (tempNode == null)
            {
                break; // break once we reach a null on our tempNode
            }

            //set our tempNode to the next node to keep traversing and reduce the size
            tempNode = tempNode.next;
            size--;
        }

        //Once we reach the null we can let our tail equal to the previous node as we have reached the end of the linked list
        if (tempNode == null)
        {
            prevNode.next = null;
            tail = prevNode;
        }
        else
        {
            prevNode.next = tempNode.next;
        }
    } // end of public void erase

    //insertList
    public void insertList(int index, List<T> list)
    {
        Node<T> node = head;
        Node<T> prevNode = null;

        if(index < 0 || index > size -1) //range check to make sure that i is inside our linked list
        {
            throw new ArrayIndexOutOfBoundsException("index " + index + " size " + size); // we write inside the exception to tell the user more information
        }
        //While loop to move to the next index
        while (index-- != 0)
        {
            prevNode = node;
            node = node.next;

        }
        if (node == head)
        {
            //loop to get the index of the list and add it to the front when the node is the head
            for(int i = list.size() -1; i>= 0; i--)
            {
                addFront(list.get(i));
            }
        }
        else if (node == tail)
        {
            //loop to get the index of the list and start adding it to the end when the node is the tail
            for(int i = 0; i< list.size(); i++)
            {
                addEnd(list.get(i));
            }
        }
        else
        {
            //If we are not at the head or tail we must add a new node
            for(T data : list)
            {
                Node<T> newNode = new Node<>(data, node);
                prevNode.next = newNode;
                size++;

                prevNode = prevNode.next;
            }
        }
    } //end of public void insertList

    //will gives us a compile error if we do not spell or write out our methods correctly (in this case the toString()) method if we forget where its uppercase or lowercase etc.
    //So its basically a way to know if you messed up and it will tell you that you messed up instead of just compiling and running the code and giving garbage as a result, this way you also know where to go back to
    @Override

    //This toString allows us to grab the data from our linked list so we can then print it out to console
    //It also allows us to format it nicely which is always a plus :)
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        Node<T> p = head;

        while (p != null)
        {
            sb.append(p.data + " ");
            p = p.next;
        }

        sb. append("]");
        return new String(sb);
    } //end of toString method

    private class Node<T>
    {
        T data;
        Node<T> next;

        //constructor
        Node(T data, Node<T> next)
        {
            this.data = data;
            this.next = next;
        }
    } // end of Node<T> class

    public static void main(String[] args)
    {
        GenLinkedList<Object> list = new GenLinkedList<>(); //a "list" is a new generic linked list

        //First I will print the list to show that it is empty
        System.out.println("As we can see below, our list is empty");
        System.out.println(list);

        System.out.println("---------------------------");

        //addFront - add front receives an item to add as a parameter, and adds to the front of the list.
        System.out.println("addFront - Here I will demonstrate the addFront method by adding, 3, 6, and 9 to the front of our previous list");
        list.addFront(3);
        list.addFront(6);
        list.addFront(9);

        System.out.println(list);

        System.out.println("---------------------------");

        //addEnd - add end receives an item to add as a parameter, and adds to the end of the list
        System.out.println("addEnd - Here I will demonstrate the addEnd method by adding 4, 8, and 12 to the end of our previous list");
        list.addEnd(4);
        list.addEnd(8);
        list.addEnd(12);

        System.out.println(list);

        System.out.println("---------------------------");

        //removeFront - removes a node from the front of the list
        System.out.println("removeFront - Here I will demonstrate removeFront by removing 9 and 6 from the front of our previous list");
        list.removeFront();
        list.removeFront();

        System.out.println(list);

        System.out.println("---------------------------");

        //removeEnd - removes a node from the end of the list
        System.out.println("removeEnd - Here I will demonstrate removeEnd by removing 12 from the end of our previous list");
        list.removeEnd();

        System.out.println(list);

        System.out.println("---------------------------");

        //set - receives a position and item as parameters, sets the element at this position, provided it is within the current size
        System.out.println("set - Here I will demonstrate set by setting the 4 to a 6 and setting the 8 to a 9 from our previous list");
        list.set(1,6);
        list.set(2,9);
        //we can also try setting it to a number out of bounds, this code below will throw an ArrayIndexOutOFBoundsException
        //list.set(3,7);

        System.out.println(list);

        System.out.println("---------------------------");

        //get - receives a position as a parameter, returns the item at this position, provided it is within the current size
        System.out.println("get - Here I will demonstrate get by showing the item at position/index 1 which for us should be 6 as seen in our previous list");
        System.out.println(list.get(1));
        //we can also try getting the position/index that is out of bounds, this code below will throw an ArrayIndexOutOFBoundsException
        //System.out.println(list.get(3));

        System.out.println("---------------------------");

        //swap - receives two index positions as parameters, and swaps the nodes at these positions, provided they are within current size
        System.out.println("swap - Here I will demonstrate swap by swapping the position/index 0 and 2, I will show our list before and after");
        System.out.println("Before: \n" + list);
        list.swap(0,2);
        System.out.println("After: \n" + list);
        //We can also try swapping a position that does not exist, the code below will throw an ArrayIndexOutOFBoundsException
        //list.swap(-1,5);

        System.out.println("---------------------------");

        //shift - receives an integer as parameter, and shifts the list forward or backward thi number of nodes, provided it is within the current size
        System.out.println("shift - Here I will demonstrate shift by shifting the nodes first, +1 to the left then -2 to the right");
        System.out.println("Original: \n" + list);
        list.shift(1);
        System.out.println("After +1 to the left: \n" + list);
        list.shift(-2);
        System.out.println("After -2 to the right: \n" + list);

        System.out.println("---------------------------");

        //removeMatching - receives a value of the generic type as a parameter and removes all occurrences of this value from the list
        System.out.println("removeMatching - Here I will demonstrate removeMatching by first adding a couple more elements and then using our matching to remove all elements at once");

        list.addFront(3);
        list.addFront(1);
        list.addFront(3);
        list.addFront(5);

        System.out.println("Here is our new list: \n" + list);

        System.out.println("Now I will remove all the number 3's at once using our removeMatching method: ");
        list.removeMatching(3);
        System.out.println(list);

        System.out.println("---------------------------");

        //erase- receives an index position and number of elements as parameters, and removes the elements beginning at the index position for the number of elements specified
        System.out.println("erase - Here I will demonstrate our erase method by erasing all the elements after the number 5 which is at index 0");
        list.erase(1,3);
        System.out.println(list);

        //if the index position together with the number of elements to erase is not within our linked list size, an ArrayOutOFBoundsException will occur
        //Used the commented code below to try it out
        //list.erase(1,9);

        System.out.println("---------------------------");

        //insertList - receives a generic list and an index position as parameters, and copies each value of the passe4d list into the current list starting at the index position
        System.out.println("insertList - Here I will demonstrate the insertList method, by inserting a list before our number 5");

        List<Object> secondList = new ArrayList<>();
        for(int k = 0; k < 5; k++)
        {
            secondList.add(k);
        }
        secondList.add('a');
        secondList.add('b');
        secondList.add('c');
        System.out.println("This is the list we will insert after our 5: \n" + secondList);

        list.insertList(0,secondList);
        System.out.println("This is our new list after insertion, as we can see we inserted the list and there is our previous 5: \n" + list);

        System.out.println("---------------------------");


    } // end of main

} // end of GenLinkedList class
