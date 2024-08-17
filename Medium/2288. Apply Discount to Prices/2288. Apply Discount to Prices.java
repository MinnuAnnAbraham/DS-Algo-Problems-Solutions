class Solution {
    public String discountPrices(String sentence, int discount) {
        String res = "";
        String[] stringArray = sentence.split(" ");
        for(int i = 0; i< stringArray.length; i++){
            String s = stringArray[i];
            if(s.charAt(0) =='$'){
                String temp = s;
                temp = temp.substring(1);
                if(temp.matches("\\d+(\\.\\d*)?")){
                    double num = Double.valueOf(temp);
                    double d = num - (((double)num * discount)/100d);
                    DecimalFormat df = new DecimalFormat("0.00");
                    stringArray[i] = "$" + df.format(d).toString();
                }
            }
        }
        return String.join(" ", stringArray);
    }
}