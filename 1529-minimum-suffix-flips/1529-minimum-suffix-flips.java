class Solution {
    public int minFlips(String target) {
        int flips=0;
        char curr='0';
        for(char ch:target.toCharArray()){
            if(ch!=curr){
                flips++;
                curr=(curr=='0')?'1':'0';
            }
        }
        return flips;
    }
}