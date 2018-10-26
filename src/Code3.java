/**
 * @program: learn
 * @description: 无限重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 *      请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 *
 * @author: lihaoju
 * @create: 2018-10-26 10:39
 */
public class Code3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        String now;
        int i = 0, max = 0, num;
        while (true) {
            now = "";
            num = 0;
            for(int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if(!now.contains(c + "")) {
                    num ++;
                    if(num > max) {
                        max = num;
                    }
                    now = now + c;
                } else {
                    break;
                }
            }

            i++;
            if(i >= s.length()) {
                break;
            }
        }
        return max;
    }
}
