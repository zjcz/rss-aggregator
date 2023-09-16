package dev.jonclarke.rssaggregator.feedloader;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Base class for feed loader tests
 */
public abstract class FeedLoaderTest {

    /**
     * Load the test feed from the feed folder
     * @param filename The name of the feed file to be imported
     * @return The feed reader
     */
    protected Reader getFeedReader(final String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource(filename);
        final InputStream stream = resource.getInputStream();
        assertNotNull(resource, "Could not find resource " + filename);
        return new InputStreamReader(stream);
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
