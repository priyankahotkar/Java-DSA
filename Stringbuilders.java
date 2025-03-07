public class Stringbuilders {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Tony");
        System.out.println(sb);
        System.out.println(sb.charAt(0));
        sb.setCharAt(0, 'P');
        System.out.println(sb);
        sb.insert(0, 'S');
        System.out.println(sb);
        sb.insert(3, 'n');
        System.out.println(sb);
        sb.delete(0, 1);
        System.out.println(sb);
        sb.append(" Stark");
        System.out.println(sb);
        System.out.println(sb.length());
        sb.reverse();
        System.out.println(sb);
    }
}
