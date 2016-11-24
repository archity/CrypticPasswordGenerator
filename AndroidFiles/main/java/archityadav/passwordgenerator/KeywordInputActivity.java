package archityadav.passwordgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class KeywordInputActivity extends AppCompatActivity
{
    EditText keywordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyword_input);

        keywordEditText = (EditText) findViewById(R.id.keywordEditText);
    }

    public void gotoMainActivity(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("keyword", keywordEditText.getText());   //key, value
        /* Would send this data to the next activity...*/

        Intent nextActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(nextActivityIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        /* Goes to the nextactivity UsernameInput...*/
    }
}
