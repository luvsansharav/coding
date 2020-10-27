package practice;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    private static List<Integer> subSet = new ArrayList<>();

    public static void main(String [] args) {
        int arr[] = new int[]{1, 2, 3};
        subsetBit(arr);
        subsetTree(0, arr);
    }

    private static void subsetBit(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < (1 << n); i++) {

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(arr[j] + " ");

                }
            }

            System.out.println();
        }
    }

    private static void subsetTree(int i, int[] arr) {
        if (i == arr.length) {
            System.out.println(subSet.toString());
            return;
        }

        subSet.add(arr[i]);
        subsetTree(i + 1, arr);
        subSet.remove(subSet.size() - 1);

        subsetTree(i + 1, arr);
    }
}