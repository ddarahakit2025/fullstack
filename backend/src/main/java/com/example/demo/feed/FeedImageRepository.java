package com.example.demo.feed;

import com.example.demo.feed.model.FeedImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedImageRepository extends JpaRepository<FeedImage, Long> {
}
