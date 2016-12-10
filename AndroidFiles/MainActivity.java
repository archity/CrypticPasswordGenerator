package archityadav.passwordgenerator;

import android.content.Context;
import android.content.Intent; // for transition
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager; //To access mobile data (IEMEI)
import android.widget.TextView; // to display text on screen

import java.util.HashMap;

/*KeywordMatrix can't be extended because of AppCompatActivity...but its objects can still be declares
    and instantiated in this class because it is in the same package.*/

public class MainActivity extends AppCompatActivity
{
    String siteName, userName;
    String keyword;
    String imei;
    TextView pwTextView;

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

        pwTextView = (TextView)findViewById(R.id.passwordTextView);

        /*Get the bundle(info) from the previous activities...*/
        Intent intent = getIntent();
        //
        if(intent!=null)
        {
            siteName = intent.getStringExtra("site");
            userName = intent.getStringExtra("username");
            keyword = intent.getStringExtra("keyword");
            /* Website name, username and special word sent from initial screens received...*/
        }
        getIMEI();
        //pwTextView.setText(userName+" ");
        //pwTextView.append(siteName+" ");
        //pwTextView.append(keyword);

        executeCodeRed();//the main logic...

        generatePassword();//generate the password

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

        /*------------------------------------------------------------------*/

        if(userName.length() < 15)
        {
            /* If this condition is true, then additional characters will have to be added to fill
            up the userName string. It will be filled in such a way that the same string gets
            appended to the userName repeatedly until the length reaches 15. (This will be done
            character by character, not whole string at once.)
             */
            int j = 0;

            StringBuilder tempFinalString = new StringBuilder(userName);
                /* StringBuilder will hold the original userName string. The following loop will
                   keep on adding to it the same userName, until the length reaches 26...
                 */
            for(int i = userName.length(); i < 15; i++)
            {
                if(j==userName.length())
                {
                        /* Revert back to the first character to continue filling the
                        empty spaces of the userName.
                         */
                    j = 0;
                }
                tempFinalString.insert(i, userName.charAt(j));
                j++;
            }
            userName = tempFinalString.toString();
        }

        else if(userName.length() > 15)
        {
            //Trim the userName to 15 characters only...
            StringBuilder tempFinalString = new StringBuilder();
            for(int i = 0; i<15; i++)
            {
                tempFinalString.insert(i, userName.charAt(i));
            }
            userName = tempFinalString.toString();
        }
        /*------------------------------------------------------------------*/
        for(int j = 0; j<imei.length(); j++)//traversing the rows...
        {
            /* This loop goes till the the length of the IMEI number. If the username is smaller
                than this, repetition of the username would take place. If the username is larger than
                this, then it will be trimmed to match the length of the IMEI number...
                 */

            for(int i = 0;i<26; i++)//traverse through the whole coloumn
            {
                colHashMap.put(i, Character.getNumericValue(imei.charAt(j)) + keywordOject.arr[KeywordMatrixAndro.fetchCharacterPosition(userName.charAt(j))] + 32 +  userNameObject.arr[i]);
                /* This is one damn big statement :)
                  value = IMEI(j) + username's jth letter's number from the keyword + 32 + username(i)
                   */
            }
            completeHashMap.put(j, colHashMap);
        }
    }
    public void generatePassword()
    {
        /* Generates the password based on the 2D Hashmap created by the
         executeCodeRed() function
          */
        pwTextView.setText("");//Set the textview blank
        int x, y;
        int asciiNumber;
        KeywordMatrixAndro websiteNameObject = new KeywordMatrixAndro(siteName);
        for(int i = 0; i<siteName.length(); i++)
        {
            int pos = websiteNameObject.fetchCharacterPosition(siteName.charAt(i));
            x = websiteNameObject.arr[pos];
            y = i;
            try
            {
                asciiNumber = (Integer) completeHashMap.get(y).get(x);
                //System.out.println(completeHashMap.get(y).get(x));

                /*EXPLANATION: completeHashMap.get(y) returns the complete coloumn hashmap
                @ the position y. So we've the whole coloumn hashmap. To extract the value
                out of it, we call the get function of this coloumn hashmap ( thus the .get(x) )
                and we had to cast this to Integer explicitly as it was returning an object.
                 */
                pwTextView.append(Character.toString((char)asciiNumber));
            }
            catch(NullPointerException ex)
            {
                System.err.println(ex);
                System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOO");
                //System.out.println(completeHashMap.get(y).get(x));
                StackTraceElement[] trace = ex.getStackTrace();
                System.err.println(trace[0].toString());
            }
        }
    }
}



