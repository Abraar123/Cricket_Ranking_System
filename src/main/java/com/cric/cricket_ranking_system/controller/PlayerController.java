package com.cric.cricket_ranking_system.controller;

import com.cric.cricket_ranking_system.dto.ShuffleRequest;
import com.cric.cricket_ranking_system.dto.ShuffleResponse;
import com.cric.cricket_ranking_system.service.PlayerService;
import com.cric.cricket_ranking_system.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cric")
public class PlayerController {

    @Autowired
    private PlayerService pService;

    @PostMapping("/add")
    public ResponseEntity<ResponseStructure<List<String>>> addPlayers(@RequestBody ShuffleRequest r) {
        return pService.addPlayers(r);
    }

    @GetMapping("/shuffle")
    public ResponseEntity<ResponseStructure<?>> generateOrder() {
        return pService.generateOrder();
    }
}

