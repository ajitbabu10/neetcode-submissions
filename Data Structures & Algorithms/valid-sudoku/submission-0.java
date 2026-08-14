class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int r=0;r<9;r++) {
            rows.put(r, new HashSet<>());
            columns.put(r, new HashSet<>());
            for(int c=0;c<9;c++) {
                String key = r/3+","+c/3;
                squares.put(key, new HashSet<>());
            }
        }

        for(int r=0;r<9;r++) {
            for(int c=0;c<9;c++) {
                char currentChar = board[r][c];
                if(currentChar == '.')
                    continue;
                if(rows.get(r).contains(currentChar) || 
                    columns.get(c).contains(currentChar) ||
                    squares.get(r/3+","+c/3).contains(currentChar)) {
                        return false;
                } else {
                    rows.get(r).add(currentChar);
                    columns.get(c).add(currentChar);
                    squares.get(r/3+","+c/3).add(currentChar);
                }
            }
        }

        return true;
    }
}
