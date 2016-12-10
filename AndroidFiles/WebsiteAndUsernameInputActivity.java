package archityadav.passwordgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WebsiteAndUsernameInputActivity extends AppCompatActivity
{

    EditText websiteEditText, usernameEditText;
    TextView usernameTextView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_input);

        websiteEditText = (EditText) findViewById(R.id.websiteEditText);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        usernameTextView = (TextView) findViewById(R.id.usernameTextView);

        websiteEditText.bringToFront();
        usernameEditText.bringToFront();
        usernameTextView.bringToFront();
    }

    public void gotoNextActivity(View view)
    {
        intent = new Intent(WebsiteAndUsernameInputActivity.this, KeywordInputActivity.class);

        intent.putExtra("site", websiteEditText.getText().toString());   //key, value
        intent.putExtra("username", usernameEditText.getText().toString());
        /* Would send this data to the next activity...*/

        //Intent nextActivityIntent = new Intent(getApplicationContext(), KeywordInputActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        /* Goes to the next activity KeywordInput...*/

    }

}
