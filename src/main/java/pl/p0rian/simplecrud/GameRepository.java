package pl.p0rian.simplecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Game> getAll(){
        return jdbcTemplate.query("SELECT id, title, score FROM game",
                BeanPropertyRowMapper.newInstance(Game.class));

    }
    public Game getById(int id){
        return jdbcTemplate.queryForObject("SELECT id, title, score FROM game WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Game.class), id);

    }

    public int add(List<Game> games) {
        games.forEach(game ->  jdbcTemplate.update
                ("INSERT INTO game(title, score) VALUES(?, ?)",
                        game.getTitle(), game.getScore()
                )
        );
        return 1;
    }

    public int update(Game game){
        return jdbcTemplate.update("UPDATE game SET title=?, score=? WHERE id =?",
                game.getTitle(), game.getScore(), game.getId());
    }

    public int delete(int id){
       return jdbcTemplate.update("DELETE FROM game WHERE id =?", id);
    }
}
