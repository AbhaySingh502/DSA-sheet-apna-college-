package Hashing;

import java.util.*;

public class choseKarrayElement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of array: ");
        int n = sc.nextInt();
        System.out.println("the size of subarray: ");
        int k = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Elements in your array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int m[] = new int[k];

        for (int i = 0; i < k; i++) {
            m[i] = arr[i];
        }
        int max = m[0];
        int min = m[0];
        for (int i = 0; i < k; i++) {
            if (max < m[i]) {
                max = m[i];
            }
            if (min > m[i]) {
                min = m[i];
            }
        }
        System.out.println("Minimum diffrence in an array: " + (max - min));
        sc.close();
    }
}