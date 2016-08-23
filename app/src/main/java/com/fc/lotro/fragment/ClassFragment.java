package com.fc.lotro.fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.fc.lotro.R;
import com.fc.lotro.adapter.ClassAdapter;
import com.fc.lotro.entity.GridListItem;

import java.util.ArrayList;

public class ClassFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ArrayList<GridListItem> items;
    private GridView gridView;
    private Context mContext;
    private FragmentManager fm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        View view = inflater.inflate(R.layout.fragment_class, container, false);
        gridView = (GridView) view.findViewById(R.id.zyGridView);
        items = new ArrayList<>();
        getData();
        ClassAdapter adapter = new ClassAdapter(mContext, items);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getFragmentManager();
    }

    private void getData() {
        items.add(getItem(R.drawable.beorning_icon, R.string.beorning));
        items.add(getItem(R.drawable.burglar_icon, R.string.burglar));
        items.add(getItem(R.drawable.captain_icon, R.string.captain));
        items.add(getItem(R.drawable.champion_icon, R.string.champion));
        items.add(getItem(R.drawable.guardian_icon, R.string.guardian));
        items.add(getItem(R.drawable.hunter_icon, R.string.hunter));
        items.add(getItem(R.drawable.lore_master_icon, R.string.lore_master));
        items.add(getItem(R.drawable.minstrel_icon, R.string.minstrel));
        items.add(getItem(R.drawable.runekeeper_icon, R.string.runekeeper));
        items.add(getItem(R.drawable.warden_icon, R.string.warden));
    }

    private GridListItem getItem(int imageId, int titleId) {
        GridListItem item = new GridListItem();
        item.setPhotoId(imageId);
        item.setTitle(getString(titleId));
        return item;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        FragmentTransaction ft = fm.beginTransaction();
        ClassChildFragment classChildFragment = new ClassChildFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", i);
        classChildFragment.setArguments(bundle);
        ft.replace(R.id.id_content, classChildFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
