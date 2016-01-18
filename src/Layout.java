import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by $SPS on 15-01-2016.
 */
public class Layout implements ActionListener {

    //Strings to hold input and output respectively.
    ///////////////////////////////////////////////
    String ques = "", answer = "";
    //////////////////////////////////////////////

    // Operation buttons.
    //////////////////////////////////////////////
    JButton multi = new JButton("*");
    JButton divide = new JButton("/");
    JButton add = new JButton("+");
    JButton subs = new JButton("-");
    JButton equal = new JButton("=");
    //JButton remainder = new JButton("%");
    //JButton power = new JButton("^");
    /////////////////////////////////////////////

    //Other feature buttons
    ////////////////////////////////////////////
    JButton refresh = new JButton("Refresh");
    JButton lBrac = new JButton("(");
    JButton rBrac = new JButton(")");
    ////////////////////////////////////////////

    //Numbers.
    //////////////////////////////////////////////
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton zero = new JButton("0");
    /////////////////////////////////////////////


    //Text fields , panels , frames etc.
    /////////////////////////////////////////////////////////////////////////
    JFrame mainFrame = new JFrame("Calculator");
    JPanel inOutPanel = new JPanel();
    JPanel keyboard = new JPanel();
    JPanel operations = new JPanel();
    JPanel numbers = new JPanel();
    JTextField input = new JTextField(ques, 15);
    JTextField output = new JTextField();
    Border operBorder = BorderFactory.createTitledBorder("Operations");
    Border numBorder = BorderFactory.createTitledBorder("Numbers");
    Border inOutBorder = BorderFactory.createTitledBorder("In/Out");
    /////////////////////////////////////////////////////////////////////////


    /*Constructor
    *  Builds the layout.
    *  Sets the action listners to buttons.
     */
    public Layout() {

        this.equal.setActionCommand("=");
        this.lBrac.setActionCommand("(");
        this.rBrac.setActionCommand(")");
        this.refresh.setActionCommand("refresh");
        this.add.setActionCommand("+");
        this.subs.setActionCommand("-");
        this.divide.setActionCommand("/");
        this.multi.setActionCommand("*");
        this.zero.setActionCommand("0");
        this.one.setActionCommand("1");
        this.two.setActionCommand("2");
        this.three.setActionCommand("3");
        this.four.setActionCommand("4");
        this.five.setActionCommand("5");
        this.six.setActionCommand("6");
        this.seven.setActionCommand("7");
        this.eight.setActionCommand("8");
        this.nine.setActionCommand("9");
        this.output.setColumns(15);
        this.operations.setBorder(this.operBorder);
        this.operations.add(this.equal);
        this.operations.add(this.multi);
        this.operations.add(this.divide);
        //operations.add(remainder);
        this.operations.add(this.subs);
        //operations.add(power);
        this.operations.add(this.add);
        this.operations.add(this.lBrac);
        this.operations.add(this.rBrac);
        this.numbers.add(this.zero);
        this.numbers.add(this.one);
        this.numbers.add(this.two);
        this.numbers.add(this.three);
        this.numbers.add(this.four);
        this.numbers.add(this.five);
        this.numbers.add(this.six);
        this.numbers.add(this.seven);
        this.numbers.add(this.eight);
        this.numbers.add(this.nine);
        this.numbers.setBorder(this.numBorder);
        this.add.addActionListener(this);
        this.equal.addActionListener(this);
        this.multi.addActionListener(this);
        this.divide.addActionListener(this);
        this.subs.addActionListener(this);
        // this.remainder.addActionListener(this);
        //this.power.addActionListener(this);
        this.zero.addActionListener(this);
        this.one.addActionListener(this);
        this.two.addActionListener(this);
        this.three.addActionListener(this);
        this.four.addActionListener(this);
        this.five.addActionListener(this);
        this.six.addActionListener(this);
        this.seven.addActionListener(this);
        this.eight.addActionListener(this);
        this.nine.addActionListener(this);
        this.refresh.addActionListener(this);
        this.rBrac.addActionListener(this);
        this.lBrac.addActionListener(this);
        this.inOutPanel.add(this.output);
        this.inOutPanel.add(this.input);
        this.inOutPanel.requestFocus();
        this.inOutPanel.setBorder(this.inOutBorder);
        this.inOutPanel.setAlignmentX(this.mainFrame.getWidth() / 2);
        this.inOutPanel.setAlignmentY(0);
        this.keyboard.setSize(400, 400);
        this.keyboard.setAlignmentX(10);
        this.keyboard.setAlignmentY(20);
        this.keyboard.add(this.inOutPanel);
        this.keyboard.add(this.operations);
        this.keyboard.add(this.numbers);
        this.keyboard.add(this.refresh);
        this.mainFrame.add(this.keyboard);
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setSize(500, 270);
        this.mainFrame.setResizable(false);
        this.mainFrame.setVisible(true);
        this.mainFrame.setBackground(Color.blue);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton buttonPressed = (JButton) (e.getSource());
        if (buttonPressed.getActionCommand() == this.lBrac.getActionCommand() || buttonPressed.getActionCommand() == this.rBrac.getActionCommand() || buttonPressed.getActionCommand() == this.multi.getActionCommand() || buttonPressed.getActionCommand() == this.subs.getActionCommand() || buttonPressed.getActionCommand() == this.add.getActionCommand() || buttonPressed.getActionCommand() == this.divide.getActionCommand() || buttonPressed.getActionCommand() == this.zero.getActionCommand() || buttonPressed.getActionCommand() == this.one.getActionCommand() || buttonPressed.getActionCommand() == this.two.getActionCommand() || buttonPressed.getActionCommand() == this.three.getActionCommand() || buttonPressed.getActionCommand() == this.four.getActionCommand() || buttonPressed.getActionCommand() == this.five.getActionCommand() || buttonPressed.getActionCommand() == this.six.getActionCommand() || buttonPressed.getActionCommand() == this.seven.getActionCommand() || buttonPressed.getActionCommand() == this.eight.getActionCommand() || buttonPressed.getActionCommand() == this.nine.getActionCommand()) {

            if ((answer != "")) {
                if ((buttonPressed.getActionCommand() == this.multi.getActionCommand() || buttonPressed.getActionCommand() == this.subs.getActionCommand() || buttonPressed.getActionCommand() == this.add.getActionCommand() || buttonPressed.getActionCommand() == this.divide.getActionCommand()))
                    this.ques = answer;
                else
                    this.ques = "";
                this.answer = "";
            }

            this.ques = this.ques + (buttonPressed.getActionCommand());


            this.input.setText(this.ques);

        } else if (buttonPressed.getActionCommand() == this.equal.getActionCommand()) {

            if (this.ques != "")
                this.calculateUsingStack();

        } else if (buttonPressed.getActionCommand() == this.refresh.getActionCommand()) {

            this.Refresh();

        }

    }

    private void Refresh() {

        this.ques = "";
        this.answer = "";
        this.input.setText(this.ques);
        this.output.setText(this.answer);

    }

    private void calculateUsingStack() {

        StringEvaluation answ = new StringEvaluation();
        try {
            this.answer = answ.evaluate(ques);
        } catch (Exception e) {
            this.answer = "Wrong Input!";
        }
        this.output.setText(this.answer);

    }
}