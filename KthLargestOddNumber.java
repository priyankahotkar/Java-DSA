public class KthLargestOddNumber {
    public static void main(String[] args) {
        int L = -2;
        int R = 7;
        int K = 4;
        int ans = 0;
        if (R%2 != 0) {
            ans = R - ((K-1)*2);
        }
        else if(R%2 == 0) {
            ans = R - 1 - ((K-1)*2);
        }
        if (ans < 0) {
            ans = 0;
        }
        System.out.println(ans);
    }
}
