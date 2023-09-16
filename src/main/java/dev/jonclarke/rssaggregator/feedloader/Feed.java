package dev.jonclarke.rssaggregator.feedloader;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Feed {
    private FeedType feedType;
    private String description;
    private String link;
    private String title;
    private List<FeedCategory> category;
    private FeedCloud cloud;
    private String copyright;
    private String docs;
    private String generator;
    private FeedImage image;
    private String language;
    private Timestamp lastBuildDate;
    private String managingEditor;
    private Timestamp pubDate;
    private String rating;
    private List<String> skipDays;
    private List<Integer> skipHours;
    private Integer ttl;
    private String webMaster;
    private List<FeedItem> items;

    public FeedType getFeedType() {
        return feedType;
    }

    public void setFeedType(final FeedType feedType) {
        this.feedType = feedType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public List<FeedCategory> getCategory() {
        if (category == null) {
            category = new ArrayList<>();
        }
        return category;
    }

    public FeedCloud getCloud() {
        return cloud;
    }

    public void setCloud(final FeedCloud cloud) {
        this.cloud = cloud;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(final String copyright) {
        this.copyright = copyright;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(final String docs) {
        this.docs = docs;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(final String generator) {
        this.generator = generator;
    }

    public FeedImage getImage() {
        return image;
    }

    public void setImage(final FeedImage image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public Timestamp getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(final Timestamp lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getManagingEditor() {
        return managingEditor;
    }

    public void setManagingEditor(final String managingEditor) {
        this.managingEditor = managingEditor;
    }

    public Timestamp getPubDate() {
        return pubDate;
    }

    public void setPubDate(final Timestamp pubDate) {
        this.pubDate = pubDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(final String rating) {
        this.rating = rating;
    }

    public List<String> getSkipDays() {
        return skipDays;
    }

    public void setSkipDays(final List<String> skipDays) {
        this.skipDays = skipDays;
    }

    public List<Integer> getSkipHours() {
        return skipHours;
    }

    public void setSkipHours(final List<Integer> skipHours) {
        this.skipHours = skipHours;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(final Integer ttl) {
        this.ttl = ttl;
    }

    public String getWebMaster() {
        return webMaster;
    }

    public void setWebMaster(final String webMaster) {
        this.webMaster = webMaster;
    }

    public List<FeedItem> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }

        return items;
    }

}
