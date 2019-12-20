import javafx.scene.Group;
import javafx.scene.Node;

import java.util.ArrayList;

public class Stream
{

    private double speed = 0;
    private Group body = new Group();
    private ArrayList<Symbol> symbols = new ArrayList<>();
    public static ArrayList<Stream> streams = new ArrayList<>();

    public Stream(double x, double y)
    {
        this.speed = 2 + Math.round(Math.random() * 4);
        this.body.setLayoutX(x);
        this.body.setLayoutY(y);
        final int limit = 15 + (int) Math.round(Math.random() * 35);
        for (int i = 0; i < limit; i++)
        {
            this.symbols.add(new Symbol(0, i * 25));
        }
        for (Symbol symbol : symbols)
        {
            this.body.getChildren().add(symbol.getBody());
        }
        streams.add(this);
    }

    public Node getBody()
    {
        return this.body;
    }

    public void next()
    {
        // FALL
        this.body.setLayoutY(body.getLayoutY() + speed);
        if (body.getLayoutY() > Main.height + 50)
        {
            // passed away, reset it again
            this.body.setLayoutY(-2000 + Math.round(Math.random() * 1000));
            this.speed = 2 + Math.round(Math.random() * 4);
        }
        //
        for (Symbol symbol : symbols)
        {
            symbol.next();
        }
    }
}
