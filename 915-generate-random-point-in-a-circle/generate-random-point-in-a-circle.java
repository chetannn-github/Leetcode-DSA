class Solution {
    double r, x, y;

    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double theta = 2 * Math.PI * Math.random(); 
        double radius = Math.sqrt(Math.random()) * r; // O to r 

        double x1 = x + radius * Math.cos(theta);
        double y1 = y + radius * Math.sin(theta);

        return new double[]{x1, y1};
    }
}
