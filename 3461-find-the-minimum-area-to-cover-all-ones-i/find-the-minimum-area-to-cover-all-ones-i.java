// class Solution {
//     public int minimumArea(int[][] grid) {
//         int leftMost = -1, rightMost = -1, top = -1, bottom = -1;
        
//         for (int row = 0; row < grid.length; row++) {
//             for (int col = 0; col < grid[0].length; col++) {
//                 if (grid[row][col] == 1) {
//                     top = row;
//                     break;
//                 }
//             }
//             if (top != -1) {
//                 break;
//             }
//         }

//         for (int row = grid.length - 1; row >= top; row--) {
//             for (int col = 0; col < grid[0].length; col++) {
//                 if (grid[row][col] == 1) {
//                     bottom = row;
//                     break;
//                 }
//             }
//             if (bottom != -1) {
//                 break;
//             } 
//         }

//         for (int col = 0; col < grid[0].length; col++) {
//             for (int row = top; row <= bottom; row++) {
//                 if (grid[row][col] == 1) {
//                     leftMost = col;
//                     break;
//                 }
//             }
//             if (leftMost != -1) {
//                 break;
//             }
//         }

//         for (int col = grid[0].length - 1; col >= leftMost; col--) {
//             for (int row = top; row <= bottom; row++) {
//                 if (grid[row][col] == 1) {
//                     rightMost = col;
//                     break;
//                 }
//             }
//             if (rightMost != -1) {
//                 break;
//             }
//         }

//         return (rightMost - leftMost + 1) * (bottom - top + 1);
//     }
// }



class Solution {

    public int minimumArea(int[][] grid) {
        int left = -1, right = -1, top = -1, bottom = -1;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    if(top == -1) {
                        top = row; 
                        bottom = row;
                    }else {
                        bottom = row;
                    }

                    if(left == -1) {
                        left = col;
                        right = col;
                    }else if(col > right) {
                        right = col;
                    }else if(col < left) {
                        left = col;
                    }
                }
            }
        }

       
        return (right - left + 1) * (bottom - top + 1);
    }
}