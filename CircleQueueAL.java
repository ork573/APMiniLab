
import java.util.*;

/**
 *  Implementation of Queue, using LinkedList (previous and next).
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class CircleQueueAL
{
    private ArrayList al;
    private static int currentNode = 0;
    /**
     *  Constructor for the SinglyLinkedList object
     *  Generates an empty list.
     */
    public CircleQueueAL()
    {
        al = new ArrayList();
    }

    /**
     *  Returns the head Object.
     *
     * @return  the head Object in Stack.
     */
    public Object getFirstObject()
    {
        if (al.get(0) == null)
            return null;
        else
            return al.get(0);
    }

    /**
     *  Returns the tail Objects.
     *
     * @return  the current Object in Stack.
     */
    public Object getLastObject()
    {
        if (al.get(al.size()-1) == null)
            return null;
        else
            return al.get(al.size()-1);
    }

    /**
     *  Returns the current Object
     *
     * @return  the current Object in Stack.
     */
    public Object getObject()
    {
        if (al.get(currentNode) == null)
            return null;
        else
            return al.get(currentNode);
    }

    /**
     *  Advances the current node.
     *
     */
    public void setNext()
    {
        currentNode++;
        // never let currentNode be out of bounds, wrap to head
        if (currentNode > al.size()-1)
            currentNode = 0;
    }

    /**
     *  Reverses the current node.
     *
     */
    public void setPrevious()
    {
        currentNode--;
        // never let currentNode be out of bounds, wrap to tail
        if (currentNode < 0)
            currentNode = al.size()-1;
    }

    /**
     *  Add a new object at the end of the Queue,
     *
     * @param  opaqueObject  is the data to be inserted in the Queue object.
     */
    public void add(Object opaqueObject)
    {
        al.add(opaqueObject);
    }

    /**
     *  Delete an object from the front of the Queue,
     *
     */
    public Object delete()
    {
        Object opaqueObject = null;
        if (al.get(0) != null){
            opaqueObject = al.get(0);
            al.remove(0);
        }
        return opaqueObject;
    }

    /**
     *  Returns a string representation of this Queue,
     *  polymorphic nature of toString overrides of standard System.out.print behavior
     *
     * @return    string representation of this Queue
     */
    public String toString()
    {
        String queueToString = "[";
        // start from the head and work up
        for(int i = 0;i < al.size()-1;i++)
        {
            queueToString += "("+al.get(i)+"), ";  // append the data to output string
        }                                       // loop 'till queue reaches tailNode
        queueToString += "("+al.get(al.size()-1)+")";
        queueToString += "]";
        return queueToString;
    }

    /**
     * Performs insertion sort based off of the contents of object
     */
    public void insertionSort() {   
        //continue while nodes remain in bounds
        for (int i = 1;i < al.size();i++) { 
            int j = i;
            Object temp = al.get(i);
            //walks slots backwards until key position in found
            while ( al.get(j-1).toString().compareTo(al.get(j).toString()) > 0 ) {
                //shifts object greater than key value to the right in list
                al.set(j,al.get(j-1));
                j--;
            }
            //place key in insertion position
            al.set(j,temp);
        } 
    }

    public void selectionSort() {   
        //continue while nodes remain in bounds
        for (int i = 0;i < al.size()-1;i++) { 
            int j = i+1;
            Object temp = al.get(i);
            int tempindex = i;
            //walks slots forwards noting lowest value
            while (j < al.size()) {
                if (temp.toString().compareTo(al.get(j).toString()) > 0){
                    temp = al.get(j);
                    tempindex = j;
                }
                j++;
            }
            //place key in insertion position
            al.set(tempindex,al.get(i));
            al.set(i,temp);
        } 
    }

    public static void main(String[] args){
        CircleQueueAL test = new CircleQueueAL();
        test.add("hi");
        test.add(5);
        test.add(8);
        test.add(1);
        test.delete();
        System.out.println(test);
        test.setNext();
        System.out.println(test.al.get(currentNode));
        test.setNext();
        System.out.println(test.al.get(currentNode));
        test.selectionSort();
        System.out.println(test);

    }
}

