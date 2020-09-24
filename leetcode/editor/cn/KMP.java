/**
 * @author： tsb
 * @date： 2020/9/24
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class KMP {
    public static void main(String[] args) {
        char[] str = {'A', 'B', 'A', 'B', 'C', 'A', 'B', 'A', 'A'};
        int[] prefix = new int[str.length];
        prefixTable(str, prefix);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prefix.length; i++) {
            if (i != prefix.length - 1) sb.append(prefix[i]).append(", ");
            else sb.append(prefix[i]);
        }
        System.out.println(sb);
    }

    public static void prefixTable(char[] pattern, int[] prefix) {
        prefix[0] = 0;
        int i = 1;
        int len = 0;
        while (i < pattern.length) {
            if (pattern[len] == pattern[i]) prefix[i++] = ++len;
            else if (len > 0) len = prefix[len - 1];
            else prefix[i++] = len;
        }
    }
}
