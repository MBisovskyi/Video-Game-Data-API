package com.dcc.videoGameApi.service;

import com.dcc.videoGameApi.models.VideoGame;
import com.dcc.videoGameApi.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class VideoGameService {

    @Autowired
    private VideoGameRepository videoGameRepository;

    public long GetCountOfGames(){
        return videoGameRepository.count();
    }


    public List<VideoGame> findAllGames() {
        return videoGameRepository.findAll().stream().toList();
    }

    public VideoGame findGameById(Integer id) {
        return videoGameRepository.findById(id).orElse(null);
    }
}
