import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<String>> itemList = new MutableLiveData<>(new ArrayList<>());

    public MutableLiveData<ArrayList<String>> getItemList() {
        return itemList;
    }

    public void addItem(String item) {
        ArrayList<String> currentList = itemList.getValue();
        if (currentList != null) {
            currentList.add(item);
            itemList.setValue(currentList);
        }
    }

    public void removeItem(int position) {
        ArrayList<String> currentList = itemList.getValue();
        if (currentList != null && position < currentList.size()) {
            currentList.remove(position);
            itemList.setValue(currentList);
        }
    }

    public void updateItem(int position, String newItem) {
        ArrayList<String> currentList = itemList.getValue();
        if (currentList != null && position < currentList.size()) {
            currentList.set(position, newItem);
            itemList.setValue(currentList);
        }
    }
}
