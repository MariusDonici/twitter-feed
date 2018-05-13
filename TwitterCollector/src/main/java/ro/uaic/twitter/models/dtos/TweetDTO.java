package ro.uaic.twitter.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import twitter4j.GeoLocation;
import twitter4j.Place;
import twitter4j.User;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TweetDTO {

    private String id;
    private Date createdAt;
    private User user;
    private GeoLocation geoLocation;
    private String language;
    private Place place;
    private long quotedTweetId;
    private Integer retweetsCount;
    private Integer favoriteCount;
    private String source;
    private String tweetText;
    private String[] listOfCountrieWitheld;
    private Boolean isRetweet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public long getQuotedTweetId() {
        return quotedTweetId;
    }

    public void setQuotedTweetId(long quotedTweetId) {
        this.quotedTweetId = quotedTweetId;
    }

    public Integer getRetweetsCount() {
        return retweetsCount;
    }

    public void setRetweetsCount(Integer retweetsCount) {
        this.retweetsCount = retweetsCount;
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public String[] getListOfCountrieWitheld() {
        return listOfCountrieWitheld;
    }

    public void setListOfCountrieWitheld(String[] listOfCountrieWitheld) {
        this.listOfCountrieWitheld = listOfCountrieWitheld;
    }

    public Boolean getRetweet() {
        return isRetweet;
    }

    public void setIsRetweet(Boolean retweet) {
        isRetweet = retweet;
    }
}
