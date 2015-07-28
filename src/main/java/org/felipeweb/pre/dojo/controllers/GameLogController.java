package org.felipeweb.pre.dojo.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import org.felipeweb.pre.dojo.models.ResultGame;
import org.felipeweb.pre.dojo.parser.LogParser;

import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by felipeweb on 7/27/15.
 */
@Controller
public class GameLogController {
    private final Result result;

    /**
     * @deprecated CDI eyes only
     */
    protected GameLogController() {
        this(null);
    }

    @Inject
    public GameLogController(Result result) {
        this.result = result;
    }

    @Post("/lerLog")
    public void lerLog(UploadedFile log) {
        try {
            Path path = Paths.get("./logGame");
            log.writeTo(path);
            List<ResultGame> resultGames = LogParser.parse(path);
            result.include("resultGames", resultGames);
            result.redirectTo(IndexController.class).result();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
