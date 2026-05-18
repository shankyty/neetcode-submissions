class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        int n = wordList.size();
        int m = wordList.get(0).length();
        Set<String> words = new HashSet<>();
        Set<String> visited = new HashSet<>();
        words.addAll(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int wordsCount = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            //System.out.println("level = " + wordsCount +",size = " + size);
            for(int k = 0; k < size; k++){
                String current = queue.poll();
                char[] currentA = current.toCharArray();
                //System.out.println("current = " + current);
                for(int i = 0; i < currentA.length; i++){
                    char c = currentA[i];
                    for(int j = 0; j < 26; j++){
                        char curr = (char)('a' + j);
                        if(curr != c){
                            currentA[i] = curr;
                            String next = new String(currentA);
                            if(words.contains(next)){
                                if(endWord.equals(next)){
                                    return wordsCount + 1;
                                }
                                if(!visited.contains(next)){
                                    visited.add(next);
                                    queue.offer(next);
                                }
                                //System.out.println("added = " + next);
                                
                            }
                        }
                    }
                    currentA[i] = c;
                }
            }
            wordsCount++;
        }
        return 0;
    }
}