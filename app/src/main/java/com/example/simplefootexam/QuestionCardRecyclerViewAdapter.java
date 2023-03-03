package com.example.simplefootexam;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.simplefootexam.model.Question;
import java.util.List;


public class QuestionCardRecyclerViewAdapter
        extends RecyclerView.Adapter<QuestionCardRecyclerViewAdapter.QuestionViewHolder> {

    private final List<Question> mValues;

    public QuestionCardRecyclerViewAdapter(List<Question> items) {
        mValues = items;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_question_item,
                parent, false);
        return new QuestionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final QuestionViewHolder holder, int position) {
        // TODO
        // bind question to holder
        // set onclick listener on holder view
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {

        public final TextView mIdView;

        public final TextView mQuestionview;

        public final ImageView mImageView;

        public QuestionViewHolder(View view) {
            super(view);
            mIdView = view.findViewById(R.id.text_question_id);
            mImageView = view.findViewById(R.id.cardimage);
            mQuestionview = view.findViewById(R.id.text_question);
        }
    }
}
