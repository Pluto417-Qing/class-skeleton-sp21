package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> arr1 = new AListNoResizing<>();
        BuggyAList<Integer> arr2 = new BuggyAList<>();

        arr1.addLast(1);
        arr2.addLast(1);
        arr1.addLast(2);
        arr2.addLast(2);
        arr1.addLast(3);
        arr2.addLast(3);

        assertEquals(arr1.removeLast(), arr2.removeLast());
        assertEquals(arr1.removeLast(), arr2.removeLast());
        assertEquals(arr1.removeLast(), arr2.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L1 = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L1.addLast(randVal);
                L2.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size1 = L1.size();
                int size2 = L2.size();
                assertEquals(size1, size2);
            } else if (operationNumber == 2 && L1.size() != 0) {
                int last1 = L1.getLast();
                int last2 = L2.getLast();
                assertEquals(last1, last2);
            } else if (operationNumber == 3 && L1.size() != 0) {
                int last1 = L1.removeLast();
                int last2 = L2.removeLast();
                assertEquals(last1, last2);
            }
        }
    }
}
