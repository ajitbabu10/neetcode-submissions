class Twitter {
    // Just a sort solution, since heap is complex (chatgpt)

    int time;
    HashMap<Integer, Set<Integer>> following;
    HashMap<Integer, List<Tweet>> tweets;

    class Tweet {
        int id;
        int time;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        time = 0;
        following = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        Tweet tweet = new Tweet(tweetId, time++);
        tweets.get(userId).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> allTweets = new ArrayList<>();

        // Add user's own tweets
        if(tweets.containsKey(userId)) {
            allTweets.addAll(tweets.get(userId));
        }

        // Add tweets of people user follows
        if(following.containsKey(userId)) {
            for(int followee : following.get(userId)) {
                if(tweets.containsKey(followee)) {
                    allTweets.addAll(tweets.get(followee));
                }
            }
        }

        // Newest first
        allTweets.sort((a,b) -> b.time - a.time);

        List<Integer> res = new ArrayList<>();
        // Return last 10 tweets
        for(int i = 0 ; i < Math.min(10, allTweets.size()) ; i++) {
            res.add(allTweets.get(i).id);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
