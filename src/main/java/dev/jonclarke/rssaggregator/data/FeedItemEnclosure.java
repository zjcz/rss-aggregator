package dev.jonclarke.rssaggregator.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class FeedItemEnclosure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private Long length;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedItem_id")
    @JsonBackReference
    private FeedItem feedItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(final Long length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public FeedItem getFeedItem() {
        return feedItem;
    }

    public void setFeedItem(FeedItem feedItem) {
        this.feedItem = feedItem;
    }
}
