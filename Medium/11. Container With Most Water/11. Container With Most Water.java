class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int first = 0;
        int last = n-1;
        int area = 0;
        while(first < last){
            int min = Math.min(height[first], height[last]);
            area = Math.max(area, min* (last-first));
            if(height[first] <= height[last]){
                first++;
            }
            else{
                last--;
            }
        }
        return area;
    }
}