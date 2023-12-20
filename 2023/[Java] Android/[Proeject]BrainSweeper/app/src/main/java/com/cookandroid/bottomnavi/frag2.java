package com.cookandroid.bottomnavi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class frag2 extends Fragment {
    private View view;
    private SharedViewModel viewModel; // SharedViewModel 인스턴스

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2, container, false);

        // SharedViewModel 초기화
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // ListView 및 ArrayAdapter 설정
        ListView listView = view.findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, new ArrayList<String>());
        listView.setAdapter(adapter);

        // ViewModel 데이터 관찰
        viewModel.getItemList().observe(getViewLifecycleOwner(), itemList -> {
            adapter.clear();
            adapter.addAll(itemList);
            adapter.notifyDataSetChanged();
        });

        return view;
    }
}
