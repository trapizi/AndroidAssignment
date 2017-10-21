package com.example.steven.spaghetti;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.steven.spaghetti.Common.Common;
import com.example.steven.spaghetti.Interface.ItemClickListener;
import com.example.steven.spaghetti.Model.Quiz;
import com.example.steven.spaghetti.ViewHolder.QuizViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class QuizSelectionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_quiz_selection, container, false);



        listQuiz = (RecyclerView) myFragment.findViewById(R.id.listQuiz);
        listQuiz.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        listQuiz.setLayoutManager(layoutManager);


        loadQuiz();
        return myFragment;
    }

    View myFragment;

    RecyclerView listQuiz;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Quiz, QuizViewHolder> mFirebaseAdapter;

    FirebaseDatabase mDatabase;
    DatabaseReference quiz;


    public static QuizSelectionFragment newInstance() {
        QuizSelectionFragment quizSelectionFragment = new QuizSelectionFragment();
        return quizSelectionFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        quiz = FirebaseDatabase.getInstance().getReference();


        mDatabase = FirebaseDatabase.getInstance();
        quiz = mDatabase.getReference("Quiz");


    }





    private void loadQuiz() {

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Quiz, QuizViewHolder>(
                Quiz.class,
                R.layout.quiz_layout,
                QuizViewHolder.class,
                quiz
        ) {
            @Override
            protected void populateViewHolder(QuizViewHolder viewHolder, final Quiz model, int position) {
                viewHolder.quiz_name.setText(model.getName());
                Picasso.with(getActivity())
                        .load(model.getImage())
                        .into(viewHolder.quiz_image);

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //Toast.makeText(getActivity(), String.format("%s|%s", mFirebaseAdapter.getRef(position).getKey(), model.getName()), Toast.LENGTH_SHORT).show();
                    Intent startQuiz = new Intent(getActivity(),StartQuiz.class);
                        Common.quizId = mFirebaseAdapter.getRef(position).getKey();
                        Common.quizName=  model.getName();
                        startActivity(startQuiz);

                    }
                });
            }
        };
        mFirebaseAdapter.notifyDataSetChanged();
        listQuiz.setAdapter(mFirebaseAdapter);

    }
}
