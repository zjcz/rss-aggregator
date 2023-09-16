package dev.jonclarke.rssaggregator.feedloader;

import java.io.Reader;

/**
 * Object to parse an RSS or Atom feed into an object.  Use the RSSReaderFactory to create an instance of this object.
 */
public interface RSSReader {
    /**
     * Import the feed from the given reader.
     * @param feedReader Reader object containing the feed data.  Could be an input stream from a url or local file
     * @return Feed object containing the parsed feed data
     */
    Feed readFeed(final Reader feedReader);
}
