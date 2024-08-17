class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int [] start_times = new int[intervals.length];
        int [] end_times = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            start_times[i] = intervals[i][0];
            end_times[i] = intervals[i][1];
        }
        Arrays.sort(start_times);
        Arrays.sort(end_times);
        int i = 1;
        int j = 0;
        
        while(i < start_times.length){
            if(start_times[i] < end_times[j]){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}