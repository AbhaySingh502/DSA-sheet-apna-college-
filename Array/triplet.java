
import java.util.*;

public class triplet {
    public static List<List<Integer>> triplets(int nums[]) {
        // int n = arr.length;
        // int m[] = new int[3 * n];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // for (int k = 0; k < n; k++) {
        // if (arr[i] + arr[j] + arr[k] == 0 && arr[i] != arr[j] && arr[j] != arr[k]) {
        // m[i] = arr[i];
        // m[i + 1] = arr[j];
        // m[i + 2] = arr[k];
        // System.out.println(m[i] + " " + m[i + 1] + " " + m[i + 2]);
        // // System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
        // }
        // }
        // }
        // }

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0)
                break;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0)
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if (sum <= 0)
                    while (nums[j] == nums[++j] && j < k)
                        ;
                if (sum >= 0)
                    while (nums[k--] == nums[k] && j < k)
                        ;
            }
            while (nums[i] == nums[++i] && i < nums.length - 2)
                ;
        }
        return result;

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
        triplets(arr);
        sc.close();
    }
}
