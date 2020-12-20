package com.codecademy.unquote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // TODO #1: add integer member variables here
    int currentQuestionIndex;
    int totalCorrect;
    int totalQuestions;

    // TODO #2: add ArrayList member variable here
    ArrayList <Question> questions = new ArrayList<Question>();

    //TODO 3-A: Declare Member Variables

    ImageView questionImageView;
    TextView questionTextView;
    TextView questionsRemainingTextView;
    Button answer0Button;
    Button answer1Button;
    Button answer2Button;
    Button answer3Button;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO 2-G: Show app icon in ActionBar

        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_unquote_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setElevation(0);

        // TODO 3-B: assign View member variables

        questionImageView = findViewById(R.id.iv_main_question_image);
        questionTextView = findViewById(R.id.tv_main_question_title);
        questionsRemainingTextView = findViewById(R.id.tv_main_questions_remaining);
        answer0Button = findViewById(R.id.btn_main_answer_0);
        answer1Button = findViewById(R.id.btn_main_answer_1);
        answer2Button = findViewById(R.id.btn_main_answer_2);
        answer3Button = findViewById(R.id.btn_main_answer_3);
        submitButton = findViewById(R.id.btn_main_submit_answer);

        // TODO 4-E: set onClickListener for each answer Button


        answer0Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click-handling logic
                onAnswerSelected(0);
            }
        });

        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(1);
            }
        });

        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(2);
            }
        });

        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(3);
            }
        });


        // TODO 5-A: set onClickListener for the submit answer Button

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSubmission();
            }
        });

        startNewGame();
    }

    // TODO 3-F:
    public void displayQuestion(Question question) {

        questionImageView.setImageResource(question.imageId);
        questionTextView.setText(question.questionText);

        //answers
        answer0Button.setText(question.answer0);
        answer1Button.setText(question.answer1);
        answer2Button.setText(question.answer2);
        answer3Button.setText(question.answer3);
    }

    // TODO 3-C:

    public void displayQuestionsRemaining(int questionRemaining) {
        questionsRemainingTextView.setText(String.valueOf(questionRemaining));
    }

    // TODO 4-A:
    public void  onAnswerSelected(int answerSelected) {
        Question currentQuestion = getCurrentQuestion();
        currentQuestion.playerAnswer = answerSelected;
        String checkMark = "✔";

        answer0Button.setText(currentQuestion.answer0);
        answer1Button.setText(currentQuestion.answer1);
        answer2Button.setText(currentQuestion.answer2);
        answer3Button.setText(currentQuestion.answer3);

            if (answerSelected == 0) {
                answer0Button.setText("✔ " + currentQuestion.answer0);
            } else if (answerSelected == 1) {
                answer1Button.setText("✔ " + currentQuestion.answer1);
            } else if (answerSelected == 2) {
                answer2Button.setText("✔ " + currentQuestion.answer2);
            } else if (answerSelected == 3) {
                answer3Button.setText("✔ " + currentQuestion.answer3);
            }

    }


    // TODO #3 add startNewGame() here
    void startNewGame() {
        questions = new ArrayList<>();

        // TODO 2-H: Provide actual drawables for each of these questions!
        Question question0 = new Question( R.drawable.img_quote_0, "Pretty good advice, and perhaps a scientist did say it...Who actually did?", "Albert Einstein", "Isaac Newton", "Rita Mae Brown", "Rosalind Franklin", 2);
        Question question1 = new Question(R.drawable.img_quote_1, "Was honest Abe honestly quoted? Who authored this pithy bit of wisdom?", "Edward Stieglitz", "Maya Angelou", "Abraham Lincoln", "Ralph Waldo Emerson", 0);
        Question question2 = new Question(R.drawable.img_quote_2, "Easy advice to read, difficult advice to follow -- who actually said it?", "Martin Luther King Jr", "Mother Teresa", "Fred Rogers", "Oprah Winfrey", 1);
        Question question3 = new Question(R.drawable.img_quote_3, "Insanely inspiring. insanely incorrect (maybe). Who is the true source of this inspiration?", "Nelson Mandela", "Harriet Tubman", "Mahatma Gandhi ", "Nicholas Klein", 3);
        Question question4 = new Question(R.drawable.img_quote_4, "A peace worth striving for -- who actually reminded us of this?", "Malala Yousafzai ", "Martin Luther King Jr. ", "Liu Xiaobo ", "Dalai Lama", 1);
        Question question5 = new Question(R.drawable.img_quote_5, "Unfortunately, true -- but did Marilyn Monroe convey it or did someone else?", "Laurel Thatcher Ulrich", "Eleanor Roosevelt ", "Marilyn Monroe", "Queen Victoria", 0);
        Question question6 = new Question(R.drawable.img_quote_6, "Here’s the truth, Will Smith did say this, but in which movie?", "Independence Day", "Bad Boys", "Men In Black", "Pursuit of Happiness", 2 );
        Question question7 = new Question(R.drawable.img_quote_7, "Which TV funny gal actually quipped this 1-liner?", "Ellen Degeneres", "Amy Poehler", "Betty White", "Tina Fey", 3);
        Question question8 = new Question(R.drawable.img_quote_8, "Did he actually give this advice?", "Forrest Gump", "Dory (Finding Nemo)", "Esther Williams", "The Mayor Jaws", 1);
        Question question9 = new Question(R.drawable.img_quote_9, "Whose heart will go on?", "Whitney Houston", "Diana Ross", "Celine Dion", "Mariah Carey", 0);
        Question question10 = new Question(R.drawable.img_quote_10, "This person is the king of something alright, who said this?", "Tony Montana, Scarface", "Joker, The Dark Knight", "Lex Luthor, Batman v Superman", "Jack, Titanic", 3);
        Question question11 = new Question(R.drawable.img_quote_11, "Is Grey synonymous for wise? Did Gandalf actually say this?", "Yoda, Star Wars", "Gandalf the Grey, Lord of the Rings", "Dumbledore, Harry Potter", "Uncle Ben, Spider-man", 0);
        Question question12 = new Question(R.drawable.img_quote_12, "Houston we have a problem -- which space traveler actually does this the phrase belong to?", "Han Solo, Star Wars", "Captain Kirk, Star Trek", "Buzz Lightyear, Toy Story", "Jim Lovell, Apollo 13", 2);


        questions.add(question0);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);
        questions.add(question8);
        questions.add(question9);
        questions.add(question10);
        questions.add(question11);
        questions.add(question12);

        totalCorrect = 0;
        totalQuestions = questions.size();

        Question firstQuestion = chooseNewQuestion();

        // TODO 3-D.ii: Uncomment the line below after implementing displayQuestionsRemaining(int)
         displayQuestionsRemaining(questions.size());

        // TODO 3-H.ii: Uncomment after implementing displayQuestion(Question)
         displayQuestion(firstQuestion);
    }


    // TODO #4 add chooseNewQuestion() here
    Question chooseNewQuestion() {
        int randomQuestionNumber;
        randomQuestionNumber = generateRandomNumber(questions.size());

        currentQuestionIndex = randomQuestionNumber;

        return questions.get(currentQuestionIndex);
    }
    // TODO #5 add getCurrentQuestion() here
    Question getCurrentQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        return currentQuestion;
    }

    // TODO #6 add onAnswerSubmission() here
    void onAnswerSubmission() {
        Question currentQuestion = getCurrentQuestion();

        if(currentQuestion.playerAnswer == -1) {
            return;
        }

        if (currentQuestion.isCorrect()) {
            totalCorrect = totalCorrect + 1;
        }
        questions.remove(currentQuestion);

        // TODO 3-D.i: Uncomment the line below after implementing displayQuestionsRemaining(int)
         displayQuestionsRemaining(questions.size());

        if (questions.size() == 0) {
            String gameOverMessage = getGameOverMessage(totalCorrect, totalQuestions);

            // TODO 5-D: Show a popup instead
            AlertDialog.Builder gameOverDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            gameOverDialogBuilder.setCancelable(false);
            gameOverDialogBuilder.setTitle("Game Over!");

            //5-E
            gameOverDialogBuilder.setMessage(gameOverMessage);

            gameOverDialogBuilder.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startNewGame();
                }
            });

            gameOverDialogBuilder.create().show();

        } else {
            chooseNewQuestion();

            // TODO 3-H.i: uncomment after implementing displayQuestion(Question)
             displayQuestion(getCurrentQuestion());
        }
    }

    int generateRandomNumber(int max) {
        double randomNumber = Math.random();
        double result = max * randomNumber;
        return (int) result;
    }

    String getGameOverMessage(int totalCorrect, int totalQuestions) {
        if (totalCorrect == totalQuestions) {
            return "You got all " + totalQuestions + " right! You won!";
        } else {
            return "You got " + totalCorrect + " right out of " + totalQuestions + ". Better luck next time!";
        }
    }
}