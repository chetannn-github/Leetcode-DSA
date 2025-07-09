class Solution {
    int rows,cols;
    private static int[][] dirns = {{1,0},{0,1}};
    public int[][] findFarmland(int[][] land) {
        this.rows = land.length;
        this.cols = land[0].length;
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(land[i][j] == 1) {
                    List<Integer> farmland = new ArrayList<>();
                    farmland.add(i);farmland.add(j);farmland.add(i);farmland.add(j);
                    dfs(new Pair(i,j),land, farmland);
                    result.add(farmland);
                }
            }
        }
        int[][] farms = new int[result.size()][4];
        int idx = 0;
        for(List<Integer> cords : result) {
            farms[idx][0] = cords.get(0);
            farms[idx][1] = cords.get(1);
            farms[idx][2] = cords.get(2);
            farms[idx][3] = cords.get(3);
            idx++;
        }

        return farms;
        
    }


    public void dfs(Pair curr, int[][] land, List<Integer> farmland) {
        int x = curr.x, y = curr.y;
        land[x][y] = 0;
        if(farmland.get(2) <= x && farmland.get(3) <= y ){
            farmland.set(2,x);
            farmland.set(3,y);
        }
        

        for(int[] dirn : dirns) {
            int nx = x + dirn[0];
            int ny = y + dirn[1];

            if(nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                if(land[nx][ny] == 1) {
                    dfs(new Pair(nx,ny),land, farmland);
                }
            }
        }        
    }

}


class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}