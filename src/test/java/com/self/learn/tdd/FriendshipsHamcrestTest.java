package com.self.learn.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Tests using Hamcrest
 */
public class FriendshipsHamcrestTest {
    private Friendships friendships;

    @Before
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
        assertThat(friendships.getFriendList("Sagar"), empty());
    }

    @Test
    public void chandanHas5Friends() {
        assertThat(friendships.getFriendList("Chandan"), hasSize(5));
    }

    @Test
    public void chandanIsFriendWithEveryone() {
        assertThat(friendships.getFriendList("Chandan"), containsInAnyOrder("Vijay", "Yeshwanth", "Mayur", "Virendra", "Deepak"));
    }
}
