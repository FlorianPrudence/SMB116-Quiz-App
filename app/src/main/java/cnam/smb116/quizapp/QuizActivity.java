package cnam.smb116.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;

    private Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4, btnNext;

    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;
    private boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);

        btnAnswer1 = findViewById(R.id.button_answer1);
        btnAnswer2 = findViewById(R.id.button_answer2);
        btnAnswer3 = findViewById(R.id.button_answer3);
        btnAnswer4 = findViewById(R.id.button_answer4);
        btnNext = findViewById(R.id.button_next);

        QuestionDBHelper dbHelper = new QuestionDBHelper(this);
        questionList = dbHelper.getAllQuestions();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        showNextQuestion();

        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(1);
            }
        });
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(2);
            }
        });
        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(3);
            }
        });
        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(4);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextQuestion();
            }
        });
    }

    private void showNextQuestion() {
        btnNext.setVisibility(View.INVISIBLE);
        btnAnswer1.setTextColor(Color.WHITE);
        btnAnswer2.setTextColor(Color.WHITE);
        btnAnswer3.setTextColor(Color.WHITE);
        btnAnswer4.setTextColor(Color.WHITE);

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            btnAnswer1.setText(currentQuestion.getOption1());
            btnAnswer2.setText(currentQuestion.getOption2());
            btnAnswer3.setText(currentQuestion.getOption3());
            btnAnswer4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
        } else {
            finishQuiz();
        }
    }

    private void checkAnswer(int index) {
        answered = true;

        if (index == currentQuestion.getCorrectAnswer()) {
            score++;
            textViewScore.setText("Score: " + score);
        }

        showSolution();
    }

    private void showSolution() {
        btnAnswer1.setTextColor(Color.RED);
        btnAnswer2.setTextColor(Color.RED);
        btnAnswer3.setTextColor(Color.RED);
        btnAnswer4.setTextColor(Color.RED);

        switch (currentQuestion.getCorrectAnswer()) {
            case 1:
                btnAnswer1.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 1 is correct");
                break;
            case 2:
                btnAnswer2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 2 is correct");
                break;
            case 3:
                btnAnswer3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 3 is correct");
                break;
            case 4:
                btnAnswer4.setTextColor(Color.GREEN);
                textViewQuestion.setText("Answer 4 is correct");
                break;
        }

        if (questionCounter < questionCountTotal) {
            btnNext.setVisibility(View.VISIBLE);
            btnNext.setText("Next");
        } else {
            btnNext.setVisibility(View.VISIBLE);
            btnNext.setText("Finish");
        }
    }

    private void finishQuiz() {
        finish();
    }
}