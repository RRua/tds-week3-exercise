package com.example.simplefootexam;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.simplefootexam.model.Question;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingleQuestionFragment extends Fragment {

    @BindView(R.id.textViewQuestion)
    TextView textViewQuestion;

    @BindView(R.id.imageQuestion)
    ImageView questionImage;

    @BindView(R.id.button_top_left)
    CustomButton buttonTopLeft;

    @BindView(R.id.button_top_right)
    CustomButton buttonTopRight;

    @BindView(R.id.button_bottom_left)
    CustomButton buttonBottomLeft;

    @BindView(R.id.button_bottom_right)
    CustomButton buttonBottomRight;

    Question question;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_single_question, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick({ R.id.button_top_left, R.id.button_top_right, R.id.button_bottom_left,
            R.id.button_bottom_right })
    public void onClickOnButtons(View view) {
        if (view instanceof CustomButton) {
            String txt = ((CustomButton) view).getText().toString();
            if (txt.equals(question.getAnswer())) {
                Toast.makeText(getContext(),
                        "Your answer is correct", Toast.LENGTH_LONG).show();
            } else {
                ((CustomButton) view).setWrong(true);
                view.invalidate();
            }
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Question q = getArguments().getParcelable("question");
        setQuestion(q);
    }

    public void setQuestion(Question quest) {
        question = quest;
        List<String> l = new ArrayList<>(Arrays.asList(question.alternatives));
        Collections.shuffle(l);
        buttonTopLeft.setText(l.get(0));
        buttonTopRight.setText(l.get(1));
        buttonBottomLeft.setText(l.get(2));
        buttonBottomRight.setText(l.get(3));
        textViewQuestion.setText(question.getQuestion());
        questionImage
                .setImageBitmap(BitmapFactory.decodeResource(this.getResources(),
                        quest.getImageId()));
    }
}
