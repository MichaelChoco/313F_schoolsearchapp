package hk.edu.hkmu.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class UsefulWeb extends AppCompatActivity {

    private Button backButton;
    private ImageButton webButton1;
    private ImageButton webButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_web);

        backButton = findViewById(R.id.back_button);
        webButton1 = findViewById(R.id.web1);
        webButton2 = findViewById(R.id.web2);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(UsefulWeb.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        webButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://applications.edb.gov.hk/schoolsearch/schoolsearch.aspx?langno=1");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                finish();
            }
        });

        webButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://schooland.hk/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                finish();
            }
        });
    }
}