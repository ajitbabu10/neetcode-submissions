class TimeMap {

    Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = map.getOrDefault(key, new ArrayList<>());

        int l=0;
        int r=list.size()-1;
        String res="";

        while(l <= r) {
            int mid = l+(r-l)/2;
            if(list.get(mid).getTimeStamp() <= timestamp) {
                res = list.get(mid).getValue();
                l=mid+1;
            } else {
                r=mid-1;
            }
        }

        return res;
    }
}

class Node {
    private int timestamp;
    private String value;

    public Node(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public int getTimeStamp() {
        return timestamp;
    }

    public String getValue() {
        return value;
    }
}
