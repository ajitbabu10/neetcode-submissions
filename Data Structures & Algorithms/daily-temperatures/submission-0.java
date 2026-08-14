class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>(); // 0->temp, 1->index
        int[] ans = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temp > stack.peek()[0]) {
                int[] pop = stack.pop();
                int popTemp = pop[0];
                int popIndex = pop[1];
                ans[popIndex] = i - popIndex;
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return ans;
    }
}
