/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cypher;

import java.util.HashMap;
import javax.swing.JOptionPane;
import java.io.*;

/**
 *
 * @author Sonu
 */
public class cypherGUI_2 extends javax.swing.JFrame
{
    
    String user;
    String kywd;
    String website;
    String imei;
    CypherGUI obj = new CypherGUI();
    
    KeywordMatrix usernameObj;
    
     
    KeywordMatrix keywordObj;
     
    HashMap<Integer, Integer> colMap = new HashMap<Integer, Integer>();
    HashMap<Integer, HashMap> completeMap = new HashMap<Integer, HashMap>();
     
     public void algo()
     {
         usernameObj = new KeywordMatrix(user);
         keywordObj = new KeywordMatrix(kywd);
          if(user.length() < 15)
        {
            /* If this condition is true, then additional characters will have to be added to fill
            up the userName string. It will be filled in such a way that the same string gets
            appended to the userName repeatedly until the length reaches 15. (This will be done
            character by character, not whole string at once.)
             */
            int j = 0;

            StringBuilder tempFinalString = new StringBuilder(user);
                /* StringBuilder will hold the original userName string. The following loop will
                   keep on adding to it the same userName, until the length reaches 26...
                 */
            for(int i = user.length(); i < 15; i++)
            {
                if(j==user.length())
                {
                        /* Revert back to the first character to continue filling the
                        empty spaces of the userName.
                         */
                    j = 0;
                }
                tempFinalString.insert(i, user.charAt(j));
                j++;
            }
            user = tempFinalString.toString();
        }

        else if(user.length() > 15)
        {
            //Trim the userName to 15 characters 
            StringBuilder tempFinalString = new StringBuilder();
            for(int i = 0; i<15; i++)
            {
                tempFinalString.insert(i, user.charAt(i));
            }
            user = tempFinalString.toString();
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
                colMap.put(i, Character.getNumericValue(imei.charAt(j)) + keywordObj.arr[KeywordMatrix.fetchCharacterPosition(user.charAt(j))] + 32 +  usernameObj.arr[i]);
                /* This is one damn big statement :)
                  value = IMEI(j) + username's jth letter's number from the keyword + 32 + username(i)
                   */
            }
            completeMap.put(j, colMap);
        }
    }
         
         
     public void generatePassword()
    {
        
        StringBuilder pwTextView = new StringBuilder("");
        //Set the textview blank
        int x, y;
        int asciiNumber;
        KeywordMatrix websiteNameObject = new KeywordMatrix(website);
        for(int i = 0; i<website.length(); i++)
        {
            int pos = websiteNameObject.fetchCharacterPosition(website.charAt(i));
            x = websiteNameObject.arr[pos];
            y = i;
            try
            {
                asciiNumber = (Integer) completeMap.get(y).get(x);
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
        JOptionPane pwd = new JOptionPane(pwTextView);
    }
     
     
    cypherGUI_2(String web, String imeiLol) 
    {
        website = web;
        imei = imeiLol;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        keyword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Generate Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Keyword");

        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });

        keyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(keyword))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(jButton1)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
        //String user1 = uname.getText().toString();
        //user = user1;        // TODO add your handling code here:
    }                                     

    private void keywordActionPerformed(java.awt.event.ActionEvent evt) {                                        
            
        //String kywd1 = keyword.getText().toString();
        //kywd=kywd1;// TODO add your handling code here:
    }                                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        user = uname.getText();
        kywd = keyword.getText();
        
        generatePassword();
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cypherGUI_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cypherGUI_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cypherGUI_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cypherGUI_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() 
            {
                //new cypherGUI_2().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField keyword;
    private javax.swing.JTextField uname;
    // End of variables declaration                   
}
