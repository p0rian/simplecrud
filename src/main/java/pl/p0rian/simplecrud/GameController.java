package pl.p0rian.simplecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/test")
    public int test(){
        return 1;
    }

    @GetMapping("")
    public List<Game> getAll(){
        return gameRepository.getAll();
    }

    @GetMapping("/{id}")
    public Game getById(@PathVariable("id") int id){
        return gameRepository.getById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Game> games){
        return gameRepository.add(games);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Game updatedGame){
        Game game = gameRepository.getById(id);

        if (game != null) {
            game.setTitle(updatedGame.getTitle());
            game.setScore(updatedGame.getScore());

            gameRepository.update(game);
            return 1;
        }else {

            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int id){
        return gameRepository.delete(id);
    }
}