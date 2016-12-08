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
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("site", websiteEditText.getText());   //key, value
        intent.putExtra("username", usernameEditText.getText());
        /* Would send this data to the next activity...*/

        Intent nextActivityIntent = new Intent(getApplicationContext(), KeywordInputActivity.class);
        startActivity(nextActivityIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        /* Goes to the next activity KeywordInput...*/

    }

}
