package com.movieflix.streaming.mapper;

import com.movieflix.streaming.model.Streaming;
import com.movieflix.streaming.request.StreamingRequest;
import com.movieflix.streaming.response.StreamingResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request){
        return Streaming
                .builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }

}
