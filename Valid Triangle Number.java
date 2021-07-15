class Solution {
    public int triangleNumber(int[] arr) {
      //Sort to avoid number of Comparisons
         Arrays.sort(arr);
         int count = 0;
      
      for(int i = arr.length - 1;i >= 2;i--){
        int l = 0;
        int r = i - 1;
       while(l < r){
          int sum = arr[l] + arr[r];
         
          if(sum > arr[i]){
            //if sum is greater than arr[i] than all the values greater than l can make valid triplets
            count += (r - l);
            r--;
          }
         //otherwise increase the left index to increase your sum
          else{
             l++;
          }
         
       }
      }
      return count;
    }
}