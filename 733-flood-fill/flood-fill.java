class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        
        Queue<Pair> queue = new LinkedList<>();
        int[][] dirns = {{-1,0},{1,0},{0,1},{0,-1}};

        int rows = image.length;
        int cols = image[0].length;
        int intialColor = image[sr][sc];
        queue.add(new Pair(sr,sc));

        while(!queue.isEmpty()) {
            int currSize = queue.size();
            while(currSize --> 0) {
                Pair curr = queue.remove();
                image[curr.x][curr.y] = color;

                for(int[] dirn : dirns) {
                    int nx = dirn[0] + curr.x;
                    int ny = dirn[1] + curr.y;

                    if(nx >=0  && ny >=0 && nx < rows && ny < cols) {
                        if(image[nx][ny] == intialColor) {
                            queue.add(new Pair(nx,ny));
                        }
                    }
                }  
            }
        }

        return image;
    }
}

class Pair {
    int x,y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}