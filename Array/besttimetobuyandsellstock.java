package Hackerrank;

import java.util.*;

public class arrray {
    public int printStock(int[] arr, int n) {
        int max = arr[0];
        int min = arr[0];
        int j = 0;
        int i = 1;
        for (; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                j = i;
            }
        }
        for (j = i; j < n; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
        }
        return max - min;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        int min = arr[0];
        int j = 0;
        int i = 1;
        for (; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                j = i;
            }
        }
        for (; j < n; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
        }
        System.out.println(max - min);

    }
}
