package dev.jonclarke.rssaggregator.feedloader;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test the feed loader with an RSS v2.0 feed
 */
public class FeedLoaderRSS20Test extends FeedLoaderTest {
    private final String TEST_FEED_FILENAME = "rss20.xml";

    /**
     * Test the loader can convert the xml feed into Feed objects
     * Requires mocking the underlying repository
     */
    @Test
    public void importRss20validFile_validateFeed() throws IOException {
        RSSReader rss = RSSReaderFactory.create();
        Feed feed = rss.readFeed(getFeedReader(TEST_FEED_FILENAME));
        assertEquals(FeedType.RSS, feed.getFeedType());
        assertEquals("RSS Feed Description", feed.getDescription());
        assertEquals("http://www.example.com", feed.getLink());
        assertEquals("RSS Feed Title", feed.getTitle());
        assertEquals("RSS Feed Copyright", feed.getCopyright());
        assertEquals("https://www.rssboard.org/rss-specification", feed.getDocs());
        assertEquals("RSS Feed Generator", feed.getGenerator());
        assertEquals("RSS Feed Language", feed.getLanguage());
        assertEquals(getTimestamp("Wed, 06 Sep 2023 14:35:08 GMT"), feed.getLastBuildDate());
        assertEquals(getTimestamp("Wed, 06 Sep 2023 14:35:08 GMT"), feed.getPubDate());
        assertEquals("RSS Feed Managing Editor", feed.getManagingEditor());
        assertEquals("RSS Feed Rating", feed.getRating());
        assertEquals(100, feed.getTtl());
        assertEquals("RSS Feed WebMaster", feed.getWebMaster());
    }

    @Test
    public void importRss20validFile_validateFeedCategory() throws IOException {
        RSSReader rss = RSSReaderFactory.create();
        Feed feed = rss.readFeed(getFeedReader(TEST_FEED_FILENAME));
        List<FeedCategory> categories = feed.getCategory();
        assertEquals(2, categories.size());
        assertEquals("Category 1", categories.get(0).getName());
        assertEquals("Category 1 Domain", categories.get(0).getDomain());
        assertEquals("Category 2", categories.get(1).getName());
        assertEquals("Category 2 Domain", categories.get(1).getDomain());
    }

    @Test
    public void importRss20validFile_validateFeedCloud() throws IOException {
        RSSReader rss = RSSReaderFactory.create();
        Feed feed = rss.readFeed(getFeedReader(TEST_FEED_FILENAME));
        FeedCloud cloud = feed.getCloud();
        assertEquals("http://www.example.com", cloud.getDomain());
        assertEquals(123, cloud.getPort());
        assertEquals("/path", cloud.getPath());
        assertEquals("RSS Feed Cloud Protocol", cloud.getProtocol());
        assertEquals("RSS Feed Cloud Register Procedure", cloud.getRegisterProcedure());
    }

    @Test
    public void importRss20validFile_validateFeedImage() throws IOException {
        RSSReader rss = RSSReaderFactory.create();
        Feed feed = rss.readFeed(getFeedReader(TEST_FEED_FILENAME));
        FeedImage image = feed.getImage();
        assertEquals("http://www.example.com/image", image.getLink());
        assertEquals("RSS Feed Image Title", image.getTitle());
        assertEquals("http://www.example.com/image/url", image.getUrl());
        assertEquals(100, image.getHeight());
        assertEquals(200, image.getWidth());
        assertEquals("RSS Feed Image Description", image.getDescription());
    }

    @Test
    public void importRss20validFile_validateSkipDays() throws IOException {
        RSSReader rss = RSSReaderFactory.create();
        Feed feed = rss.readFeed(getFeedReader(TEST_FEED_FILENAME));
        List<String> skipDays = feed.getSkipDays();
        assertEquals(2, skipDays.size());
        assertEquals(DayOfWeek.MONDAY.toString().toLowerCase(), skipDays.get(0));
        assertEquals(DayOfWeek.FRIDAY.toString().toLowerCase(), skipDays.get(1));
    }

    @Test
    public void importRss20validFile_validateSkipHours() throws IOException {
        RSSReader rss = RSSReaderFactory.create();
        Feed feed = rss.readFeed(getFeedReader(TEST_FEED_FILENAME));
        List<Integer> skipHours = feed.getSkipHours();
        assertEquals(2, skipHours.size());
        assertEquals(1, skipHours.get(0));
        assertEquals(23, skipHours.get(1));
    }

    @Test
    public void importRss20validFile_validateFeedItems() throws IOException {
        RSSReader rss = RSSReaderFactory.create();
        Feed feed = rss.readFeed(getFeedReader(TEST_FEED_FILENAME));
        List<FeedItem> items = feed.getItems();

        ////////////////////////////////////
        // Validate item 1
        ////////////////////////////////////
        assertEquals(2, items.size());
        FeedItem item = items.get(0);
        assertEquals("RSS Feed Item 1 Author", item.getAuthor());
        assertEquals("http://www.example.com/newsitem1/comments", item.getComments());
        assertEquals("RSS Feed Item 1 Description", item.getDescription());
        assertEquals("http://www.example.com/newsitem1guid", item.getGuid());
        assertEquals("http://www.example.com/newsitem1", item.getLink());
        assertEquals(getTimestamp("Wed, 06 Sep 2023 14:35:08 GMT"), item.getPubDate());
        assertNull(item.getUpdatedDate()); // expect to be null for rss 2.0
        assertEquals("RSS Feed Item 1 Title", item.getTitle());

        FeedItemSource source = item.getSource();
        assertEquals("http://www.example.com/newsitem1source", source.getUri());
        assertEquals("http://www.example.com/newsitem1source", source.getLink());
        assertEquals("RSS Feed Item 1 Source", source.getTitle());

        List<FeedCategory> categories = item.getCategories();
        assertEquals(2, categories.size());
        assertEquals("RSS Feed Item 1 Category 1", categories.get(0).getName());
        assertEquals("RSS Feed Item 1 Category 1 Domain", categories.get(0).getDomain());
        assertEquals("RSS Feed Item 1 Category 2", categories.get(1).getName());
        assertEquals("RSS Feed Item 1 Category 2 Domain", categories.get(1).getDomain());

        ////////////////////////////////////
        // Validate item 2
        ////////////////////////////////////
        item = items.get(1);
        assertEquals("RSS Feed Item 2 Author", item.getAuthor());
        assertEquals("http://www.example.com/newsitem2/comments", item.getComments());
        assertEquals("RSS Feed Item 2 Description", item.getDescription());
        assertEquals("http://www.example.com/newsitem2guid", item.getGuid());
        assertEquals("http://www.example.com/newsitem2", item.getLink());
        assertEquals(getTimestamp("Wed, 06 Sep 2023 14:35:08 GMT"), item.getPubDate());
        assertNull(item.getUpdatedDate()); // expect to be null for rss 2.0
        assertEquals("RSS Feed Item 2 Title", item.getTitle());

        source = item.getSource();
        assertEquals("http://www.example.com/newsitem2source", source.getUri());
        assertEquals("http://www.example.com/newsitem2source", source.getLink());
        assertEquals("RSS Feed Item 2 Source", source.getTitle());

        categories = item.getCategories();
        assertEquals(2, categories.size());
        assertEquals("RSS Feed Item 2 Category 1", categories.get(0).getName());
        assertEquals("RSS Feed Item 2 Category 1 Domain", categories.get(0).getDomain());
        assertEquals("RSS Feed Item 2 Category 2", categories.get(1).getName());
        assertEquals("RSS Feed Item 2 Category 2 Domain", categories.get(1).getDomain());
    }

    @Test
    public void importRss20validFile_validateFeedItemCategories() throws IOException {
        RSSReader rss = RSSReaderFactory.create();
        Feed feed = rss.readFeed(getFeedReader(TEST_FEED_FILENAME));
        List<FeedItem> items = feed.getItems();

        ////////////////////////////////////
        // Validate item 1
        ////////////////////////////////////
        List<FeedCategory> categories = items.get(0).getCategories();
        assertEquals(2, categories.size());
        assertEquals("RSS Feed Item 1 Category 1", categories.get(0).getName());
        assertEquals("RSS Feed Item 1 Category 1 Domain", categories.get(0).getDomain());
        assertEquals("RSS Feed Item 1 Category 2", categories.get(1).getName());
        assertEquals("RSS Feed Item 1 Category 2 Domain", categories.get(1).getDomain());

        ////////////////////////////////////
        // Validate item 2
        ////////////////////////////////////
        categories = items.get(1).getCategories();
        assertEquals(2, categories.size());
        assertEquals("RSS Feed Item 2 Category 1", categories.get(0).getName());
        assertEquals("RSS Feed Item 2 Category 1 Domain", categories.get(0).getDomain());
        assertEquals("RSS Feed Item 2 Category 2", categories.get(1).getName());
        assertEquals("RSS Feed Item 2 Category 2 Domain", categories.get(1).getDomain());
    }

    @Test
    public void importRss20validFile_validateFeedItemEnclosures() throws IOException {
        RSSReader rss = RSSReaderFactory.create();
        Feed feed = rss.readFeed(getFeedReader(TEST_FEED_FILENAME));
        List<FeedItem> items = feed.getItems();

        ////////////////////////////////////
        // Validate item 1
        ////////////////////////////////////
        List<FeedItemEnclosure> enclosures = items.get(0).getEnclosures();
        assertEquals(2, enclosures.size());
        assertEquals(100, enclosures.get(0).getLength());
        assertEquals("audio/mpeg", enclosures.get(0).getType());
        assertEquals("http://www.example.com/newsitem1/audio1.mp3", enclosures.get(0).getUrl());
        assertEquals(100, enclosures.get(1).getLength());
        assertEquals("audio/mpeg", enclosures.get(1).getType());
        assertEquals("http://www.example.com/newsitem1/audio2.mp3", enclosures.get(1).getUrl());

        ////////////////////////////////////
        // Validate item 2
        ////////////////////////////////////
        enclosures = items.get(1).getEnclosures();
        assertEquals(2, enclosures.size());
        assertEquals(100, enclosures.get(0).getLength());
        assertEquals("audio/mpeg", enclosures.get(0).getType());
        assertEquals("http://www.example.com/newsitem2/audio1.mp3", enclosures.get(0).getUrl());
        assertEquals(100, enclosures.get(1).getLength());
        assertEquals("audio/mpeg", enclosures.get(1).getType());
        assertEquals("http://www.example.com/newsitem2/audio2.mp3", enclosures.get(1).getUrl());
    }
}
