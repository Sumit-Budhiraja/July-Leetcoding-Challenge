class Solution {
    private int mod = 1000000007;
    long[][] memo;
    public int countVowelPermutation(int n) {
        memo = new long[n][5];
        long sum=0;
        for(int i=0;i<5;i++)
        sum=(sum+f(0,i,n))%mod;
        return (int)sum;
        
    }
    
    public long f(int i,int ch,int n)
    {
        if(memo[i][ch]!=0)
            return memo[i][ch];
        long sum=0;
        if(i==n-1)
            return 1;
        else if(ch==0)
            sum=f(i+1,1,n)%mod;
        else if(ch==1)
            sum=(f(i+1,0,n)+f(i+1,4,n))%mod;
        else if(ch==2)
            sum=(f(i+1,4,n)+f(i+1,3,n))%mod;
        else if(ch==3)
            sum=f(i+1,0,n);
        else if(ch==4)
            sum=(f(i+1,0,n)+f(i+1,1,n)+f(i+1,2,n)+f(i+1,3,n))%mod;
        return memo[i][ch]=sum;
    }
    
}