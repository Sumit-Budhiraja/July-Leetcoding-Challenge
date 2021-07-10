class Solution {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int mod = 1000000007;
        long[] dp = new long[arr.length+1];
        dp[0] = 1;
        if(s.charAt(0) == '*'){
            dp[1] = 9;
        }else if(s.charAt(0) == '0'){
            dp[1] = 0;
        }else{
            dp[1] = 1;
        }
        for(int i = 2; i < dp.length; i++){
            if(arr[i-1] == '0'){
                //do nothing
            }else if(arr[i-1] == '*'){
                dp[i] = (dp[i-1] * 9) % mod;
            }else{
                dp[i] = (dp[i-1] * 1) % mod;
            }
            
            if(s.charAt(i-2) != '*' && s.charAt(i-1) != '*'){
                int num = Integer.valueOf(s.substring(i - 2, i));
                if(num >= 10 && num <= 26){
                    dp[i] += dp[i-2];
                }
            }else if(s.charAt(i-1) == '*'){
                if(s.charAt(i-2) == '1'){
                    dp[i] += (dp[i-2] * 9) % mod;
                }else if(s.charAt(i - 2) == '2'){
                    dp[i] += (dp[i-2] * 6) % mod;
                }else if(s.charAt(i - 2) == '*'){
                    dp[i] += (dp[i-2] * 15) % mod;
                }else{
                    continue;
                }
            }else if(s.charAt(i - 1) != '*' && s.charAt(i - 2) == '*'){
                int num = s.charAt(i - 1) - '0';
                if(num > 6){
                    dp[i] +=  (dp[i-2] * 1) % mod;
                }else{
                    dp[i] +=  (dp[i-2] * 2) % mod;
                }
                
            }
            dp[i] = dp[i] % mod;
        }
        return (int) dp[dp.length - 1];
    }
}