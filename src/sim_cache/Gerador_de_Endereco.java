/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim_cache;
import java.io.*;
import java.util.Random;
/**
 *
 * @author cassi
 */
public class Gerador_de_Endereco {
   public Gerador_de_Endereco(){
    
}
    public void Gerador(){
    try {
                   File file = new File("arqTexto1.txt");
                   PrintWriter outFile = new PrintWriter(new FileWriter(file));
                   FileOutputStream outFileBin = new FileOutputStream("arqBinario1.dat");
		   DataOutputStream out = new DataOutputStream(outFileBin);

                   int numGerado = 0;
                   Random r = new Random();
                   //System.out.println("Endereços gerados: ");
                    for(int i=0;i<100;i++){
                        numGerado=r.nextInt(10);
                        outFile.println(numGerado);
                        out.writeInt(numGerado);
                        //System.out.println(numGerado);
                   }
                   for(int i=0;i<1000;i++){
                        numGerado=r.nextInt(10000);
                        outFile.println(numGerado);
                        out.writeInt(numGerado);
                        //System.out.println(numGerado);
                   }
		   outFile.close();
                   outFileBin.close();
	   }
	   catch (FileNotFoundException exception){
		System.out.println("Arquivo nao encontrado.");
	   }
	   catch (IOException exception){
		System.out.println("Erro de I/O: " + exception);
	   }	
    }
    }
