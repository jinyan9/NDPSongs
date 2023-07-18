package sg.edu.rp.c346.id22022452.ndpsongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editTitle, editSingers, editYear , editID ;
    RadioGroup radioGroup;
    Button Btninsert, Btndisplay;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTitle = findViewById(R.id.etTitle);
        editSingers = findViewById(R.id.etName);
        editYear = findViewById(R.id.etYear);
        radioGroup = findViewById(R.id.radioGroup);
        Btninsert = findViewById(R.id.btnInsert);
        Btndisplay = findViewById(R.id.btnShowList);



        dbHelper = new DBHelper(this);
        Btndisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongActivity.class);
                startActivity(intent);
            }
        });

        Btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString();
                String singers = editSingers.getText().toString();
                int year = Integer.parseInt(editYear.getText().toString());
                int stars = getSelectedStars();

                int id = Integer.parseInt(editID.getText().toString());
                Song song = new Song(id,title, singers, year, stars);
                dbHelper.addSong(song);



                // Clear input fields
                editTitle.setText("");
                editSingers.setText("");
                editYear.setText("");
                radioGroup.clearCheck();
            }

        });
    }


    private int getSelectedStars() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        String starsText = radioButton.getText().toString();
        return Integer.parseInt(starsText);
    }

}