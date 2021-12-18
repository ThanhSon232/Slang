/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;
import java.util.*;
/**
 *
 * @author tranthanhson
 */
public class entry {
    String keyword;
    Vector<String> Defination;
    
    entry(){
        this.Defination = new Vector<String>();
    }
    
    entry(String keyword, Vector<String> Defination){
    this.keyword = keyword;
    this.Defination = Defination;
    }
    
    entry(entry E){
    this.keyword = E.getKeyword();
    this.Defination = E.getDefination();
    }
    
        public static  entry parseEntry(String str) {
        entry temp = new entry();
        String[] arrStr = str.split("`");
        temp.keyword = arrStr[0];
        String[] def = arrStr[1].replace('|',' ').split("  ");
        for(String e : def){
            temp.Defination.add(e);
        }
        return temp;   
    }
       
    public String getKeyword(){
        return keyword;
    } 
    
    public Vector<String> getDefination(){
        return Defination;
    }
}
