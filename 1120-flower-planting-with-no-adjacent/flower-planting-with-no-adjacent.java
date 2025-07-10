class Solution {
    List<List<Integer>> adj;
    int colorOfNode[];
    public int[] gardenNoAdj(int N, int[][] paths) {
        int m = 4;
        adj = new ArrayList<>();
        colorOfNode = new int[N];
        for(int i=0;i<N;i++) adj.add(new ArrayList<>());
        
        for(int[] path : paths){
            adj.get(path[0]-1).add(path[1]-1);
            adj.get(path[1]-1).add(path[0]-1);
        }
        
        solve(0,N);
        return colorOfNode;
    }
    
    boolean solve(int currNode, int N){
        if(currNode == N) return true;

        for(int color = 1; color<=N; color++){
            
            if(isSafe(currNode,color,N)){
                colorOfNode[currNode] = color;
                if(solve(currNode+1,N)) return true;
                colorOfNode[currNode] = 0;
            }
        }

        return false;
    }

    boolean isSafe(int currNode,int colorFilled,int N){
        for(int nbr : adj.get(currNode)){
            if(colorOfNode[nbr] == colorFilled){
                return false;
            }
        }

        return true;
    }
    
    
    
}