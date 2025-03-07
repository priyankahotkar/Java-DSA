import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean containsDuplicate(String str) {   //O(n)
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')' && !s.isEmpty()) {
                if (s.peek() == '(') {
                    return true;
                } else {
                    while (!s.isEmpty() && s.peek() != '(') {
                        s.pop();
                    }
                    s.pop();
                }
            }
            else {
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate("(((a+(b)))+(c+d))"));
        System.out.println(containsDuplicate("((((a)+(b))+c+d))"));
        System.out.println(containsDuplicate("((a+b)+(c+d))"));
        System.out.println(containsDuplicate("(((a+b))+c)"));
        System.out.println(containsDuplicate("(a-b)"));
        System.out.println(containsDuplicate("((a+b))"));
    }
}
