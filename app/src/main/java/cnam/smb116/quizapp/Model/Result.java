package cnam.smb116.quizapp.Model;

import static java.text.DateFormat.getDateTimeInstance;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

public class Result implements Parcelable {
    private long time;
    private int correctAnswers;
    private int totalQuestions;

    protected Result(Parcel in) {
        time = in.readLong();
        correctAnswers = in.readInt();
        totalQuestions = in.readInt();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Result() {
    }

    public Result(long time, int correctAnswers, int totalQuestions) {
        this.time = time;
        this.correctAnswers = correctAnswers;
        this.totalQuestions = totalQuestions;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(time);
        parcel.writeInt(correctAnswers);
        parcel.writeInt(totalQuestions);
    }

    @NonNull
    @Override
    public String toString() {
        DateFormat df = getDateTimeInstance();
        Date resultDate = new Date(time);
        double percentRight = (double) correctAnswers / totalQuestions * 100;
        return df.format(resultDate) + "\nScore : " + correctAnswers + "/" + totalQuestions + ", " + new DecimalFormat("#.##").format(percentRight) + "%";
    }
}
