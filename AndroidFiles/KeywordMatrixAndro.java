package archityadav.passwordgenerator;

/**
 * Created by Archit on 28-11-2016.
 */
/*This class doesn't have any Android activity associated with it. It is just for providing access to the
 main rotation logic...
  */
public class KeywordMatrixAndro
{
    public static int []arr = new int[26];

    /*Constructor*/
    KeywordMatrixAndro(String string)
    {
        initializeTheArray();
        for(int i = 0; i<string.length(); i++)// loop will run till the word length
        {
            mouldTheArray(string.charAt(i));
        }
    }
    /*-------------------------*/



    static int fetchCharacterPosition(char c)
    {
        int no = c;

        if(no >= 97)
        {
            no = no-97;
        }
        else if(no >=65 && no <= 90)//to take care of the capital letters.
        {
            no = no-65;
        }
        return no;
    }

    /*--------------------------------------------------*/

    static int mouldTheArray(char ch)
    {
        int []tempArray = new int[26];

        int posToStop = fetchCharacterPosition(ch);

        for(int i = 0; i<26; i++)
        {
            tempArray[i] = arr[i];
            if((i+1)==posToStop)
            {
                for(int downCounter = posToStop, iterator = 0; downCounter>0; downCounter--, iterator++)
                {
                    arr[iterator] = tempArray[downCounter-1];
                }
                break;
            }
        }
        return 0;
    }

    static void initializeTheArray()//To be called once.
    {
        for(int i = 0; i<26; i++)
        {
            arr[i] = i;
            /* this should be i, not i+1, else NullPointerException may be thrown
            for letter z caused by ArrayIndexOutOfBoundsException...
             */
        }
    }

    /*--------------------------*/


}
