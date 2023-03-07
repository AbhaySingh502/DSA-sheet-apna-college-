package Array;

import java.util.*;

public class kthmissing {
    public static void printKth(int ar[], int k) {
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = 0; i < ar.length; i++) {
            for (int j = 1;; j++) {
                if (ar[i] != j) {
                    ls.add(j);
                }
                if (ls.size() == k) {
                    ls.get(k);
                    break;
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of array: ");
        int n = sc.nextInt();
        System.out.println("the finding of index: ");
        int k = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Elements in your array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        printKth(arr, k);
    }
}
