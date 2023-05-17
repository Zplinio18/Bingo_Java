/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bingo;

import java.util.Arrays;

/**
 *
 * @author pedro
 */
public class Cartela {
    
    private static int NumCartelas = 0;
    private static int[] sorteados = new int[75];
    private static int cont = 0;
    
    private int cartela;
    private int[][]matN = new int[5][5];
    private String[][]matS = new String[5][5];
    
    
    public Cartela(){
        NumCartelas++;
        cartela = NumCartelas;
        inicializaVetor();
    }
    public static int NCart(){
        return NumCartelas;
    }
    private static void inicializaVetor(){
        for(int i=0; i < 75; i++)
            sorteados[i] = 0;
    }
    
    
    public int []sorteiaColuna(int a, int b){
        
        int []vet = new int[5];
        int x, i = 0,aux = 0;
        
        for(int l=0; l < 5; l++){
            vet[i] = 0;
        }
        
        while (i<5)
        {
            x = (int) (Math.random()*(b-a)+a);
            
            for(int j =0;j < 5;j++){
                if(x==vet[j])
                    aux=1;
            }
            
            if(aux == 1)
                aux = 0;
            else{
                vet[i] = x;
                i++;
            } 
        }
        Arrays.sort(vet);
        
        return vet;
    }
    public void  inicializaMatS(){
        
        for(int i=0; i < 5; i++)
            for(int j=0; j<5; j++)
                matS[i][j] = "[ ]";
        
        matS[2][2]="[x]";

                
    }
    public void inicializaMatN(){
        int[]v=new int[5];
        
        v = sorteiaColuna(1, 15);
        for(int j=0; j< 5;j++){
            matN[j][0] = v[j];
        }
        
        v = sorteiaColuna(16, 30);
        for(int j=0; j< 5;j++){
            matN[j][1] = v[j];
        }
        v = sorteiaColuna(31, 45);
        for(int j=0; j< 5;j++){
            matN[j][2] = v[j];
        }
        v = sorteiaColuna(46, 60);
        for(int j=0; j< 5;j++){
            matN[j][3] = v[j];
        }
        v = sorteiaColuna(61, 75);
        for(int j=0; j< 5;j++){
            matN[j][4] = v[j];
        }
      matN[2][2] = 99;      

    }
    public void inicializa(){
        inicializaMatS();
        inicializaMatN();
    }
    public void imprimeJogo(){
        
        System.out.println("Cartela " +cartela);
        System.out.print("   B   "+ "  I   "+ "  N   " + "  G   "+ "  O   \n");
        
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(matN[i][j] == 99)
                    System.out.print("      ");
                else
                    System.out.print(" "+matS[i][j]+matN[i][j]);
                if(matN[i][j]<10)
                    System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static boolean existe(int x){
        for(int i=0; i < 75; i++)
            if(sorteados[i] == x)
                return false;
        
        return true;
           
    }
    public static void sorteiaNumero(){
        
        int x;
        do{
           x = (int) (Math.random()*(75-1)+1);
        }
        while(!existe(x));
        
        sorteados[cont] = x;
        cont ++;
        
        System.out.println("O numero sorteado foi: " +x);
    }
   public void marcaValor(){
       
      for(int i=0; i < 5; i++)
            for(int j=0; j<5; j++)
                if(matN[i][j] == sorteados[cont-1]){
                    matS[i][j] = "[x]";
                    System.out.println("O jogador " +cartela+ " marcou!");
                    System.out.println("");
                }
                    
   }
    
   public boolean verificaLinha(){
       
       
       for(int i = 0; i < 5; i++)
                        for(int j = 0; j< 5; j++)
                            if(i == 0 &&matS[i][j].equals("[x]") && matS[i+1][j].equals("[x]") && matS[i+2][j].equals("[x]") && matS[i+3][j].equals("[x]")&& matS[i+4][j].equals("[x]"))
                                return true;
                            else if(j == 0 && matS[i][j].equals("[x]") && matS[i][j+1].equals("[x]") && matS[i][j+2].equals("[x]") && matS[i][j+3].equals("[x]")&& matS[i][j+4].equals("[x]"))
                                return true;
       
       return false;
   }
   public boolean verificaCruz(){
       int ver = 0;
       
       for(int i=0; i <5; i++){
           if(matS[i][2].equals("[x]"))
               ver++;
           if(matS[2][i].equals("[x]"))
               ver++;
       }
       
       return ver==10;
   }
}
