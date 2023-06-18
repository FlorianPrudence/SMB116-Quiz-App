package cnam.smb116.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import cnam.smb116.quizapp.Helpers.QuizDBHelper;
import cnam.smb116.quizapp.Model.Result;

public class ResultActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        listView = (ListView) findViewById(R.id.result_listView);
        Button backBtn = (Button) findViewById(R.id.finishBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                }
            });
        populateListView();
    }

    public void populateListView() {
        QuizDBHelper helper = new QuizDBHelper(this);
        ArrayList<Result> results = helper.getAllResult();
        ListAdapter adapter = new ArrayAdapter<Result>(this, android.R.layout.simple_list_item_1, results);
        listView.setAdapter(adapter);
    }
}
