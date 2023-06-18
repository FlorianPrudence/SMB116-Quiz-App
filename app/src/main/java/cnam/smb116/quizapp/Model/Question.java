package cnam.smb116.quizapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Question implements Parcelable {
    private String question;
    private String correctAnswer;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;
    private String optionF;
    private String optionG;
    private String optionH;
    private String optionI;
    private String optionJ;
    private QuestionType type;

    public Question() {
    }

    protected Question(Parcel in) {
        question = in.readString();
        correctAnswer = in.readString();
        optionA = in.readString();
        optionB = in.readString();
        optionC = in.readString();
        optionD = in.readString();
        optionE = in.readString();
        optionF = in.readString();
        optionG = in.readString();
        optionH = in.readString();
        optionI = in.readString();
        optionJ = in.readString();
        type = QuestionType.valueOf(in.readString());
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(question);
        parcel.writeString(correctAnswer);
        parcel.writeString(optionA);
        parcel.writeString(optionB);
        parcel.writeString(optionC);
        parcel.writeString(optionD);
        parcel.writeString(optionE);
        parcel.writeString(optionF);
        parcel.writeString(optionG);
        parcel.writeString(optionH);
        parcel.writeString(optionI);
        parcel.writeString(optionJ);
        parcel.writeString(type.name());
    }

    public enum QuestionType {
        SingleChoice,
        MultipleChoice,
        Text
    }

    public Question(String question, String correctAnswer, String optionA, String optionB, String optionC, String optionD, String optionE, String optionF, String optionG, String optionH, String optionI, String optionJ, QuestionType type) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.optionE = optionE;
        this.optionF = optionF;
        this.optionG = optionG;
        this.optionH = optionH;
        this.optionI = optionI;
        this.optionJ = optionJ;
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getOptionE() {
        return optionE;
    }

    public void setOptionE(String optionE) {
        this.optionE = optionE;
    }

    public String getOptionF() {
        return optionF;
    }

    public void setOptionF(String optionF) {
        this.optionF = optionF;
    }

    public String getOptionG() {
        return optionG;
    }

    public void setOptionG(String optionG) {
        this.optionG = optionG;
    }

    public String getOptionH() {
        return optionH;
    }

    public void setOptionH(String optionH) {
        this.optionH = optionH;
    }

    public String getOptionI() {
        return optionI;
    }

    public void setOptionI(String optionI) {
        this.optionI = optionI;
    }

    public String getOptionJ() {
        return optionJ;
    }

    public void setOptionJ(String optionJ) {
        this.optionJ = optionJ;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }
}
