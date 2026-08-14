class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int r=0;r<9;r++) {
            for(int c=0;c<9;c++) {
                char currentChar = board[r][c];
                String squareKey = r/3+","+c/3;
                if(currentChar == '.')
                    continue;
                if(rows.computeIfAbsent(r, k -> new HashSet<>()).contains(currentChar) || 
                    columns.computeIfAbsent(c, k -> new HashSet<>()).contains(currentChar) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(currentChar)) {
                        return false;
                } else {
                    rows.get(r).add(currentChar);
                    columns.get(c).add(currentChar);
                    squares.get(squareKey).add(currentChar);
                }
            }
        }

        return true;
    }
}
