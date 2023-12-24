package com.cookandroid.bottomnavi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class frag3 extends Fragment {
    private View view;
    private SharedViewModel viewModel; // SharedViewModel 인스턴스
    private ArrayAdapter<String> immediateTasksAdapter;
    private ArrayAdapter<String> plannedTasksAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        setupListView(R.id.listViewForImmediateTasks, viewModel.getImmediateTasks(), true);
        setupListView(R.id.listViewForPlannedTasks, viewModel.getPlannedTasks(), false);

        return view;
    }

    private void setupListView(int listViewId, LiveData<ArrayList<String>> liveData, boolean isImmediateTask) {
        ListView listView = view.findViewById(listViewId);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, new ArrayList<>());
        listView.setAdapter(adapter);
        if (isImmediateTask) {
            immediateTasksAdapter = adapter;
        } else {
            plannedTasksAdapter = adapter;
        }

        liveData.observe(getViewLifecycleOwner(), itemList -> {
            adapter.clear();
            adapter.addAll(itemList);
            adapter.notifyDataSetChanged();
        });

        listView.setOnItemClickListener((parent, view, position, id) -> showConfirmationDialog(adapter.getItem(position), isImmediateTask));
    }

    private void showConfirmationDialog(String selectedTask, boolean isImmediateTask) {
        new AlertDialog.Builder(getContext())
                .setTitle("완료하셨나요?")
                .setMessage(selectedTask)
                .setNegativeButton("예", (dialog, which) -> {
                    if (isImmediateTask) {
                        viewModel.removeImmediateTask(selectedTask);
                    } else {
                        viewModel.removePlannedTask(selectedTask);
                    }
                })
                .setPositiveButton("아니요", null)

                .show();
    }

}
