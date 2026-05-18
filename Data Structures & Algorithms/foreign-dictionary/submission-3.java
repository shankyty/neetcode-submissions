class Solution {
    public String foreignDictionary(String[] words) {
        boolean[][] adj = new boolean[26][26];
        boolean[] chars = new boolean[26];
        char[][] wordsA = new char[words.length][0];
        for(int i = 0; i < words.length; i++){
            wordsA[i] = words[i].toCharArray();
            for(char c : wordsA[i]) chars[c - 'a'] = true;
        }
        for(int i = 0; i < words.length - 1; i++){
            int j = 0;
            int minLen = Math.min(wordsA[i].length, wordsA[i + 1].length);
            for(; j < minLen && wordsA[i][j] == wordsA[i + 1][j]; j++);
            
            if(j < wordsA[i].length && j == wordsA[i + 1].length) return "";
            
            if(j < minLen){
                adj[wordsA[i][j] - 'a'][wordsA[i + 1][j] - 'a'] = true;

            }
        }
        List<Integer> sorted  = new ArrayList<>(26);
        if(topological_sort(chars, adj, sorted)){
            StringBuilder sb = new StringBuilder(26);
            for(int i = sorted.size() - 1; i >= 0; i--){
                sb.append((char)('a' + sorted.get(i)));
            }
            System.out.println(sb.toString());
            return sb.toString();
        }
        return "";
    }
    boolean dfs(boolean[][] adj, int v, int[] visited, List<Integer> sorted) {
        visited[v] = 1;
        for(int u = 0; u < 26; u++){
            if (adj[v][u] ){
                if(visited[u] == 0) {
                    if(!dfs(adj, u, visited, sorted)){
                        return false;
                    }
                } else if(visited[u] == 1) {
                    return false;
                }
            }
        }
        visited[v] = 2;
        sorted.add(v);
        return true;
    }

    boolean topological_sort(boolean[] chars, 
                            boolean[][] adj, 
                            List<Integer> sorted) {
        int[] visited = new int[26];
        Arrays.fill(visited, 0);
        for (int i = 0; i < 26; ++i) {
            if (chars[i] && visited[i] == 0) {
                if(!dfs(adj, i, visited, sorted)){
                    return false;
                }
            }
        }
        return true;
    }
}
