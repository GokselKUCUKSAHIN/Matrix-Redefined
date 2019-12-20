import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Symbol
{

    private static final int BASE = 0x30A0;
    //
    private Color color = Color.rgb(0, 255, 70);
    private double x;
    private double y;
    private int size = 40;
    private Label body;
    private int timeInterval = 0;
    private int ccv = 0; // Current Count Value

    public Symbol(double x, double y)
    {
        this.x = x;
        this.y = y;
        setTimeInterval();
        //
        body = new Label(getRandomSymbol() + "");
        body.setTextFill(color);
        body.setStyle(String.format("-fx-font-weight: bold; -fx-font-size: %dpx", size)); // css :(
        body.setLayoutX(x);
        body.setLayoutY(y);
    }

    public void setSize(int size)
    {
        body.setStyle(String.format("-fx-font-weight: bold; -fx-font-size: %dpx", size));
    }

    public void setColor(Color color)
    {
        this.body.setTextFill(color);
    }

    public void next()
    {
        if (ccv == timeInterval)
        {
            this.body.setText(getRandomSymbol() + "");
            this.body.setTextFill(Color.rgb(
                    0,
                    220 + (int) Math.round(Math.random() * 35),
                    40 + (int) Math.round(Math.random() * 35))
            );
            setTimeInterval();
        } else
        {
            ccv++;
        }
    }

    public Label getBody()
    {
        return this.body;
    }

    private void setTimeInterval()
    {
        this.timeInterval = 6 + (int) Math.round(Math.random() * 14);
        ccv = 0;
    }

    //
    public static char getRandomSymbol()
    {
        return (char) (BASE + (int) Math.round(Math.random() * 96));
    }
}