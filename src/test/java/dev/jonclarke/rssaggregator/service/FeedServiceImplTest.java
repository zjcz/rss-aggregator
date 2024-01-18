package dev.jonclarke.rssaggregator.service;

import dev.jonclarke.rssaggregator.data.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FeedServiceImplTest {
    @InjectMocks
    FeedServiceImpl service;
    @Mock
    FeedRepository repo;

    @Test
    void testFindAll_RetrieveAll_ExpectValidResponse() {
        // Arrange
        ArrayList<Feed> expected = new ArrayList<>();
        expected.add(generateTestFeedObject(1L, "Test", "Test Description", "http://test.com"));
        expected.add(generateTestFeedObject(2L, "Test 2", "Test 2 Description", "http://test-two.com"));
        when(repo.findAll()).thenReturn(expected);

        // Act
        Iterable<Feed> actual = service.findAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testFindAll_RetrieveAllWhenEmpty_HandleEmptyDataSet() {
        // Arrange
        ArrayList<Feed> expected = new ArrayList<>();
        when(repo.findAll()).thenReturn(expected);

        // Act
        Iterable<Feed> actual = service.findAll();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testFindById_RetrieveWithValidId_ExpectValidResponse() {
        // Arrange
        Feed expected = generateTestFeedObject(1L, "Test", "Test Description", "http://test.com");
        when(repo.findById(1L)).thenReturn(Optional.of(expected));

        // Act
        Feed actual = service.findById(1L);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testFindById_RetrieveWithInvalidId_ExpectNull() {
        // Arrange
        when(repo.findById(1L)).thenReturn(Optional.empty());

        // Act
        Feed actual = service.findById(1L);

        // Assert
        assertNull(actual);
    }

    @Test
    void testSave_SaveAllFields_ExpectMatch() {
        // Arrange
        Feed expected = generateTestFeedObject(1L, "Test", "Test Description", "http://test.com");
        when(repo.save(any(Feed.class))).thenReturn(expected);

        // Act
        Feed actual = service.save(expected);

        // Assert
        assertEquals(expected, actual);
    }

    private Feed generateTestFeedObject(long id, String title, String description, String url) {
        Feed f = new Feed();
        f.setId(id);
        f.setFeedType(FeedType.RSS);
        f.setDescription(description);
        f.setLink(url);
        f.setImage(new FeedImage() {{
            setLink("http://www.example.com/image");
            setTitle("RSS Feed Image Title");
            setUrl("http://www.example.com/image/url");
            setDescription("RSS Feed Image Description");
            setHeight(100);
            setWidth(100);
        }});
        f.setTitle(title);

        f.getCategory().add(new FeedCategory() {{
            setDomain("Category 1 Domain");
            setName("Category 1");
        }});
        f.getCategory().add(new FeedCategory() {{
            setDomain("Category 2 Domain");
            setName("Category 2");
        }});

        f.setCopyright("RSS Feed Copyright");
        f.setDocs("https://www.rssboard.org/rss-specification");
        f.setGenerator("RSS Feed Generator");
        f.setLanguage("RSS Feed Language");
        f.setManagingEditor("RSS Feed Managing Editor");
        f.setPubDate(getTimestamp("Wed, 06 Sep 2023 14:35:08 GMT"));
        f.setWebMaster("RSS Feed Web Master");

        f.getItems().add(new FeedItem() {{
            setAuthor("RSS Feed Item 1 Author");
            getCategories().add(new FeedCategory() {{
                setDomain("RSS Feed Item 1 Category 1 Domain");
                setName("RSS Feed Item 1 Category 1");
            }});
            getCategories().add(new FeedCategory() {{
                setDomain("RSS Feed Item 1 Category 2 Domain");
                setName("RSS Feed Item 1 Category 2");
            }});

            setComments("RSS Feed Item Comments");
            setDescription("RSS Feed Item Description");
            getEnclosures().add(new FeedItemEnclosure() {{
                setLength(100L);
                setType("audio/mpeg");
                setUrl("http://www.example.com/newsitem1/audio1.mp3");
            }});
            getEnclosures().add(new FeedItemEnclosure() {{
                setLength(100L);
                setType("audio/mpeg");
                setUrl("http://www.example.com/newsitem1/audio2.mp3");
            }});
            setGuid("http://www.example.com/newsitem1guid");
            setLink("http://www.example.com/item/link");
            setPubDate(getTimestamp("Wed, 06 Sep 2023 14:35:08 GMT"));
            setSource(new FeedItemSource() {{
                setUrl("http://www.example.com/item/source/url");
                setTitle("RSS Feed Item 1 Source");
            }});
            setTitle("RSS Feed Item 1 Title");
        }});

        f.setTtl(100);
        f.setCloud(new FeedCloud() {{
            setDomain("http://www.example.com");
            setPath("/path");
            setPort(123);
            setProtocol("RSS Feed Cloud Protocol");
            setRegisterProcedure("RSS Feed Cloud Register Procedure");
        }});

        f.setRating("RSS Feed Rating");
        f.setSkipDays(List.of("Monday", "Friday"));
        f.setSkipHours(List.of(1, 23));
        f.setLastBuildDate(getTimestamp("Wed, 06 Sep 2023 14:35:08 GMT"));

        return f;
    }

    /**
     * Convert the string date time into a timestamp
     * @param dateTime The date time string to convert
     */
    protected Timestamp getTimestamp(final String dateTime) {
        // use the solution from https://stackoverflow.com/questions/39279480/how-to-convert-rfc-1123-date-time-formatter-to-local-time
        // to convert the feed date time string into a timestamp.  This is required because the feed date time is in GMT
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTime, DateTimeFormatter.RFC_1123_DATE_TIME);

        ZoneId z = ZoneId.systemDefault();
        LocalDateTime localDateTime = zonedDateTime.withZoneSameInstant(z).toLocalDateTime();

        return Timestamp.valueOf(localDateTime);
    }
}