package dev.jonclarke.rssaggregator.feedloader;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FeedItem {
    private String author;
    private List<FeedCategory> category;
    private String comments;
    private String description;
    private List<FeedItemEnclosure> enclosures;
    private String guid;
    private String link;
    private Timestamp pubDate;
    private Timestamp updatedDate;
    private FeedItemSource source;
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public List<FeedCategory> getCategories() {
        if (category == null) {
            category = new ArrayList<>();
        }

        return category;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(final String comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public List<FeedItemEnclosure> getEnclosures() {
        if (enclosures == null) {
            enclosures = new ArrayList<>();
        }

        return enclosures;
    }


    public String getGuid() {
        return guid;
    }

    public void setGuid(final String guid) {
        this.guid = guid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public Timestamp getPubDate() {
        return pubDate;
    }

    public void setPubDate(final Timestamp pubDate) {
        this.pubDate = pubDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(final Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public FeedItemSource getSource() {
        return source;
    }

    public void setSource(final FeedItemSource source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
