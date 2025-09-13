class Solution {
    public int snakesAndLadders(int[][] board) {
        reverseRowsAndOddRowElements(board);
        Queue<Integer> queue = new LinkedList<>();
        int n = board.length;
        HashSet<Integer> visited = new HashSet<>();
        
        queue.add(0);
        visited.add(0);
        int diceRollsCount = 0;

        while(!queue.isEmpty()) {
            int currSize = queue.size();

            while(currSize-->0) {
                int currPosition = queue.remove();
                if(currPosition == n*n - 1) return diceRollsCount;

                List<Integer> nextPos = new ArrayList<>();
                for(int i=1; i<=6; i++) {
                    int nextPosition = currPosition + i;
                    if(nextPosition < n*n) {
                        nextPos.add(nextPosition);
                    }
                }

                for(int nextOnes : nextPos) {
                    int nextRow = nextOnes / n;
                    int nextCol = nextOnes % n;
                    int val = board[nextRow][nextCol] ;

                    int destination = (val == -1) ? nextOnes : val - 1;

                    if (!visited.contains(destination)) {
                        visited.add(destination);
                        queue.add(destination);
                    }
                
                }

            }

            diceRollsCount++;
        }

        return -1;
    }


    public static void reverseRowsAndOddRowElements(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;

        while (top < bottom) {
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;

            top++;
            bottom--;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 1) { // odd index
                reverseArray(matrix[i]);
            }
        }
    }

    private static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}