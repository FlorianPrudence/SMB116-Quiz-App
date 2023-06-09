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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import cnam.smb116.quizapp.Helpers.QuizDBHelper;
import cnam.smb116.quizapp.Model.Question;

public class QuizActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 45000;

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_QUESTION_COUNT_TOTAL = "keyQuestionCountTotal";
    private static final String KEY_MILLIS_LEFT = "keyMillisLeft";
    private static final String KEY_ANSWER = "keyAnswer";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";

    private TextView textViewQuestion, textViewScore, textViewQuestionCount, textViewCountDown;
    private Button btnAnswerA, btnAnswerB, btnAnswerC, btnAnswerD, btnAnswerE, btnAnswerF, btnAnswer;
    private CheckBox cbAnswerA, cbAnswerB, cbAnswerC, cbAnswerD, cbAnswerE, cbAnswerF, cbAnswerG, cbAnswerH, cbAnswerI, cbAnswerJ;
    private EditText textAnswer;
    private RelativeLayout btnAnswerLayout, textAnswerLayout, multipleAnswerLayout;
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
        textAnswer = findViewById(R.id.edit_text_answer);

        btnAnswerA = findViewById(R.id.button_answerA);
        btnAnswerB = findViewById(R.id.button_answerB);
        btnAnswerC = findViewById(R.id.button_answerC);
        btnAnswerD = findViewById(R.id.button_answerD);
        btnAnswerE = findViewById(R.id.button_answerE);
        btnAnswerF = findViewById(R.id.button_answerF);
        btnAnswer = findViewById(R.id.button_answer);

        cbAnswerA = findViewById(R.id.checkboxA);
        cbAnswerB = findViewById(R.id.checkboxB);
        cbAnswerC = findViewById(R.id.checkboxC);
        cbAnswerD = findViewById(R.id.checkboxD);
        cbAnswerE = findViewById(R.id.checkboxE);
        cbAnswerF = findViewById(R.id.checkboxF);
        cbAnswerG = findViewById(R.id.checkboxG);
        cbAnswerH = findViewById(R.id.checkboxH);
        cbAnswerI = findViewById(R.id.checkboxI);
        cbAnswerJ = findViewById(R.id.checkboxJ);

        btnAnswerLayout = findViewById(R.id.layout_btn_answer);
        textAnswerLayout = findViewById(R.id.layout_text_answer);
        multipleAnswerLayout = findViewById(R.id.layout_multiple_answer);

        textColorDefaultBtn = btnAnswerA.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        if (savedInstanceState == null) {
            dbHelper = new QuizDBHelper(this);
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
            handleQuestionDisplaying();
            if (!answered) {
                startCountDown();
            } else {
                btnAnswer.setText(getString(R.string.nextQuestion));
                updateCountDownText();
                showSolution();
            }
        }

        btnAnswerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "A";
                checkAnswer();
            }
        });
        btnAnswerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "B";
                checkAnswer();
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
                answer = "D";
                checkAnswer();
            }
        });
        btnAnswerE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "E";
                checkAnswer();
            }
        });
        btnAnswerF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = "F";
                checkAnswer();
            }
        });
        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered) {
                    showNextQuestion();
                }
                else {
                    switch (currentQuestion.getType()) {
                        case Text:
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                            answer = textAnswer.getText().toString().trim();
                            break;
                        case MultipleChoice:
                            answer = parseMultipleAnswer();
                            break;
                    }
                    checkAnswer();
                }
            }
        });
    }

    private void showNextQuestion() {
        cbAnswerA.setChecked(false);
        cbAnswerB.setChecked(false);
        cbAnswerC.setChecked(false);
        cbAnswerD.setChecked(false);
        cbAnswerE.setChecked(false);
        cbAnswerF.setChecked(false);
        cbAnswerG.setChecked(false);
        cbAnswerH.setChecked(false);
        cbAnswerI.setChecked(false);
        cbAnswerJ.setChecked(false);

        btnAnswerA.setTextColor(textColorDefaultBtn);
        btnAnswerB.setTextColor(textColorDefaultBtn);
        btnAnswerC.setTextColor(textColorDefaultBtn);
        btnAnswerD.setTextColor(textColorDefaultBtn);
        btnAnswerE.setTextColor(textColorDefaultBtn);
        btnAnswerF.setTextColor(textColorDefaultBtn);

        cbAnswerA.setTextColor(textColorDefaultCd);
        cbAnswerB.setTextColor(textColorDefaultCd);
        cbAnswerC.setTextColor(textColorDefaultCd);
        cbAnswerD.setTextColor(textColorDefaultCd);
        cbAnswerE.setTextColor(textColorDefaultCd);
        cbAnswerF.setTextColor(textColorDefaultCd);
        cbAnswerG.setTextColor(textColorDefaultCd);
        cbAnswerH.setTextColor(textColorDefaultCd);
        cbAnswerI.setTextColor(textColorDefaultCd);
        cbAnswerJ.setTextColor(textColorDefaultCd);

        textAnswer.setTextColor(textColorDefaultCd);
        textAnswer.getText().clear();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            btnAnswer.setText(getString(R.string.validate));
            handleQuestionDisplaying();

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            finishQuiz();
        }
    }

    private void handleQuestionDisplaying() {
        switch (currentQuestion.getType()) {
            case Text:
                btnAnswer.setEnabled(true);
                btnAnswer.setVisibility(View.VISIBLE);
                btnAnswerLayout.setVisibility(View.INVISIBLE);
                multipleAnswerLayout.setVisibility(View.INVISIBLE);
                textAnswerLayout.setVisibility(View.VISIBLE);
                textAnswer.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case SingleChoice:
                btnAnswer.setEnabled(false);
                btnAnswer.setVisibility(View.INVISIBLE);
                btnAnswerLayout.setVisibility(View.VISIBLE);
                textAnswerLayout.setVisibility(View.INVISIBLE);
                multipleAnswerLayout.setVisibility(View.INVISIBLE);

                if (currentQuestion.getOptionA() != null) {
                    btnAnswerA.setVisibility(View.VISIBLE);
                    btnAnswerA.setEnabled(true);
                    btnAnswerA.setText(currentQuestion.getOptionA());
                } else {
                    btnAnswerA.setVisibility(View.INVISIBLE);
                    btnAnswerA.setText(null);
                }

                if (currentQuestion.getOptionB() != null) {
                    btnAnswerB.setVisibility(View.VISIBLE);
                    btnAnswerB.setEnabled(true);
                    btnAnswerB.setText(currentQuestion.getOptionB());
                } else {
                    btnAnswerB.setVisibility(View.INVISIBLE);
                    btnAnswerB.setText(null);
                }

                if (currentQuestion.getOptionC() != null) {
                    btnAnswerC.setVisibility(View.VISIBLE);
                    btnAnswerC.setEnabled(true);
                    btnAnswerC.setText(currentQuestion.getOptionC());
                } else {
                    btnAnswerC.setVisibility(View.INVISIBLE);
                    btnAnswerC.setText(null);
                }

                if (currentQuestion.getOptionD() != null) {
                    btnAnswerD.setVisibility(View.VISIBLE);
                    btnAnswerD.setEnabled(true);
                    btnAnswerD.setText(currentQuestion.getOptionD());
                } else {
                    btnAnswerD.setVisibility(View.INVISIBLE);
                    btnAnswerD.setText(null);
                }

                if (currentQuestion.getOptionE() != null) {
                    btnAnswerE.setVisibility(View.VISIBLE);
                    btnAnswerE.setEnabled(true);
                    btnAnswerE.setText(currentQuestion.getOptionE());
                } else {
                    btnAnswerE.setVisibility(View.INVISIBLE);
                    btnAnswerE.setText(null);
                }

                if (currentQuestion.getOptionF() != null) {
                    btnAnswerF.setVisibility(View.VISIBLE);
                    btnAnswerF.setEnabled(true);
                    btnAnswerF.setText(currentQuestion.getOptionF());
                } else {
                    btnAnswerF.setVisibility(View.INVISIBLE);
                    btnAnswerF.setText(null);
                }

                break;
            case MultipleChoice:
                btnAnswer.setEnabled(true);
                btnAnswer.setVisibility(View.VISIBLE);
                btnAnswerLayout.setVisibility(View.INVISIBLE);
                textAnswerLayout.setVisibility(View.INVISIBLE);
                multipleAnswerLayout.setVisibility(View.VISIBLE);

                if (currentQuestion.getOptionA() != null) {
                    cbAnswerA.setVisibility(View.VISIBLE);
                    cbAnswerA.setEnabled(true);
                    cbAnswerA.setText(currentQuestion.getOptionA());
                } else {
                    cbAnswerA.setVisibility(View.INVISIBLE);
                    cbAnswerA.setText(null);
                }

                if (currentQuestion.getOptionB() != null) {
                    cbAnswerB.setVisibility(View.VISIBLE);
                    cbAnswerB.setEnabled(true);
                    cbAnswerB.setText(currentQuestion.getOptionB());
                } else {
                    cbAnswerB.setVisibility(View.INVISIBLE);
                    cbAnswerB.setText(null);
                }

                if (currentQuestion.getOptionC() != null) {
                    cbAnswerC.setVisibility(View.VISIBLE);
                    cbAnswerC.setEnabled(true);
                    cbAnswerC.setText(currentQuestion.getOptionC());
                } else {
                    cbAnswerC.setVisibility(View.INVISIBLE);
                    cbAnswerC.setText(null);
                }

                if (currentQuestion.getOptionD() != null) {
                    cbAnswerD.setVisibility(View.VISIBLE);
                    cbAnswerD.setEnabled(true);
                    cbAnswerD.setText(currentQuestion.getOptionD());
                } else {
                    cbAnswerD.setVisibility(View.INVISIBLE);
                    cbAnswerD.setText(null);
                }

                if (currentQuestion.getOptionE() != null) {
                    cbAnswerE.setVisibility(View.VISIBLE);
                    cbAnswerE.setEnabled(true);
                    cbAnswerE.setText(currentQuestion.getOptionE());
                } else {
                    cbAnswerE.setVisibility(View.INVISIBLE);
                    cbAnswerE.setText(null);
                }

                if (currentQuestion.getOptionF() != null) {
                    cbAnswerF.setVisibility(View.VISIBLE);
                    cbAnswerF.setEnabled(true);
                    cbAnswerF.setText(currentQuestion.getOptionF());
                } else {
                    cbAnswerF.setVisibility(View.INVISIBLE);
                    cbAnswerF.setText(null);
                }

                if (currentQuestion.getOptionG() != null) {
                    cbAnswerG.setVisibility(View.VISIBLE);
                    cbAnswerG.setEnabled(true);
                    cbAnswerG.setText(currentQuestion.getOptionG());
                } else {
                    cbAnswerG.setVisibility(View.INVISIBLE);
                    cbAnswerG.setText(null);
                }

                if (currentQuestion.getOptionH() != null) {
                    cbAnswerH.setVisibility(View.VISIBLE);
                    cbAnswerH.setEnabled(true);
                    cbAnswerH.setText(currentQuestion.getOptionH());
                } else {
                    cbAnswerH.setVisibility(View.INVISIBLE);
                    cbAnswerH.setText(null);
                }

                if (currentQuestion.getOptionI() != null) {
                    cbAnswerI.setVisibility(View.VISIBLE);
                    cbAnswerI.setEnabled(true);
                    cbAnswerI.setText(currentQuestion.getOptionI());
                } else {
                    cbAnswerI.setVisibility(View.INVISIBLE);
                    cbAnswerI.setText(null);
                }

                if (currentQuestion.getOptionJ() != null) {
                    cbAnswerJ.setVisibility(View.VISIBLE);
                    cbAnswerJ.setEnabled(true);
                    cbAnswerJ.setText(currentQuestion.getOptionJ());
                } else {
                    cbAnswerJ.setVisibility(View.INVISIBLE);
                    cbAnswerJ.setText(null);
                }
                break;
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
                switch (currentQuestion.getType()) {
                    case Text:
                        answer = textAnswer.getText().toString().trim();
                        break;
                    case MultipleChoice:
                        answer = parseMultipleAnswer();
                        break;
                }
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
        btnAnswer.setVisibility(View.VISIBLE);
        btnAnswer.setEnabled(true);
        if (questionCounter < questionCountTotal)
            btnAnswer.setText(getString(R.string.nextQuestion));
        else
            btnAnswer.setText(getString(R.string.finish));
        switch (currentQuestion.getType()) {
            case Text:
                textAnswer.setInputType(InputType.TYPE_NULL);
                if(answer.equalsIgnoreCase(currentQuestion.getCorrectAnswer())) {
                    textAnswer.setTextColor(Color.GREEN);
                } else {
                    textAnswer.setTextColor(Color.RED);
                    textAnswer.setText(correctAnswer);
                }
                break;
            case SingleChoice:
                btnAnswerA.setTextColor(Color.RED);
                btnAnswerB.setTextColor(Color.RED);
                btnAnswerC.setTextColor(Color.RED);
                btnAnswerD.setTextColor(Color.RED);
                btnAnswerE.setTextColor(Color.RED);
                btnAnswerF.setTextColor(Color.RED);

                btnAnswerA.setEnabled(false);
                btnAnswerB.setEnabled(false);
                btnAnswerC.setEnabled(false);
                btnAnswerD.setEnabled(false);
                btnAnswerE.setEnabled(false);
                btnAnswerF.setEnabled(false);

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
                }
                break;
            case MultipleChoice:
                cbAnswerA.setTextColor(Color.RED);
                cbAnswerB.setTextColor(Color.RED);
                cbAnswerC.setTextColor(Color.RED);
                cbAnswerD.setTextColor(Color.RED);
                cbAnswerE.setTextColor(Color.RED);
                cbAnswerF.setTextColor(Color.RED);
                cbAnswerG.setTextColor(Color.RED);
                cbAnswerH.setTextColor(Color.RED);
                cbAnswerI.setTextColor(Color.RED);
                cbAnswerJ.setTextColor(Color.RED);

                cbAnswerA.setEnabled(false);
                cbAnswerB.setEnabled(false);
                cbAnswerC.setEnabled(false);
                cbAnswerD.setEnabled(false);
                cbAnswerE.setEnabled(false);
                cbAnswerF.setEnabled(false);
                cbAnswerG.setEnabled(false);
                cbAnswerH.setEnabled(false);
                cbAnswerI.setEnabled(false);
                cbAnswerJ.setEnabled(false);

                String cAnswer = currentQuestion.getCorrectAnswer();

                if(cAnswer.contains("A"))
                    cbAnswerA.setTextColor(Color.GREEN);
                if(cAnswer.contains("B"))
                    cbAnswerB.setTextColor(Color.GREEN);
                if(cAnswer.contains("C"))
                    cbAnswerC.setTextColor(Color.GREEN);
                if(cAnswer.contains("D"))
                    cbAnswerD.setTextColor(Color.GREEN);
                if(cAnswer.contains("E"))
                    cbAnswerE.setTextColor(Color.GREEN);
                if(cAnswer.contains("F"))
                    cbAnswerF.setTextColor(Color.GREEN);
                if(cAnswer.contains("E"))
                    cbAnswerE.setTextColor(Color.GREEN);
                if(cAnswer.contains("F"))
                    cbAnswerF.setTextColor(Color.GREEN);
                if(cAnswer.contains("G"))
                    cbAnswerG.setTextColor(Color.GREEN);
                if(cAnswer.contains("H"))
                    cbAnswerH.setTextColor(Color.GREEN);
                if(cAnswer.contains("I"))
                    cbAnswerG.setTextColor(Color.GREEN);
                if(cAnswer.contains("J"))
                    cbAnswerH.setTextColor(Color.GREEN);
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

    private String parseMultipleAnswer() {
        StringBuilder blr = new StringBuilder();
        if(cbAnswerA.isChecked())
            blr.append("A;");
        if(cbAnswerB.isChecked())
            blr.append("B;");
        if(cbAnswerC.isChecked())
            blr.append("C;");
        if(cbAnswerD.isChecked())
            blr.append("D;");
        if(cbAnswerE.isChecked())
            blr.append("E;");
        if(cbAnswerF.isChecked())
            blr.append("F;");
        if(cbAnswerG.isChecked())
            blr.append("G;");
        if(cbAnswerH.isChecked())
            blr.append("H;");
        if(cbAnswerI.isChecked())
            blr.append("I;");
        if(cbAnswerJ.isChecked())
            blr.append("J");

        if(blr.length() > 0 && blr.charAt(blr.length() - 1) == ';')
            blr.deleteCharAt(blr.length() - 1);

        //Toast.makeText(this, blr.toString(), Toast.LENGTH_SHORT).show();
        return blr.toString();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            setResult(RESULT_CANCELED);
            finish();
        } else {
            Toast.makeText(this, "Press back again to leave", Toast.LENGTH_SHORT).show();
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