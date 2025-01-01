// class Solution {
//     public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
//         HashSet<List<Integer>> hs = new HashSet<>();
//         for (int[] cord : dig) {
//             hs.add(Arrays.asList(cord[0], cord[1]));
//         }

//         int ans = 0;

//         for(int[] cord : artifacts){
//             int x1 = cord[0];
//             int y1 = cord[1];
//             int x2 = cord[2];
//             int y2 = cord[3];

//             if((x1==x2)){
//                 while(y1<=y2 && hs.contains(Arrays.asList(x1,y1))){
//                     y1++;
//                 }
//                 if(y1>y2){
//                     ans++;
//                 }

                
//             }else if(y1==y2){
//                 while(x1<=x2 && hs.contains(Arrays.asList(x1,y1))){
//                     x1++;
//                 }
//                 if(x1>x2){
//                     ans++;
//                 }
//             }else{
//                 if(hs.contains(Arrays.asList(x1,y1)) && hs.contains(Arrays.asList(x2,y2)) && hs.contains(Arrays.asList(x1+1,y1))  && hs.contains(Arrays.asList(x1,y1+1))){
//                     ans++;
//                 }
//             }
//         }
//         return ans;
//     }
// }

class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] covered = new boolean[n][n];
        for (int[] d : dig)
            covered[d[0]][d[1]] = true;

        int count = 0;
        for (int[] artifact : artifacts) {
            boolean canBeExtracted = true;
            for (int r=artifact[0]; r<=artifact[2]; r++) {
                for (int c=artifact[1]; c<=artifact[3]; c++) {
                    if (!covered[r][c]) {
                        canBeExtracted = false;
                        break;
                    }
                }
            }
            if (canBeExtracted) count++;
        }
        return count;
    }
}