package archityadav.passwordgenerator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;

import java.util.HashMap;

/*KeywordMatrix can't be extended because of AppCompatActivity...but its objects can still be declares
    and instantiated in this class because it is in the same package.*/

public class MainActivity extends AppCompatActivity
{
    String siteName, userName;
    String keyword;
    String imei;

    HashMap<Integer, Integer> colHashMap = new HashMap<Integer, Integer>();
    /*This hashmap consists of just the columns. Imagine this as a single dimensional
    array consisting of all the ASCII compatible numbers.
     */

    HashMap<Integer, HashMap> completeHashMap = new HashMap<Integer, HashMap>();
    /* The complete hashmap. Its value is itself a hashmap, which the so-called
    single dimensional array...
     */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*Get the bundle(info) from the previous activities...*/
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            siteName = extras.getString("Site");
            userName = extras.getString("username");
            keyword = extras.getString("keyword");
            /* Website name, username and special word sent from initial screens received...*/
        }
        getIMEI();

        executeCodeRed();//the main logic...

        //imei = android.telephony.TelephonyManager.getDeviceId();
    }

    public void getIMEI()   //to get the IMEI number of the person's device.
    {
        //imei = android.telephony.TelephonyManager.getDeviceId();
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        imei = telephonyManager.getDeviceId();
    }

    public void executeCodeRed()
    {
        KeywordMatrixAndro userNameObject = new KeywordMatrixAndro(userName);//anoushkritgoel
        KeywordMatrixAndro keywordOject = new KeywordMatrixAndro(keyword);//starboy

        for(int j = 0; j<imei.length(); j++)//traversing the rows...
        {
            /* This loop goes till the the length of the IMEI number. If the username is smaller
                than this, repetition of the username would take place. If the username is larger than
                this, then it will be trimmed to match the length of the IMEI number...
                 */

            for(int i = 0;i<26; i++)//traverse through the whole coloumn
            {
                colHashMap.put(i,Character.getNumericValue(imei.charAt(j)) + keywordOject.arr[KeywordMatrixAndro.fetchCharacterPosition(userName.charAt(j))] + 32 +  userNameObject.arr[i]);
                /* This is one damn big statement :)
                  value = IMEI(j) + username's jth letter's number from the keyword + 32 + username(i)
                   */
            }
            completeHashMap.put(j, colHashMap);
        }
    }

}



