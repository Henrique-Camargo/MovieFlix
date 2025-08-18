package com.movieflix.streaming.controller;

import com.movieflix.docs.StreamingDocs;
import com.movieflix.streaming.mapper.StreamingMapper;
import com.movieflix.streaming.model.Streaming;
import com.movieflix.streaming.request.StreamingRequest;
import com.movieflix.streaming.response.StreamingResponse;
import com.movieflix.streaming.service.StreamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController implements StreamingDocs {

    private final StreamingService service;

    @PostMapping
    public ResponseEntity<com.movieflix.streaming.response.StreamingResponse> save(@Valid @RequestBody StreamingRequest request){
        Streaming savedStreaming = service.save(StreamingMapper.toStreaming(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));
    }

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> findAll(){
        List<StreamingResponse> streamings = service.findAll().stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return ResponseEntity.ok(streamings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id){
        return service.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        try {
            service.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
