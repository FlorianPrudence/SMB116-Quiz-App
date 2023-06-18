package cnam.smb116.quizapp.Contracts;

import android.provider.BaseColumns;

public final class ResultContract {

    public ResultContract() {
    }

    public static class ResultTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_results";
        public static final String COLUMN_TIME= "time";
        public static final String COLUMN_CORRECT_ANSWERS = "correct_answers";
        public static final String COLUMN_TOTAL_QUESTIONS = "total_questions";
    }
}
