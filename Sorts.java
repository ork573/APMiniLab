
/**
 * Write a description of class isort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorts
{
    enum ListType {Standard, Bubble, Insert, Selection};
    ListType listType = ListType.Standard;

    private int[] list;
    private int[] blist; int bcompares = 0; int bswaps = 0;
    private int[] ilist; int icompares = 0; int iswaps = 0;
    private int[] slist; int scompares = 0; int sswaps = 0;

    /**
     * Constructor for objects of class isort
     */
    public Sorts()
    {
        int size = 50;
        list = new int[size];
        for (int i = 0; i < list.length; i++)
            list[i] = (int)(Math.random() * size) + 1;

        blist = list.clone();
        this.BubbleSort();
        ilist = list.clone();
        this.InsertionSort();
        slist = list.clone();
        this.SelectionSort();
    }

    public String toString() {
        int[] list;

        switch(listType) {
            case Standard:
            System.out.println("Original List");
            list = this.list;
            break;
            case Bubble:
            System.out.println("Bubble Sort -- "
                + " Operations: " + (this.bcompares + this.bswaps)
                + " Compares: " + this.bcompares
                + " Swaps: " + this.bswaps);
            list = this.blist;
            break;
            case Insert:
            System.out.println("Insertions Sort -- "
                + " Operations: " + (this.icompares + this.iswaps)
                + " Compares: " + this.icompares
                + " Swaps: " + this.iswaps);
            list = this.ilist;
            break;
            case Selection:
            default:
            System.out.println("Selection Sort -- "
                + " Operations: " + (this.scompares + this.sswaps)
                + " Compares: " + this.scompares
                + " Swaps: " + this.sswaps);
            list = this.slist;
        }

        String output = "[";
        for (int i = 0; i < list.length; i++)
            output += " " + list[i];
        return output +" ]";    
    }

    private int[] BubbleSort() { 

        // iterate list, one less than length
        for (int i = 0; i < blist.length - 1; i++) {

            // bubble sort key logic
            for (int k = 1; k < blist.length - i; k++) {

                // analytics
                this.bcompares++; // compare counter

                // bubble sort swap logic
                if (blist[k-1] > blist[k]) {
                    int swap = blist[k];
                    blist[k] = blist[k-1];
                    blist[k-1] = swap;

                    // analytics
                    this.bswaps++; // swap counter
                }

            }

        }
        return blist;
    }

    private int[] InsertionSort() {
        // iterate list, one less than length
        for (int i = 0; i < ilist.length - 1; i++) {

            // insertion sort key logic
            int k = i + 1;
            int swap = ilist[k];            
            while( k > 0 && swap < ilist[k-1]) {
                ilist[k] = ilist[k-1];
                k--;

                // analytics
                this.icompares++; // compare counter
                this.iswaps++; // shift counter
            }
            ilist[k] = swap;

            this.iswaps++;  // increment swap counter

        }

        return ilist;
    }

    private int[] SelectionSort() {

        // iterate list, one less than length
        for (int i = 0; i < slist.length -1; i++) {

            //variables to find smallest value
            int temp = slist[i];
            int tempindex = i;
            for ( int k = 1; k < slist.length - i; k++) {
                if (slist[i+k] < temp){
                    temp = slist[i+k];
                    tempindex = i+k;
                }   
                // analytics
                this.scompares++; // compare counter
            }
            if (slist[i] > temp){
                slist[tempindex] = slist[i];
                slist[i] = temp;
                this.sswaps++;  // increment swap counter
            }

        }
        return slist;
    }

    /**
     *
     */
    public static void main(String[] args)
    {
        // Original List
        Sorts is = new Sorts();
        System.out.println(is);

        // Bubble Sort
        is.listType = ListType.Bubble;
        System.out.println(is);

        // Insertion Sort
        is.listType = ListType.Insert;
        System.out.println(is);
        
        //Selection Sort
        is.listType = ListType.Selection;
        System.out.println(is);
    }
}
/**
 * Insertion Sort is the best, requiring fewest operations overall. It is balanced in comparisons and swaps, so that fewer comparisons are needed.
 * Bubble Sort, like Selection Sort, makes a set, high number of comparisons, and both set one value in its correct place at the end of an iteration of the outer loop, but Bubble Sort takes often many swaps to make this happen whereas Selection Sort can do it in one per iteration.
 * Insertion Sort, instead of effectively comparing all items with each other like Selection Sort, only compares each item with those that come before it until they cease to be larger, so some items are not compared. However, while the total comparisons may be about half as much as in Selection Sort, the number of swaps is almost the same. As a result, the total iterations tend to be just under those of Selection Sort. 
 */