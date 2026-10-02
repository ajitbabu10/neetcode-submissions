class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        backtrack(0,0, n, curr);
        return res;
    }

    public void backtrack(int open, int close, int n, StringBuilder curr) {
        if(open == n && close == n) {
            res.add(curr.toString());
            return;
        }

        if(open < n) {
            curr.append("(");
            backtrack(open+1, close, n, curr);
            curr.deleteCharAt(curr.length()-1);
        }
        

        // we can add the closing brace only when this condition satisfies
        if(close < open) {
            curr.append(")");
            backtrack(open, close+1, n, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
