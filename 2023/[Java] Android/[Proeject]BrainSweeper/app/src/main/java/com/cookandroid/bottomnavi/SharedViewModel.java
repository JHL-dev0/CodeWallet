package com.cookandroid.bottomnavi;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    // MutableLiveData 객체를 사용하여 ArrayList<String> 타입의 데이터를 관리합니다.
    private final MutableLiveData<ArrayList<String>> itemList = new MutableLiveData<>(new ArrayList<>());

    // itemList의 getter 메소드입니다.
    public MutableLiveData<ArrayList<String>> getItemList() {
        return itemList;
    }

    // 새로운 아이템을 itemList에 추가하는 메소드입니다.
    public void addItem(String item) {
        ArrayList<String> currentList = itemList.getValue();
        if (currentList != null) {
            currentList.add(item);
            itemList.setValue(currentList); // itemList의 값을 현재 리스트로 업데이트합니다.
        }
    }

    // 특정 위치의 아이템을 제거하는 메소드입니다.
    public void removeItem(int position) {
        ArrayList<String> currentList = itemList.getValue();
        if (currentList != null && position < currentList.size()) {
            currentList.remove(position);
            itemList.setValue(currentList); // 변경된 리스트로 itemList를 업데이트합니다.
        }
    }

    // 특정 위치의 아이템을 새 아이템으로 변경하는 메소드입니다.
    public void updateItem(int position, String newItem) {
        ArrayList<String> currentList = itemList.getValue();
        if (currentList != null && position < currentList.size()) {
            currentList.set(position, newItem);
            itemList.setValue(currentList); // 변경된 리스트로 itemList를 업데이트합니다.
        }
    }
}
