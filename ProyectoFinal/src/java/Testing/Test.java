/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import javax.swing.JOptionPane;

/**
 *
 * @author jfert
 */
public class Test {
    public String ArrToString(String[][] arr)
    {
        String str = "";

        for (String[] arr1 : arr) {
            for (String arr11 : arr1) {
                str += arr11 + "\n";
            }
            str += "\n";
        }
        return str;
    }
    
    public static String Arr2ToString(String[] arr){
        String str = "";

        for (String arr1 : arr) {
            str += arr1 + "\n";
        }
        str += "\n";
        
        return str;
    }
    
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}