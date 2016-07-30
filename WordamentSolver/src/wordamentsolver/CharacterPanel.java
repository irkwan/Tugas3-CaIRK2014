/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordamentsolver;

/**
 *
 * @author ASUS
 */
public class CharacterPanel {
    public char karakter; //karakter pada panel
    public boolean taken; //boolean untuk indikasi apakah panel sudah dilewati
    
    public CharacterPanel(){
        karakter=' ';
        taken=false;
    }
}
