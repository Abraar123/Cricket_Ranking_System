package com.cric.cricket_ranking_system.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShuffleResponse {

    private List<String> shuffledPlayers;

    public ShuffleResponse() {
    }

    public ShuffleResponse(List<String> shuffledPlayers) {
        this.shuffledPlayers = shuffledPlayers;
    }
}
