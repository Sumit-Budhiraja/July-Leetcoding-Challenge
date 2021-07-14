class Solution {
    public int findPeakElement(int[] nums) {
        
        int p1 = 0 ;
		int p2 = nums.length-1;
		
		while(p1 < p2) {
			
			if(nums[p1] > nums[p2]) {
				p2--;
				
			}else {
				p1++;
			}
			
			
        }
		return p1;
        
    }
}