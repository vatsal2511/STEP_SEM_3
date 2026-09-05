package STEP_SEM_3.Week_4_Assignment;

public class FindMinRotatedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1; // Minimum must be in the right half
            } else {
                right = mid; // Minimum is at mid or in the left half
            }
        }
        
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums)); // Output: 1
    }
}
