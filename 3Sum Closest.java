class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int l = i+1, r = nums.length-1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target-sum) < Math.abs(target-res)) {
                    res = sum;
                }
                if(sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
		}
        
        return res;
    }
}