package com.self.learn.tdd;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Tests using TestNG
 */
public class FriendshipsNgTest {

    private Friendships friendships;

    @BeforeMethod
    public void before() {
        friendships = new Friendships();
        friendships.makeFriends("Chandan", "Yeshwanth");
        friendships.makeFriends("Chandan", "Mayur");
        friendships.makeFriends("Chandan", "Virendra");
        friendships.makeFriends("Chandan", "Deepak");
        friendships.makeFriends("Chandan", "Vijay");
    }

    @Test
    public void sagarDoesNotFriends() {
        Assert.assertTrue(friendships.getFriendList("Sagar").isEmpty(), "Sagar does not have friends.");
    }

    @Test
    public void chandanHas5Friends() {
        Assert.assertEquals(friendships.getFriendList("Chandan").size(), 5, "Chandan has 5 friends.");
    }

    @Test
    public void chandanIsFriendWithEveryone() {
        List<String> friendsOfChandan = Arrays.asList("Yeshwanth", "Mayur", "Virendra", "Deepak", "Vijay");

        Assert.assertTrue(friendships.getFriendList("Chandan").containsAll(friendsOfChandan));
    }

}