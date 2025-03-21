package com.example.demo.feed.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FeedDto {
    @Getter
    public static class RegisterRequest {
        private String contents;

        public Feed toEntity() {
            return Feed.builder()
                    .contents(contents)
                    .build();
        }
    }

    @Getter
    public static class RegisterImageRequest {
        private MultipartFile[] images;

        public List<FeedImage> toEntity(Feed feed) {
            return Arrays.asList(images).stream().map(image -> FeedImage.builder()
                    .url(image.getOriginalFilename())
                    .feed(feed)
                    .build()).collect(Collectors.toList());
        }
    }



    @AllArgsConstructor
    @Getter
    public static class ListResponse {
        private Boolean isSuccess;
        private List<FeedResponse> result;

        public static ListResponse success(List<FeedResponse> result) {
            return new ListResponse(true, result);
        }
    }

    @AllArgsConstructor
    @Getter
    public static class ReadResponse {
        private Boolean isSuccess;
        private FeedResponse result;

        public static ReadResponse success(FeedResponse result) {
            return new ReadResponse(true, result);
        }
    }

    @Getter
    public static class FeedResponse {

        private Long idx;
        private String contents;
        private List<String> imageUrls = new ArrayList<>();

        public static FeedResponse from(Feed feed) {
            FeedResponse response = new FeedResponse();
            response.idx = feed.getIdx();
            response.contents = feed.getContents();
            response.imageUrls = feed.getFeedImageList().stream().map(image -> image.getUrl()).collect(Collectors.toList());

            return response;
        }
    }
}
