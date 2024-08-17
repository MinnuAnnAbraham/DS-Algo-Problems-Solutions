class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int [] start_times = new int[intervals.length];
        int [] end_times = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            start_times[i] = intervals[i][0];
            end_times[i] = intervals[i][1];
        }
        Arrays.sort(start_times);
        Arrays.sort(end_times);
        int no_of_rooms_occupied=0;
        int min_rooms_needed=0;
        int i = 0;
        int j = 0;
        
        while(i < start_times.length && j < end_times.length){
            if(start_times[i] < end_times[j]){
                i++;
                no_of_rooms_occupied++;
                min_rooms_needed = Math.max(min_rooms_needed,no_of_rooms_occupied);
            }
            else{
                j++;
                no_of_rooms_occupied--;
            }
        }
        return min_rooms_needed;
    }
}