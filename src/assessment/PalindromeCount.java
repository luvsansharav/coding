package assessment;

public class PalindromeCount {

    public static void main(String[] args) {
        System.out.println(countPalindromes("abac"));
    }

    static int countPalindromes(String s) {
        int result = s.length();
        for (int i = 0; i < s.length() - 1; i++) {
            result += expand(i, i + 1, s) / 2;
        }
        for (int i = 0; i < s.length() - 2; i++) {
            result += expand(i, i + 2, s) / 2;
        }
        return result;
    }

    static int expand(int l, int r, String s) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }


}
