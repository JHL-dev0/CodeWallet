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
    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private EditText editText;
    private int selectedPosition = -1; // 선택된 항목의 위치를 저장하는 변수
    private FragmentAListener listener;
    private SharedViewModel viewModel;
    public interface FragmentAListener {
        void onInputASent(CharSequence input);
        void onItemListUpdated(ArrayList<String> itemList);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
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


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position; // 사용자가 선택한 항목의 위치 저장
            }
        });

        // ViewModel 초기화
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.isEmpty()) {
                    if (selectedPosition >= 0) {
                        // 선택된 항목 수정
                        itemList.set(selectedPosition, text);
                        selectedPosition = -1; // 선택 초기화
                    } else {
                        // 새 항목 추가
                        itemList.add(text);
                    }

                    // ListView 갱신
                    CharSequence input = itemList.get(itemList.size() - 1);
                    listener.onInputASent(input);

                    adapter.notifyDataSetChanged();
                    listView.clearChoices(); // ListView의 선택 상태 초기화
                    editText.setText(""); // EditText 내용을 비웁니다.
                    editText.requestFocus(); // EditText에 포커스를 유지합니다.


                } else {
                    Toast.makeText(getActivity(), "텍스트를 입력해주세요!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition >= 0) {
//                    Toast.makeText(getContext(), "수정버튼이 클릭되었습니다!", Toast.LENGTH_SHORT).show();
                    editText.setText(itemList.get(selectedPosition));
                }
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition >= 0) {
//                    Toast.makeText(getContext(), "삭제버튼이 클릭되었습니다!", Toast.LENGTH_SHORT).show();
                    itemList.remove(selectedPosition);
                    adapter.notifyDataSetChanged();
                    selectedPosition = -1; // 선택 초기화
                    listView.clearChoices(); // ListView의 선택 상태 초기화


//
                    editText.setText(""); // EditText 내용을 비웁니다.
                }
            }
        });

        return view;
    }
}
