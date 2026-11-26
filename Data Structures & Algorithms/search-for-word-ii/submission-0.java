class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> res = new ArrayList<>();
        for (String w : words) {
            TrieNode cur = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) {
                    cur.children[i] = new TrieNode();
                }
                cur = cur.children[i];
            }
            cur.word = w;
        }
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        char letter = board[r][c];
        TrieNode next = node.children[letter - 'a'];
        if (next == null) return;

        if (next.word != null) {
            res.add(next.word);
            next.word = null;
        }

        board[r][c] = '#';

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < board.length 
                && nc >= 0 && nc < board[0].length
                && board[nr][nc] != '#') {
                    dfs(board, nr, nc, next, res);
            }
        }
        board[r][c] = letter;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    // boolean endOfWord = false;
    String word = null;
}