package com.self.learn.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Tests using JUnit
 */
public class FriendshipsJunitTest {

    private Friendships friendships;

    @Before
    public void setup() {
        friendships = new Friendships();
        friendships.makeFriends("Chandan", "Yeshwanth");
        friendships.makeFriends("Chandan", "Mayur");
        friendships.makeFriends("Chandan", "Virendra");
        friendships.makeFriends("Chandan", "Deepak");
        friendships.makeFriends("Chandan", "Vijay");
    }

    @Test
    public void sagarDoesNotFriends() {
        Assert.assertTrue("Sagar does not have friends.", friendships.getFriendList("Sagar").isEmpty());
    }

    @Test
    public void chandanHas5Friends() {
        Assert.assertEquals("Chandan has 5 friends.", 5, friendships.getFriendList("Chandan").size());
    }

    @Test
    public void chandanIsFriendWithEveryone() {
        List<String> friendsOfChandan = Arrays.asList("Yeshwanth", "Mayur", "Virendra", "Deepak", "Vijay");
        Assert.assertTrue(friendships.getFriendList("Chandan").containsAll(friendsOfChandan));
    }
}