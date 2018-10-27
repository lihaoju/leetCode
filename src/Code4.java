/**
 * 两个排序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 *
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 *
 * 你可以假设 nums1 和 nums2 不同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 中位数是 (2 + 3)/2 = 2.5
 *
 */
public class Code4 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = 0, n2 = 0, n = 0;
        if(null != nums1) {
            n1 = nums1.length;
        }
        if(null != nums2) {
            n2 = nums2.length;
        }
        n = n1 + n2;
        int[] nums = new int[n];
        int i=0,j=0,k=0;
        double d;
        while (true) {
            if(i<n1 && j<n2) {
                if(nums1[i] > nums2[j]) {
                    nums[k] = nums2[j];
                    k++;
                    j++;
                } else if (nums1[i] == nums2[j]) {
                    nums[k] = nums1[i];
                    i++;
                    k++;
                    nums[k] = nums2[j];
                    j++;
                    k++;
                } else {
                    nums[k] = nums1[i];
                    i++;
                    k++;
                }
            } else if (i >= n1 && j<n2) {
                nums[k] = nums2[j];
                j++;
                k++;
            } else if (i< n1 && j >= n2) {
                nums[k] = nums1[i];
                i++;
                k++;
            } else {
                break;
            }
        }

        if(n%2 == 0) {
            d= nums[n/2] + nums[n/2 - 1];
            d = d/2;
        } else {
            d = (nums[n/2]);
        }
        return d;
    }
}
