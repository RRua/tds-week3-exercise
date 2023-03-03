package com.example.simplefootexam.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.example.simplefootexam.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;

public class Question implements Parcelable {

    private final String id;

    private final String question;

    private final int imageId;

    public String[] alternatives;

    public Question(String id, int image_id) {
        this.id = id;
        this.imageId = image_id;
        this.question = "?";
        this.alternatives = new String[4];
    }

    public Question(String id, String question, int image_id, String answer) {
        this.id = id;
        this.imageId = image_id;
        this.question = question;
        this.alternatives = new String[4];
    }

    protected Question(Parcel in) {
        id = in.readString();
        question = in.readString();
        imageId = in.readInt();
        in.readStringArray(alternatives);
    }

    public Question(int id, JSONObject jo) throws JSONException, NoSuchFieldException, IllegalAccessException {
        this.id = String.valueOf(id);
        this.question = jo.getString("question");
        this.imageId = R.drawable.class.getField(jo.getString("image")).getInt(null);
        ;
        JSONArray alts = jo.getJSONArray("alternatives");
        this.alternatives = new String[4];
        for (int i = 0; i < alts.length() && i < 4; i++) {
            this.alternatives[i] = alts.get(i).toString();
        }
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getImageId() {
        return imageId;
    }

    public String[] getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(String[] alternatives) {
        this.alternatives = alternatives;
    }

    public static Creator<Question> getCREATOR() {
        return CREATOR;
    }

    public String getAnswer() {
        return this.alternatives.length > 0 ? this.alternatives[0] : null;
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
    public String toString() {
        return question + id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(question);
        parcel.writeInt(imageId);
        parcel.writeStringArray(alternatives);
    }
}
