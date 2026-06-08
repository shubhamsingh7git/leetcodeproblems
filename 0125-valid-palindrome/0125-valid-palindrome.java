class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        String result = s.replaceAll("[^A-Za-z0-9]", "").replaceAll("\\s", "");
        int start=0;
        int end=result.length()-1;
        if (result.length()==0) return true;
        while(start<end){
            if(result.charAt(start)!=result.charAt(end)){
                return false;
                
                
            }
            start++;
            end--;
        }
        return true;
        
    }
}