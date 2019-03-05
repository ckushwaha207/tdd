package com.self.learn.tdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FriendshipsMongoMockitoTest {

    @InjectMocks
    FriendshipsMongo friendships;

    @Mock
    FriendCollection friends;

    @Test
    public void mockingWorksAsExpected() {
        Person chandan = new Person("Chandan");
        Mockito.doReturn(chandan).when(friends).findByName("Chandan");
        assertThat(friends.findByName("Chandan")).isEqualTo(chandan);
    }

    @Test
    public void sagarHasNoFriends() {
        assertThat(friendships.getFriendList("Sagar")).isEmpty();
    }

    public void chandanHas5Friends() {
        List<String> friendsOfChandan = Arrays.asList("Yeshwanth", "Mayur", "Virendra", "Deepak", "Vijay");
        Person chandan = Mockito.spy(new Person("Chandan"));

        Mockito.doReturn(chandan).when(friends.findByName("Chandan"));
        Mockito.doReturn(friendsOfChandan).when(chandan.getFriends());

        assertThat(friendships.getFriendList("Chandan"))
                .hasSize(5)
                .containsOnly("Yeshwanth", "Mayur", "Virendra", "Deepak", "Vijay");

    }
}