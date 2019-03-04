package com.self.learn.tdd;

import java.util.*;

public class Friendships {
    private Map<String, List<String>> friendships = new HashMap<>();

    public List<String> getFriendList(String person) {
        if (!friendships.containsKey(person)) {
            return Collections.emptyList();
        }

        return friendships.get(person);
    }

    public boolean areFriends(String person1, String person2) {
        return friendships.containsKey(person1)
                && friendships.get(person1).contains(person2);
    }

    public void makeFriends(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }

    private void addFriend(String person, String friend) {
        if (!friendships.containsKey(person)) {
            friendships.put(person, new ArrayList<>());
        }

        List<String> friends = friendships.get(person);
        if (!friends.contains(friend)) {
            friends.add(friend);
        }
    }
}
