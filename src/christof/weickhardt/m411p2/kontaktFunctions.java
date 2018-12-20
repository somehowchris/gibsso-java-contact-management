/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christof.weickhardt.m411p2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author christoftobias.weick
 */
public class kontaktFunctions {
    public static kontaktData searchKontakt(ArrayList<kontaktData> list, String name, String vorname){
        for(kontaktData data : list){
            if(data.getName().equals(name) && data.getVorname().equals(vorname)){
                return data;
            }
        }
        return null;
    }
    public static kontaktData searchKontakt(HashMap<String,ArrayList<kontaktData>> list, String name, String vorname){
        if(list.containsKey(name)){
            ArrayList<kontaktData> people = list.get(name);
            //Optional<kontaktData> kd = people.stream().filter(person -> (person.getVorname().equals(vorname))).findFirst();
            //return kd.get();
            for(kontaktData kd : people){
                if(kd.getVorname().equals(vorname)){
                    return kd;
                }
            }
            return null;
        }
        return null;
    }
    
    
    public static HashMap<String,Integer> countNames(ArrayList<kontaktData> list){
        HashMap<String, Integer> names = new HashMap();
        
        for(kontaktData kd : list){
            String name = kd.getName();
            if(names.containsKey(name)){
                int current = (Integer) names.get(name);
                names.put(name, current++);
            }else{
                names.put(name,1);
            }
        }
        return names;
    }
    public static HashMap<String,ArrayList<kontaktData>> getNameHashmap(ArrayList<kontaktData> list){
        HashMap<String, ArrayList<kontaktData>> names = new HashMap();

        for(kontaktData kd : list){
            String name = kd.getName();
            if(names.containsKey(name)){
                ArrayList<kontaktData> current = (ArrayList<kontaktData>) names.get(name);
                current.add(kd);
            }else{
                ArrayList<kontaktData> kdData = new ArrayList<>();
                kdData.add(kd);
                names.put(name, kdData);
            }
        }
        return names;
    }
}
