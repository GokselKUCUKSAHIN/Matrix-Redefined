import javafx.scene.Group;
import javafx.scene.Node;

import java.util.ArrayList;

public class Stream
{

    private double x;
    private double y;
    private double z;
    private Group body = new Group();
    private ArrayList<Symbol> symbols = new ArrayList<>();

    public Stream(double x, double y)
    {
        this.x = x;
        this.y = y;
        this.body.setLayoutX(x);
        this.body.setLayoutY(y);
        final int limit = 7 + (int) Math.round(Math.random() * 13);
        for (int i = 0; i < limit; i++)
        {
            this.symbols.add(new Symbol(0, i * 42));
        }
        for (Symbol symbol : symbols)
        {
            this.body.getChildren().add(symbol.getBody());
        }
    }
    public Node getBody()
    {
        return this.body;
    }
    public void next()
    {
        for (Symbol symbol : symbols)
        {
            symbol.next();
        }
    }
}
