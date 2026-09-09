package com.cric.cricket_ranking_system.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShuffleRequest {

    private List<String> players;
}
