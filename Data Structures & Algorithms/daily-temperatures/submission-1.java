class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // without storing temp in stack. soln 1 is more intuitive though
        Stack<Integer> stack = new Stack<>(); 
        int[] ans = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int popIndex = stack.pop();
                ans[popIndex] = i - popIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
