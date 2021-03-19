package com.ongdev.dashboard.models;

import lombok.Data;

@Data
public class YoutubeResponse {
    private String viewCount;
    private String subscriberCount;
    private String hiddenSubscriberCount;
    private String videoCount;

}
