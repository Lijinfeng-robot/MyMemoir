package com.example.mymemoir.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author LiJinFeng
 */
public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    public SharedViewModel(){
        mText = new MutableLiveData<>();
    }
    public void setMessage(String message) {

        mText.setValue(message);
    }
    public LiveData<String> getText() {
        return mText;
    }

}
