class Solution {
static class Pair implements Comparable < Pair > {
int n ;
int g;
Pair(int n , int g){
this.n = n;
this.g = g;
}
public int compareTo(Pair o){
return o.g - this.g;
}
}
public List findClosestElements(int[] arr, int k, int x) {
List< Integer > res = new ArrayList<>();

         Pair[] pairs = new Pair[arr.length];
  for(int i = 0 ; i < arr.length;i++){
      pairs[i] = new Pair(arr[i] , Math.abs(x - arr[i]));
  }
  PriorityQueue< Pair > pq = new PriorityQueue<>();
  for(int i = 0 ; i < arr.length;i++){
      if(i < k){
          pq.add(pairs[i]);
      }else{
          if(pairs[i].g < pq.peek().g){
              pq.remove();
              pq.add(pairs[i]);
          }
      }
  }
  while(pq.size() > 0){
      Pair p = pq.remove();
      res.add(p.n);
  }
   Collections.sort(res);
  return res;
}
}