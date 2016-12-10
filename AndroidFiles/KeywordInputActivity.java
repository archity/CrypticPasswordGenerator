package archityadav.passwordgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class KeywordInputActivity extends AppCompatActivity
{
    EditText keywordEditText;
    Intent intent3;
    String uname, site;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyword_input);

        Intent tempIntent = getIntent();
        uname = tempIntent.getStringExtra("username");
        site = tempIntent.getStringExtra("site");
        keywordEditText = (EditText) findViewById(R.id.keywordEditText);
    }

    public void gotoMainActivity(View view)
    {
        intent3 = new Intent(KeywordInputActivity.this, MainActivity.class);
        intent3.putExtra("keyword", keywordEditText.getText().toString());   //key, value
        intent3.putExtra("username", uname);
        intent3.putExtra("site", site);
        /* Would send this data to the next activity...*/

        startActivity(intent3);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }
}
