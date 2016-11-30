import java.lang.*;
import java.util.*;


public class Cypher extends KeywordMatrix {


	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Your Username");
		String usn = s.nextLine();
		
		double imei=0;
		String str_imei = Double.toString(imei);
		while(str_imei.length() != 15) {
		System.out.println("Enter Your 15-digit IMEI Number");
		 str_imei = s.nextLine();
		}
		int []arr_imei = new int[15];
		for(int o=0; o<=14; o++ ){
			arr_imei[o] = Character.digit(str_imei.charAt(o), 10);  //IMEI array is made
		}
		
		
		System.out.println("Security Question:");
		System.out.println("If You Could Make Your Own Planet, What Would You Name It?");
		String kywd = s.nextLine();
		
		System.out.println("Enter Your Website Name (without 'www' and '.com'");
		String wsite = s.nextLine();
		
		for(int i = 0; i<wsite.length(); i++)// loop will run till the word length
        {
            mouldTheArray(wsite.charAt(i));   
        }
		int []webseq = new int[26];
		for(int m=0; m<26; m++){
			webseq[m] = arr[m];
		}
		//sequence with website name is generated
		
		for(int i = 0; i<usn.length(); i++)// loop will run till the word length
        {
            mouldTheArray(usn.charAt(i));   
        }
		int []vert = new int[26];
		for(int k=0; k<26; k++) {
			vert[k] = arr[k];
		}
		//vert[] is the vertical sequence of numbers
		
		for(int i = 0; i<kywd.length(); i++)// loop will run till the word length
        {
            mouldTheArray(kywd.charAt(i));   
        }
		int []keysequence = new int[26];
		for(int j=0; j<26; j++){
			keysequence[j] = arr[j];
		}
		//Sequence is generated for the special keyword
		
		int num1 = keysequence[18];
		int num2 = keysequence[16];
		int num3 = keysequence[11];
		
		Character []pswd = new Character[wsite.length()]; //array for password
		
int a1, hz1,hz2,hz,a2,r,uname_temp,uname_multiply,a3,pass_val, pass_ascii; //variables for algorithm
char p;
		for(int q=0; q<=wsite.length()-1; q++){
			 a1 = num1*(q+1);
			 hz1 = fetchCharacterPosition(wsite.charAt(q));
			 hz2 = webseq[hz1];
			if(hz2 >15) {
				hz2 = hz2%16;
			}
			 hz = arr_imei[hz2];
			 a2 = num2*hz;
			 r = q;
			if(q>=usn.length()){
				r = q%usn.length()+1;
			}
			 uname_temp = fetchCharacterPosition(usn.charAt(r));
			 uname_multiply = vert[uname_temp];
			 a3 = num3*uname_multiply;
			 pass_val = a1+a2+a3;
			 pass_ascii = (pass_val)%93 + 33;
			 p = (char)pass_ascii;
			pswd[q] = p;
			
		}
		
		System.out.println("Your Cyphered Password Is:-\n");
		for(int y=0; y<wsite.length(); y++){
			System.out.print(pswd[y]);
		}
			
}
	
	
}
