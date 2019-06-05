package com.example.asus.dialogfragmenttoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CustomDialogFragment.OnInputListener {

    Button openDialog;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "new changes", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "new toast", Toast.LENGTH_SHORT).show();
        openDialog  = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogFragment customDialogFragment = new CustomDialogFragment();
                customDialogFragment.show(getSupportFragmentManager(),"tag");
            }
        });
    }

    @Override
    public void input(String input) {
        textView.setText(input);
    }
}
