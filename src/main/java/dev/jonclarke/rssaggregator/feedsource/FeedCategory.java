//package dev.jonclarke.rssaggregator.feedsource;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//
//@Entity
//public class FeedCategory {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String domain;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "feedSource_id")
//    @JsonBackReference
//    private FeedSource feedSource;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public FeedCategory() {
//    }
//
//    public static FeedCategory create(String name, String domain, FeedSource parent) {
//        FeedCategory category = new FeedCategory();
//        category.setName(name);
//        category.setDomain(domain);
//        category.setFeedSource(parent);
//        return category;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDomain() {
//        return domain;
//    }
//
//    public void setDomain(String domain) {
//        this.domain = domain;
//    }
//
//    public FeedSource getFeedSource() {
//        return feedSource;
//    }
//
//    public void setFeedSource(FeedSource feedSource) {
//        this.feedSource = feedSource;
//    }
//
//}
