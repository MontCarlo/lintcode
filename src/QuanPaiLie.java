import java.util.ArrayList;
import java.util.List;

public class QuanPaiLie {
    /*
     * 全排列
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static List<List<Integer>> permute(int[] nums) {
        // write your code here
        boolean[] flags = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if(nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        func(result, temp, nums, flags);
        return result;
    }
    
    public static void func(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] flags) {
        for(int i = 0; i < nums.length; i++) {
            if(!flags[i]) {
                temp.add(nums[i]);
                flags[i] = true;
                if(temp.size() == nums.length) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.addAll(temp);
                    result.add(list);
                }
                func(result, temp, nums, flags);
                temp.remove(new Integer(nums[i]));
                flags[i] = false;
            }


            
        }
    }
    
    //以下是迭代实现
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {0,1};
        List<List<Integer>> result = permute(nums);
        System.out.println(result.toString());
    }
}
