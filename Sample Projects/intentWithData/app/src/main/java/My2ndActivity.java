import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.bailey.intentwithdata.R;

/**
 * Created by baile on 10/2/2017.
 */

public class My2ndActivity extends AppCompatActivity {
    private String firstName;
    private String lastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my2nd);
        // Intent is passed into
        Intent intent = this.getIntent();
        this.firstName= intent.getStringExtra("firstName");
        this.lastName = intent.getStringExtra("lastName");
        String greeting = "Hello "+ firstName+" "+ lastName +" - I got the name from the Main Activity";
        TextView textGreeting =(TextView) this.findViewById(R.id.text_greeting);
        textGreeting.setText(greeting);
    }
    // When completed this Activity, send feedback to the caller.
    @Override
    public void finish() {
        // Prepare data intent
        Intent data = new Intent();
        data.putExtra("feedback", this.firstName + ", Hi! I got this name from you");
                // Activity finished ok, return the data
        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }
    // The method is called when the user clicks the Back button.
    public void backClicked(View view) {
        this.onBackPressed();
    }
}