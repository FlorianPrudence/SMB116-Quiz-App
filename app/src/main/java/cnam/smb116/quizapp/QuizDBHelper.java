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
    protected static final int DATABASE_VERSION = 10;

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
        Question q1 = new Question("A 4-hour Sprint Planning meeting is typical for a Sprint or Iteration that is how long?", Question.QuestionType.SingleChoice,
                "Four weeks", "Two weeks", "Four days","One week", "2", null);
        Question q2 = new Question("What is the best definition of ‘Done’?", Question.QuestionType.SingleChoice,
                "When a development work is ready for a release", "When a product meets Product Owner expectations", "When a product has passed Quality Assurance (QA) test and has all the required release documentation","When it is determined by the Scrum Master", "1", null);
        Question q3 = new Question("How should multiple cohesive Scrum Teams be structured in order to produce integrated Increments on the same product?", Question.QuestionType.SingleChoice,
                "Each Scrum Team develops all technical parts of functionality", "Each Scrum Team only works on one technical layer of the system", null ,null, "1", null);
        Question q4 = new Question("Who can prematurely cancel or terminate a Sprint?", Question.QuestionType.SingleChoice,
                "The Product Owner", "The Developers", "The Scrum Master","The customer", "1", null);
        Question q5 = new Question("The IT Manager asks Developers for a status report describing the progress throughout the Sprint. How can the Scrum Master help the team?", Question.QuestionType.SingleChoice,
                "Tell the Developers to produce the report by themselves", "Create and deliver the report to the Manager him/herself", "Explain to the IT Manager that the Sprint Review is a good opportunity to produce a status report","Ask the Product Owner to send the report to the Manager", "3", null);
        Question q6 = new Question("What enhances the transparency of an Increment?", Question.QuestionType.SingleChoice,
                "Updating Sprint tasks accurately in the electronic tracking tool", "Doing all the work defined in the Sprint Backlog", "Doing all the work needed to meet the Definition of Done","Reporting Sprint progress to the Stakeholders daily", "3", null);
        Question q7 = new Question("How should multiple Scrum teams be created?", Question.QuestionType.SingleChoice,
                "By asking the Developers to break into teams", "By asking the Product Owner to assign people to the different teams", "Assembling teams based on people skills across multiple application layers (such a database, UI, etc.)",null, "1", null);
        Question q8 = new Question("Which of the following best describes the Daily Scrum?", Question.QuestionType.SingleChoice,
                "The meeting should ensure that it is clear to all which team members are not performing", "There is no recommended length of time for the event", "Everyone is expected to stand for the whole duration to keep the meeting short","Everyone is expected to keep the meeting short and to focus on Sprint Goals", "4", null);
        Question q9 = new Question("In a Burndown Chart:", Question.QuestionType.SingleChoice,
                "X tracks cost, Y tracks value", "Y tracks value, Y tracks cost", "X tracks time, Y tracks work","X tracks work, Y tracks time", "3", "");
        Question q10 = new Question("Which answer best describes the Product Backlog?", Question.QuestionType.SingleChoice,
                "It is a Baseline to follow as part of the Change Management processes", "It is allowed to evolve and change as more is learned about the Product and its Customers", "It contains all foreseeable tasks and requirements from which the Scrum Team can develop and maintain a complete Project Plan","It provides just enough information to enable a Scrum Team to start the design phase of a Product", "2", null);
        Question q11 = new Question("A mature Scrum Team will execute at least one Release Sprint, as well as may release several.", Question.QuestionType.SingleChoice,
                "True", "False", null, null, "2", null);
        Question q12 = new Question("How can a Scrum Master help Developers perform at their highest level of productivity?", Question.QuestionType.SingleChoice,
                "Ensure that all meetings are kept within their Time-Box", "Keep high-value features at high priority in the Product Backlog",
                "Facilitate the Developers’ decisions and remove Impediments", "Prevent changes to the Backlog once the Sprint begins", "3", null);
        Question q13 = new Question("When Developers are having trouble delivering a usable Increment because they don’t understand a functional requirement, what should they do?",
                Question.QuestionType.SingleChoice, "Work with the Product Owner to get information and agree on what is acceptable", "Partially complete a functionality that should be part of the usable increment and discuss the remaining work at the Sprint Review", "Recruit a specialist to work with the Developers", "Defer the work to a more appropriate Sprint", "1", null);
        //Question q8 = new Question("Qui a composé la Vème Symphonie ?", Question.QuestionType.Text, null, null, null,null, "Beethoven", "Parce que");
        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        addQuestion(q8);
        addQuestion(q9);
        addQuestion(q10);
        addQuestion(q11);
        addQuestion(q12);
        addQuestion(q13);
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
