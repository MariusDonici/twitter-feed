package ro.uaic.twitter.service.listeners.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import ro.uaic.twitter.models.entities.TweetEntity;
import ro.uaic.twitter.service.listeners.TweetListener;
import ro.uaic.twitter.utils.TweetMapper;
import twitter4j.Status;


/**
 * Should send to websockets the tweets
 *
 */
@Component
public class UserTweetListener implements TweetListener {

    private TweetMapper tweetMapper;
    private SimpMessageSendingOperations messagingTemplate;

    @Autowired
    public UserTweetListener(TweetMapper tweetMapper, SimpMessageSendingOperations messagingTemplate) {
        this.tweetMapper = tweetMapper;
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void onStatus(Status status) {
        System.out.println("USER LISTENER");

        TweetEntity tweetEntity = tweetMapper.statusToTweet.apply(status);

        messagingTemplate.convertAndSend("/topic/feed", tweetEntity);

    }
}
