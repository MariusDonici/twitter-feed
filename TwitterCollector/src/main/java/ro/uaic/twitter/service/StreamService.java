package ro.uaic.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.uaic.twitter.configuration.twitter.TwitterConfiguration;
import ro.uaic.twitter.repositories.TweetRepository;
import ro.uaic.twitter.service.listeners.impl.ApplicationTweetListener;
import ro.uaic.twitter.service.listeners.impl.UserTweetListener;
import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.UserStreamAdapter;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class StreamService {

    private TwitterStream dataMiningStream;
    private TwitterStream userStream;

    private UserStreamAdapter

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private ApplicationTweetListener applicationTweetListener;

    @Autowired
    private UserTweetListener userTweetListener;

    public StreamService() {

        dataMiningStream = new TwitterStreamFactory(getConfiguration("app")).getInstance();
        userStream = new TwitterStreamFactory(getConfiguration("user")).getInstance();
    }

    private Configuration getConfiguration(String config) {
        TwitterConfiguration configuration = new TwitterConfiguration(config);

        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();

        configurationBuilder.setOAuthConsumerKey(configuration.getConsumerKey())
                .setOAuthConsumerSecret(configuration.getConsumerSecret())
                .setOAuthAccessToken(configuration.getAccessKey())
                .setOAuthAccessTokenSecret(configuration.getAccessSecret());

        return configurationBuilder.build();
    }


    @PostConstruct
    private void startMiningForData() {
        dataMiningStream.addListener(applicationTweetListener);
        double[][] boundingBox = {{-180, -90}, {180, 90}};
        FilterQuery filterQuery = new FilterQuery();
        filterQuery.locations(boundingBox);

        dataMiningStream.filter(filterQuery);
    }

    @PreDestroy
    private void stopStreams() {
        dataMiningStream.shutdown();
        userStream.shutdown();
    }


    public void collectTweets() {
        double[][] boundingBox = {{-180, -90}, {180, 90}};
        FilterQuery filterQuery = new FilterQuery();
        filterQuery.track("Donald trump");
        filterQuery.language("en");

        userStream.addListener(userTweetListener);
        userStream.filter(filterQuery);
    }


}
