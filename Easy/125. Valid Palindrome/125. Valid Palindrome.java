class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int r = s.length()-1;
        int l = 0;
        while(l<r){
            char cleft = s.charAt(l);
            char cright = s.charAt(r);
            if(!Character.isLetterOrDigit(cleft)){
                l++;
            }
            else if(!Character.isLetterOrDigit(cright)){
                r--;
            }
            else{
                if(cleft == cright){
                    l++;
                    r--;
                }
                else{
                    return false;
                }
            }
                
        }
        return true;
    }
}