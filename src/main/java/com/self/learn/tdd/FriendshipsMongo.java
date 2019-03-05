package com.self.learn.tdd;

import java.util.Collections;
import java.util.List;

public class FriendshipsMongo {
    private FriendCollection friends;

    public FriendshipsMongo() {
        friends = new FriendCollection();
    }

    public List<String> getFriendList(String person) {
        Person p = friends.findByName(person);
        if (p == null) return Collections.emptyList();
        return p.getFriends();
    }

    public boolean areFriends(String person1, String person2) {
        Person p = friends.findByName(person1);
        return p != null && p.getFriends().contains(person2);
    }

    public void makeFriend(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }

    private void addFriend(String person, String friend) {
        Person p = friends.findByName(person);
        if (p == null) p = new Person(person);
        p.addFriend(friend);
        friends.save(p);
    }
}
