package Hashing;

import java.util.*;

public class MaximumReapetingNumber {
    public static int findMax(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                max = entry.getKey();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Elements in your array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        MaximumReapetingNumber m = new MaximumReapetingNumber();
        System.out.println("max oucrring elemnt is: " + m.findMax(arr));
    }
}
