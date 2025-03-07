public class Assign21 {
        public static void main(String[] args) {
            // 1. Creating a String
            String str1 = "Hello";
    
            // 2. Length of the String
            int length = str1.length();
            System.out.println("Length of the string: " + length);
    
            // 3. Concatenation
            String str2 = " World";
            String concatenated = str1.concat(str2);
            System.out.println("Concatenated string: " + concatenated);
    
            // 4. Character at a specific index
            char charAtIndex = str1.charAt(2);
            System.out.println("Character at index 2: " + charAtIndex);
    
            // 5. Substring
            String substring = str1.substring(1, 3);
            System.out.println("Substring from index 1 to 3: " + substring);
    
            // 6. Index of a character
            int indexOfChar = str1.indexOf('l');
            System.out.println("Index of 'l': " + indexOfChar);
    
            // 7. Index of a character starting from a specific index
            int indexOfCharFromIndex = str1.indexOf('l', 3);
            System.out.println("Index of 'l' starting from index 3: " + indexOfCharFromIndex);
    
            // 8. Converting to lowercase
            String lowerCase = str1.toLowerCase();
            System.out.println("Lowercase: " + lowerCase);
    
            // 9. Converting to uppercase
            String upperCase = str1.toUpperCase();
            System.out.println("Uppercase: " + upperCase);
    
            // 10. Removing leading and trailing whitespaces
            String stringWithSpaces = "  Hello  ";
            String trimmed = stringWithSpaces.trim();
            System.out.println("Trimmed string: '" + trimmed + "'");
    
            // 11. Checking if starts with a specific prefix
            boolean startsWith = str1.startsWith("He");
            System.out.println("Starts with 'He': " + startsWith);
    
            // 12. Checking if ends with a specific suffix
            boolean endsWith = str1.endsWith("lo");
            System.out.println("Ends with 'lo': " + endsWith);
    
            // 13. Replacing characters
            String replaced = str1.replace('l', 'x');
            System.out.println("Replaced 'l' with 'x': " + replaced);
    
            // 14. Checking if empty
            boolean isEmpty = str1.isEmpty();
            System.out.println("Is empty: " + isEmpty);
    
            // 15. Splitting the string
            String str3 = "Hello,World,Java";
            String[] splitArray = str3.split(",");
            System.out.println("Split string:");
            for (String s : splitArray) {
                System.out.println(s);
            }
        }
}
