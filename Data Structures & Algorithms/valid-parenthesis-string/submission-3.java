class Solution {
    public boolean checkValidString(String s) {
        char[] sA = s.toCharArray();
        Deque<Integer> left = new ArrayDeque<>(sA.length);
        Deque<Integer> star = new ArrayDeque<>(sA.length);
        for(int i = 0; i < sA.length; i++){
            if(sA[i] == '('){
                left.addLast(i);
            } else if(sA[i] == ')'){
                if(!left.isEmpty()){
                    left.removeLast();
                } else if(!star.isEmpty()){
                    star.removeLast();
                } else {
                    return false;
                }
            } else if(sA[i] == '*'){
                star.addLast(i);
            }
        }
        while(!left.isEmpty() && !star.isEmpty()){
            if(left.removeLast() > star.removeLast()){
                return false;
            }
        }
        return left.isEmpty();
    }
}
