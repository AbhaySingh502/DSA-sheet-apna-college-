import java.util.Scanner;

public class maxKdiv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int k = sc.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = +arr[j];
                if ((sum) % k == 0) {
                    res = Math.max(res, j - i - 1);
                }
            }
        }
        System.out.println(res);
        sc.close();
    }
}
