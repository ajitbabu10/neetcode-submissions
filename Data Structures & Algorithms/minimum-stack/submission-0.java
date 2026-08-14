class MinStack {

    List<Integer> list;

    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
        list.removeLast();
    }
    
    public int top() {
        return list.getLast();
    }
    
    public int getMin() {   
        int min = Integer.MAX_VALUE;
        for(Integer elt : list) {
            min = Math.min(min, elt);
        }

        return min;
        
    }
}
