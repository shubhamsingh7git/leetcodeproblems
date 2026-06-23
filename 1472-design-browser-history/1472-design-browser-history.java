class BrowserHistory {
    private List<String> history;
    private int curr;

    public BrowserHistory(String homepage) {
        history=new ArrayList<>();
        history.add(homepage);
        curr=0;
    }
    
    public void visit(String url) {
        while(history.size()>curr+1){
            history.remove(history.size()-1);
        }
        history.add(url);
        curr++;
    }
    
    public String back(int steps) {
        curr=Math.max(0,curr-steps);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        curr=Math.min(history.size()-1,curr+steps);
        return history.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */