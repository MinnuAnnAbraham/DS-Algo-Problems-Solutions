class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String charArrayString = String.valueOf(charArray);
            map.putIfAbsent(charArrayString, new ArrayList<>());
            map.get(charArrayString).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}