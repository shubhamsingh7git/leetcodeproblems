class Solution {
    public boolean detectCapitalUse(String word) {
        int n=word.length();
        boolean allUpper=true;
        boolean allLower=true;
        for(char c:word.toCharArray()){
            if(Character.isLowerCase(c)){
                allUpper=false;
            }
            else{
                allLower=false;
            }
        }
        if(allUpper || allLower) return true;
        if(Character.isUpperCase(word.charAt(0))){
            for(int i=1;i<n;i++){
                if(Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}