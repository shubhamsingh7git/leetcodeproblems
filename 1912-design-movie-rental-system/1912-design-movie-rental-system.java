class MovieRentingSystem {
    private Map<Integer,TreeSet<int[]>>available;
    private TreeSet<int[]>rented;
    private Map<String,Integer>priceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        available=new HashMap<>();
        priceMap=new HashMap<>();
        rented=new TreeSet<>((a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            if(a[1]!=b[1]) return a[1]-b[1];
            return a[2]-b[2];
        });
        for(int[]e:entries){
            int shop=e[0];
            int movie=e[1];
            int price=e[2];
            available.computeIfAbsent(movie,k->new TreeSet<>((a,b)->{
                if(a[0]!=b[0]) return a[0]-b[0];
                return a[1]-b[1];
            })).add(new int[]{price,shop});
            priceMap.put(shop+"#"+movie,price);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer>ans=new ArrayList<>();
        if(!available.containsKey(movie)) return ans;
        int count=0;
        for(int[]p:available.get(movie)){
            ans.add(p[1]);
            count++;
            if(count==5) break;
        }
        return ans;
    }
    
    public void rent(int shop, int movie) {
        int price=priceMap.get(shop+"#"+movie);
        available.get(movie).remove(new int[]{price,shop});
        rented.add(new int[]{price,shop,movie});
    }
    
    public void drop(int shop, int movie) {
        int price=priceMap.get(shop+"#"+movie);
        rented.remove(new int[]{price,shop,movie});
        available.get(movie).add(new int[]{price,shop});
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> ans=new ArrayList<>();
        int count=0;
        for(int[]r:rented){
            ans.add(Arrays.asList(r[1],r[2]));
            count++;
            if(count==5) break;
        }
        return ans;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */