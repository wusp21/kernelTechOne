package leetCode;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: wusp
 * @Date: 2020/11/12-9:15
 * @Description:
 * @version: 1.0
 */
public class solution {
    public static void main(String[] args) {
        solution solution = new solution();
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 5;
        List<List<Integer>> lists = solution.shiftGrid(grid,k);
        for (int i=0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                System.out.print(lists.get(i).get(j)+" ");
            }
            System.out.println("");
        }
    }

    /**
     * number: 922
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     *
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     *
     * 你可以返回任何满足上述条件的数组作为答案
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int[] sortedA = new int[A.length];
        int i;
        i = 0;
        for (int x: A) {
            if (x % 2 == 0){
                sortedA[i] = x;
                i+=2;
            }
        }
        i = 1;
        for (int x: A){
            if (x % 2 ==1){
                sortedA[i] = x;
                i+=2;
            }
        }
        return sortedA;
    }

    /**
     *给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
     *number: 1351
     * 请你统计并返回 grid 中 负数 的数目。
     * @param grid
     * @return 负数的数量
     */
    public int countNegatives(int[][] grid) {
        int numOfMinus = 0;
        int x = grid.length;
        int y = grid[0].length;
        for(int i = 0; i<x;i++){
            for (int j = 0; j <y;j++){
                if (grid[i][j]<0) {
                    if (numOfMinus == 0){
                        numOfMinus += (x - i ) * (y - j);
                    } else{
                        numOfMinus += (x-i)*(y-j);
                    }
                    y = j;
                }
            }
        }
        return numOfMinus;
    }

    public void test(){
        int[][] arr = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        for (int i = 0;i<3;i++){
            for (int j = 0; j<4;j++){
                System.out.print(arr[i][j]+",");
            }
            System.out.println(" ");
        }
        System.out.println(arr.length);
    }

    /**
     * number: 15
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0;i<nums.length;i++) {
            if (nums[i]>0)
                break;
            if (i>0&&nums[i]==nums[i-1])
                continue;
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if (sum == 0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right&&nums[left]==nums[left+1])
                        left++;
                    while (left<right&&nums[right]==nums[right-1])
                        right--;

                    left++;
                    right--;
                }
                else if (sum < 0) left++;
                else if (sum > 0) right--;
            }
        }
        return list;
    }

    /**
     * number:1260
     * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
     *
     * 每次「迁移」操作将会引发下述活动：
     *
     * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
     * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
     * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
     * 请你返回 k 次迁移操作后最终得到的 二维网格。
     * @param grid
     * @param k
     * @return
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int sum = grid.length*grid[0].length;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0;i<grid.length;i++){
            List list = new ArrayList();
            for(int j=0;j<grid[0].length;j++) {
                list.add(grid[i][j]);
            }
            lists.add(list);
        }
        if (k%(grid[0].length * grid.length) == 0){
            return lists;
        }else {
            ArrayList<Integer> list =new ArrayList<>();
            for(int i=0;i<lists.size();i++){
                list.addAll(lists.get(i));
            }
            int t = k % sum;
            List subList = list.subList(sum-t,list.size());
            subList.addAll(list.subList(0,sum-t));
            lists.clear();
            for(int i = 0;i<grid.length;i++){
                lists.add(subList.subList(i*grid[0].length,i*grid[0].length+grid[0].length));
            }
            return lists;
        }
    }
}
