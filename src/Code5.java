/**
 * @ClassName: Code5
 * @Description: 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @Author: lihaoju
 * @Date: 2018/10/27 11:12
 * @Version: 1.0
 */
public class Code5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

    public static String longestPalindrome(String s) {
        int max1 = 0, max2 = 0,l,r, mod = 0;
        int length = s.length();
        String s1 = "",s2 = "", modStr;
        for(int i= 0;i < length;i++) {
            r = i + 1;
            l = i;
            //两种模式 bb aba
            if(r < length) {
                modStr = "";
                //bb
                while(true) {
                    if(l >=0 && r < length) {
                        if(s.charAt(l) == s.charAt(r)) {
                            modStr= s.charAt(l) + modStr + s.charAt(r);
                            mod = mod + 2;
                            l--;
                            r++;
                        } else {
                            if(mod > max1) {
                                max1 = mod;
                                s1 = modStr;
                            }
                            break;
                        }
                    }  else {
                        if(mod > max1) {
                            max1 = mod;
                            s1 = modStr;
                        }
                        break;
                    }
                }

                //aba
                mod = 1;
                r = i + 1;
                l = i - 1;
                modStr = s.charAt(i) + "";
                while(true) {
                    if(l >=0 && r < length) {
                        if(s.charAt(l) == s.charAt(r)) {
                            mod = mod + 2;
                            modStr = s.charAt(l) + modStr + s.charAt(r);
                            l--;
                            r++;
                        } else {
                            if(mod > max2) {
                                max2 = mod;
                                s2 = modStr;
                            }
                            break;
                        }
                    }  else {
                        if(mod > max2) {
                            max2 = mod;
                            s2 = modStr;
                        }
                        break;
                    }
                }
            } else {
                if(i == 0) {
                    s2 = s.charAt(i) + "";
                }
                break;
            }
        }
        if(max1 > max2) {
            return s1;
        }
        return s2;
    }
}
