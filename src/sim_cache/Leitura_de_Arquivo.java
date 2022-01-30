/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim_cache;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cassi
 */
public class Leitura_de_Arquivo {
    private Cache c;
    public Leitura_de_Arquivo(Cache c){
        this.c = c;
    }
    
    public void leitura(){
        try
         {
                 DataInputStream arq = new DataInputStream(new BufferedInputStream(new FileInputStream("arqBinario1.dat")));
       try {
           while(arq.available()!=0){
               int linha = arq.readInt();
               c.procura(linha);
                }
            } catch (IOException ex) {
           Logger.getLogger(Leitura_de_Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(Leitura_de_Arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
       }catch (FileNotFoundException e) {
           e.printStackTrace();
        }
    }
    
}
