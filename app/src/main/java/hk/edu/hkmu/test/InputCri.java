package hk.edu.hkmu.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class InputCri extends AppCompatActivity {
    static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    static String EXTRA_CHECK = "EXTRA_CHECK";
    static String FROM = "FROM";
    private Button SubmitButton;
    private RadioButton sortid;
    private RadioButton sortname;
    private Spinner spinnercat;
    private Spinner spinnergen;
    private Spinner spinnersess;
    private Spinner spinnerdis;
    private Spinner spinnerfin;
    private Spinner spinnerlevel;
    private Spinner spinnerreli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_cri);
        SubmitButton = findViewById(R.id.submitbutton);
        sortid = findViewById(R.id.sortbyId);
        sortname = findViewById(R.id.sortbyName);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String returnString = "return";
                boolean sortbyid = sortid.isChecked();
                boolean sortbyname = sortname.isChecked();
                if (sortbyid) {
                    returnString = "SortbyId";
                } else if (sortbyname) {
                    returnString = "Sortbyname";
                }
                String cat = spinnercat.getSelectedItem().toString();
                String gen = spinnergen.getSelectedItem().toString();
                String sess = spinnersess.getSelectedItem().toString();
                String dis = spinnerdis.getSelectedItem().toString();
                String fin = spinnerfin.getSelectedItem().toString();
                String level = spinnerlevel.getSelectedItem().toString();
                String reli = spinnerreli.getSelectedItem().toString();
                ArrayList<String> list = new ArrayList<String>();
                list.add(cat);
                list.add(gen);
                list.add(sess);
                list.add(dis);
                list.add(fin);
                list.add(level);
                list.add(reli);
                Log.e("String", list.toString());
                Intent intent = new Intent(InputCri.this, Result.class);
                intent.putStringArrayListExtra(EXTRA_MESSAGE,list);
                intent.putExtra(FROM, "Cri");
                intent.putExtra(EXTRA_CHECK, returnString);
                startActivity(intent);
                finish();
            }
        });
        spinnercat = findViewById(R.id.categoryspinner);
        spinnergen = findViewById(R.id.genderspinner);
        spinnersess = findViewById(R.id.sessionspinner);
        spinnerdis = findViewById(R.id.districtspinner);
        spinnerfin = findViewById(R.id.fintypespinner);
        spinnerlevel = findViewById(R.id.levelspinner);
        spinnerreli = findViewById(R.id.religionspinner);

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.categoryspinner, android.R.layout.simple_spinner_item);
        spinnercat.setAdapter(adapter1);
        spinnercat.setSelection(0, true);
        spinnercat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.genderspinner, android.R.layout.simple_spinner_item);
        spinnergen.setAdapter(adapter2);
        spinnergen.setSelection(0, true);
        spinnergen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.sessionspinner, android.R.layout.simple_spinner_item);
        spinnersess.setAdapter(adapter3);
        spinnersess.setSelection(0, false);
        spinnersess.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this, R.array.districtspinner, android.R.layout.simple_spinner_item);
        spinnerdis.setAdapter(adapter4);
        spinnerdis.setSelection(0, false);
        spinnerdis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this, R.array.fintypespineer, android.R.layout.simple_spinner_item);
        spinnerfin.setAdapter(adapter5);
        spinnerfin.setSelection(0, false);
        spinnerfin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter adapter6 = ArrayAdapter.createFromResource(this, R.array.levelspinner, android.R.layout.simple_spinner_item);
        spinnerlevel.setAdapter(adapter6);
        spinnerlevel.setSelection(0, false);
        spinnerlevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter adapter7 = ArrayAdapter.createFromResource(this, R.array.religionspinner, android.R.layout.simple_spinner_item);
        spinnerreli.setAdapter(adapter7);
        spinnerreli.setSelection(0, false);
        spinnerreli.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}