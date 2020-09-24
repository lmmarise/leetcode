/**
 * @author： tsb
 * @date： 2020/9/24
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class KMP {
    public static void main(String[] args) {
        char[] text = {'A', 'B', 'A', 'A', 'B', 'A', 'B', 'C', 'A', 'B', 'A', 'A', 'B', 'A'};
        char[] pattern = {'A', 'B', 'A', 'B', 'C', 'A', 'B', 'A', 'A'};
        int[] prefixTable = prefixTable(pattern);

        printArr(prefixTable);


        kmpSearch(text, pattern);
    }

    /**
     * 搜索指定字符串在目标字符串中出现的位置
     *
     * @param text    指定字符串
     * @param pattern 要搜索的字符串
     */
    public static void kmpSearch(char[] text, char[] pattern) {
        int[] prefixTable = prefixTable(pattern);
        int m = text.length, n = pattern.length;
        int i = 0, j = 0;
        while (i < m) {
            if (j == n - 1 && text[i] == pattern[j]) {
                System.out.println("found pattern at: " + (i - j));
                j = prefixTable[j];
            }
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = prefixTable[j];
                if (j < 0) {
                    i++;
                    j++;
                }
            }
        }
    }

    /**
     * 为字符串建立prefixTable
     */
    public static int[] prefixTable(char[] pattern) {
        int[] prefixTable = new int[pattern.length];
        prefixTable[0] = 0;
        int i = 1, len = 0;
        while (i < pattern.length) {
            if (pattern[i] == pattern[len]) prefixTable[i++] = ++len;
            else if (len > 0) len = prefixTable[len - 1];
            else prefixTable[i++] = len;
        }

        int[] temp = new int[prefixTable.length + 1];
        temp[0] = -1;
        System.arraycopy(prefixTable, 0, temp, 1, prefixTable.length);
        prefixTable = temp;
        return prefixTable;
    }

    private static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) sb.append(arr[i]).append(", ");
            else sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
