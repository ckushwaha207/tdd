package com.self.learn.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests using AssertJ
 */
public class FriendshipsAssertJTest {

    private Friendships friendships;

    @Before
    public void setUp() {
        friendships = new Friendships();
        friendships.makeFriends("Chandan", "Yeshwanth");
        friendships.makeFriends("Chandan", "Mayur");
        friendships.makeFriends("Chandan", "Virendra");
        friendships.makeFriends("Chandan", "Deepak");
        friendships.makeFriends("Chandan", "Vijay");
    }

    @Test
    public void sagarDoesNotFriends() {
        assertThat(friendships.getFriendList("Sagar")).isEmpty();
    }

    @Test
    public void chandanHas5Friends() {
        assertThat(friendships.getFriendList("Chandan"))
                .hasSize(5)
                .containsOnly("Vijay", "Yeshwanth", "Mayur", "Virendra", "Deepak");
    }
}