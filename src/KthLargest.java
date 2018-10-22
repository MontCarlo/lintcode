
public class KthLargest {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public static int kthLargestElement(int k, int[] nums) {
        // write your code here
        int length = nums.length - 1;
        return func(k, 0, length, nums);
    }
    public static int func(int k, int start, int end, int[] nums) {
        if(start == end) {
            return nums[start];
        }
        int flagPos = start;
        int count = 0;
        for(int i = start + 1; i <= end; i ++) {
            if(nums[i] > nums[start]) {
                swap(i,  ++ flagPos, nums);
                count ++;
            }
        }
        swap(flagPos,  start, nums);
        if(count + 1 == k) {
            return nums[flagPos];
        } else if(count + 1 < k) {
            return func(k - count - 1, flagPos + 1, end, nums);
        } else {
            return func(k, start, flagPos - 1, nums);
        }
    }
    
    public static void  swap(int i, int j , int[] nums) {
        int k = 0;
        k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }
    
    public static void main(String[] args) {
        int k = 10;
        int[] nums = {1,2,3,4,5,6,8,9,10,7};
        System.out.println(kthLargestElement(k, nums));
        k = 3;
        int[] nums2 = {9,3,2,4,8};
        System.out.println(kthLargestElement(k, nums2));
        
    }
}
