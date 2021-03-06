/**
 * @author： tsb
 * @date： 2020/9/23
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class DP {
    public static void main(String[] args) {
        System.out.println(dptOpt(new int[]{1, 2, 4, 1, 7, 8, 3}));
    }

    public static int dptOpt(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("传入的数组不能为空");
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return Math.max(arr[0], arr[1]);

        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        temp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            temp[i] = Math.max(temp[i - 2] + arr[i], temp[i - 1]);
        }
        return temp[temp.length - 1];
    }
}
