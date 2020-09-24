//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("hfuisdhcsbdkcewfergvebtrb"));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] strArr = s.toCharArray();
        int len = strArr.length;
        if (len < 1) return 0;
        int maxLen = 0, i = 0, j = 0;
        boolean[] hashTable = new boolean[128];
        while (i < len && j < len) {
            if (!hashTable[strArr[i]]) {
                hashTable[strArr[i]] = true;
                int currentLen = i - j + 1;
                maxLen = Math.max(currentLen, maxLen);
                i++;
            } else {
                hashTable[strArr[j++]] = false;
            }
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
