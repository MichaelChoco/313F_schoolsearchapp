package hk.edu.hkmu.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class UsefulWeb extends AppCompatActivity {

    private Button backbutton;
    private ImageButton web1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_web);

        backbutton = findViewById(R.id.back_button);
        web1 = findViewById(R.id.web1);
        
        web1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webLink("https://applications.edb.gov.hk/schoolsearch/schoolsearch.aspx?langno=1");
            }
        });
        
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(UsefulWeb.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void webLink(String url){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
