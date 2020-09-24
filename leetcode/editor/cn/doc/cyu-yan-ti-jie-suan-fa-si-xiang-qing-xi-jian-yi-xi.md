### 解题思路
此处撰写解题思路

### 代码

```c
/*算法思想：采用哈希表 + 滑动窗口的思想
1.设置双指针i和j，用hashtable表示集合中元素是否出现
2.从第一个元素开始向后遍历，分为两种情况
            若当前元素不在集合中，则将其加入集合，更新长度，同时将i向后移动一个单位
            若当前元素在集合中，将集合中的该元素删除，并将j向后移动
3.结尾返回最大长度即可
*/
int lengthOfLongestSubstring(char * s){
    int len = strlen(s);
    if(len <= 1)
        return len;
    int maxlen = 1, i = 0, j = 0;
    bool hashtable[128] = {false};
    while(i < len && j < len)
    {
        if(hashtable[s[i]] == false)    //若未出现过
        {
            hashtable[s[i]] = true; //加入集合
            int currentlen = i - j + 1;
            if(currentlen > maxlen)
                maxlen = currentlen;
            i++;
        }
        else    //当出现过，则将其去除，并让后指针移动
        {
            hashtable[s[j]] = false;
            j++;
        }
    }
    return maxlen;
}
```