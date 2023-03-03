package Array;

import java.util.*;

public class ContainsDuplicate {
    public int search(int[] nums, int target) {
        int c = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                c = i;
            }

        }
        return c;
    }

    public static void main(String arrgs[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ContainsDuplicate m = new ContainsDuplicate();
        System.out.println(m.search(arr, target));

    }
}
