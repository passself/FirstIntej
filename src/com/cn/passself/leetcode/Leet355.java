package com.cn.passself.leetcode;
import java.util.*;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/design-twitter/
 * 设计twitter
 *
 */
public class Leet355 {
    /*public Twitter() {

    }*/
    static int timestamp = 0;
    class Tweet{
        private int id;
        private int time;
        private Tweet next;
        // 需要传入推文内容（id）和发文时间
        public Tweet(int id,int time,Tweet next){
            this.id = id;
            this.time = time;
            this.next  = next;
        }
    }

    class User{
        private int id;
        public Set<Integer> followed;
        //用户发表的推文链表头结点
        public Tweet head;

        public User(int userId){
            followed = new HashSet<Integer> ();
            this.id = userId;
            this.head = null;
            follow(id);
        }

        public void follow(int userid){
            followed.add(userid);
        }

        public void unfollow(int userId){
            if (userId != this.id){
                followed.remove(userId);
            }
        }

        public void post(int tweetId){
            Tweet tweet = new Tweet(tweetId,timestamp,null);
            timestamp++;
            // 将新建的推文插入链表头
            // 越靠前的推文 time 值越大
            tweet.next = head;
            head = tweet;
        }
    }

    /** Initialize your data structure here. */
    public Leet355() {

    }

    private HashMap<Integer, User> userMap = new HashMap<Integer, User> ();


    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // 若 userId 不存在，则新建
        if (!userMap.containsKey(userId))
            userMap.put(userId,new User(userId));
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     * */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        //关注用户列表ID
        Set<Integer> users = userMap.get(userId).followed;
        // 自动通过 time 属性从大到小排序
        PriorityQueue<Tweet> pq = new PriorityQueue<> (users.size(),(a,b)->(b.time-a.time));
        for(int id:users){
            Tweet twt  = userMap.get(id).head;
            if (twt == null){
                continue;
            }
            pq.add(twt);
        }
        while(!pq.isEmpty()){
            if (res.size() == 10) break;
            // 弹出 time 值最大的（最近发表的）
            Tweet tw = pq.poll();
            res.add(tw.id);
            // 将下一篇 Tweet 插入进行排序
            if (tw.next != null)
                pq.add(tw.next);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)){
            User user = new User(followerId);
            userMap.put(followerId,user);
        }
        if(!userMap.containsKey(followeeId)){
            User user = new User(followeeId);
            userMap.put(followeeId,user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)){
            User flwer = userMap.get(followerId);
            flwer.unfollow(followeeId);
        }
    }
}
