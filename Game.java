
//Import needed packages 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

class Game implements ActionListener {
  // Declaring all variable of GUI and game class.

  private JLabel labelWelcome;
  private JLabel labelGame;
  private JButton buttonOne;
  private JButton buttonTwo;
  private JButton buttonThree;
  private JButton buttonFour;
  private JLabel totalscore;
  private JButton nextQ;
  // private JButton enterAnswer;
  private JButton enterName;
  private JButton exit;
  private ArrayList<Question> questions;
  private int score;
  private JTextField nameSpace;
  private JLabel name;
  private JLabel showQs;
  private JLabel feedback;
  private ButtonGroup choiceGroup;

  // Array list for the questions
  public Game() {
    questions = new ArrayList<Question>();
    score = 0;
    String question = "";
    String choiceOne = "";
    String choiceTwo = "";
    String choiceThree = "";
    String choiceFour = "";
    int answer = 0;
    int points = 0;
    String category = "";

    try {

      FileReader file;
      file = new FileReader("trivia.txt");
      BufferedReader reader = new BufferedReader(file);

      while (reader.ready()) {
        // may need to parse the integer while intializing the question object
        question = reader.readLine();
        choiceOne = reader.readLine();
        choiceTwo = reader.readLine();
        choiceThree = reader.readLine();
        choiceFour = reader.readLine();
        answer = Integer.parseInt(reader.readLine());
        points = Integer.parseInt(reader.readLine());
        category = reader.readLine();
        Question q = new Question(question, choiceOne, choiceTwo, choiceThree, choiceFour, answer, points, category);
        questions.add(q);
      }
      reader.close();
    }
    // Catch any error and show it
    catch (IOException e) {

      System.out.println("An error occured: " + e);

    }
    // all this looks good
    FileWriter writer;
    // reading in the score text file and writing to the gui
    try {
      writer = new FileWriter("score.txt");
      BufferedWriter output = new BufferedWriter(writer);
      output.flush();
      output.close();
    }

    catch (IOException ex) {
      ex.printStackTrace();
    }

    try {
      writer = new FileWriter("score.txt");
      BufferedWriter output = new BufferedWriter(writer);
      output.write("player Score =" + score);
      output.newLine();

      output.flush();
      output.close();
    } catch (IOException exc) {
      exc.printStackTrace();
    }
    // initializing the frame and formatting the frame with a flowlayout and size
    JFrame frame = new JFrame("Group 10's Jeopardy Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(600, 350);
    frame.getContentPane().setBackground(Color.YELLOW);
    frame.setVisible(true);

    buttonOne = new JButton(questions.get(0).getChoiceOne());
    buttonTwo = new JButton(questions.get(0).getChoiceTwo());
    buttonThree = new JButton(questions.get(0).getChoiceThree());
    buttonFour = new JButton(questions.get(0).getChoiceFour());
    // formatting the choice buttons
    buttonOne.setForeground(Color.GREEN);
    buttonTwo.setForeground(Color.GREEN);
    buttonThree.setForeground(Color.GREEN);
    buttonFour.setForeground(Color.GREEN);
    buttonOne.setBackground(Color.BLUE);
    buttonTwo.setBackground(Color.BLUE);
    buttonThree.setBackground(Color.BLUE);
    buttonFour.setBackground(Color.BLUE);
    // adding the choice buttons to a button group
    choiceGroup = new ButtonGroup();
    choiceGroup.add(buttonOne);
    choiceGroup.add(buttonTwo);
    choiceGroup.add(buttonThree);
    choiceGroup.add(buttonFour);
    //intitializing name, answer, exit and next question button
    enterName = new JButton("Click to Enter the Game!");
    // enterAnswer = new JButton("Enter Choice");
    nextQ = new JButton("Next Question");
    exit = new JButton("Exit Game");

    // colors may be wacky
    
    // adding actionlisteners to the buttons
    enterName.addActionListener(this);
    // enterAnswer.addActionListener(this);
    nextQ.addActionListener(this);
    exit.addActionListener(this);
    exit.setForeground(Color.YELLOW);
    exit.setBackground(Color.BLACK);

  
   //Created a text field with a specifield number
    nameSpace = new JTextField(15);
    nameSpace.setActionCommand("myTF");
    nameSpace.addActionListener(this);
    name = new JLabel("Please enter your name: ");
    name.setForeground(Color.gray);


   //Declare the Welcome label 
    labelWelcome = new JLabel("Welcome to Jeopardy!");

    totalscore = new JLabel("Score: " + score);
    feedback = new JLabel("");
    showQs = new JLabel(questions.get(0).getQuestion());

    showQs.setForeground(Color.GRAY);

    //Add frame to GUI
    frame.add(labelWelcome);
    // frame.add(labelGame);
    frame.add(buttonOne);
    frame.add(buttonTwo);
    frame.add(buttonThree);
    frame.add(buttonFour);
    frame.add(nextQ);
    frame.add(enterName);
    frame.add(name);
    frame.add(nameSpace);
    frame.add(enterName);
    frame.add(totalscore);
    frame.add(showQs);
    frame.add(nextQ);
    // frame.add(enterAnswer);
    frame.add(exit);
    frame.add(feedback);
    // frame.show();
    frame.setVisible(true);
    showQs.setVisible(false);
    labelWelcome.setVisible(false);
    totalscore.setVisible(false);
    buttonOne.setVisible(false);
    buttonTwo.setVisible(false);
    buttonThree.setVisible(false);
    buttonFour.setVisible(false);
    feedback.setVisible(false);
    // enterAnswer.setVisible(false);
    nextQ.setVisible(false);

    buttonOne.addActionListener(this);
    buttonTwo.addActionListener(this);
    buttonThree.addActionListener(this);
    buttonFour.addActionListener(this);

    buttonOne.setActionCommand("buttonOne");
    buttonTwo.setActionCommand("buttonTwo");
    buttonThree.setActionCommand("buttonThree");
    buttonFour.setActionCommand("buttonFour");
  }

  int i = 0;

  void NextQuestion() {

    if (i < questions.size()) {
      showQs.setText("");
      buttonOne.setText("");
      buttonTwo.setText("");
      buttonThree.setText("");
      buttonFour.setText("");
      feedback.setText("");
      i++;

      showQs.setText(questions.get(i).getQuestion());
      buttonOne.setText(questions.get(i).getChoiceOne());
      buttonTwo.setText(questions.get(i).getChoiceTwo());
      buttonThree.setText(questions.get(i).getChoiceThree());
      buttonFour.setText(questions.get(i).getChoiceFour());

      System.out.println(questions.get(i).getQuestion());
      System.out.println(questions.get(i).getChoiceOne());
      System.out.println(questions.get(i).getChoiceTwo());
      System.out.println(questions.get(i).getChoiceThree());
      System.out.println(questions.get(i).getChoiceFour());

      // enterAnswer.setVisible(true);
    }
 //This will notify that game has ended
    //Label that displays the selection
    else {
      labelWelcome.setText("The Game Has Ended");
      showQs.setVisible(false);
      buttonOne.setVisible(false);
      buttonTwo.setVisible(false);
      buttonThree.setVisible(false);
      buttonFour.setVisible(false);
      feedback.setVisible(false);
      // enterAnswer.setVisible(false);
      nextQ.setVisible(false);
      exit.setVisible(false);

    }

  }

  // this method tallies up the score for correct answers and tells the user
  // "incorrect" if they choose incorrectly
 //Add action peformer to display the score 
  public void actionPerformed(ActionEvent ae) {
    int choiceOne = 1;
    int choiceTwo = 2;
    int choiceThree = 3;
    int choiceFour = 4;

    // if (ae.getActionCommand().equals("Enter Choice")) {
    if (ae.getActionCommand().equals("buttonOne")) {
      if (questions.get(i).getAnswer() == 1) {
        feedback.setText("Nice. You’re Correct! + 5 points");
        score += questions.get(i).getPoints();
        totalscore.setText("Your Score = " + score);
        System.out.println("yes");
      } else {
        feedback.setText("Wrong Choice");
      }
      buttonOne.setEnabled(false);
      buttonTwo.setEnabled(false);
      buttonThree.setEnabled(false);
      buttonFour.setEnabled(false);
    }

    else if (ae.getActionCommand().equals("buttonTwo")) {
      if (questions.get(i).getAnswer() == 2) {
        feedback.setText("Nice. You’re Correct! + 5 points");
        score += questions.get(i).getPoints();
        totalscore.setText("Your Score = " + score);
        System.out.println("yes");
      } else {
        feedback.setText("Wrong Choice");
      }
      buttonOne.setEnabled(false);
      buttonTwo.setEnabled(false);
      buttonThree.setEnabled(false);
      buttonFour.setEnabled(false);
    }

    else if (ae.getActionCommand().equals("buttonThree")) {
      if (questions.get(i).getAnswer() == 3) {
        feedback.setText("Nice. You’re Correct! + 5 points");
        score += questions.get(i).getPoints();
        totalscore.setText("Your Score = " + score);
        System.out.println("yes");
      } else {
        feedback.setText("Wrong Choice");
      }
      buttonOne.setEnabled(false);
      buttonTwo.setEnabled(false);
      buttonThree.setEnabled(false);
      buttonFour.setEnabled(false);
    }

    else if (ae.getActionCommand().equals("buttonFour")) {
      if (questions.get(i).getAnswer() == 4) {
        feedback.setText("Nice. You’re Correct! + 5 points");
        score += questions.get(i).getPoints();
        totalscore.setText("Your Score = " + score);
        System.out.println("yes");
      } else {
        feedback.setText("Wrong Choice");
      }
      buttonOne.setEnabled(false);
      buttonTwo.setEnabled(false);
      buttonThree.setEnabled(false);
      buttonFour.setEnabled(false);
    }

    else if (ae.getActionCommand().equals("Next Question")) {
      if (i == 5) {
        labelWelcome.setText("The Game Has Ended");
        showQs.setVisible(false);
        buttonOne.setVisible(false);
        buttonTwo.setVisible(false);
        buttonThree.setVisible(false);
        buttonFour.setVisible(false);
        feedback.setVisible(false);
        // enterAnswer.setVisible(false);
        nextQ.setVisible(false);
        exit.setVisible(false);
      } else {
        System.out.println(i);
        choiceGroup.clearSelection();
        NextQuestion();
        questions.get(i).getAnswer();
        questions.get(i).getPoints();
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(true);
        buttonThree.setEnabled(true);
        buttonFour.setEnabled(true);

        FileWriter writer;
        try {
          writer = new FileWriter("score.txt");
          BufferedWriter output = new BufferedWriter(writer);
          output.flush();
          output.close();
        }

        catch (IOException ex) {
          ex.printStackTrace();
        }

        try {
          writer = new FileWriter("score.txt");
          BufferedWriter output = new BufferedWriter(writer);
          output.write("player Score =" + score);
          output.newLine();

          output.flush();
          output.close();
        } catch (IOException exc) {
          exc.printStackTrace();
        }

      }
    }

    else if (ae.getActionCommand().equals("Click to Enter the Game!")) {
      String userName = nameSpace.getText();
      labelWelcome.setText("Welcome " + userName + " to Jeopardy");

      name.setVisible(false);
      nameSpace.setVisible(false);
      enterName.setVisible(false);
      showQs.setVisible(true);
      labelWelcome.setVisible(true);
      totalscore.setVisible(true);
      buttonOne.setVisible(true);
      buttonTwo.setVisible(true);
      buttonThree.setVisible(true);
      buttonFour.setVisible(true);
      feedback.setVisible(true);
      // enterAnswer.setVisible(true);
      nextQ.setVisible(true);
      exit.setVisible(true);

    }

    else if (ae.getActionCommand().equals("Exit Game")) {
      System.exit(0);
    }

    else {
      feedback.setText("Please click a button to continue");
    }
  }
}
