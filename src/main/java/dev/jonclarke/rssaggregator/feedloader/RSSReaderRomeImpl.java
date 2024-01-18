package dev.jonclarke.rssaggregator.feedloader;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.FeedException;
import dev.jonclarke.rssaggregator.data.*;

import java.io.Reader;
import java.sql.Timestamp;


/**
 * An RSS reader that uses the Rome library
 */
public class RSSReaderRomeImpl implements RSSReader {
    RSSReaderRomeImpl() {
    }

    /**
     * Import the feed from the given reader
     * @param feedReader Reader object containing the feed data.  Could be an input stream from a url or local file
     * @return Feed object containing the parsed feed data
     */
    @Override
    public Feed readFeed(Reader feedReader) {
        SyndFeed sf = null;
        Feed ret = null;

        try {
            sf = getFeed(feedReader);
        } catch (FeedException ex) {
            // TODO: Log error
        }

        if (sf != null) {
            ret = convertFeed(sf);
        }

        return ret;
    }

    /**
     * Load the feed from the given reader
     * @param feed Reader object containing the feed data.  Could be an input stream from a url or local file
     * @return Rome SyndFeed object
     * @throws FeedException If the feed cannot be parsed
     */
    private SyndFeed getFeed(final Reader feed) throws FeedException {
        SyndFeedInput input = new SyndFeedInput();
        input.setPreserveWireFeed(true);
        return input.build(feed);
    }

    /**
     * Convert the Rome SyndFeed object to our Feed object
     * @param feed Rome SyndFeed object
     * @return Feed object
     */
    private Feed convertFeed(SyndFeed feed) {
        Feed f = new Feed();
        f.setFeedType(feed.getFeedType().startsWith("rss") ? FeedType.RSS : FeedType.ATOM);
        f.setDescription(feed.getDescription());
        f.setLink(feed.getLink());
        f.setImage(convertFeedImage(feed.getImage()));
        f.setTitle(feed.getTitle());

        if (f.getCategory() != null) {
            feed.getCategories().forEach(e -> f.getCategory().add(convertFeedCategory(e)));
        }

        f.setCopyright(feed.getCopyright());
        f.setDocs(feed.getDocs());
        f.setGenerator(feed.getGenerator());
        f.setLanguage(feed.getLanguage());
        f.setManagingEditor(feed.getManagingEditor());
        if (feed.getPublishedDate() != null) {
            f.setPubDate(Timestamp.from(feed.getPublishedDate().toInstant()));
        }

        f.setWebMaster(feed.getWebMaster());

        if (feed.getEntries() != null) {
            feed.getEntries().forEach(e -> f.getItems().add(convertFeedItem(e)));
        }

        if (feed.originalWireFeed() instanceof Channel c) {
            f.setTtl(c.getTtl());

            if (c.getCloud() != null) {
                f.setCloud(convertFeedCloud(c.getCloud()));
            }

            f.setRating(c.getRating());
            f.setSkipDays(c.getSkipDays());
            f.setSkipHours(c.getSkipHours());

            if (c.getLastBuildDate() != null) {
                f.setLastBuildDate(Timestamp.from(c.getLastBuildDate().toInstant()));
            }
        }

        return f;
    }

    private FeedCategory convertFeedCategory(final SyndCategory category) {
        FeedCategory c = new FeedCategory();
        c.setDomain(category.getTaxonomyUri());
        c.setName(category.getName());
        return c;
    }

    private FeedCloud convertFeedCloud(final com.rometools.rome.feed.rss.Cloud cloud) {
        FeedCloud c = new FeedCloud();
        c.setDomain(cloud.getDomain());
        c.setPath(cloud.getPath());
        c.setPort(cloud.getPort());
        c.setProtocol(cloud.getProtocol());
        c.setRegisterProcedure(cloud.getRegisterProcedure());
        return c;
    }

    private FeedImage convertFeedImage(final SyndImage image) {
        FeedImage i = new FeedImage();
        i.setLink(image.getLink());
        i.setTitle(image.getTitle());
        i.setUrl(image.getUrl());
        i.setDescription(image.getDescription());
        i.setHeight(image.getHeight());
        i.setWidth(image.getWidth());
        i.setLink(image.getLink());
        i.setUrl(image.getUrl());
        return i;
    }

    private FeedItem convertFeedItem(final SyndEntry item) {
        FeedItem i = new FeedItem();
        i.setAuthor(item.getAuthor());
        i.setComments(item.getComments());
        i.setDescription(item.getDescription().getValue());

        if (item.getCategories() != null) {
            item.getCategories().forEach(e -> i.getCategories().add(convertFeedCategory(e)));
        }

        i.setLink(item.getLink());

        if (item.getPublishedDate() != null) {
            i.setPubDate(Timestamp.from(item.getPublishedDate().toInstant()));
        }

        if (item.getEnclosures() != null) {
            item.getEnclosures().forEach(e -> i.getEnclosures().add(convertFeedItemEnclosure(e)));
        }

        i.setGuid(item.getUri());

        if (item.getSource() != null) {
            i.setSource(convertFeedItemSource(item.getSource()));
        }

        i.setTitle(item.getTitle());

        if (item.getUpdatedDate() != null) {
            i.setUpdatedDate(Timestamp.from(item.getUpdatedDate().toInstant()));
        }

        return i;
    }

    private FeedItemEnclosure convertFeedItemEnclosure(final SyndEnclosure enclosure) {
        FeedItemEnclosure e = new FeedItemEnclosure();
        e.setLength(enclosure.getLength());
        e.setType(enclosure.getType());
        e.setUrl(enclosure.getUrl());
        return e;
    }

    private FeedItemSource convertFeedItemSource(final SyndFeed feed) {
        FeedItemSource s = new FeedItemSource();
        s.setUrl(feed.getUri());
        s.setTitle(feed.getTitle());
        return s;
    }
}
