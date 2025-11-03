class Solution {
    int[][] dirns = {{0,1}, {1,0},{0,-1}, {-1,0}};
    public int slidingPuzzle(int[][] board) {
        HashSet<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int[] row : board) sb.append(row[0]+""+row[1]+""+row[2]);
        
        Queue<String> queue = new LinkedList<>();
        queue.add(sb.toString());
        visited.add(sb.toString());
        int steps = 0;

        while(!queue.isEmpty()) {
            int currSize = queue.size();

            while(currSize-->0) {
                String curr = queue.remove();
                if(curr.equals("123450")) return steps; 

                int x = 0; int y = 0;
                for(int i=0; i<6; i++) {
                    if(curr.charAt(i) == '0'){ 
                        x = i / 3;
                        y = i % 3;
                        break;
                    }
                }
                

                for(int[] dirn : dirns) {
                    int nx = x + dirn[0], ny = y + dirn[1];
                    if(nx < 0 || ny < 0 || nx >= 2 || ny >=3) continue;

                    StringBuilder nbrSb = new StringBuilder(curr);
                    char ch = nbrSb.charAt(nx*3 + ny);

                    nbrSb.setCharAt(nx*3 + ny, '0');
                    nbrSb.setCharAt(x*3 + y,ch);
                    String nbrString = nbrSb.toString();

                    if(visited.contains(nbrString)) continue;
                    queue.add(nbrString);
                    visited.add(nbrString);
                }
            }
            steps++;
        }
        return -1;
    }
}