package ro.uaic.twitter.service.listeners.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.uaic.twitter.models.entities.TweetEntity;
import ro.uaic.twitter.repositories.TweetRepository;
import ro.uaic.twitter.service.listeners.TweetListener;
import ro.uaic.twitter.utils.TweetMapper;
import twitter4j.Status;

/**
 * Should retrieve tweets and save them to the database
 */
@Service
public class ApplicationTweetListener implements TweetListener {

    private TweetRepository tweetRepository;
    private TweetMapper tweetMapper;

    @Autowired
    public ApplicationTweetListener(TweetRepository tweetRepository, TweetMapper tweetMapper) {
        this.tweetRepository = tweetRepository;
        this.tweetMapper = tweetMapper;
    }

    @Override
    public void onStatus(Status status) {
        System.out.println("APP LISTENER");

        TweetEntity tweetEntity = tweetMapper.statusToTweet.apply(status);

        tweetRepository.save(tweetEntity);
    }
}
