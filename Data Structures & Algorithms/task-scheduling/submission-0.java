class Solution {
    public int leastInterval(char[] tasks, int n) {
        // very un-intuitive, solution is from chatgpt, remember the formula
        // Math.max(tasks.length, (maxFreq - 1) * (n + 1) + countMax)

        // find the freq
        int[] freq = new int[26];   
        for(char task : tasks) {
            freq[task - 'A']++;
        }

        //find maxFreq
        int maxFreq = 0;
        int countMax = 0;

        for(int f : freq) {
            maxFreq = Math.max(f, maxFreq);
        }

        // Count how many tasks have maximum frequency
        for(int f : freq) {
            if(f == maxFreq) {
                countMax++;
            }
        }

        int res = (maxFreq - 1) * (n + 1) + countMax;
        return Math.max(tasks.length, res);
    }
}
