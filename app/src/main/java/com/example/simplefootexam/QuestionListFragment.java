package com.example.simplefootexam;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.simplefootexam.model.Question;
import com.example.simplefootexam.utils.Utils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuestionListFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    private static Map<String, Question> questions = new HashMap<>();
    private static boolean isLoaded = false;
    //private QuestionViewModel questionViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        initQuestions(this.getContext());
        //ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider
        //        .AndroidViewModelFactory.getInstance(this.requireActivity().getApplication());
        //questionViewModel = new ViewModelProvider(this, factory).get(QuestionViewModel.class);
    }

    public QuestionListFragment() {
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



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_list,
                container, false);
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            QuestionCardRecyclerViewAdapter adapter =
                    new QuestionCardRecyclerViewAdapter(new ArrayList<>(questions.values()));
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
