/**************************************************
*   Author: Morrison
*   Date:  01 Mar 2022
**************************************************/
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
public class RPNCalc extends Application
{
    private TextField display;
    private NumberButton[] numButtons;
    private IStack<Double> theStack;
    private boolean doneEntering;
    private GridPane keyPad;
    private enum Mode{DEG, RAD}
    private Mode mode;
    private static final double RAD2DEG;
    private static final double DEG2RAD;
    static 
    {
        RAD2DEG = 180/Math.PI;
        DEG2RAD = Math.PI/180;
    }
    public RPNCalc()
    {
        mode = Mode.RAD;   //default is radian mode
        doneEntering = false;
        keyPad = new GridPane();

        theStack = new AStack<>();//NOte: display is top of stack
        display = new TextField();
        display.setStyle("-fx-font-size:16pt;-fx-font-family:'Comic Sans MS';-fx-text-weight:bold;");
        display.setAlignment(Pos.BOTTOM_RIGHT);    //right justify display.  
        numButtons = new NumberButton[12];
        for(int k = 0; k < 10; k++)
        {
            numButtons[k] = new NumberButton("" + k);
        }
        numButtons[10] = new NumberButton("E");
        numButtons[11] = new NumberButton(".");
    }

    @Override
    public void init()
    {
    }

    @Override
    public void start(Stage primary)
    {
        primary.setTitle("4280 RPN Calculator");
        BorderPane bp = new BorderPane();
        makeNumPad();
        makeOpPad();
        makeFunctionPad();
        bp.setCenter(keyPad);
        bp.setTop(display);
        primary.setScene(new Scene(bp, 800, 500));
        primary.show();
    }
    private void makeOpPad()
    {
        HBox box = new HBox();
        OpButton plusButton = new OpButton("+", (x, y) -> x + y);
        OpButton timesButton = new OpButton("*", (x, y) -> x*y);
        OpButton minusButton = new OpButton("-", (x, y) -> x - y);
        OpButton divideButton = new OpButton("/", (x, y) -> x/y);
        OpButton powButton = new OpButton("**", (x, y) -> Math.pow(x,y));
        keyPad.add(plusButton, 3, 0);
        keyPad.add(minusButton, 3, 1);
        keyPad.add(timesButton, 3, 2);
        keyPad.add(divideButton, 3, 3);
        keyPad.add(powButton, 3, 4);
    }
    private void makeFunctionPad()
    {
        FunctionButton chsButton = new FunctionButton("(-)", x -> -x);
        keyPad.add(chsButton, 3,5);
        FunctionButton sineButton = new FunctionButton("sin", x ->
        {
            if(mode == Mode.DEG)
            {
                return Math.sin(DEG2RAD*x);
            }
            else
            {
                return Math.sin(x);
            }
        });
        keyPad.add(sineButton, 4,0);
        FunctionButton cosineButton = new FunctionButton("cos", x ->
        {
            if(mode == Mode.DEG)
            {
                return Math.cos(DEG2RAD*x);
            }
            else
            {
                return Math.cos(x);
            }
        });
        keyPad.add(cosineButton, 4,1);
        FunctionButton tangentButton = new FunctionButton("tan", x ->
        {
            if(mode == Mode.DEG)
            {
                return Math.tan(DEG2RAD*x);
            }
            else
            {
                return Math.tan(x);
            }
        });
        keyPad.add(tangentButton, 4,2);
        FunctionButton arcsineButton = new FunctionButton("asin", x ->
        {
            if(mode == Mode.DEG)
            {
                return RAD2DEG* Math.asin(x);
            }
            else
            {
                return Math.asin(x);
            }
        });
        keyPad.add(arcsineButton, 4,3);
        FunctionButton arccosineButton = new FunctionButton("acos", x ->
        {
            if(mode == Mode.DEG)
            {
                return RAD2DEG* Math.acos(x);
            }
            else
            {
                return Math.acos(x);
            }
        });
        keyPad.add(arccosineButton, 4,4);
        FunctionButton arctanButton = new FunctionButton("atan", x ->
        {
            if(mode == Mode.DEG)
            {
                return RAD2DEG* Math.atan(x);
            }
            else
            {
                return Math.atan(x);
            }
        });
        keyPad.add(arctanButton, 4,5);

    }
    private void makeNumPad()
    {
        keyPad.setVgap(15);
        keyPad.setHgap(10);
        keyPad.add(numButtons[7], 0, 0);
        keyPad.add(numButtons[8], 1, 0);
        keyPad.add(numButtons[9], 2, 0);
        keyPad.add(numButtons[4], 0, 1);
        keyPad.add(numButtons[5], 1, 1);
        keyPad.add(numButtons[6], 2, 1);
        keyPad.add(numButtons[1], 0, 2);
        keyPad.add(numButtons[2], 1, 2);
        keyPad.add(numButtons[3], 2, 2);
        keyPad.add(numButtons[10], 0, 3);
        keyPad.add(numButtons[0], 1, 3);
        keyPad.add(numButtons[11], 2, 3);
        CalcButton enterButton = new CalcButton("ENTER");
        enterButton.setOnAction( e ->
        {
            try
            {
                double item = Double.parseDouble(display.getText());
                theStack.push(item);
                System.out.println(theStack);
            }
            catch(NumberFormatException ex)
            {
                //TODO: decide how to handle
                System.err.println("QUACK");
            }
            finally
            {
                display.clear();
            }
        });
        keyPad.add(enterButton, 0, 4);//TODO make colpan of 2.
        GridPane.setColumnSpan(enterButton, 2);
        enterButton.setPrefSize(160, 50);
        CalcButton backspace = new CalcButton("<-");
        keyPad.add(backspace, 2,4);
        backspace.setOnAction( e ->
        {
            int n = display.getText().length();
            if(n > 0)
            {
                display.setText(display.getText().substring(0, n - 1));
            }
        });
        CalcButton clearButton = new CalcButton("C");
        CalcButton clearEntryButton = new CalcButton("CE");
        keyPad.add(clearButton, 0,5 );
        keyPad.add(clearEntryButton, 1, 5 );
        clearButton.setOnAction( e ->
        {
            theStack.clear();
            display.clear();
            doneEntering = false;
        });
        clearEntryButton.setOnAction( e ->
        {
            display.clear();
        });
        CalcButton modeButton = new CalcButton("RAD");
        modeButton.setOnAction( e ->
        {
            if(modeButton.getText().equals("RAD"))
            {
                modeButton.setText("DEG");
                mode = Mode.DEG;
            }
            else
            {
                modeButton.setText("RAD");
                mode = Mode.RAD;
            }
        });
        keyPad.add(modeButton, 2, 5 );
        FunctionButton sqrtButton = new FunctionButton("sqrt", Math::sqrt);
        keyPad.add(sqrtButton, 5, 0);
    }
    @Override
    public void stop()
    {
    }
    /************************Inner Classes***********/
    class CalcButton extends Button
    {
        private String ch;
        public CalcButton(String ch)
        {
            super(ch);
            setStyle("-fx-font-size:16pt;-fx-font-family:'Comic Sans MS';-fx-text-weight:bold;");
            setPrefSize(75,50);
        }
    }
    class NumberButton extends CalcButton
    {
        private final String ch;
        public NumberButton(String ch)
        {
            super(ch);
            this.ch = ch;
            setOnAction( e ->
            {
                if(doneEntering)
                {
                    double d = Double.parseDouble(display.getText());
                    //TODO: we may need to catch this exception
                    theStack.push(d);
                    display.clear();
                    doneEntering = false;
                    //put item in display onto the stack
                    //clear display
                    //then being number entering
                }
                //when the button is pushed, 
                //the button's character is appended to the 
                //textfield.
                display.setText(display.getText() + ch);
            });
        }
    }
    class OpButton extends CalcButton
    {
        private String symbol;
        private DoubleBinaryOperator op;
        public OpButton(String symbol, DoubleBinaryOperator op)
        {
            super(symbol);
            this.op = op;
            setPrefSize(75, 50);
            setOnAction( e -> {
                try
                {
                    double first = theStack.pop();
                     double second = Double.parseDouble(display.getText());
                    //TODO: handle NumberFormatException
                    double result = op.applyAsDouble(first, second);
                    display.setText("" + result);
                    doneEntering = true;
                }
                catch(EmptyStackException ex)
                {
                    //QUACK!!!
                    //TODO: Is there a better way to handle this?`
                }
            });
        }
    }
    class FunctionButton extends CalcButton
    {
        private DoubleUnaryOperator op;
        public FunctionButton(String symbol, DoubleUnaryOperator op)
        {
            super(symbol);
            this.op = op;
            setOnAction( e -> 
            {
                double d = Double.parseDouble(display.getText());
                display.setText("" + op.applyAsDouble(d));
                doneEntering = true;
            });
        }
    }
}