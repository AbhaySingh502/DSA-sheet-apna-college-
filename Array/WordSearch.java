
import java.util.*;

public class WordSearch {
    public static void exist(char[][] board, String word) {
        // char c[] = new char[word.length()];

        // for (int i = 0; i < word.length(); i++) {
        // }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            for (int k = 0; k < board.length; k++) {
                for (int j = 0; j < board[k].length; j++) {
                    if (board[k][j] == c) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
        if (count == word.length()) {
            System.out.println(true);
        } else
            System.out.println(false);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Size of array: ");
        // int n = sc.nextInt();
        char arr[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

        System.out.println("your word to search: ");
        String word = sc.nextLine();
        // System.out.println("Elements in your array: ");
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // arr[i][j] = sc.next().charAt(0);
        // }
        // }

        exist(arr, word);
        sc.close();
    }

}
