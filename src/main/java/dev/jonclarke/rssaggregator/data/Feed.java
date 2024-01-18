package dev.jonclarke.rssaggregator.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private FeedType feedType;
    private String description;
    private String link;
    private String title;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<FeedCategory> category = new ArrayList<>();

    @OneToOne(mappedBy = "feed", cascade = CascadeType.ALL)
    @JsonManagedReference
    private FeedCloud cloud;
    private String copyright;
    private String docs;
    private String generator;

    @OneToOne(mappedBy = "feed", cascade = CascadeType.ALL)
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

    @OneToMany(mappedBy = "parentFeed", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<FeedItem> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feed feed = (Feed) o;
        return Objects.equals(id, feed.id) && feedType == feed.feedType && Objects.equals(description, feed.description) && Objects.equals(link, feed.link) && Objects.equals(title, feed.title) && Objects.equals(category, feed.category) && Objects.equals(cloud, feed.cloud) && Objects.equals(copyright, feed.copyright) && Objects.equals(docs, feed.docs) && Objects.equals(generator, feed.generator) && Objects.equals(image, feed.image) && Objects.equals(language, feed.language) && Objects.equals(lastBuildDate, feed.lastBuildDate) && Objects.equals(managingEditor, feed.managingEditor) && Objects.equals(pubDate, feed.pubDate) && Objects.equals(rating, feed.rating) && Objects.equals(skipDays, feed.skipDays) && Objects.equals(skipHours, feed.skipHours) && Objects.equals(ttl, feed.ttl) && Objects.equals(webMaster, feed.webMaster) && Objects.equals(items, feed.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, feedType, description, link, title, category, cloud, copyright, docs, generator, image, language, lastBuildDate, managingEditor, pubDate, rating, skipDays, skipHours, ttl, webMaster, items);
    }

    @Override
    public String toString() {
        return "Feed{" +
                "id=" + id +
                ", feedType=" + feedType +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", cloud=" + cloud +
                ", copyright='" + copyright + '\'' +
                ", docs='" + docs + '\'' +
                ", generator='" + generator + '\'' +
                ", image=" + image +
                ", language='" + language + '\'' +
                ", lastBuildDate=" + lastBuildDate +
                ", managingEditor='" + managingEditor + '\'' +
                ", pubDate=" + pubDate +
                ", rating='" + rating + '\'' +
                ", skipDays=" + skipDays +
                ", skipHours=" + skipHours +
                ", ttl=" + ttl +
                ", webMaster='" + webMaster + '\'' +
                ", items=" + items +
                '}';
    }
}
