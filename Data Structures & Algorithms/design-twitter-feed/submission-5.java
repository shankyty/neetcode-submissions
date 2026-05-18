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
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        follower.getOrDefault(userId, Set.of(userId)).stream()
            .map(tweets::get)
            .filter(Objects::nonNull)
            .flatMap(LinkedList::stream)
            .forEach(tweet -> {
                pq.offer(tweet);
                if (pq.size() > FEED_SIZE) {
                    pq.poll();
                }
            });

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll()[0]);
        }
        Collections.reverse(result);
        return result;
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
