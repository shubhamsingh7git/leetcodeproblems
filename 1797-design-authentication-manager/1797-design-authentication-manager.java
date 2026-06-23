class AuthenticationManager {
    private int ttl;
    private Map<String,Integer>map;

    public AuthenticationManager(int timeToLive) {
        ttl=timeToLive;
        map=new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId,currentTime+ttl);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId) && map.get(tokenId)>currentTime){
            map.put(tokenId,currentTime+ttl);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count=0;
        for(int expiry:map.values()){
            if(expiry>currentTime){
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */