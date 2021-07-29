class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // check if matrix is empty 
        if(mat == null || mat.length == 0) return mat;
        // getting row length 
        int rowLen=mat.length;
        // getting column length
        int colLen=mat[0].length;
        // We are using BFS approach so queue is initialized
         Queue<int []> queue= new LinkedList<>();
        // Need Visited array to keep track of visited 
        boolean[][] visited = new boolean[rowLen][colLen];
        // Visiting all zeros in the matrix adding them in queue and marking them visited
        for(int row=0;row<rowLen;row++){
            for(int col=0;col<colLen;col++){
                if(mat[row][col]==0){
                    queue.offer(new int[]{row,col});
                    visited[row][col]=true;
                }
            }
        }
       // We need direction to traverse for bfs Left Right Bottom Up
       int [][] directions={{0,-1},{0,1},{1,0},{-1,0}};
       // Traversing queue 
        while(!queue.isEmpty()){
            // Need queue size to traverse 
            int qsize=queue.size();
           for(int i=0;i<qsize;i++){
            int [] current=queue.poll();
            int currentX=current[0];
            int currentY=current[1];
               for(int[] d :directions){
                   int x=currentX + d[0];
                   int y=currentY + d[1];
                   if(x<0 || x>rowLen-1 || y<0 || y>colLen-1 || visited[x][y])
                       continue;
                   mat[x][y]=mat[currentX][currentY]+1;
                   queue.offer(new int[]{x,y});
                   visited[x][y]=true;
                   
                   
               }
                     
                
            }
            
        }
        return mat;
    }
}