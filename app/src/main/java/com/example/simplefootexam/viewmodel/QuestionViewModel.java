package com.example.simplefootexam.viewmodel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.simplefootexam.model.Question;
import com.example.simplefootexam.utils.Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.content.Context;

public class QuestionViewModel extends AndroidViewModel {

    private static Map<String, Question> questions = new HashMap<>();

    private static boolean isLoaded = false;

    public QuestionViewModel(@NonNull Application application) {
        super(application);
        initQuestions(application.getApplicationContext());
    }

    private void initQuestions(Context ctx) {
        if (isLoaded) {
            return;
        }
        JSONArray jsonArray = Utils.loadSONFile(ctx);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jo = null;
            try {
                jo = jsonArray.getJSONObject(i);
                Question q = new Question(i, jo);
                questions.put(q.getId(), q);
            } catch (JSONException | NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        isLoaded = true;
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions.values());
    }
}
