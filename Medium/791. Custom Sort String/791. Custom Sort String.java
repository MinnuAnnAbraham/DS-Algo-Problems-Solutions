class Solution {
    public String customSortString(String order, String s) {
        char[] count = new char[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)-'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            while(count[order.charAt(i)-'a']>0){
                sb.append(order.charAt(i));
                count[order.charAt(i)-'a']--;
            }
        }
        for(char c = 'a'; c <= 'z'; c++){
            while(count[c-'a'] > 0){
                sb.append(c);
                count[c-'a']--;
            }
        }
    return sb.toString(); 
    }
}