package lab.lab11;

import java.awt.*;
import java.awt.CheckboxGroup;
import java.awt.Checkbox;
import java.awt.event.*;
import java.util.Random;

/**
 * Created by Juan Carlos on 10/25/2016.
 */

public class RockPaperScissors extends Frame {
    //use the following constants in turn-checking
    private static final int ROCK = 1;
    private static final int SCISSORS = 2;
    private static final int PAPER = 3;
    private static final int LIZARD = 4;
    private static final int SPOCK = 5;

    //Random rand used for randomize()
    private Random rand;

    private Label lbl;      //labels for short texts
    private Label lblPlayer;
    private Label lblComputer;
    private CheckboxGroup radio; //used to group all Checkbox objects as radio buttons
    private TextArea txtDisplay; //display for turn status
    private TextField txtDisplayPlayer; //TextFields for player and computer scores
    private TextField txtDisplayComp;
    private TextField finishMessage; //TextField for endgame message
    private Button comGenResult;    //Button used to computer generate computer choice
    private Frame frame;   //Frame used as container for endgame message
    private Dialog messageDialog;    //endgame message
    private int playerScore;
    private int computerScore;
    private int playersHand;    //int representation of player and computer hand choice
    private int computersHand;
    private String playersOption;   //String representation of above
    private String computersOption;
    private String display;    //String equivalent of txtDisplay
    private String determine;
    private String whoWins; //round winner

    private Button yes;  //for buttons in Dialog
    private Button no;

    public RockPaperScissors() {
        whoWins = "NOBODY";
        setLayout(new FlowLayout());    //default layout

        //initializing necessary fields
        this.rand = new Random();
        playersOption = new String();
        computersOption = new String();
        playerScore = 0;
        computerScore = 0;

        //initializing necessary components
        lbl = new Label("Your computersHand");
        lblPlayer = new Label("Player's Score");
        lblComputer = new Label("Computer's Score");
        radio = new CheckboxGroup();
        frame = new Frame();
        messageDialog = new Dialog(frame, "Game over");
        messageDialog.setLayout(new FlowLayout());
        messageDialog.setSize(500,120);
        yes = new Button("Yes");
        messageDialog.add(yes);
        no = new Button("No");
        messageDialog.add(no);

        //initializing and grouping of Checkbox components
        Checkbox paper = new Checkbox("Paper", radio, true);
        Checkbox scissors = new Checkbox("Scissors", radio, false);
        Checkbox rock = new Checkbox("Rock", radio, false);
        Checkbox lizard = new Checkbox("Lizard", radio, false);
        Checkbox spock = new Checkbox("Spock", radio, false);

        //setting initial textDisplay Strings
        determine = "WINS THIS ROUND";
        display = "Results:\nPlayer chose " + playersOption + "\nComputer chose " + computersOption + "\n" + whoWins + " " + determine;

        //initializing necessary components
        txtDisplay = new TextArea(display, 5, 30);
        txtDisplayPlayer = new TextField(new Integer(playerScore).toString());
        txtDisplayComp = new TextField(new Integer(computerScore).toString());
        comGenResult = new Button("RockPaperScissorsLizardSpock!");
        finishMessage = new TextField("");
        messageDialog.add(finishMessage);
        txtDisplay.setEditable(false);
        txtDisplayPlayer.setEditable(false);
        txtDisplayComp.setEditable(false);
        finishMessage.setEditable(false);

        //adding them into the RockPaperScissors Frame
        add(lbl);
        add(paper);
        add(rock);
        add(scissors);
        add(lizard);
        add(spock);
        add(txtDisplay);
        add(comGenResult);
        add(lblPlayer);
        add(lblComputer);
        add(txtDisplayPlayer);
        add(txtDisplayComp);

        //setting necessary frame variables
        setTitle("RockPaperScissorsLizardSpock!");
        setSize(500, 400);
        setVisible(true);

        //to force exit program using the close button
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });

        //anonymous inner class used to listen to mouse click on generator button
        comGenResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomize();    //generate new value of opponent's hand
                Checkbox temp = radio.getSelectedCheckbox();   //gets user's choice

                //sets up the playersOption and playersHand fields from user's choice
                if (temp.equals(rock)) {
                    playersOption = "ROCK";
                    playersHand = ROCK;
                }
                if (temp.equals(paper)) {
                    playersOption = "PAPER";
                    playersHand = PAPER;
                }
                if (temp.equals(scissors)) {
                    playersOption = "SCISSORS";
                    playersHand = SCISSORS;
                }
                if (temp.equals(lizard)) {
                    playersOption = "LIZARD";
                    playersHand = LIZARD;
                }
                if (temp.equals(spock)) {
                    playersOption = "SPOCK";
                    playersHand = SPOCK;
                }

                //updates scores
                whoWins = determineRoundWinner();
                if (whoWins == "YOU"){
                    determine = "WIN";
                    playerScore++;
                } else if (whoWins == "COMPUTER") {
                    determine = "WINS";
                    computerScore++;
                } else
                    determine = "WINS";

                //displays round updates
                display = "Results:\nPlayer chose " + playersOption + "\nComputer chose " + computersOption + "\n" + whoWins + " " + determine;
                txtDisplay.setText(display);

                //updates scores
                txtDisplayPlayer.setText(new Integer(playerScore).toString());
                txtDisplayComp.setText(new Integer(computerScore).toString());

                //checks if game is over
                String winner;
                if(playerScore == 5 || computerScore == 5){
                    if(getWinner() == 1)
                        winner = "Player";
                    else
                        winner = "Computer";
                    //makes the dialog box visible
                    finishMessage.setText(winner + " wins. Play again?");
                    messageDialog.setVisible(true);
                    yes.addActionListener(new ActionListener() { //more anonymous inner classes to check for mouse clicks on buttons yes and no
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            playerScore = computerScore = 0;    //resets game scores
                            messageDialog.setVisible(false); //hides the dialog
                            txtDisplayPlayer.setText(new Integer(playerScore).toString());   //updates score display
                            txtDisplayComp.setText(new Integer(computerScore).toString());
                        }
                    });
                    no.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        } //exit game
                    });
                    messageDialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosing(java.awt.event.WindowEvent e) { //exit game if user tries to press the close button
                            System.exit(0);
                        }
                    });
                }
            }
        });
    }

    public String determineRoundWinner() {
        if (playersHand == ROCK && (computersHand == LIZARD || computersHand == SCISSORS))
            return "YOU";
        else if (playersHand == ROCK && (computersHand == PAPER || computersHand == SPOCK))
            return "COMPUTER";
        else if (playersHand == ROCK && computersHand == ROCK)
            return "NOBODY";

        if (playersHand == PAPER && (computersHand == ROCK || computersHand == SPOCK))
            return "YOU";
        else if (playersHand == PAPER && (computersHand == SCISSORS || computersHand == LIZARD))
            return "COMPUTER";
        else if (playersHand == PAPER && computersHand == PAPER)
            return "NOBODY";

        if (playersHand == SPOCK && (computersHand == ROCK || computersHand == SCISSORS))
            return "YOU";
        else if (playersHand == SPOCK && (computersHand == LIZARD || computersHand == PAPER))
            return "COMPUTER";
        else if (playersHand == SPOCK && computersHand == SPOCK)
            return "NOBODY";

        if (playersHand == LIZARD && (computersHand == PAPER || computersHand == SPOCK))
            return "YOU";
        else if (playersHand == LIZARD && (computersHand == ROCK || computersHand == SCISSORS))
            return "COMPUTER";
        else if (playersHand == LIZARD && computersHand == LIZARD)
            return "NOBODY";

        if (playersHand == SCISSORS && (computersHand == LIZARD || computersHand == PAPER))
            return "YOU";
        else if (playersHand == SCISSORS && (computersHand == ROCK || computersHand == SPOCK))
            return "COMPUTER";
        else if (playersHand == SCISSORS && computersHand == SCISSORS)
            return "NOBODY";
        return null;
    }

    public int getWinner() {
        if (playerScore == 5)
            return 1;
        else if (computerScore == 5)
            return 2;
        else
            return 0;
    }

    private void randomize() {
        System.out.println(computersHand);
        computersHand = rand.nextInt(5) + 1;

        if (computersHand == ROCK)
            computersOption = "ROCK";
        else if (computersHand == SCISSORS)
            computersOption = "SCISSORS";
        else if (computersHand == PAPER)
            computersOption = "PAPER";
        else if (computersHand == LIZARD)
            computersOption = "LIZARD";
        else if (computersHand == SPOCK)
            computersOption = "SPOCK";
    }

    public static void main(String[] args) throws InterruptedException {
        RockPaperScissors rps = new RockPaperScissors();
    }
}
