package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4);
        print(input);
    }

    private static void print(List<Integer> input) {

        if (input.isEmpty()) {
            System.out.println(result.toString());
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < input.size(); j++) {
                if (i == j) continue;
                sub.add( input.get(j) );
            }

            result.add(input.get(i));
            print(sub);
            result.remove(result.size() - 1);
        }

    }
}
