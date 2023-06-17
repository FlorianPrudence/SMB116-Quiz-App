package cnam.smb116.quizapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_HIGHSCORE = "quizzHighScore";
    public static final String QUESTION_QTY = "quizzQuestionQty";

    public static final int FULL_TEST_QUESTION_COUNT = 80;
    private TextView textViewHighscore;
    private int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadHighscore();

        Button buttonStartFullQuiz = findViewById(R.id.button_start_full_quiz);
        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        Button buttonSeeResults = findViewById(R.id.button_see_results);
        EditText editTextQuestionQty = findViewById(R.id.edit_text_question_qty);

        QuizDBHelper dbHelper = new QuizDBHelper(this);
        int questionCount = dbHelper.countAllQuestions();

        if(questionCount < FULL_TEST_QUESTION_COUNT)
            buttonStartFullQuiz.setEnabled(false);

        editTextQuestionQty.setFilters( new InputFilter[]{ new MinMaxFilter( "1" , String.valueOf(questionCount))});
        editTextQuestionQty.setHint(editTextQuestionQty.getHint() + " (Max : " + questionCount + ")");

        buttonStartFullQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz(FULL_TEST_QUESTION_COUNT);
            }
        });

        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextQuestionQty.getText().length() > 0) {
                    int questionQty = Integer.parseInt(editTextQuestionQty.getText().toString());
                    startQuiz(questionQty);
                } else {
                    Toast.makeText(MainActivity.this, "Please input a valid number of questions", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonSeeResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });
    }

    private void startQuiz(int questionQty) {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        intent.putExtra(QUESTION_QTY, questionQty);
        QuizzActivityResult.launch(intent);
    }

    ActivityResultLauncher<Intent> QuizzActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if(data != null) {
                        int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, -1);
                        if (score > -1 && score > highscore) {
                            updateHighscore(score);
                        }
                    }
                }
            });

    private void loadHighscore() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText(getString(R.string.highscore) + highscore);
    }

    private void updateHighscore(int newHighscore) {
        highscore = newHighscore;
        textViewHighscore.setText(getString(R.string.highscore) + highscore);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor sEdit = prefs.edit();
        sEdit.putInt(KEY_HIGHSCORE, highscore);
        sEdit.apply();
    }
}