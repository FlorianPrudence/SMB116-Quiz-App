package cnam.smb116.quizapp;

import static cnam.smb116.quizapp.MainActivity.QUESTION_QTY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {
    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_QUESTION_COUNT_TOTAL = "keyQuestionCountTotal";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWER = "keyAnswer";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";

    private TextView textViewQuestion, textViewScore, textViewQuestionCount, textViewCountDown, textViewExplanation;
    private Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4, btnAnswerText;
    private EditText textAnswer;
    private RelativeLayout btnAnswerLayout, textAnswerLayout;
    private ColorStateList textColorDefaultBtn, textColorDefaultCd;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis, backPressedTime;
    private ArrayList<Question> questionList;
    private int questionCounter, questionCountTotal, score;
    private Question currentQuestion;
    private boolean answered;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        textViewExplanation = findViewById(R.id.text_view_explanation);
        textAnswer = findViewById(R.id.edit_text_answer);

        btnAnswer1 = findViewById(R.id.button_answer1);
        btnAnswer2 = findViewById(R.id.button_answer2);
        btnAnswer3 = findViewById(R.id.button_answer3);
        btnAnswer4 = findViewById(R.id.button_answer4);
        btnAnswerText = findViewById(R.id.button_text_answer);

        btnAnswerLayout = findViewById(R.id.layout_btn_answer);
        textAnswerLayout = findViewById(R.id.layout_text_answer);

        textColorDefaultBtn = btnAnswer1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        if (savedInstanceState == null) {
            QuestionDBHelper dbHelper = new QuestionDBHelper(this);
            questionCountTotal = getIntent().getIntExtra(QUESTION_QTY, dbHelper.countAllQuestions());
            questionList = dbHelper.getAllQuestions();
            Collections.shuffle(questionList);
            showNextQuestion();
        } else {
            questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);
            questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
            questionCountTotal = savedInstanceState.getInt(KEY_QUESTION_COUNT_TOTAL);
            currentQuestion = questionList.get(questionCounter - 1);
            score = savedInstanceState.getInt(KEY_SCORE);
            timeLeftInMillis = savedInstanceState.getLong(KEY_MILLIS_LEFT);
            answered = savedInstanceState.getBoolean(KEY_ANSWERED);
            answer = savedInstanceState.getString(KEY_ANSWER);
            switch (currentQuestion.getType()) {
                case Text:
                    btnAnswerLayout.setVisibility(View.INVISIBLE);
                    textAnswerLayout.setVisibility(View.VISIBLE);
                    textAnswer.setInputType(InputType.TYPE_CLASS_TEXT);
                    btnAnswerText.setText("Confirmer");
                    break;
                case MultipleChoices:
                    btnAnswerLayout.setVisibility(View.VISIBLE);
                    textAnswerLayout.setVisibility(View.INVISIBLE);
                    break;
            }

            if (!answered) {
                startCountDown();
            } else {
                btnAnswerText.setText("Next");
                updateCountDownText();
                showSolution();
            }
        }

        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "1";
                    checkAnswer();
                }
            }
        });
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "2";
                    checkAnswer();
                }
            }
        });
        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "3";
                    checkAnswer();
                }
            }
        });
        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "4";
                    checkAnswer();
                }
            }
        });
        btnAnswerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                if(answered)
                    showNextQuestion();
                else {
                    answer = textAnswer.getText().toString().trim();
                    checkAnswer();
                }
            }
        });
    }

    private void showNextQuestion() {
        btnAnswer1.setTextColor(textColorDefaultBtn);
        btnAnswer2.setTextColor(textColorDefaultBtn);
        btnAnswer3.setTextColor(textColorDefaultBtn);
        btnAnswer4.setTextColor(textColorDefaultBtn);
        textAnswer.setTextColor(textColorDefaultCd);
        textAnswer.getText().clear();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            textViewExplanation.setText("");

            switch (currentQuestion.getType()) {
                case Text:
                    btnAnswerLayout.setVisibility(View.INVISIBLE);
                    textAnswerLayout.setVisibility(View.VISIBLE);
                    textAnswer.setInputType(InputType.TYPE_CLASS_TEXT);
                    btnAnswerText.setText("Confirmer");
                    break;
                case MultipleChoices:
                    btnAnswerLayout.setVisibility(View.VISIBLE);
                    textAnswerLayout.setVisibility(View.INVISIBLE);
                    break;
            }

            btnAnswer1.setText(currentQuestion.getOption1());
            btnAnswer2.setText(currentQuestion.getOption2());
            btnAnswer3.setText(currentQuestion.getOption3());
            btnAnswer4.setText(currentQuestion.getOption4());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis < 10000) {
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }

    private void checkAnswer() {
        answered = true;
        countDownTimer.cancel();

        if (answer != null && answer.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
            score++;
            textViewScore.setText("Score: " + score);
        }
        showSolution();
    }

    private void showSolution() {
        String correctAnswer = currentQuestion.getCorrectAnswer();
        textViewExplanation.setText(currentQuestion.getExplanation());
        switch (currentQuestion.getType()) {
            case Text:
                textAnswer.setInputType(InputType.TYPE_NULL);
                if(answer.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
                    textAnswer.setTextColor(Color.GREEN);
                } else {
                    textAnswer.setTextColor(Color.RED);
                    textAnswer.setText(correctAnswer);
                }
                if (questionCounter < questionCountTotal)
                    btnAnswerText.setText("Next");
                else
                    btnAnswerText.setText("Finish");
                break;
            case MultipleChoices:
                btnAnswer1.setTextColor(Color.RED);
                btnAnswer2.setTextColor(Color.RED);
                btnAnswer3.setTextColor(Color.RED);
                btnAnswer4.setTextColor(Color.RED);
                switch (currentQuestion.getCorrectAnswer()) {
                    case "1":
                        btnAnswer1.setTextColor(Color.GREEN);
                        break;
                    case "2":
                        btnAnswer2.setTextColor(Color.GREEN);
                        break;
                    case "3":
                        btnAnswer3.setTextColor(Color.GREEN);
                        break;
                    case "4":
                        btnAnswer4.setTextColor(Color.GREEN);
                        break;
                }
                break;
        }
    }

    private void finishQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            setResult(RESULT_CANCELED);
            finish();
        } else {
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putInt(KEY_QUESTION_COUNT_TOTAL, questionCountTotal);
        outState.putLong(KEY_MILLIS_LEFT, timeLeftInMillis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putString(KEY_ANSWER, answer);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, questionList);
    }
}