package Array;

import java.util.*;

public class kthmissing {
    public static void printKth(int ar[], int k) {
        // ArrayList<Integer> ls = new ArrayList<>();
        // for (int i = 0; i < ar.length; i++) {
        // for (int j = 1;; j++) {
        // if (ar[i] != j) {
        // ls.add(j);
        // }
        // if (ls.size() == k) {
        // ls.get(k);
        // break;
        // }
        // }
        // }
    }

    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int missingCount = 0;
        int lastSeen = 0;

        for (int i = 0; i < n; i++) {
            int current = arr[i];
            missingCount += current - lastSeen - 1;
            if (missingCount >= k) {
                return lastSeen + k - (missingCount - (current - lastSeen - 1));
            }
            lastSeen = current;
        }

        return lastSeen + k - missingCount;
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
        findKthPositive(arr, k);
    }
}
