class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int totalTime = 0 ;
        String garbageType = new String("MGP");
        for(int i = 0; i < garbage.length; i++){
            totalTime += garbage[i].length();
        }
        int [] travelSum = new int[travel.length];
        travelSum[0] = travel[0];
        for(int i = 1; i < travel.length; i++){
                travelSum[i]  = travelSum[i-1]+travel[i];
        }
        for(char c : garbageType.toCharArray()){
            for(int i = garbage.length-1; i>0; i--){
                if(garbage[i].contains(String.valueOf(c))){
                    totalTime += travelSum[i-1];
                    break;
                }
            }
        }
    return totalTime;
    }
}