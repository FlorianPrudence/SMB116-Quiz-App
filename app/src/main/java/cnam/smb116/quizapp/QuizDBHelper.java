package cnam.smb116.quizapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import cnam.smb116.quizapp.QuestionContract.QuestionsTable;

public class QuizDBHelper extends SQLiteOpenHelper {
    protected static final String DATABASE_NAME = "QuizApp.db";
    protected static final int DATABASE_VERSION = 9;

    private SQLiteDatabase db;

    public QuizDBHelper(Context context) {
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
                QuestionsTable.COLUMN_CORRECT_ANSWER + " TEXT," +
                QuestionsTable.COLUMN_EXPLANATION + " TEXT" +
                ")";

        final String SQL_CREATE_RESULTS_TABLE = "CREATE TABLE " +
                ResultContract.ResultTable.TABLE_NAME + " ( " +
                ResultContract.ResultTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ResultContract.ResultTable.COLUMN_TIME + " INTEGER, " +
                ResultContract.ResultTable.COLUMN_CORRECT_ANSWERS + " TEXT, " +
                ResultContract.ResultTable.COLUMN_TOTAL_QUESTIONS + " TEXT " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        db.execSQL(SQL_CREATE_RESULTS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionContract.QuestionsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ResultContract.ResultTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("A is correct", Question.QuestionType.MultipleChoices, "A", "B", "C","D", "1", "Parce que");
        addQuestion(q1);
        Question q2 = new Question("B is correct", Question.QuestionType.MultipleChoices, "A", "B", "C","D", "2", "Parce que");
        addQuestion(q2);
        Question q3 = new Question("C is correct", Question.QuestionType.MultipleChoices, "A", "B", "C","D", "3", "Parce que");
        addQuestion(q3);
        Question q4 = new Question("D is correct", Question.QuestionType.MultipleChoices, "A", "B", "C","D", "4", "Parce que");
        addQuestion(q4);
        Question q5 = new Question("B is correct again", Question.QuestionType.MultipleChoices, "A", "B", "C","D", "2", "Parce que");
        addQuestion(q5);
        Question q6 = new Question("Quelle est la couleur du cheval blanc d'Henri IV ?", Question.QuestionType.Text, null, null, null,null, "Blanc", "Parce que");
        addQuestion(q6);
        Question q7 = new Question("Comment s'appelle l'alcool japonais à base de prunes ?", Question.QuestionType.Text, null, null, null,null, "Umeshu", "Parce que");
        addQuestion(q7);
        Question q8 = new Question("Qui a composé la Vème Symphonie ?", Question.QuestionType.Text, null, null, null,null, "Beethoven", "Parce que");
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
        cv.put(QuestionsTable.COLUMN_EXPLANATION, question.getExplanation());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public int countAllQuestions() {
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT COUNT(*) FROM " + QuestionsTable.TABLE_NAME, null);
        c.moveToFirst();
        int count = c.getInt(0);
        c.close();
        return count;
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
                question.setExplanation(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_EXPLANATION)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public long insertResult(int correctAnswers, int totalQuestions) {
        ContentValues values = new ContentValues();
        values.put(ResultContract.ResultTable.COLUMN_TIME, System.currentTimeMillis());
        values.put(ResultContract.ResultTable.COLUMN_CORRECT_ANSWERS, correctAnswers);
        values.put(ResultContract.ResultTable.COLUMN_TOTAL_QUESTIONS, totalQuestions);
        return db.insert(ResultContract.ResultTable.TABLE_NAME, null, values);
    }

    @SuppressLint("Range")
    public ArrayList<Result> getAllResult() {
        ArrayList<Result> resultList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + ResultContract.ResultTable.TABLE_NAME + " ORDER BY " + ResultContract.ResultTable.COLUMN_TIME + " DESC", null);

        if (c.moveToFirst()) {
            do {
                Result result = new Result();
                result.setTime(c.getLong(c.getColumnIndex(ResultContract.ResultTable.COLUMN_TIME)));
                result.setCorrectAnswers(c.getInt(c.getColumnIndex(ResultContract.ResultTable.COLUMN_CORRECT_ANSWERS)));
                result.setTotalQuestions(c.getInt(c.getColumnIndex(ResultContract.ResultTable.COLUMN_TOTAL_QUESTIONS)));
                resultList.add(result);
            } while (c.moveToNext());
        }

        c.close();
        return resultList;
    }
}
