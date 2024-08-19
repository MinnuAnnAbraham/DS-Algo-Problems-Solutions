int minMeetingRooms(int[][] intervals){
    if(intervals.length<=1)
        return intervals.length;
    // sort the intervals in ascending order of the start time 
    Arrays.sort(intervals, new Comparator<int[]>() {
        public int compare(int[] o1, int[] o2) {
            return o1[0]-o2[0];
        }
    });
    int max=0, cur=1, end=intervals[0][1];
    for(int i=0; i<intervals.length-1; i++){
        if(end>intervals[i+1][0]){
            cur++;
            max = Math.max(cur, max);
        }else {
            cur--;
        }
        end = Math.max(end, intervals[i+1][1]);
    }
    return max;
}