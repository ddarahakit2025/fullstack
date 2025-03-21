package com.example.demo.feed;

import com.example.demo.feed.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Feed, Long> {
    List<Feed> findAllByOrderByIdxDesc();

}
