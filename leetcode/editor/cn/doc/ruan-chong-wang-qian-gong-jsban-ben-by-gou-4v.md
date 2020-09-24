思路：
1、定义蠕虫的头和尾，
2、取到最新的一个code（食物），
3、发现已经肚子里面已经有了，或者肚子里已经有重复食物了，于是，边吃边拉！（更记录最后的重复食物的位置）
4、发现肚子里面没有，且肚子里面的重复食物也拉出去了，就长长~~~

5、吃到最后，蠕虫的长度，就是我们需要的无重复的食物（字符串）长度
```
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(stringss) {
    let lens = stringss.length;
    let startIndex = 0;
    let contnueIndex = -1; // 重复指针的位置
    for (let i=0; i< lens; i++) {
        let stringNow = stringss.slice(startIndex, i);
        let code = stringss.slice(i, i + 1);
        // 更新指针位置
        let codeIndex = stringNow.lastIndexOf(code);
        if (codeIndex > -1) {
            let contnueIndex2 = startIndex + codeIndex;
            contnueIndex = contnueIndex > contnueIndex2 ? contnueIndex : contnueIndex2;
        }
        if (startIndex <= contnueIndex) {
            startIndex++;
        }
    }
    return lens - startIndex;
};
```
