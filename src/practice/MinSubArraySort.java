package practice;

import java.util.Arrays;
import java.util.Stack;

public class MinSubArraySort {

    public static void main(String[] args) {
        int[] input = {1, 3, 2, 5};
        System.out.println(findMinSub1(input));
        System.out.println(findMinSub2(input));
        System.out.println(findMinSub3(input));
    }

    /**
     * time_complexity: O(n), space_complexity: O(1)
     * @param input: array of integer
     * @return min size of sub array needs to be ordered.
     */
    private static int findMinSub1( int[] input ) {
        if( input.length == 0 ) return 0;

        int left, max = input[0];
        for(left = 0; left < input.length; left++) {
            if( input[left] >= max ) {
                max = input[left];
            } else {
                left--; break;
            }
        }

        int right, min = input[input.length - 1];
        for(right = input.length - 1; right >= 0; right--) {
            if( input[right] <= min ) {
                min = input[right];
            } else {
                right++; break;
            }
        }

        return (right - left) + 1;
    }

    /**
     * time_complexity: O(n), space_complexity: O(n)
     * @param input: array of integer
     * @return min size of sub array needs to be ordered.
     */
    private static int findMinSub2( int[] input ) {
        Stack<Integer> stack = new Stack<>();

        int left;
        for(left = 0; left < input.length; left++) {
            if( !stack.isEmpty() ) {
                if( stack.peek() < input[left] ) {
                    stack.push(input[left]);
                } else {
                    left--; break;
                }
            } else {
                stack.push(input[left]);
            }
        }

        int right; stack = new Stack<>();
        for(right = input.length - 1; right >= 0 ; right--) {
            if( !stack.isEmpty() ) {
                if( stack.peek() >= input[right] ) {
                    stack.push(input[right]);
                } else {
                    right++; break;
                }
            } else {
                stack.push(input[right]);
            }
        }

        return (right - left) + 1;
    }

    /**
     * time_complexity: O(nlogn), space_complexity: O(n)
     * @param input: array of integer
     * @return min size of sub array needs to be ordered.
     */
    private static int findMinSub3( int[] input ) {
        int left = 0, right = input.length - 1;

        int[] copiedArrray = Arrays.copyOf(input, input.length);
        Arrays.sort(copiedArrray);

        for(int i = 0; i < input.length; i++) {
            if( input[i] != copiedArrray[i] ) {
                left = i; break;
            }
        }

        for(int i = input.length - 1; i >= 0; i--) {
            if( input[i] != copiedArrray[i] ) {
                right = i; break;
            }
        }

        return (right - left) + 1;
    }
}
