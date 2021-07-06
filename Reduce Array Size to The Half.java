class Solution {
   public int minSetSize(int[] arr) {
        int freq[]=new int [100001];
        int n=arr.length;
        for(int i=0;i<n;i++){
            freq[arr[i]]++; 
        }
        Arrays.sort(freq);
        int s=n/2;
        int ans=0;
        for(int i=freq.length-1;i>=0;i--){
            if(s<=0)
                break;
            s-=freq[i];
			ans++;
        }
        return ans;
    }
}