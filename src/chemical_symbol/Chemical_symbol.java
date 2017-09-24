/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chemical_symbol;

import java.util.ArrayList;

/**
 *
 * @author CHEDJOU
 */
public class Chemical_symbol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ChemicalSymbols cs = new ChemicalSymbols();
        cs.ruleVerification("Spenglerium", "Ee");
        cs.ruleVerification("Zeddemorium ", "Zr");
        cs.ruleVerification("Venkmine ", "Kn");
        cs.ruleVerification("Stantzon ", "Zt");
        cs.ruleVerification("Melintzum ", "Nn");
        cs.ruleVerification("Tullium  ", "Tu");
        cs.ruleVerification("Ttee  ", "Te");
       
    }
}
