/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim_cache;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cassi
 */
public class Cache {
    private int nsets;
    private int bsize;
    private int assoc;
    private int misscomp;
    private int missconf;
    private int misscap;
    private int hit;
    private int acessos;
    private int temptag;
    private int tempind;
    private int alocados;
    private ArrayList <Blocos> blocos;
    
    public Cache(){
        nsets = 256;
        bsize = 4;
        assoc = 1;
        misscomp = 0;
        missconf = 0;
        misscap = 0;
        hit = 0;
        acessos = 0;
        alocados = 0;
        blocos = new ArrayList();
        Blocos aux;
        for(int i=0; i<nsets; i++){
            aux = new Blocos();
            blocos.add(aux);
        }
    }
    
    public Cache(int nsets, int bsize, int assoc){
        this.nsets = nsets;
        this.bsize = bsize;
        this.assoc = assoc;
        misscomp = 0;
        missconf = 0;
        misscap = 0;
        hit = 0;
        acessos = 0;
        alocados = 0;
        blocos = new ArrayList();
        Blocos aux;
        for(int i=0; i<nsets*assoc; i++){
            aux = new Blocos();
            blocos.add(aux);
        }
    }
    
    public void procura(int endereco){
        acessos++;
        temptag = (endereco/bsize) / nsets;
        tempind = (endereco/bsize) % nsets;
        Blocos auxb;
        for(int i = tempind*assoc; i<tempind*assoc+assoc; i++){
            auxb = blocos.get(i);
            //System.out.println("temp: "+temptag+" aux: "+auxb.getTag());
            if(auxb.getVal()==0){
                auxb.setTag(temptag);
                auxb.setVal(1);
                alocados++;
                misscomp++;
                return;
            }
            if(temptag == auxb.getTag()){
                hit++;
                return;
            }
        }
        if(alocados>=nsets*assoc){
            misscap++;
            Random rand = new Random();
            int aux;
            aux = tempind*assoc + rand.nextInt(assoc);
            auxb = blocos.get(aux);
            auxb.setTag(temptag);
            return;
        }
        else{
            missconf++;
            Random rand = new Random();
            int aux = tempind*assoc + rand.nextInt(assoc);
            auxb = blocos.get(aux);
            auxb.setTag(temptag);
            return;
        }
    }
    
    public int getMisscomp(){
        return misscomp;
    }
    
    public int getMissconf(){
        return missconf;
    }
    
    public int getMisscap(){
        return misscap;
    }
    public int getHit(){
        return hit;
    }
    public int getAcessos(){
        return acessos;
    }
}
