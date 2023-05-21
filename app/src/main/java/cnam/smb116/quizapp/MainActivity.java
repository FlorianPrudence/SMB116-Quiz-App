package cnam.smb116.quizapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
    private TextView textViewHighscore;
    private int highscore;

    private int questionCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadHighscore();

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);
        EditText editTextQuestionQty = findViewById(R.id.edit_text_question_qty);

        QuestionDBHelper dbHelper = new QuestionDBHelper(this);
        questionCount = dbHelper.countAllQuestions();
        editTextQuestionQty.setFilters( new InputFilter[]{ new MinMaxFilter( "1" , String.valueOf(questionCount))});
        editTextQuestionQty.setHint(editTextQuestionQty.getHint() + " (Max : " + questionCount + ")");

        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextQuestionQty.getText().length() > 0) {
                    int questionQty = Integer.parseInt(editTextQuestionQty.getText().toString());
                    Toast.makeText(MainActivity.this, "Nombre de questions : " + questionQty, Toast.LENGTH_SHORT).show();
                    startQuiz(questionQty);
                } else {
                    Toast.makeText(MainActivity.this, "Veuillez saisir un nombre de question valide", Toast.LENGTH_SHORT).show();
                }
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
                        int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                        if (score > highscore) {
                            updateHighscore(score);
                        }
                    }
                }
            });

    private void loadHighscore() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);
    }

    private void updateHighscore(int newHighscore) {
        highscore = newHighscore;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor sEdit = prefs.edit();
        sEdit.putInt(KEY_HIGHSCORE, highscore);
        sEdit.apply();
    }
}