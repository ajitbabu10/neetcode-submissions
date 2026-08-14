class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            Character curr = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == map.get(curr)) {
                stack.pop();
            } else {
                stack.push(curr);
            }
        }

        return stack.isEmpty();
    }
}
