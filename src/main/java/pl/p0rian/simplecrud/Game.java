package pl.p0rian.simplecrud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private int id;
    private String title;
    private float score;
}
