class Solution {
    public boolean isBoomerang(int[][] points) {
        if(points == null || points.length < 1) return false;
        
        if(points.length != 3) return false;
        
        double area = ((double)((points[1][0] - points[0][0]) * (points[2][1] - points[0][1])) - ((points[2][0] - points[0][0]) * (points[1][1] - points[0][1]))) / 2;
        System.out.println(area);
        if(area == 0) return false;
        return true;
    }
}
