class Solution {
    public String minWindow(String s, String t) {
        //write and see the solution before seeing code, algo is rememberable but code is not!
        // if(t.length() > s.length()) return "";
        // if(t.equals("")) return "";

        int[] result = {-1,-1};
        int minLen = Integer.MAX_VALUE;

        
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> haveMap = new HashMap<>();

        for(Character c:t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = needMap.size();

        int l=0;
        for(int r = 0; r < s.length() ; r++) {
            Character c = s.charAt(r);
            haveMap.put(c, haveMap.getOrDefault(c, 0) + 1);
            if(needMap.containsKey(c)) {
                if(needMap.get(c).equals(haveMap.get(c))) {
                    have++;
                } 
            }

            while(have == need) {
                if(r-l+1 < minLen) {
                    result[0] = l;
                    result[1] = r;
                    minLen = r-l+1;
                }
                Character charLeft = s.charAt(l);
                haveMap.put(charLeft, haveMap.get(charLeft) - 1);
                if(needMap.containsKey(charLeft) && haveMap.get(charLeft) < needMap.get(charLeft)) {
                    have--;
                }
                l++;
            }

        } 
        if(minLen == Integer.MAX_VALUE) return "";
        else 
            return s.substring(result[0], result[1]+1);
    }
}
