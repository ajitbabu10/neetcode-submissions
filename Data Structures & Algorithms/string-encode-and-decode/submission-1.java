class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";

        StringBuilder encoded = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();

        for(String str : strs) {
            sizes.add(str.length());
        }

        for(Integer size : sizes) {
            encoded.append(size).append(',');
        }

        encoded.append('#');

        for(String str : strs) {
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        if(str.equals("")) return new ArrayList<>();

        //Find the first occurence of #
        int i = 0;
        while(str.charAt(i) != '#') {
            i++;
        }

        String sizesString = str.substring(0, i-1);
        String[] sizes = sizesString.split(",");
        List<Integer> sizeList = new ArrayList<>();

        for(String size : sizes) {
            sizeList.add(Integer.parseInt(size));
        }

        String words = str.substring(i+1);

        List<String> ans = new ArrayList<>();
        int start=0;
        int end=0;
        for(Integer size : sizeList) {
            start = end;
            end = end + size;
            ans.add(words.substring(start, end));
        }

        return ans;

    }
}
