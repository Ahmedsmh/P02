package sg.edu.rp.c346.id19008424.demoexplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeroStatsActivity extends AppCompatActivity {
    TextView tvName, tvStrength, tvTechnicalProwess;
    Button btnLike, btnDislike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);
        Intent i = getIntent();

        Hero hero = (Hero) i.getSerializableExtra("hero");

        tvName = (TextView) findViewById(R.id.textViewName);
        tvStrength = (TextView)findViewById(R.id.textViewStrength);
        tvTechnicalProwess = (TextView) 						findViewById(R.id.textViewTechnicalProwess);

        btnDislike = findViewById(R.id.buttonDislike);
        btnLike = findViewById(R.id.buttonLike);
        // Use getters of Hero object to get the attributes
        tvName.setText(hero.getName());
        tvStrength.setText("Strength: " + hero.getStrength());
        tvTechnicalProwess.setText("Technical: " +
        hero.getTechnicalProwess());
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("like", "like");
                // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                setResult(RESULT_OK, i);
                finish();

            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "dislike");
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                // dislike
                setResult(RESULT_OK, i);
                finish();
            }});
    }

}
