package com.example.demo.feed;

import com.example.demo.feed.model.FeedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feed")
public class FeedController {
    private final FeedService feedService;

    @PostMapping(value ="/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void register(
            @RequestPart FeedDto.RegisterRequest dto
    ) {

        feedService.register(dto);
    }


    @GetMapping("/read/{idx}")
    public ResponseEntity<FeedDto.ReadResponse> read(@PathVariable Long idx) {
        FeedDto.FeedResponse result = feedService.read(idx);

        return ResponseEntity.ok(FeedDto.ReadResponse.success(result));
    }

    @GetMapping("/list")
    public ResponseEntity<FeedDto.ListResponse> list() {
        List<FeedDto.FeedResponse> result = feedService.list();

        return ResponseEntity.ok(FeedDto.ListResponse.success(result));
    }

}
