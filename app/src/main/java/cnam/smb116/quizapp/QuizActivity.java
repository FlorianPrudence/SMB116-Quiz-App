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
    private Button btnAnswerA, btnAnswerB, btnAnswerC, btnAnswerD, btnAnswerE, btnAnswerF, btnAnswerG, btnAnswerH, btnAnswerI, btnAnswerJ, btnAnswerText;
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
    private QuizDBHelper dbHelper;

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

        btnAnswerA = findViewById(R.id.button_answerA);
        btnAnswerB = findViewById(R.id.button_answerB);
        btnAnswerC = findViewById(R.id.button_answerC);
        btnAnswerD = findViewById(R.id.button_answerD);
        btnAnswerE = findViewById(R.id.button_answerE);
        btnAnswerF = findViewById(R.id.button_answerF);
        btnAnswerG = findViewById(R.id.button_answerG);
        btnAnswerH = findViewById(R.id.button_answerH);
        btnAnswerI = findViewById(R.id.button_answerI);
        btnAnswerJ = findViewById(R.id.button_answerJ);
        btnAnswerText = findViewById(R.id.button_text_answer);

        btnAnswerLayout = findViewById(R.id.layout_btn_answer);
        textAnswerLayout = findViewById(R.id.layout_text_answer);

        textColorDefaultBtn = btnAnswerA.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        if (savedInstanceState == null) {
            dbHelper = new QuizDBHelper(this);
            questionCountTotal = getIntent().getIntExtra(QUESTION_QTY, dbHelper.countQuestionsByType(Question.QuestionType.SingleChoice));
            questionList = dbHelper.getQuestionsByType(Question.QuestionType.SingleChoice);
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
                    btnAnswerText.setText("Confirm");
                    break;
                case SingleChoice:
                    btnAnswerLayout.setVisibility(View.VISIBLE);
                    textAnswerLayout.setVisibility(View.INVISIBLE);
                    break;
            }

            if (!answered) {
                startCountDown();
            } else {
                btnAnswerText.setText("Next question");
                updateCountDownText();
                showSolution();
            }
        }

        btnAnswerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "A";
                    checkAnswer();
                }
            }
        });
        btnAnswerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "B";
                    checkAnswer();
                }
            }
        });
        btnAnswerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "C";
                    checkAnswer();
                }
            }
        });
        btnAnswerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "D";
                    checkAnswer();
                }
            }
        });
        btnAnswerE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "E";
                    checkAnswer();
                }
            }
        });
        btnAnswerF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "F";
                    checkAnswer();
                }
            }
        });
        btnAnswerG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "G";
                    checkAnswer();
                }
            }
        });
        btnAnswerH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "H";
                    checkAnswer();
                }
            }
        });
        btnAnswerI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "I";
                    checkAnswer();
                }
            }
        });
        btnAnswerJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered)
                    showNextQuestion();
                else {
                    answer = "J";
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
        btnAnswerA.setTextColor(textColorDefaultBtn);
        btnAnswerB.setTextColor(textColorDefaultBtn);
        btnAnswerC.setTextColor(textColorDefaultBtn);
        btnAnswerD.setTextColor(textColorDefaultBtn);
        btnAnswerE.setTextColor(textColorDefaultBtn);
        btnAnswerF.setTextColor(textColorDefaultBtn);
        btnAnswerG.setTextColor(textColorDefaultBtn);
        btnAnswerH.setTextColor(textColorDefaultBtn);
        btnAnswerI.setTextColor(textColorDefaultBtn);
        btnAnswerJ.setTextColor(textColorDefaultBtn);
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
                    btnAnswerText.setText("Confirm");
                    break;
                case SingleChoice:
                    btnAnswerLayout.setVisibility(View.VISIBLE);
                    textAnswerLayout.setVisibility(View.INVISIBLE);
                    break;
            }

            if (currentQuestion.getOptionA() != null) {
                btnAnswerA.setVisibility(View.VISIBLE);
                btnAnswerA.setEnabled(true);
                btnAnswerA.setText(currentQuestion.getOptionA());
            } else {
                btnAnswerA.setVisibility(View.INVISIBLE);
                btnAnswerA.setEnabled(true);
            }

            if (currentQuestion.getOptionB() != null) {
                btnAnswerB.setVisibility(View.VISIBLE);
                btnAnswerB.setEnabled(true);
                btnAnswerB.setText(currentQuestion.getOptionB());
            } else {
                btnAnswerB.setVisibility(View.INVISIBLE);
                btnAnswerB.setEnabled(true);
            }

            if (currentQuestion.getOptionC() != null) {
                btnAnswerC.setVisibility(View.VISIBLE);
                btnAnswerC.setEnabled(true);
                btnAnswerC.setText(currentQuestion.getOptionC());
            } else {
                btnAnswerC.setVisibility(View.INVISIBLE);
                btnAnswerC.setEnabled(true);
            }

            if (currentQuestion.getOptionD() != null) {
                btnAnswerD.setVisibility(View.VISIBLE);
                btnAnswerD.setEnabled(true);
                btnAnswerD.setText(currentQuestion.getOptionD());
            } else {
                btnAnswerD.setVisibility(View.INVISIBLE);
                btnAnswerD.setEnabled(true);
            }

            if (currentQuestion.getOptionE() != null) {
                btnAnswerE.setVisibility(View.VISIBLE);
                btnAnswerE.setEnabled(true);
                btnAnswerE.setText(currentQuestion.getOptionE());
            } else {
                btnAnswerE.setVisibility(View.INVISIBLE);
                btnAnswerE.setEnabled(true);
            }

            if (currentQuestion.getOptionF() != null) {
                btnAnswerF.setVisibility(View.VISIBLE);
                btnAnswerF.setEnabled(true);
                btnAnswerF.setText(currentQuestion.getOptionF());
            } else {
                btnAnswerF.setVisibility(View.INVISIBLE);
                btnAnswerF.setEnabled(true);
            }

            if (currentQuestion.getOptionG() != null) {
                btnAnswerG.setVisibility(View.VISIBLE);
                btnAnswerG.setEnabled(true);
                btnAnswerG.setText(currentQuestion.getOptionG());
            } else {
                btnAnswerG.setVisibility(View.INVISIBLE);
                btnAnswerG.setEnabled(true);
            }

            if (currentQuestion.getOptionH() != null) {
                btnAnswerH.setVisibility(View.VISIBLE);
                btnAnswerH.setEnabled(true);
                btnAnswerH.setText(currentQuestion.getOptionH());
            } else {
                btnAnswerH.setVisibility(View.INVISIBLE);
                btnAnswerH.setEnabled(true);
            }

            if (currentQuestion.getOptionI() != null) {
                btnAnswerI.setVisibility(View.VISIBLE);
                btnAnswerI.setEnabled(true);
                btnAnswerI.setText(currentQuestion.getOptionI());
            } else {
                btnAnswerI.setVisibility(View.INVISIBLE);
                btnAnswerI.setEnabled(true);
            }

            if (currentQuestion.getOptionJ() != null) {
                btnAnswerJ.setVisibility(View.VISIBLE);
                btnAnswerJ.setEnabled(true);
                btnAnswerJ.setText(currentQuestion.getOptionJ());
            } else {
                btnAnswerJ.setVisibility(View.INVISIBLE);
                btnAnswerJ.setEnabled(true);
            }

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
                    btnAnswerText.setText("Next Question");
                else
                    btnAnswerText.setText("Finish");
                break;
            case SingleChoice:
                btnAnswerA.setTextColor(Color.RED);
                btnAnswerB.setTextColor(Color.RED);
                btnAnswerC.setTextColor(Color.RED);
                btnAnswerD.setTextColor(Color.RED);
                btnAnswerE.setTextColor(Color.RED);
                btnAnswerF.setTextColor(Color.RED);
                btnAnswerG.setTextColor(Color.RED);
                btnAnswerH.setTextColor(Color.RED);
                btnAnswerI.setTextColor(Color.RED);
                btnAnswerJ.setTextColor(Color.RED);
                switch (currentQuestion.getCorrectAnswer()) {
                    case "A":
                        btnAnswerA.setTextColor(Color.GREEN);
                        break;
                    case "B":
                        btnAnswerB.setTextColor(Color.GREEN);
                        break;
                    case "C":
                        btnAnswerC.setTextColor(Color.GREEN);
                        break;
                    case "D":
                        btnAnswerD.setTextColor(Color.GREEN);
                        break;
                    case "E":
                        btnAnswerE.setTextColor(Color.GREEN);
                        break;
                    case "F":
                        btnAnswerF.setTextColor(Color.GREEN);
                        break;
                    case "G":
                        btnAnswerG.setTextColor(Color.GREEN);
                        break;
                    case "H":
                        btnAnswerH.setTextColor(Color.GREEN);
                        break;
                    case "I":
                        btnAnswerI.setTextColor(Color.GREEN);
                        break;
                    case "J":
                        btnAnswerJ.setTextColor(Color.GREEN);
                        break;
                }
                break;
        }
    }

    private void finishQuiz() {
        dbHelper.insertResult(score, questionCountTotal);

        Intent resultIntent = new Intent();
        if(questionCountTotal == MainActivity.FULL_TEST_QUESTION_COUNT)
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
            Toast.makeText(this, "Appuyez à nouveau sur retour pour quitter", Toast.LENGTH_SHORT).show();
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