package com.vietnamrubbergroup.ui.formReport;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FormReportViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FormReportViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}