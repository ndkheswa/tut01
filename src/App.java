
public class App {
    public static void main(String[] args) throws Exception {

        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is ");
        printLevelOrderTraversal();

    }

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }

    }

    static Node root;

    static void printLevelOrderTraversal() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
        }
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight)
                return lheight + 1;
            else {
                return rheight + 1;
            }
        }
    }

    static void printCurrentLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    static int binarySearch(int[] A, int loIndex, int hiIndex, int value) {

        if (loIndex > hiIndex) {
            return -1;
        } else {
            int middle = (loIndex + hiIndex) / 2;
            if (value == A[middle]) {
                return middle;
            } else if (value < A[middle]) {
                return binarySearch(A, loIndex, middle - 1, value);
            } else {
                return binarySearch(A, middle + 1, hiIndex, value);
            }
        }
    }


    static void selectionSort(int[] A) {
        for (int lastPlace = A.length - 1; lastPlace > 0; lastPlace--) {
            /**
             * find the largest item among A[0], A[B], ...
             */
            int maxLoc = 0;

            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                    maxLoc = j;
                }
            }

            // swap largest item with A[lastPlace]
            int temp = A[maxLoc];
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;
        }
    }

    static void insertionSort(int[] A) {
    // Sort the array A into increasing order.
            int itemsSorted; // Number of items that have been sorted so far.
            for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
    // Assume that items A[0], A[1], ... A[itemsSorted-1]
    // have already been sorted. Insert A[itemsSorted]
    // into the sorted part of the list.
            int temp = A[itemsSorted]; // The item to be inserted.
            int loc = itemsSorted - 1; // Start at end of list.
            while (loc >= 0 && A[loc] > temp) {
                A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1.
                loc = loc - 1; // Go on to next location.
            }
            A[loc + 1] = temp; // Put temp in last vacated space.
        }
    }

    static int quickSortStep(int[] A, int lo, int hi) {
        int pivot = A[0];

        /**
         *  the numbers hi and lo mark the endpoints of a range of numbers that have
         *  not yet been sorted. decrease hi and increase lo until they become equal.
         *
         */

        while (hi > lo) {
            while (hi > lo && A[hi] >= pivot) {
                /**
                 *  move hi past numbers greater than pivto
                 */
                hi--;
            }
            if (hi == lo)
                break;
            // the number A[hi] is less than pivot,
            // move it into the available space at A[lo]
            A[lo] = A[hi];
            lo++;

            while (hi > lo && A[lo] <= pivot) {
                /**
                 *  move lo up past numbers less than pivot
                 */
                lo--;
            }
            if (hi == lo)
                break;
            // at this point A[lo] is greater than pivot
            // move it into the available space at A[hi]
            A[hi] = A[lo];
            hi--;

        } // end while loop

        // at this point A[lo] has become equal to A[hi]
        // there is an available space there
       A[lo] = pivot;
        return lo;

    }

    static void quicksort(int[] A, int lo, int hi) {
        if (hi <= lo) {
            /**
             *  the list has zero length, return
             */
            return;
        } else {
            int pivotPosition = quickSortStep(A, lo, hi);
            quicksort(A, lo, pivotPosition - 1);
            quicksort(A, pivotPosition + 1, hi);
        }
    }


}
