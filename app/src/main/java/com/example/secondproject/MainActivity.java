package com.example.secondproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnSearch;
    private TextView txtResult;
    private Spinner spnBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch = findViewById(R.id.btnSearch);
        txtResult = findViewById(R.id.txtResult);
        spnBooks = findViewById(R.id.spnBooks);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cat = spnBooks.getSelectedItem().toString();
                Database db = new Database();
                List<Book> result = db.getBooks(cat);
                String str = "";
                for (Book b:result){
                    str+=b.getTitle() + " \n ";
                }
                txtResult.setText(str);
            }
        });

    }
}