package dev.jonclarke.rssaggregator.feedloader;

/**
 * Factory class to create an RSSReader object
 * To Implement:
 * RSSReader rss = RSSReaderFactory.create();
 * Feed f = rss.readFeed(reader);
 * System.out.println("Feed Title: " + f.getTitle());
 */
public class RSSReaderFactory {
    /**
     * Create a new RSSReader object
     * @return RSSReader object
     */
    public static RSSReader create() {
        // currently only have one implementation
        return new RSSReaderRomeImpl();
    }
}
