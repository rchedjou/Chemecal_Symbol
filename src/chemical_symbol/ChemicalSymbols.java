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
    
    public void ValidSymbol(String elementName, String chemicalSymbole)
    {
              
    }
    public char[] StringTocharArray(String str)
    {
        int a = str.length();
        char[] tab = new char[a];
        tab = str.toCharArray();
        return tab;
    }
    //cette fonction renvoi toutes les position d'u caractere dans une chaine
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
    //cette fonction teste si il ya une chiffre dans une chaine de caratère
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
    //cette fonctio vérifie si cette chainne possede un chiffrr
    public boolean containNumericVerification(String s)
    {
        boolean res = false;
        if(containNumeric(s))
        {
            res = true;
            System.out.println("le paramètre <"+s+"> ne doit pas avoir les valeurs numériques");
        }
        return res;
    }
    
    public boolean validNumberCharacterOfChemicalSymbol(String cs)
    {
        boolean res = false;
        if(cs!=null && !cs.isEmpty() && cs.length()==2 && cs!="  ")
            res=true;
        else
            System.out.println("Le Symbole chimique <"+cs+"> doit avoir 2 caractère!!");
        
        return res;
            
    }
    public boolean validNumberCharacterOfElementName(String en)
    {
        boolean res = false;
        if(en!=null && !en.isEmpty() && en.length()>1)
            res=true;
        else
            System.out.println("Le nom de l'élément <"+en+"> doit avoir au moins 2 caractères!!");
        
        return res;
            
    }
    public String firstCharUppercase(String str)
    {
        char[] char_table = str.toCharArray();
        char_table[0]=Character.toUpperCase(char_table[0]);
        str = new String(char_table);
        return str;
    }
    //cette fonction vérifie la casse
    
    public boolean caseVerification(String str)
    {
        boolean res=false;
        String correctWord = str.toLowerCase();
        correctWord = firstCharUppercase(correctWord);
        if(str.equals(correctWord))
            res = true;
        else
            System.out.println("La première lettre du mot <"+str+"> doit obligatoirement être en Majuscule et le reste en miniscule");
        return res;
    }
    public boolean  parametersVerification(String elementName, String chemicalSymbole)
    {
        boolean res = false;
        //number of character
        if(validNumberCharacterOfElementName(elementName)&&validNumberCharacterOfChemicalSymbol(chemicalSymbole)&&caseVerification(elementName)&&caseVerification(chemicalSymbole)&& !containNumericVerification(elementName)&&!containNumericVerification(chemicalSymbole))
            res = true;
        return res;
    }
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
