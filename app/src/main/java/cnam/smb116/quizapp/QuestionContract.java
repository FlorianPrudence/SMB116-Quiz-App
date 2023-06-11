package cnam.smb116.quizapp;

import android.provider.BaseColumns;

public final class QuestionContract {

    private QuestionContract() {
    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_TYPE = "question_type";
        public static final String COLUMN_OPTIONA = "optionA";
        public static final String COLUMN_OPTIONB = "optionB";
        public static final String COLUMN_OPTIONC = "optionC";
        public static final String COLUMN_OPTIOND = "optionD";
        public static final String COLUMN_OPTIONE = "optionE";
        public static final String COLUMN_OPTIONF = "optionF";
        public static final String COLUMN_OPTIONG = "optionG";
        public static final String COLUMN_OPTIONH = "optionH";
        public static final String COLUMN_OPTIONI = "optionI";
        public static final String COLUMN_OPTIONJ = "optionJ";
        public static final String COLUMN_CORRECT_ANSWER = "correct_answer";
    }
}
