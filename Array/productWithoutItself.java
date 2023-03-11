
import java.util.*;

public class productWithoutItself {
    public static void product(int arr[]) {
        int pro[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pro[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = 0; j < arr.length; j++) {
                arr[i] = 1;
                pro[i] = pro[i] * arr[j];
            }
            arr[i] = temp;
            System.out.println(pro[i]);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Elements in your array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        product(arr);
        sc.close();
    }

}
