package hk.edu.hkmu.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class InputCri extends AppCompatActivity {

    static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    static String EXTRA_CHECK = "EXTRA_CHECK";
    private Button SubmitButton;
    private RadioButton sortid;
    private RadioButton sortname;
    private RadioButton sortdistrict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_input_cri);
        SubmitButton = findViewById(R.id.submitbutton);
        sortid = findViewById(R.id.sortbyId);
        sortname = findViewById(R.id.sortbyName);
        sortdistrict = findViewById(R.id.sortbyDistrict);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String returnString = "return";
                boolean sortbyid = sortid.isChecked();
                boolean sortbyname = sortname.isChecked();
                boolean sortbydistrict = sortdistrict.isChecked();
                if (sortbyid) {
                    returnString = "SortbyId";
                } else if (sortbyname) {
                    returnString = "Sortbyname";
                } else if (sortbydistrict) {
                    returnString = "Sortbydistrict";
                }

                Intent intent = new Intent(InputCri.this, Result.class);
                intent.putExtra(EXTRA_CHECK, returnString);
                startActivity(intent);
            }
        });
    }
}
