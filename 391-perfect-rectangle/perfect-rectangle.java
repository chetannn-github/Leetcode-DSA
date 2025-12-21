class Solution {
public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        
        HashSet<Point> hs = new HashSet<>();
        int area = 0;
        
        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            Point A = new Point (rect[0] , rect[1]);
            Point B = new Point (rect[0] , rect[3]);
            Point C = new Point (rect[2] , rect[3]);
            Point D = new Point (rect[2] , rect[1]);
            
            if (!hs.add(A)) hs.remove(A);
            if (!hs.add(B)) hs.remove(B);
            if (!hs.add(C)) hs.remove(C);
            if (!hs.add(D)) hs.remove(D);
        }
        
        if (!hs.contains(new Point (x1 , y1)) || !hs.contains(new Point (x1 , y2)) || !hs.contains(new Point (x2 , y1)) || !hs.contains(new Point (x2 , y2)) || hs.size() != 4) return false;
        
        return area == (x2-x1) * (y2-y1);
    }

}
class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return this.x == p.x && this.y == p.y;
    }
    @Override
    public int hashCode () {
        return 31 * x + y;
    }


}