/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christof.weickhardt.m411p2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author christoftobias.weick
 */
public class main {
            
        static String name2Search = "Antoneypillai";
        static String vorname2Search = "Jihed";
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        DB db = new DB("m411p2", "kontakte");
        ArrayList<kontaktData> kd = db.readData();
        long end = System.currentTimeMillis();
        
        
        HashMap names = kontaktFunctions.getNameHashmap(kd);
        
        
        start = System.currentTimeMillis();
        
        kontaktData kdData = kontaktFunctions.searchKontakt(names, name2Search, vorname2Search);
        
        end = System.currentTimeMillis();
        System.out.println(kdData.getVorname());
        
         System.out.println("Search in hashmap"+(end-start)+" ms");
        
        
        
        
        
        System.out.println("Time 2 load: [ms] "+(end-start));
        
        // DB Search
        
        start = System.currentTimeMillis();
        
        kontaktData found = db.searchNV(name2Search, vorname2Search);
        
        end = System.currentTimeMillis();
        
        try{
            System.out.println("Found "+found.getVorname()+" "+found.getName()+" via db search in "+(end-start)+" ms");
        }catch(Exception e){
            System.err.println("Found nobody name "+name2Search+" and first name "+vorname2Search+" via db search in "+(end-start)+" ms");
        }
        // ArrayList Search
        
        start = System.currentTimeMillis();
        
        found = kontaktFunctions.searchKontakt(kd, name2Search, vorname2Search);
        
        end = System.currentTimeMillis();
        
        try{
            System.out.println("Found "+found.getVorname()+" "+found.getName()+" via arraylist search in "+(end-start)+" ms");
        }catch(Exception e){
            System.err.println("Found nobody with name "+name2Search+" and first name "+vorname2Search+" via db search in "+(end-start)+" ms");
        }
        
        // Find names
        
        start = System.currentTimeMillis();
        
        HashMap<String, Integer> list = kontaktFunctions.countNames(kd);
        
        end = System.currentTimeMillis();
        
        System.out.println("Found "+list.size()+" names in "+(end-start)+" ms");
        
        System.out.println("");
        System.out.println("Lets get some data going");
        System.out.println("#FreeTheDataAndOurMindWillFollow");
        System.out.println("");
        
        
    }
}
