class Spreadsheet {
    private Map<String,Integer> sheet;

    public Spreadsheet(int rows) {
        sheet=new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        sheet.put(cell,value);
    }
    
    public void resetCell(String cell) {
        sheet.remove(cell);
    }
    
    public int getValue(String formula) {
        String expr=formula.substring(1);
        String[] parts=expr.split("\\+");
        return evaluate(parts[0])+evaluate(parts[1]);
    }
    private int evaluate(String s){
        if(Character.isLetter(s.charAt(0))){
            return sheet.getOrDefault(s,0);
        }
        return Integer.parseInt(s);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */