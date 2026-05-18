class Twitter {

    Map<Integer, Set<Integer>> follower = new HashMap<>();
    Map<Integer, LinkedList<int[]>> tweets = new HashMap<>();
    int timeStamp = 0;
    int FEED_SIZE = 10;
    
    public Twitter() {}
    
    public void postTweet(int userId, int tweetId) {
        LinkedList<int[]> feed = tweets.computeIfAbsent(userId, __ -> new LinkedList<>());
        feed.offer(new int[]{tweetId,timeStamp++});
        follower.computeIfAbsent(userId, __ -> new HashSet<>()).add(userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> feed = new PriorityQueue<>();
        return follower.getOrDefault(userId, Set.of(userId))
            .stream()
            .map(tweets::get)
            .filter(Objects::nonNull)
            .flatMap(LinkedList::stream)
            .sorted((a, b) -> b[1] - a[1])
            .limit(FEED_SIZE)
            .map(a -> a[0])
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
