package sg.edu.rp.c346.id21036553.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> alToDo;
    ArrayAdapter<String> aaToDo;
    EditText etInputTask;
    Button btnAdd, btnClear, btnDelete;
    ListView lvToDo;
    Spinner spnToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInputTask = findViewById(R.id.etElements);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnClear = findViewById(R.id.btnClear);
        spnToDo = findViewById(R.id.spnToDo);
        lvToDo = findViewById(R.id.listViewToDo);

        //arraylist
        alToDo = new ArrayList<>();

        //array adapters
        aaToDo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alToDo);
        lvToDo.setAdapter(aaToDo);

        spnToDo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        btnAdd.setEnabled(true);
                        btnDelete.setEnabled(false);
                        etInputTask.setText("");
                        etInputTask.setHint("Add a new task");
                        break;

                    case 1:
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);
                        etInputTask.setText("");
                        etInputTask.setHint("Remove a task");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //button add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = etInputTask.getText().toString();
                //    aaColours.add(colour);
               // int pos = Integer.parseInt(etInputTask.getText().toString());
                alToDo.add(task);
                aaToDo.notifyDataSetChanged();
            }
        });

    btnDelete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int pos = Integer.parseInt(etInputTask.getText().toString());

            if(alToDo.size() > 0) {
                if (pos + 1 > alToDo.size()) {
                    Toast.makeText(MainActivity.this, "Wrong index", Toast.LENGTH_SHORT).show();
                } else {
                    alToDo.remove(pos);
                    aaToDo.notifyDataSetChanged();
                }
            }else {
                    Toast.makeText(MainActivity.this, "You don't have any task to remove", Toast.LENGTH_SHORT).show();
                }
        }
    });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInputTask.setText("");
                alToDo.clear();
                aaToDo.notifyDataSetChanged();
            }
        });


    }
}