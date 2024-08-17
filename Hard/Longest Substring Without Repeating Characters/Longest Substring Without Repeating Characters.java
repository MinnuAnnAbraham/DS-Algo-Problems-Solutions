class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int l = 0 ,r = 0;
        int n = s.length();
        while(l <= r && r < n){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength;
    }
}