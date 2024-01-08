/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        /*
        # Feedback- -ans- is not clear from the name what is it and what you are trying to do. Maybe -response- or even -updatedString- are better words?
        */
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (ans.indexOf(currentChar) == -1 || currentChar == 32) {
                ans += currentChar;
            }

        }
        return ans;
    }
}
