package dev.jonclarke.rssaggregator.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class FeedCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String domain;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    @JsonBackReference
    private Feed feed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedItem_id")
    @JsonBackReference
    private FeedItem feedItem;

    public FeedCategory() {
    }

    public static FeedCategory create(String name, String domain, Feed parent) {
        FeedCategory category = new FeedCategory();
        category.setName(name);
        category.setDomain(domain);
        category.setFeed(parent);
        return category;
    }

    public static FeedCategory create(String name, String domain, FeedItem parent) {
        FeedCategory category = new FeedCategory();
        category.setName(name);
        category.setDomain(domain);
        category.setFeedItem(parent);
        return category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(final String domain) {
        this.domain = domain;
    }
    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public FeedItem getFeedItem() {
        return feedItem;
    }

    public void setFeedItem(FeedItem feedItem) {
        this.feedItem = feedItem;
    }
}
