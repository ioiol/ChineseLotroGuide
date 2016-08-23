package com.fc.lotro.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fc.lotro.R;
import com.fc.lotro.activity.ClassWebActivity;

public class ClassChildFragment extends Fragment implements OnClickListener {
    private int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class_child, container, false);
        TextView intro = (TextView) view.findViewById(R.id.intro);
        TextView traits = (TextView) view.findViewById(R.id.traits);
        TextView skill = (TextView) view.findViewById(R.id.skill);
        TextView weapon = (TextView) view.findViewById(R.id.weapon);

        intro.setOnClickListener(this);
        traits.setOnClickListener(this);
        skill.setOnClickListener(this);
        weapon.setOnClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        position = bundle.getInt("position");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String category = "";
        switch (id) {
            //职业介绍
            case R.id.intro:
                category = "intro";
                break;
            //天赋
            case R.id.traits:
                category = "traits";
                break;
            //技能
            case R.id.skill:
                category = "skill";
                break;
            //武器
            case R.id.weapon:
                category = "weapon";
                break;
        }
        Intent intent = new Intent(getActivity(), ClassWebActivity.class);
        intent.putExtra("category", category);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}
