package STEP_SEM_3.Week_4_Assignment;

import java.util.*;

public class ThreeSum {
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    resultList.add(new int[] {nums[i], nums[left], nums[right]});
                    
                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[][] res = threeSum(nums);
        for (int[] triplet : res) {
            System.out.println(Arrays.toString(triplet));
        }
    }
}
