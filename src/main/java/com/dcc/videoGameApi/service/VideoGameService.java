package com.dcc.videoGameApi.service;

import com.dcc.videoGameApi.models.VideoGame;
import com.dcc.videoGameApi.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public List<Double> findBestConsole() {
        List<Double> listOfTotalSales = new ArrayList<>();

        // Get All games since 2013
        List<VideoGame> gamesSince2013 = videoGameRepository.findAll().stream().filter(game -> game.getYear() >= 2013).toList();

        //Get Wii Games and Sum its global sales.
        List<VideoGame> wiiGames = gamesSince2013.stream().filter(game -> game.getPlatform().equals("Wii")).toList();
        List<Double> wiiGamesGlobalSales = wiiGames.stream().map(VideoGame::getGlobalsales).toList();
        Double wiiTotalSales = wiiGamesGlobalSales.stream().mapToDouble(Double::doubleValue).sum();
        listOfTotalSales.add(wiiTotalSales);

        //Get WiiU Games and Sum its global sales.
        List<VideoGame> wiiUGames = gamesSince2013.stream().filter(game -> game.getPlatform().equals("WiiU")).toList();
        List<Double> wiiUGamesGlobalSales = wiiUGames.stream().map(VideoGame::getGlobalsales).toList();
        Double wiiUTotalSales = wiiUGamesGlobalSales.stream().mapToDouble(Double::doubleValue).sum();
        listOfTotalSales.add(wiiUTotalSales);

        //Get 3DS Games and Sum its global sales.
        List<VideoGame> threeDsGames = gamesSince2013.stream().filter(game -> game.getPlatform().equals("3DS")).toList();
        List<Double> threeDsGamesGlobalSales = threeDsGames.stream().map(VideoGame::getGlobalsales).toList();
        Double threeDsTotalSales = threeDsGamesGlobalSales.stream().mapToDouble(Double::doubleValue).sum();
        listOfTotalSales.add(threeDsTotalSales);

        //Get XOne Games and Sum its global sales.
        List<VideoGame> xOneGames = gamesSince2013.stream().filter(game -> game.getPlatform().equals("XOne")).toList();
        List<Double> xOneGamesGlobalSales = xOneGames.stream().map(VideoGame::getGlobalsales).toList();
        Double xOneTotalSales = xOneGamesGlobalSales.stream().mapToDouble(Double::doubleValue).sum();
        listOfTotalSales.add(xOneTotalSales);

        //Get X360 Games and Sum its global sales.
        List<VideoGame> x360Games = gamesSince2013.stream().filter(game -> game.getPlatform().equals("X360")).toList();
        List<Double> x360GamesGlobalSales = x360Games.stream().map(VideoGame::getGlobalsales).toList();
        Double x360TotalSales = x360GamesGlobalSales.stream().mapToDouble(Double::doubleValue).sum();
        listOfTotalSales.add(x360TotalSales);

        //Get PS3 Games and Sum its global sales.
        List<VideoGame> psThreeGames = gamesSince2013.stream().filter(game -> game.getPlatform().equals("PS3")).toList();
        List<Double> psThreeGamesGlobalSales = psThreeGames.stream().map(VideoGame::getGlobalsales).toList();
        Double psThreeTotalSales = psThreeGamesGlobalSales.stream().mapToDouble(Double::doubleValue).sum();
        listOfTotalSales.add(psThreeTotalSales);

        //Get PS4 Games and Sum its global sales.
        List<VideoGame> psFourGames = gamesSince2013.stream().filter(game -> game.getPlatform().equals("PS4")).toList();
        List<Double> psFourGamesGlobalSales = psFourGames.stream().map(VideoGame::getGlobalsales).toList();
        Double psFourTotalSales = psFourGamesGlobalSales.stream().mapToDouble(Double::doubleValue).sum();
        listOfTotalSales.add(psFourTotalSales);

        //Get PC Games and Sum its global sales.
        List<VideoGame> pcGames = gamesSince2013.stream().filter(game -> game.getPlatform().equals("PC")).toList();
        List<Double> pcGamesGlobalSales = pcGames.stream().map(VideoGame::getGlobalsales).toList();
        Double pcTotalSales = pcGamesGlobalSales.stream().mapToDouble(Double::doubleValue).sum();
        listOfTotalSales.add(pcTotalSales);

        return listOfTotalSales;
    }
}
