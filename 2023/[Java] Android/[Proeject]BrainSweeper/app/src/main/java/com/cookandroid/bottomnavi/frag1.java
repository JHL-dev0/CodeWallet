package com.cookandroid.bottomnavi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class frag1 extends Fragment {
    private View view;
    private ArrayList<String> itemList; // 리스트 아이템을 저장할 ArrayList
    private ArrayAdapter<String> adapter; // ListView에 데이터를 제공할 ArrayAdapter
    private ListView listView; // XML에서 정의된 ListView
    private EditText editText; // 아이템 입력을 위한 EditText
    private int selectedPosition = -1; // 선택된 아이템의 위치를 추적
    private FragmentAListener listener; // 프래그먼트 간 통신을 위한 리스너 인터페이스
    private SharedViewModel viewModel; // SharedViewModel 인스턴스


    // FragmentAListener 인터페이스 정의
    public interface FragmentAListener {
        void onInputASent(CharSequence input);
        void onItemListUpdated(ArrayList<String> itemList);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // 프래그먼트 레이아웃 설정
        view = inflater.inflate(R.layout.frag1, container, false);

        // Initialize the ArrayList and ArrayAdapter
        itemList = new ArrayList<String>();
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_single_choice, itemList);

        // Bind the ListView and EditText from the XML
        listView = view.findViewById(R.id.listView1);
        editText = view.findViewById(R.id.editText);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        Button btnAdd = view.findViewById(R.id.btnAdd);
        ImageButton btnEdit = (ImageButton) view.findViewById(R.id.btnEdit);
        ImageButton btnDelete = (ImageButton) view.findViewById(R.id.btnDelete);

        // ListView 아이템 선택 이벤트 리스너
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position; // 사용자가 선택한 항목의 위치 저장
            }
        });

        // SharedViewModel 초기화
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // ViewModel에서 데이터 가져오기 및 ListView에 출력
        viewModel.getItemList().observe(getViewLifecycleOwner(), newItems -> {
            itemList.clear();
            itemList.addAll(newItems);
            adapter.notifyDataSetChanged();
        });

        btnAdd.setOnClickListener(v -> {
            String text = editText.getText().toString();
            if (!text.isEmpty()) {
                if (selectedPosition >= 0) {
                    // 선택된 항목 수정
                    viewModel.updateItem(selectedPosition, text);
                    selectedPosition = -1; // 선택 초기화
                } else {
                    // 새 항목 추가
                    viewModel.addItem(text);
                }
                editText.setText(""); // EditText 내용을 비웁니다.
                editText.requestFocus(); // EditText에 포커스를 유지합니다.
            } else {
                Toast.makeText(getActivity(), "텍스트를 입력해주세요!", Toast.LENGTH_SHORT).show();
            }
        });


//        btnAdd.setOnClickListener(v -> {
//            String text = editText.getText().toString();
//            if (!text.isEmpty()) {
//                viewModel.addItem(text);
//                editText.setText(""); // EditText 내용을 비웁니다.
//                editText.requestFocus(); // EditText에 포커스를 유지합니다.
//            } else {
//                Toast.makeText(getActivity(), "텍스트를 입력해주세요!", Toast.LENGTH_SHORT).show();
//            }
//        });


//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text = editText.getText().toString();
//                if (!text.isEmpty()) {
//                    if (selectedPosition >= 0) {
//                        // 선택된 항목 수정
//                        itemList.set(selectedPosition, text);
//                        selectedPosition = -1; // 선택 초기화
//                    } else {
//                        // 새 항목 추가
//                        itemList.add(text);
//                    }
//
//                    // ListView 갱신
//                    CharSequence input = itemList.get(itemList.size() - 1);
//                    listener.onInputASent(input);
//
//                    adapter.notifyDataSetChanged();
//                    listView.clearChoices(); // ListView의 선택 상태 초기화
//                    editText.setText(""); // EditText 내용을 비웁니다.
//                    editText.requestFocus(); // EditText에 포커스를 유지합니다.
//
//
//                } else {
//                    Toast.makeText(getActivity(), "텍스트를 입력해주세요!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//        btnEdit.setOnClickListener(v -> {
//            if (selectedPosition >= 0) {
//                editText.setText(itemList.get(selectedPosition));
//                Toast.makeText(getContext(), "수정버튼이 클릭되었습니다!", Toast.LENGTH_SHORT).show();
//            }
//        });



        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition >= 0) {
                    Toast.makeText(getContext(), "수정버튼이 클릭되었습니다!", Toast.LENGTH_SHORT).show();
                    editText.setText(itemList.get(selectedPosition));
                }
            }
        });

        btnDelete.setOnClickListener(v -> {
            if (selectedPosition >= 0) {
                viewModel.removeItem(selectedPosition);
            }
        });




//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (selectedPosition >= 0) {
////                    Toast.makeText(getContext(), "삭제버튼이 클릭되었습니다!", Toast.LENGTH_SHORT).show();
//                    itemList.remove(selectedPosition);
//                    adapter.notifyDataSetChanged();
//                    selectedPosition = -1; // 선택 초기화
//                    listView.clearChoices(); // ListView의 선택 상태 초기화
//
//
////
//                    editText.setText(""); // EditText 내용을 비웁니다.
//                }
//            }
//        });

        return view;
    }
}
