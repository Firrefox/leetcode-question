//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 👍 1240 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // 异常处理
        if (s.length() > 12) {
            return res;
        }
        backtracking(s, 0, 0);
        return res;
    }

    private void backtracking(String s, int startIndex, int pointNum) {
        // 结束条件，当字符串被分割成了四段，也就是有3个点
        if (pointNum == 3) {
            // 然后判断第四段字符串是否合法，如果合法就放入res中
            if (isVadlid(s, startIndex, s.length() - 1)) {
                res.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isVadlid(s, startIndex, i)) {
                // 在str的后面插入一个点
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                backtracking(s, i + 2, pointNum);
                // 回溯删掉逗点
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                // 不合法，直接结束本层循环
                break;
            }
        }
    }

    // 判断字符串s在左闭又闭区间[start, end]所组成的数字是否合法
    private boolean isVadlid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end ; i++) {
            // 遇到非数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            // 如果大于255了不合法
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
    }
}