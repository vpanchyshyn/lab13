import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.task1.FacebookUser;
import ua.edu.ucu.apps.task1.FacebookUserAdapter;
import ua.edu.ucu.apps.task1.MessageSender;
import ua.edu.ucu.apps.task1.TwitterUser;
import ua.edu.ucu.apps.task1.TwitterUserAdapter;
import ua.edu.ucu.apps.task1.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;

public class TestTask1{

    @Test
    public void testFacebookUserAdapter() {
        FacebookUser facebookUser = new FacebookUser("facebook@email.com", "Ukraine", LocalDateTime.now().toString());
        User user = new FacebookUserAdapter(facebookUser);

        assertEquals("facebook@email.com", user.getMail());
        assertEquals("Ukraine", user.getCountry());
        assertEquals(facebookUser.getUserActiveTime(), user.getActiveTime());
        System.out.println("FacebookUserAdapter: " + user);
    }

    @Test
    public void testTwitterUserAdapter() {
        TwitterUser twitterUser = new TwitterUser("twitter@email.com", "USA", LocalDateTime.now().minusDays(1).toString());
        User user = new TwitterUserAdapter(twitterUser);

        assertEquals("twitter@email.com", user.getMail());
        assertEquals("USA", user.getCountry());
        assertEquals(twitterUser.getLastActiveTime(), user.getActiveTime());
        System.out.println("TwitterUserAdapter: " + user);
    }

    @Test
    public void testMessageSenderWithFacebookUser() {
        FacebookUser facebookUser = new FacebookUser("facebook@email.com", "Ukraine", LocalDateTime.now().toString());
        User user = new FacebookUserAdapter(facebookUser);
        MessageSender messageSender = new MessageSender();
        messageSender.send(user, "Hello Facebook user");
    }

    @Test
    public void testMessageSenderWithTwitterUser() {
        TwitterUser twitterUser = new TwitterUser("twitter@email.com", "USA", LocalDateTime.now().minusDays(1).toString());
        User user = new TwitterUserAdapter(twitterUser);
        MessageSender messageSender = new MessageSender();
        messageSender.send(user, "Hello Twitter user");
    }
}
