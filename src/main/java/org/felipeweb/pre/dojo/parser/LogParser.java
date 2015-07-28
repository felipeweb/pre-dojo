package org.felipeweb.pre.dojo.parser;

import org.felipeweb.pre.dojo.models.Player;
import org.felipeweb.pre.dojo.models.ResultGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by felipeweb on 7/27/15.
 */
public class LogParser {

    private static List<ResultGame> resultGames = new ArrayList<>();
    private static ResultGame resultGame;

    public static List<ResultGame> parse(Path path) {
        try {
            Files.lines(path).forEach(line -> {
                String event = line.split(" - ")[1];
                if (line.contains("has started")) {
                    resultGame = new ResultGame();
                    resultGame.setId(Long.parseLong(event.replaceAll("\\D", "")));
                }
                if (line.contains("has ended")) {
                    resultGames.add(resultGame);
                }
                if (line.contains("killed")) {
                    String nameKiller = event.split(" ")[0];
                    String nameKilled = event.split(" ")[2];
                    String gunName = event.split(" ")[4];
                    Optional<Player> optionalKiller = resultGame.findPlayerByName(nameKiller);
                    Optional<Player> optionalKilled = resultGame.findPlayerByName(nameKilled);
                    if (optionalKilled.isPresent()) {
                        Player killed = optionalKilled.get();
                        killed.diesUp();
                    } else {
                        Player killed = new Player();
                        killed.setName(nameKilled);
                        killed.diesUp();
                        resultGame.addPlayer(killed);
                    }
                    if (optionalKiller.isPresent()) {
                        Player killer = optionalKiller.get();
                        killer.killsUp();
                    } else if (!nameKiller.equals("<WORLD>")){
                        Player killer = new Player();
                        killer.setName(nameKiller);
                        killer.killsUp();
                        resultGame.addPlayer(killer);
                    }
                    if (!nameKiller.equals("<WORLD>")) {
                        resultGame.killsUp();
                    }
                }
            });
            return resultGames;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
