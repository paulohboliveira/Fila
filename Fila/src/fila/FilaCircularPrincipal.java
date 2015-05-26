package fila;

import java.util.Scanner;

public class FilaCircularPrincipal {
    public static void main(String[] args) {
        int quant;
        int numero = 1;
        int operacao;
        boolean opc = true;
        Scanner input = new Scanner(System.in);
        Fila f = new Fila ();
        System.out.println("Quantos elementos terá sua fila?");
        quant = input.nextInt();
        f.criarFila(quant);
        while(opc == true){
            System.out.println("O que você quer fazer?");
            System.out.println("1 - incrementar elementos; 2 - decrementar elementos; 3 - mostrar o inicio; 4 - listar fila; 5 - mostrar tamanho; 6 - fechar programa;");
            operacao = input.nextInt();
            switch(operacao){
                case 1: {
                    f.enfileirar(numero);
                    numero++;
                    break;
                }
                case 2: {
                    f.desenfileirar();
                    break;
                }
                case 3: {
                    if(f.pegarInicio()==-1){
                        System.out.println("A Fila não possui elementos.");
                        break;
                    }
                    else{
                        System.out.println("Primeiro da Fila: " +f.pegarInicio());
                        break;
                    }
                }
                case 4: {
                    f.listar();
                    break;
                }
                case 5: {
                    System.out.println("Tamanho da Fila: " +f.tamanho());
                    break;
                }
                case 6: {
                    opc = false;
                    break;
                }
                default: {
                    System.out.println("Opção incorreta.");
                }
            }
        }
    }
}
