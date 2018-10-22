public class Heapify {
    /*
     * @param A: Given an integer array
     * 
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        if (A.length == 0) {
            return;
        }
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            process(A, i);
        }
    }

    public void process(int[] A, int index) {
        int length = A.length;
        while (index * 2 + 1 < length) {
            int target = -1;
            if (index * 2 + 2 >= length) {
                if (A[index] > A[index * 2 + 1]) {
                    target = index * 2 + 1;
                } else {
                    break;
                }
            } else {
                if (A[index] < A[index * 2 + 1] && A[index] < A[index * 2 + 2]) {
                    break;
                } else {
                    if (A[index * 2 + 1] < A[index * 2 + 2]) {
                        target = index * 2 + 1;
                    } else {
                        target = index * 2 + 2;
                    }

                }
            }
            if (target != -1) {
                swap(A, index, target);
                index = target;
            }
        }
    }

    public void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void main(String[] args) {
        Heapify h = new Heapify();
        int[] A = { 71, 34, 82, 23, 1, 88, 12, 57, 10, 68, 5, 33, 37, 69, 98, 24, 26, 83, 16, 18, 43, 52, 22, 65, 8, 40,
                72, 19, 28, 13, 29, 31, 79, 60, 74, 44, 56, 54, 17, 63, 100, 42, 93, 64, 85, 62, 35, 90, 47, 77, 87, 75,
                39, 38, 25, 61, 36, 53, 46, 97, 7, 94 };
        h.heapify(A);
        System.out.println(A);
    }
}
