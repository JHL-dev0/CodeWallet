package com.cookandroid.bottomnavi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<String>> itemList = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<ArrayList<String>> immediateTasks = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<ArrayList<String>> plannedTasks = new MutableLiveData<>(new ArrayList<>());

    // Getters
    public LiveData<ArrayList<String>> getImmediateTasks() { return immediateTasks; }
    public LiveData<ArrayList<String>> getPlannedTasks() { return plannedTasks; }
    public MutableLiveData<ArrayList<String>> getItemList() { return itemList; }

    // 메소드들은 UI에서 받은 데이터를 LiveData에 반영하는 역할만 수행
    public void addImmediateTask(String item) {
        ArrayList<String> currentList = immediateTasks.getValue();
        if (currentList != null) {
            currentList.add(item);
            immediateTasks.setValue(currentList);
        }
    }

    public void addPlannedTask(String item) {
        ArrayList<String> currentList = plannedTasks.getValue();
        if (currentList != null) {
            currentList.add(item);
            plannedTasks.setValue(currentList);
        }
    }

    public void addItem(String item) {
        ArrayList<String> currentList = itemList.getValue();
        if (currentList != null) {
            currentList.add(item);
            itemList.setValue(currentList);
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

    public void removeItem(String item) {
        ArrayList<String> currentList = itemList.getValue();
        if (currentList != null && currentList.contains(item)) {
            currentList.remove(item);
            itemList.setValue(currentList);
        }
    }

    public void removeImmediateTask(String item) {
        ArrayList<String> currentList = immediateTasks.getValue();
        if (currentList != null && currentList.contains(item)) {
            currentList.remove(item);
            immediateTasks.setValue(currentList);
        }
    }

    public void removePlannedTask(String item) {
        ArrayList<String> currentList = plannedTasks.getValue();
        if (currentList != null && currentList.contains(item)) {
            currentList.remove(item);
            plannedTasks.setValue(currentList);
        }
    }
}
