class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hmap = new HashMap<>();
        for(String str:strs) {
            int[] count = new int[26];
            for(char c:str.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            hmap.putIfAbsent(key, new ArrayList<>());
            hmap.get(key).add(str);
        }
        return new ArrayList<>(hmap.values());
    }
}
