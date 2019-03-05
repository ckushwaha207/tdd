package com.self.learn.tdd;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

@RunWith(EasyMockRunner.class)
public class FriendshipsMongoEasyMockTest {
    @TestSubject
    FriendshipsMongo friendships = new FriendshipsMongo();

    @Mock(type = MockType.NICE)
    FriendCollection friends;

    @Test
    public void mockingWorksAsExpected() {
        Person chandan = new Person("Chandan");
        expect(friends.findByName("Chandan")).andReturn(chandan);
        replay(friends);
        assertThat(friends.findByName("Chandan")).isEqualTo(chandan);
    }

    @Test
    public void sagarHasNoFriends() {
        assertThat(friendships.getFriendList("Sagar")).isEmpty();
    }

    @Test
    public void chandanHas5Friends() {
        List<String> friendsOfChandan = Arrays.asList("Yeshwanth", "Mayur", "Virendra", "Deepak", "Vijay");
        Person chandan = createMock(Person.class);

        expect(friends.findByName("Chandan")).andReturn(chandan);
        expect(chandan.getFriends()).andReturn(friendsOfChandan);
        replay(friends);
        replay(chandan);

        assertThat(friendships.getFriendList("Chandan"))
                .hasSize(5)
                .containsOnly("Yeshwanth", "Mayur", "Virendra", "Deepak", "Vijay");
    }
}