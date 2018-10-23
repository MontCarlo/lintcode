/**
 * 
 * Title: LIS
 * Description: 最长上升子序列O(nlog(n))
 *
 * @author maxiao
 * @version 1.0
 * @date 2018年10月23日 下午2:10:57
 *
 */
public class LIS {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int length = nums.length;
        if(length < 2) {
            return length;
        }
        
        int result = 1;
        int[] temp = new int[length];
        temp[0] = nums[0];
        for(int i = 1; i <length; i++) { 
            int index = find(temp, 0, result, nums[i]);
            temp[index] = nums[i];
            if(index + 1> result) {
                result = index + 1;
            }
        }
        return result;
    }
    
    public int find(int[] temp, int start, int end, int n) {
        while(start < end) {
            int middle = (start + end) / 2;
            if(temp[middle] < n) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return start;
    }
    
}
