package problem14;
/**
 *
 * @author xaviersmet
 */

public class Solution14 {
    public static void main(String[] args) {
        long l = 1000001;
        long[] depths = new long[(int)l];
        depths[1] = 1; // depths[0] is discarded for the purpose of easy indexing 

        long max = 0;
        for (int i = 2; i < l; i++) {
            if (depths[i] == 0) {
                long value = i;
                long depthCounter = 0;
                while (value >= l || (value < l && depths[(int)value] == 0)) {
                    value = value % 2 == 0 ? value / 2 : value*3+1 ;
                    depthCounter++;
                }

                depths[i] = depthCounter + depths[(int)value];
                if (depths[i] > max) {
                    max = depths[i];
                    System.out.println(i + ":\t" + depths[i]);
                }
            }
            
        }
    }
    
}






// First attempt (below): produce a chain of nodes until you find a node whose depth is known,
// then iterate the chain backwards storing the depth for each previous node
// ...
// but that approach yielded HeapSpaceExceptions
//
// Second attempt (as above) only counts the number of nodes from the root of the chain to 
// a node whose depth is known

/*
class Node {
    long value;
    private Node next;
    private Node prev;
    public Node(long value) { this.value = value; this.prev = null; }
    public void SetNext(Node next) { this.next = next; next.SetPrev(this); }
    public Node GetNext() { return this.next; }
    public Node GetPrev() { return this.prev; }
    public void SetPrev(Node prev) { this.prev = prev; }
}

public class Problem14 {
    public static void main(String[] args) {
        int limit = 1000001;
        int max = 0;
        for (int i = 1; i < limit; i++) {
            if (depths[i] == 0) {
                Node node = new Node(i);
                while (depths[node.value] == 0) {
                    int nextVal = node.value % 2 == 0 ? node.value / 2 : node.value*3+1 ;
                    node.SetNext(new Node(nextVal));
                    node = node.GetNext();
                }

                while (node.value != i) {
                    node = node.GetPrev();
                    depths[node.value] = depths[node.GetNext().value] +1;
                }
                depths[i] = depths[node.GetNext().value] + 1;
                if (depths[i] > max) {
                    max = depths[i];
                    System.out.println(i + ":\t" + depths[i]);
                }
            }
            
        }
*/
