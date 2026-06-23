class UndergroundSystem {
    class CheckIn{
        String station;
        int time;
        CheckIn(String station,int time){
            this.station=station;
            this.time=time;
        }
    }
    class Route{
        long totalTime;
        int count;
        Route(long totalTime,int count){
            this.totalTime=totalTime;
            this.count=count;
        }
    }
    private Map<Integer,CheckIn>checkIns;
    private Map<String,Route>routes;

    public UndergroundSystem() {
        checkIns=new HashMap<>();
        routes=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id,new CheckIn(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn info=checkIns.get(id);
        String key=info.station+'#'+stationName;
        int travelTime=t-info.time;
        Route route=routes.getOrDefault(key,new Route(0,0));
        route.totalTime+=travelTime;
        route.count++;
        routes.put(key,route);
        checkIns.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key=startStation+'#'+endStation;
        Route route=routes.get(key);
        return (double) route.totalTime/route.count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */