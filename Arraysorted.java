public class Arraysorted {
    public static boolean arraySorted (int arr[],int i) {
        if (i == arr.length-1) {
            return true;
        }
        if (arr[i] >= arr[i+1]) {
            return false;
        }
        return arraySorted(arr, i+1);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,3};
        System.out.println(arraySorted(arr, 0));
    }
}