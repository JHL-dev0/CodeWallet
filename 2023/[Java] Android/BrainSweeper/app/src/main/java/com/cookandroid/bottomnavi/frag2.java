package com.cookandroid.bottomnavi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class frag2 extends Fragment {
    private View view;
    private SharedViewModel viewModel; // SharedViewModel 인스턴스
    private String selectedTask; // Add this line to declare selectedTask

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2, container, false);

        // SharedViewModel 초기화
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        ListView listView = view.findViewById(R.id.listView1);
        // Assuming this is the adapter for your ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, new ArrayList<String>());
        listView.setAdapter(adapter);

        // ListView 아이템 클릭 이벤트 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedTask = adapter.getItem(position); // Set the selected task here
                showDialog();
            }
        });
        // ViewModel 데이터 관찰
        viewModel.getItemList().observe(getViewLifecycleOwner(), itemList -> {
            adapter.clear();
            adapter.addAll(itemList);
            adapter.notifyDataSetChanged();
        });

        return view;
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("선택하세요");
        String[] options = {"바로할것", "계획수립"};
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    viewModel.addImmediateTask(selectedTask);
                    viewModel.removeItem(selectedTask); // Remove the item from the list
                } else {
                    viewModel.addPlannedTask(selectedTask);
                    viewModel.removeItem(selectedTask); // Remove the item from the list
                }

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

//    private void showDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("선택하세요");
//        String[] options = {"바로할것", "계획수립"};
//        builder.setItems(options, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if (which == 0) {
//                    viewModel.addImmediateTask(selectedTask); // Use the selected task here
//                } else {
//                    viewModel.addPlannedTask(selectedTask);
//                }
//            }
//        });
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }
}

//        private void showDialog() {
//            // 다이얼로그 생성 및 설정
//            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//            builder.setTitle("선택하세요");
//
//            // 다이얼로그에 표시할 항목 배열
//            String[] options = {"바로할것", "계획수립"};
//            builder.setItems(options, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    if (which == 0) {
//                        // "바로할것" 선택 시의 로직
//                        // TODO: 여기에 원하는 코드를 작성하세요.
//                    } else {
//                        // "계획수립" 선택 시의 로직
//                        // TODO: 여기에 원하는 코드를 작성하세요.
//                    }
//                }
//            });
//
//            // 다이얼로그 표시
//            AlertDialog dialog = builder.create();
//            dialog.show();
//        }


