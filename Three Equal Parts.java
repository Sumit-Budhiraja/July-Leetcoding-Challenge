class Solution {
   public int[] threeEqualParts(int[] arr) {
        int oneCount = 0;
        int n = arr.length;
        for(int t : arr){
            if(t == 1) oneCount++;
        }
        if(oneCount == 0) return new int[]{0,n-1};
        if(oneCount % 3 != 0) return new int[]{-1,-1};
        int averageOneCount = oneCount / 3;
        int start = 0;
        int mid = 0;
        int end = 0;
        int cnt = 0;
        for(int i = 0;i<n;i++){
            if(arr[i] == 0) continue;
            if(cnt == 0) {
                start = i;
            }
            cnt++;
            if(cnt == averageOneCount + 1) {
                mid = i;
            }
            if(cnt == 2 * averageOneCount + 1) {
                end = i;
            }
        }
        while(end < n && arr[start] == arr[mid] && arr[mid] == arr[end]){
            start++;
            mid++;
            end++;
        }
        if(end == n) {
            return new int[]{start-1,mid};
        }
        return new int[]{-1,-1};
    }
}