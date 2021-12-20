/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.util.*;
import java.io.*;
import component.entry;
/**
 *
 * @author tranthanhson
 */
public class readData {
    HashMap<String,Vector<String>> keyDef;
    HashMap<String,Vector<String>> defKey;
    File file;

    private void init(String e){
        Vector<String> value = new Vector<String>();
        this.defKey.put(e, value);
    }
    public readData(){
    keyDef = new HashMap<String,Vector<String>>();
    defKey = new HashMap<String,Vector<String>>();
    file = new File("slang.txt");
    try{
    Scanner scanner = new Scanner(file);
    int count = 0;
    while(scanner.hasNextLine()){
        String value = scanner.nextLine();
        if(value.split("`").length == 1){
        continue; 
        }
        entry e = entry.parseEntry(value);
        keyDef.put(e.getKeyword(), e.getDefination());
        for(String ex : e.getDefination()){
            if(!defKey.containsKey(ex)){
                this.init(ex);
                defKey.get(ex).add(e.getKeyword());
            }
            else{
                            defKey.get(ex).add(e.getKeyword());
            }
        }
    }
    scanner.close();
    }catch(Exception e)
    {}
}

    public HashMap<String, Vector<String>> getKeyDef() {
        return keyDef;
    }

    public HashMap<String, Vector<String>> getDefKey() {
        return defKey;
    }
    
    
}
