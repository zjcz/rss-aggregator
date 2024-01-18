//package dev.jonclarke.rssaggregator.feedsource;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import dev.jonclarke.rssaggregator.data.FeedItem;
//import dev.jonclarke.rssaggregator.data.FeedType;
//import jakarta.persistence.*;
//
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//public class FeedSource {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private FeedType feedType;
//    private String title;
//    private String description;
//    private String link;
//    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<FeedCategory> category = new ArrayList<>();
//    @OneToOne(mappedBy = "feed", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private FeedCloud cloud;
//    private String copyright;
//    private String docs;
//    private String generator;
//    private String imageLink;
//    private String imageTitle;
//    private String imageUrl;
//    private String imageDescription;
//    private Integer imageHeight;
//    private Integer imageWidth;
//    private String language;
//    private Timestamp lastBuildDate;
//    private String managingEditor;
//    private Timestamp publishedDate;
//    private String rating;
//    private List<String> skipDays = new ArrayList<>();
//    private List<Integer> skipHours = new ArrayList<>();
//    private Integer ttl;
//    private String webMaster;
//    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<FeedItem> items = new ArrayList<>();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public FeedType getFeedType() {
//        return feedType;
//    }
//
//    public void setFeedType(FeedType feedType) {
//        this.feedType = feedType;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getLink() {
//        return link;
//    }
//
//    public void setLink(String link) {
//        this.link = link;
//    }
//
//    public List<FeedCategory> getCategory() {
//        return category;
//    }
//
//    public FeedCloud getCloud() {
//        return cloud;
//    }
//
//    public void setCloud(FeedCloud cloud) {
//        this.cloud = cloud;
//    }
//
//    public String getCopyright() {
//        return copyright;
//    }
//
//    public void setCopyright(String copyright) {
//        this.copyright = copyright;
//    }
//
//    public String getDocs() {
//        return docs;
//    }
//
//    public void setDocs(String docs) {
//        this.docs = docs;
//    }
//
//    public String getGenerator() {
//        return generator;
//    }
//
//    public void setGenerator(String generator) {
//        this.generator = generator;
//    }
//
//    public String getImageLink() {
//        return imageLink;
//    }
//
//    public void setImageLink(String imageLink) {
//        this.imageLink = imageLink;
//    }
//
//    public String getImageTitle() {
//        return imageTitle;
//    }
//
//    public void setImageTitle(String imageTitle) {
//        this.imageTitle = imageTitle;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public String getImageDescription() {
//        return imageDescription;
//    }
//
//    public void setImageDescription(String imageDescription) {
//        this.imageDescription = imageDescription;
//    }
//
//    public Integer getImageHeight() {
//        return imageHeight;
//    }
//
//    public void setImageHeight(Integer imageHeight) {
//        this.imageHeight = imageHeight;
//    }
//
//    public Integer getImageWidth() {
//        return imageWidth;
//    }
//
//    public void setImageWidth(Integer imageWidth) {
//        this.imageWidth = imageWidth;
//    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//    public Timestamp getLastBuildDate() {
//        return lastBuildDate;
//    }
//
//    public void setLastBuildDate(Timestamp lastBuildDate) {
//        this.lastBuildDate = lastBuildDate;
//    }
//
//    public String getManagingEditor() {
//        return managingEditor;
//    }
//
//    public void setManagingEditor(String managingEditor) {
//        this.managingEditor = managingEditor;
//    }
//
//    public Timestamp getPublishedDate() {
//        return publishedDate;
//    }
//
//    public void setPublishedDate(Timestamp publishedDate) {
//        this.publishedDate = publishedDate;
//    }
//
//    public String getRating() {
//        return rating;
//    }
//
//    public void setRating(String rating) {
//        this.rating = rating;
//    }
//
//    public List<String> getSkipDays() {
//        return skipDays;
//    }
//
//    public void setSkipDays(List<String> skipDays) {
//        this.skipDays = skipDays;
//    }
//
//    public List<Integer> getSkipHours() {
//        return skipHours;
//    }
//
//    public void setSkipHours(List<Integer> skipHours) {
//        this.skipHours = skipHours;
//    }
//
//    public Integer getTtl() {
//        return ttl;
//    }
//
//    public void setTtl(Integer ttl) {
//        this.ttl = ttl;
//    }
//
//    public String getWebMaster() {
//        return webMaster;
//    }
//
//    public void setWebMaster(String webMaster) {
//        this.webMaster = webMaster;
//    }
//
//    public List<FeedItem> getItems() {
//        return items;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        FeedSource that = (FeedSource) o;
//        return Objects.equals(id, that.id) && feedType == that.feedType && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(link, that.link) && Objects.equals(category, that.category) && Objects.equals(cloud, that.cloud) && Objects.equals(copyright, that.copyright) && Objects.equals(docs, that.docs) && Objects.equals(generator, that.generator) && Objects.equals(imageLink, that.imageLink) && Objects.equals(imageTitle, that.imageTitle) && Objects.equals(imageUrl, that.imageUrl) && Objects.equals(imageDescription, that.imageDescription) && Objects.equals(imageHeight, that.imageHeight) && Objects.equals(imageWidth, that.imageWidth) && Objects.equals(language, that.language) && Objects.equals(lastBuildDate, that.lastBuildDate) && Objects.equals(managingEditor, that.managingEditor) && Objects.equals(publishedDate, that.publishedDate) && Objects.equals(rating, that.rating) && Objects.equals(skipDays, that.skipDays) && Objects.equals(skipHours, that.skipHours) && Objects.equals(ttl, that.ttl) && Objects.equals(webMaster, that.webMaster) && Objects.equals(items, that.items);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, feedType, title, description, link, category, cloud, copyright, docs, generator, imageLink, imageTitle, imageUrl, imageDescription, imageHeight, imageWidth, language, lastBuildDate, managingEditor, publishedDate, rating, skipDays, skipHours, ttl, webMaster, items);
//    }
//
//    @Override
//    public String toString() {
//        return "FeedSource{" +
//                "id=" + id +
//                ", feedType=" + feedType +
//                ", title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", link='" + link + '\'' +
//                ", category=" + category +
//                ", cloud=" + cloud +
//                ", copyright='" + copyright + '\'' +
//                ", docs='" + docs + '\'' +
//                ", generator='" + generator + '\'' +
//                ", imageLink='" + imageLink + '\'' +
//                ", imageTitle='" + imageTitle + '\'' +
//                ", imageUrl='" + imageUrl + '\'' +
//                ", imageDescription='" + imageDescription + '\'' +
//                ", imageHeight=" + imageHeight +
//                ", imageWidth=" + imageWidth +
//                ", language='" + language + '\'' +
//                ", lastBuildDate=" + lastBuildDate +
//                ", managingEditor='" + managingEditor + '\'' +
//                ", publishedDate=" + publishedDate +
//                ", rating='" + rating + '\'' +
//                ", skipDays=" + skipDays +
//                ", skipHours=" + skipHours +
//                ", ttl=" + ttl +
//                ", webMaster='" + webMaster + '\'' +
//                ", items=" + items +
//                '}';
//    }
//}
