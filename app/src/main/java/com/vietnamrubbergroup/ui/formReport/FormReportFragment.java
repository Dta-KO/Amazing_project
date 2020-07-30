package com.vietnamrubbergroup.ui.formReport;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.vietnamrubbergroup.R;

public class FormReportFragment extends Fragment {

    private FormReportViewModel formReportViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        formReportViewModel = new ViewModelProvider(this).get(FormReportViewModel.class);
        View root = inflater.inflate(R.layout.fragment_form_report, container, false);
        final TextView textView = root.findViewById(R.id.text_form_report);
        formReportViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}