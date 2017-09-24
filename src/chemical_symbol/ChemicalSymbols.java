/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chemical_symbol;

/**
 *
 * @author CHEDJOU
 */
import java.util.*;

public class ChemicalSymbols {

    public ChemicalSymbols() {
    }
    //this function transforms a string into an array of characters
    public char[] StringTocharArray(String str)
    {
        int a = str.length();
        char[] tab = new char[a];
        tab = str.toCharArray();
        return tab;
    }
    
    //this function returns all the positions of a character in a string
    public ArrayList searchAllChartPositionInString(String str, char c)
    {
        str=str.toLowerCase();
        String c1 = c+"a";
        c1=c1.toLowerCase();
        c=c1.charAt(0);
        
        ArrayList al = new ArrayList();   
        int index=str.indexOf(c);
        do
        {
            if(index!=-1)
                al.add(index);
            index = str.indexOf(c, index +  1) ; 
        }while(index>0);
        return al;
    }
    
    //this function tests whether there is a digit in a string
    public boolean containNumeric(String s)
    {
        boolean containsDigit = false;
        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    containsDigit = true;
                    break;
                }
            }
        }

    return containsDigit;
    }
    
    //this function checks if this string has a number
    public boolean containNumericVerification(String s)
    {
        boolean res = false;
        if(containNumeric(s))
        {
            res = true;
            System.out.println("the <"+ s +"> parameter must not have numeric values");
        }
        return res;
    }
    
   //this function verifies that the character number of the chemical symbol is correct 
    public boolean validNumberCharacterOfChemicalSymbol(String cs)
    {
        boolean res = false;
        if(cs!=null && !cs.isEmpty() && cs.length()==2 && cs!="  ")
            res=true;
        else
            System.out.println("The chemical symbol <"+ cs +"> must have 2 characters.");
        
        return res;
            
    }
    //this function verifies that the character number of the element name is correct 
    public boolean validNumberCharacterOfElementName(String en)
    {
        boolean res = false;
        if(en!=null && !en.isEmpty() && en.length()>1)
            res=true;
        else
            System.out.println("The element name  <"+ en +">  must be at least 2 characters");
        
        return res;
            
    }
    //this function sets the first letter of a string to uppercase
    public String firstCharUppercase(String str)
    {
        char[] char_table = str.toCharArray();
        char_table[0]=Character.toUpperCase(char_table[0]);
        str = new String(char_table);
        return str;
    }
    
    //this function checks the case 
    public boolean caseVerification(String str)
    {
        boolean res=false;
        String correctWord = str.toLowerCase();
        correctWord = firstCharUppercase(correctWord);
        if(str.equals(correctWord))
            res = true;
        else
            System.out.println("The first letter of the word <"+ str +"> must be in uppercase and the sequence in lower case");
        return res;
    }
    
    /* check the validity of the parameters
     * 1- number of character
     * 2-case
     * 3-does not include digits
     * etc.
     */
    public boolean  parametersVerification(String elementName, String chemicalSymbole)
    {
        boolean res = false;
        //number of character
        if(validNumberCharacterOfElementName(elementName)&&validNumberCharacterOfChemicalSymbol(chemicalSymbole)&&caseVerification(elementName)&&caseVerification(chemicalSymbole)&& !containNumericVerification(elementName)&&!containNumericVerification(chemicalSymbole))
            res = true;
        return res;
    }
    
    //this function verifies that the chemecal symbol is valid according to the element name
    public void ruleVerification(String elementName, String chemicalSymbole)
    {
        boolean res = false;
        String buffer = chemicalSymbole;
        if(parametersVerification(elementName,chemicalSymbole))
        {
            
            chemicalSymbole = chemicalSymbole.toLowerCase();
            ArrayList al1 = searchAllChartPositionInString(elementName,chemicalSymbole.charAt(0));
            ArrayList al2 = searchAllChartPositionInString(elementName,chemicalSymbole.charAt(1));
            /*System.out.println(chemicalSymbole.charAt(0)+"=>"+al1+"=>"+elementName);
            System.out.println(chemicalSymbole.charAt(1)+"=>"+al2+"=>"+elementName);*/
            if(!al1.isEmpty()&&!al2.isEmpty())
            {
                for(int i=0; i<al1.size(); i++)
                {
                    for(int j=0; j<al2.size(); j++)
                    {
                        if((int)al1.get(i) < (int)al2.get(j))
                            res = true;
                        if((int)al1.get(i) == (int)al2.get(j) && i!=j)
                            res=true;
                    }
                }
            }
        }
        System.out.println(elementName+" ,"+buffer+" -> "+res);
    }
}
