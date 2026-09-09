package com.cric.cricket_ranking_system.service;

import com.cric.cricket_ranking_system.dto.ShuffleRequest;
import com.cric.cricket_ranking_system.dto.ShuffleResponse;
import com.cric.cricket_ranking_system.repository.PlayerRepository;
import com.cric.cricket_ranking_system.util.ResponseStructure;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository pRepo;

    private List<String> players=new ArrayList<>();

    public ResponseEntity<ResponseStructure<List<String>>> addPlayers(ShuffleRequest r) {
        players.addAll(r.getPlayers());
        ResponseStructure<List<String>> rs=new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("Players Added Successfully");
        rs.setData(players);
        return new ResponseEntity<>(rs,HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<?>> generateOrder() {
        ResponseStructure<ShuffleResponse> rs=new ResponseStructure<>();
        if(players.isEmpty()){
            rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
            rs.setMessage("No players Added . Please Add players first");
            rs.setData(null);
            return new ResponseEntity<>(rs,HttpStatus.BAD_REQUEST);
        }
        List<String> shuffledPlayers=new ArrayList<>(players);
        int size=shuffledPlayers.size();
        Random r=new Random();
        for(int i=size-1;i>0;i--){
            int j=r.nextInt(i+1);
            String temp=shuffledPlayers.get(i);
            shuffledPlayers.set(i,shuffledPlayers.get(j));
            shuffledPlayers.set(j,temp);
        }
        ShuffleResponse sr=new ShuffleResponse();
        sr.setShuffledPlayers(shuffledPlayers);
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Order Generated ");
        rs.setData(sr);
        return new ResponseEntity<>(rs,HttpStatus.OK);
    }
}
