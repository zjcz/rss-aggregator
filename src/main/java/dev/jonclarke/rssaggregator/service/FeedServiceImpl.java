package dev.jonclarke.rssaggregator.service;

import dev.jonclarke.rssaggregator.data.Feed;
import dev.jonclarke.rssaggregator.data.FeedRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {
    private final FeedRepository feedRepository;

    public FeedServiceImpl(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public List<Feed> findAll() {
        List<Feed> feeds = new ArrayList<>();
        Iterable<Feed> feedRecords = feedRepository.findAll();
        feedRecords.iterator().forEachRemaining(feeds::add);
        return feeds;
    }

    public Feed findById(Long id) {
        return feedRepository.findById(id).orElse(null);
    }

    public Feed save(Feed feed) {
        return feedRepository.save(feed);
    }
}
