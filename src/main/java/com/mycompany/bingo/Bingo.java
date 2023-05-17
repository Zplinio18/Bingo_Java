/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bingo;

import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class Bingo {
    
    public static void inicioJogo(){
        System.out.println("Bem vindo ao Bingo!");
        }
    public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            int modo,players;
            boolean fim = true;
            String ver;
            int aux=0;
            inicioJogo();
            
            System.out.println("Digite o numero de Jogadores:");
            players = teclado.nextInt();
            
            Cartela[]vet = new Cartela[players];
            do{
                System.out.println("Digite o modo de jogo:\n"
                                         + "1 - Linha\n"
                                         + "2 - Cruz");
            
                modo = teclado.nextInt();
            }
            while (modo != 1 && modo != 2);
            
            for(int i = 0; i < players; i++){
                vet[i] = new Cartela();
            }
                
            for(int i=0; i < Cartela.NCart();i++){
                vet[i].inicializa();
                vet[i].imprimeJogo();
            }
            
            System.out.println("Deseja continuar? (s/n)");
            ver = teclado.next();
            
            while(ver.equals("s") && fim){
                Cartela.sorteiaNumero();
                
                for(int i=0; i < Cartela.NCart();i++)
                    vet[i].marcaValor();
                for(int i=0; i < Cartela.NCart();i++)
                    vet[i].imprimeJogo();
                for(int i=0; i < Cartela.NCart();i++){
                    if(modo == 1)
                    {
                        if(vet[i].verificaLinha()){
                            aux=i;
                            fim=false;
                        }
                    }
                    else{
                         if(vet[i].verificaCruz()){
                            aux=i;
                           fim=false;
                        }
                    }
                }
                    
                
                
                System.out.println("Deseja continuar? (s/n)");
                ver = teclado.next();
            }
            
            System.out.println("Fim de Jogo! Vitoria da cartela 0"+ (aux+1));
                
                
    }
}
