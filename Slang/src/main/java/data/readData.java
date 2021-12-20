/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.util.*;
import java.io.*;
import component.entry;
import java.nio.file.Files;
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
    public void addASlang(HashMap<String,Vector<String>> keyDef){
           try{
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("Slang`Defination");
            for(Map.Entry<String,Vector<String>> entry : keyDef.entrySet()){
                if(entry.getValue().size() > 1){
                    String def = "";
                for(int i = 0 ; i < entry.getValue().size(); i ++){
                    if(i < entry.getValue().size() - 1){
                    def = def + entry.getValue().get(i) + "| ";
                    }
                    else  {
                    def = def + entry.getValue().get(i);
                    }
                }
                printWriter.println(entry.getKey() + "`" +def);
                }
                else{
                    printWriter.println(entry.getKey() + "`" + entry.getValue().get(0));
                }
            }
            printWriter.close();
                }catch(Exception e){}
            
    }

    public HashMap<String, Vector<String>> getKeyDef() {
        return keyDef;
    }

    public HashMap<String, Vector<String>> getDefKey() {
        return defKey;
    }
    
    public static void copyFile( File from, File to ) throws IOException {
    Files.copy( from.toPath(), to.toPath() );
} 
    public void load(){
         File temp = new File("originalSlang.txt");
         file = new File("slang.txt");
         try{
             if(!temp.exists())
                 copyFile(file,temp);
                 
            }catch(Exception e)
            {} 
    }
    
    public void rename(){
         File temp = new File("originalSlang.txt");
         file = new File("slang.txt");
         try{
             if(!temp.exists())
                 copyFile(temp,file);
                 
            }catch(Exception e)
            {}
    }
    
    public static void main(String[] args) {
        readData data = new readData();
        data.addASlang(data.getKeyDef());
    }
}
