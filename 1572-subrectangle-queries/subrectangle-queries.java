class SubrectangleQueries {
    int[][] rect;
    public SubrectangleQueries(int[][] rectangle) {
        rect = new int[rectangle.length][rectangle[0].length];
        for(int i=0; i<rect.length; i++){
            for(int j=0; j<rect[0].length; j++){
                rect[i][j] = rectangle[i][j];
            }
        }
    }
    
    public void updateSubrectangle(int r1, int c1, int r2, int c2, int newValue) {
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                rect[i][j] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        return rect[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */