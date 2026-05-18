class Twitter {

    Map<Integer, Set<Integer>> follower = new HashMap<>();
    Deque<int[]> feeds = new ArrayDeque<>();


    public Twitter() {

    }
    
    public void postTweet(int userId, int tweetId) {
        feeds.addFirst(new int[]{userId,tweetId});
        follower.computeIfAbsent(userId, __ -> new HashSet<>()).add(userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        return feeds.stream()
            .filter(post -> follower.get(userId).contains(post[0]))
            .map(post -> post[1])
            .limit(10)
            .collect(Collectors.toList());
    }
    
    public void follow(int followerId, int followeeId) {
        follower.computeIfAbsent(followerId, __ -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId != followeeId){
            follower.computeIfAbsent(followerId, __ -> new HashSet<>()).remove(followeeId);
        }
    }
}
