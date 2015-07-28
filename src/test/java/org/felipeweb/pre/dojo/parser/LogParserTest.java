package org.felipeweb.pre.dojo.parser;

import org.felipeweb.pre.dojo.models.ResultGame;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by felipeweb on 7/27/15.
 */
public class LogParserTest {
    private Path path;

    @Before
    public void setUp() {
        this.path = Paths.get(getClass().getClassLoader().getResource("file.log").getPath());
    }

    @Test
    public void parseTest() {
        List<ResultGame> resultGames = LogParser.parse(path);
        assertFalse(resultGames.isEmpty());
        resultGames.forEach(resultGame -> {
            assertTrue(resultGame.getTotalKills() == 1);
            assertTrue(resultGame.getPlayers().get(0).getDies() == 0);
            assertTrue(resultGame.getPlayers().get(1).getDies() == 2);
            assertTrue(resultGame.getPlayers().get(1).getKills() == 0);
            assertTrue(resultGame.getPlayers().get(0).getKills() == 1);
        });

    }
}
