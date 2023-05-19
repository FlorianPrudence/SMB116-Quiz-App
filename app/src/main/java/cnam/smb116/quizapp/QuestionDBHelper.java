package cnam.smb116.quizapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import cnam.smb116.quizapp.QuestionContract.QuestionsTable;

public class QuestionDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "QuizApp.db";
    private static final int DATABASE_VERSION = 4;

    private SQLiteDatabase db;

    public QuestionDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_TYPE + " TEXT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_CORRECT_ANSWER + " TEXT" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionContract.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("A is correct", Question.QuestionType.MultipleChoices, "A", "B", "C","D", "1");
        addQuestion(q1);
        Question q2 = new Question("B is correct", Question.QuestionType.MultipleChoices, "A", "B", "C","D", "2");
        addQuestion(q2);
        Question q3 = new Question("C is correct", Question.QuestionType.MultipleChoices, "A", "B", "C","D", "3");
        addQuestion(q3);
        Question q4 = new Question("D is correct", Question.QuestionType.MultipleChoices, "A", "B", "C","D", "4");
        addQuestion(q4);
        Question q5 = new Question("B is correct again", Question.QuestionType.MultipleChoices, "A", "B", "C","D", "2");
        addQuestion(q5);
        Question q6 = new Question("Quelle est la couleur du cheval blanc d'Henri IV ?", Question.QuestionType.Text, null, null, null,null, "Blanc");
        addQuestion(q6);
        Question q7 = new Question("Comment s'appelle l'alcool japonais à base de prunes ?", Question.QuestionType.Text, null, null, null,null, "Umeshu");
        addQuestion(q7);
        Question q8 = new Question("Qui a composé la Vème Symphonie ?", Question.QuestionType.Text, null, null, null,null, "Beethoven");
        addQuestion(q8);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_TYPE, question.getType().name());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_CORRECT_ANSWER, question.getCorrectAnswer());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    @SuppressLint("Range")
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setType(Question.QuestionType.valueOf(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_TYPE))));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setCorrectAnswer(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_CORRECT_ANSWER)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
