package assessment;

public class CountingClosedPaths {
    public static int closedPath(int number) {
        int[] closePath = new int[10];

        closePath[0] = closePath[4] = closePath[6] = closePath[9] = 1;
        closePath[8] = 2;

        int result = 0;
        while (number > 0) {
            result += closePath[number % 10];
            number /= 10;
        }
        return result;
    }

    public static void main(String [] args) {
        System.out.println(closedPath(649578));
    }
}

