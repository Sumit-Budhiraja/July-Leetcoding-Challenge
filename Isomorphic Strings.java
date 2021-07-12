class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> from = new HashMap<Character, Character>();
        Map<Character, Character> to = new HashMap<Character, Character>();

		int m = s.length(); int n = t.length();
        
        if(m != n) return false;
        
        for(int i=0; i<m; i++) {
            Character fch = s.charAt(i);
            Character tch = t.charAt(i);
            
            if(!from.containsKey(fch) && !to.containsKey(tch)) {
                from.put(fch, tch);
                to.put(tch, fch);
            }else if(from.get(fch) != tch && to.get(tch) != fch) {
                return false;
            }
        }
        
        return true;
    }
}