package dev.jonclarke.rssaggregator.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class FeedCloud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String domain;
    private String path;
    private Integer port;
    private String protocol;
    private String registerProcedure;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    @JsonBackReference
    private Feed feed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRegisterProcedure() {
        return registerProcedure;
    }

    public void setRegisterProcedure(String registerProcedure) {
        this.registerProcedure = registerProcedure;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedCloud feedCloud = (FeedCloud) o;
        return Objects.equals(id, feedCloud.id) && Objects.equals(domain, feedCloud.domain) && Objects.equals(path, feedCloud.path) && Objects.equals(port, feedCloud.port) && Objects.equals(protocol, feedCloud.protocol) && Objects.equals(registerProcedure, feedCloud.registerProcedure) && Objects.equals(feed, feedCloud.feed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, domain, path, port, protocol, registerProcedure, feed);
    }

}
