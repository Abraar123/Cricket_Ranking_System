package com.cric.cricket_ranking_system.dto;

import lombok.Data;

@Data
public class MatchResultRequest {

    private String name;
    private int runs;
    private int wickets;
}
