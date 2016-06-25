package com.study.algorithm;

/**
 * Given an array nums, write a function to move all 0's
 * to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * Created by guobing on 2016/6/24.
 */
public class MoveZeroes {

    // beats 15.88%
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int size = nums.length;
        for(int i = 0; i < size - 1; i++) {
            if(nums[i] == 0) {
                for(int j = i + 1; j < size; j++) {
                    if(nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    // less loop beats 12.11%……
    public void moveZeroBetter(int [] nums) {
        if (nums == null || nums.length == 0)
            return;

        int n = nums.length;
        int j;
        for(int i = 0; i < n-1; i++){
            j = i+1;
            if(nums[i] == 0){
                while(nums[j] == 0 && j < n-1){
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }else{
                continue;
            }
        }
    }

    /***
     * 这种方式效率最高，为什么 ？ beats 87.72% why?
     * @param nums
     * 明白了！
     * 当值不为0的时候 insertPos ++ = num，相当于把0的值过滤掉了，然后把后面insertPos的都赋值为0 。时间复杂度 O(n)
     */
    public void moveZeroBest(int [] nums) {
        if (nums == null || nums.length == 0)
            return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0)
                nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String [] args) {
        int [] n = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroBetter(n);
        for(int i = 0; i < n.length; i++) {
            System.out.print(n[i] + ", ");
        }
    }
}
