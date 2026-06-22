class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freq=new HashMap<>();
        for(char c:s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character>pq=new PriorityQueue<>((a,b)->freq.get(b)-freq.get(a));
        pq.addAll(freq.keySet());
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            char ch=pq.poll();
            int count=freq.get(ch);
            while(count-->0){
                sb.append(ch);
            }
        }
        return sb.toString();
        
        
    }
}