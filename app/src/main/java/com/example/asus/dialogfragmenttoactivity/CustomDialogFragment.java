package com.example.asus.dialogfragmenttoactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CustomDialogFragment extends DialogFragment {

    public interface OnInputListener{
        void input(String input);
    }

    OnInputListener mInputListener;



    EditText text;
    Button okay, cancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_dialog, container, false);
        text = view.findViewById(R.id.editText);
        okay = view.findViewById(R.id.buttonOkay);
        cancel = view.findViewById(R.id.buttonCancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = text.getText().toString();
                mInputListener.input(input);
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mInputListener = (OnInputListener)getActivity();
        }catch (ClassCastException e){
            Log.e("Errror" , e.getMessage());
        }
    }
}
