class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] pairs = new double[n][2];

        for(int i=0; i<n ; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Double.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for(double[] pair : pairs) {
            double pos = pair[0];
            double spd = pair[1];

            double time = (target - pos) / spd;
            if(!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }

            stack.push(time);
        }

        return stack.size();
    }
}