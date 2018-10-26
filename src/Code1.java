import java.math.BigInteger;

/**
 * @program: learn
 * @description: 1.两数之和
 * @author: lihaoju
 * @create: 2018-10-23 10:42
 */
public class Code1 {

    public static void main(String[] args) {
        /*int[] nums = new int[]{2, 7, 11, 15};
        int[] r = twoSum(nums, 9);
        System.out.println(Arrays.toString(r));*/
        BigInteger b = new BigInteger("899");
        System.out.println(b.mod(new BigInteger("100")));
        System.out.println(b.divide(new BigInteger("100")));
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i < nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
