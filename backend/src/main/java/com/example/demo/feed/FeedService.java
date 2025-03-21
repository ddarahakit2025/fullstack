package com.example.demo.feed;

import com.example.demo.feed.model.Feed;
import com.example.demo.feed.model.FeedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FeedService {
    private final FeedRepository feedRepository;
    private final FeedImageRepository feedImageRepository;

    public List<FeedDto.FeedResponse> list() {
        List<Feed> feedList = feedRepository.findAllByOrderByIdxDesc();

        return feedList.stream().map(FeedDto.FeedResponse::from).collect(Collectors.toList());
    }

    public FeedDto.FeedResponse read(Long idx) {
        Optional<Feed> result = feedRepository.findById(idx);

        if(result.isPresent()) {
            Feed feed = result.get();

            return FeedDto.FeedResponse.from(feed);
        }

        return null;
    }

    public void register(FeedDto.RegisterRequest dto) {
        Feed feed = feedRepository.save(dto.toEntity());
    }
}
