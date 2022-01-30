/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sim_cache;

/**
 *
 * @author cassi
 */
public class Blocos {
   private int val;
   private int tag;
   public Blocos(){
       val = 0;
       tag = -1;
   }
   public int getVal(){
       return val;
   }
   public int getTag(){
       return tag;
   }
   public void setVal(int val){
       this.val = val;
   }
   public void setTag(int tag){
       this.tag = tag;
   }
}
