class Solution 
{
    public int findIntegers(int num) 
    {
        StringBuilder sb=new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n=sb.length();
        int []endZero=new int[n];
        int []endOne=new int[n];
        endZero[0]=1;
        endOne[0]=1;
        for(int i=1;i<n;i++)
        {
            endZero[i]=endZero[i-1]+endOne[i-1];
            endOne[i]=endZero[i-1];
        }
        int ans=endZero[n-1]+endOne[n-1];
       
        for(int i=n-2;i>=0;i--)
        {
            if(sb.charAt(i)=='1' && sb.charAt(i+1)=='1')
                break;
            if(sb.charAt(i)=='0' && sb.charAt(i+1)=='0')
                ans-=endOne[i];
        }
        return ans;
    }
}