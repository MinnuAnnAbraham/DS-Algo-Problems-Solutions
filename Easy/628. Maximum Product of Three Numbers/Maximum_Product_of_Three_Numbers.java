class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int res1, res2 ;
        int n = nums.length;
        res1 = nums[n-3]*nums[n-2]*nums[n-1];
        res2 = nums[0]*nums[1]*nums[n-1];
        return  Math.max(res1,res2);
    }
}