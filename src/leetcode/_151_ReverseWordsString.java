package leetcode;

public class _151_ReverseWordsString {

    public static void main(String[] args) {
        String input = "Hello World!";
        String reversed = reverseWords(input);
        System.out.println(reversed);
    }

    private static String reverseWords(String s) {
        String[] sA = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=sA.length-1; i>=0; i--){
            if(sA[i].length() > 0){
                sb.append(sA[i]);
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

}
