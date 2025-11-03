class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int[][] dirns = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        HashSet<String> visited = new HashSet<>();
        int m = grid.length, n = grid[0].length();
        Queue<Info> queue = new LinkedList<>();
        int keysCount = 0, steps = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                char ch = grid[i].charAt(j);
                if(ch == '@') {
                    queue.add(new Info(i,j,new HashSet<>()));
                    String setKey = getSetKey(i,j,new HashSet<>());
                    visited.add(setKey);
                }else if(ch >= 'a' && ch <= 'z') keysCount++;
            }
        }
        
        while(!queue.isEmpty()) {
            int currSize = queue.size();

            while(currSize-->0) {
                Info curr = queue.remove();
                int x = curr.x, y = curr.y;
                HashSet<Integer> keys = curr.keys;

                if(keys.size() == keysCount) return steps;

                for(int[] dirn : dirns) {
                    int nx = x + dirn[0], ny = y + dirn[1];
                    if(nx < 0 || ny < 0 || nx >=m || ny >= n) continue;
                    String setKey = getSetKey(nx,ny,keys);
                    if(visited.contains(setKey)) continue;

                    char ch = grid[nx].charAt(ny);
                    if(ch == '#') continue;

                    boolean isUpperAndNoKey = ch >= 'A' && ch <= 'Z' && !keys.contains((ch - 'A'));
                    if(isUpperAndNoKey) continue;

                    HashSet<Integer> nbrKeys =  new HashSet<>();
                    nbrKeys.addAll(keys);

                    boolean isKey = (ch >= 'a' && ch <= 'z');
                    if(isKey) nbrKeys.add(ch - 'a');
                    setKey = getSetKey(nx,ny,nbrKeys);
                    queue.add(new Info(nx,ny,nbrKeys));
                    visited.add(setKey); 
                                      
                }
            }

            steps++;
        }

        return -1;
    }

    private String getSetKey(int x, int y, HashSet<Integer> set) {
        return x + " " + y + set.toString(); 
    }
}



class Info {
    int x, y;
    HashSet<Integer> keys;

    Info(int x, int y, HashSet<Integer> keys) {
        this.x = x;
        this.y = y;
        this.keys = keys;
    }
}