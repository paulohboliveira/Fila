package fila;

public class Fila implements InterfaceFilaCircular{
    private int capacidade;
    private int quantidade = 0;
    private NoCircular fila[];
    private int inicio = 0;
    private int fim = 0;

    @Override
    public void criarFila(int tamanho) {
        fila = new NoCircular [tamanho];
        capacidade = tamanho;
    }

    @Override
    public boolean eCheia() {
        return quantidade == capacidade;
    }

    @Override
    public boolean eVazia() {
        return fim == inicio;
    }

    @Override
    public int tamanho() {
        if(eVazia()){
            return 0;
        }
        else{
            return quantidade;
        }
    }

    @Override
    public NoCircular enfileirar(int valor) {
        if(!eCheia()){
            NoCircular elemento = new NoCircular (valor);
            fila[fim] = elemento;
            quantidade++;
            if(fim < capacidade-1){
                fim++;
                if(fim == inicio){
                    fim--;
                }
            }
            else if(inicio != 0){
                fim = 0;
            }
            return elemento;
        }
        else{
            System.out.println("A Fila está Cheia.");
            return null;
        }
    }

    @Override
    public NoCircular desenfileirar() {
        if(!eVazia()){
            if(inicio<=capacidade-1){
               int aux = inicio;
               fila[inicio] = null;
               if(inicio<capacidade-1){
                   inicio++;
               }
               else{
                   inicio = 0;
               }
               if(fila[aux] == null && quantidade == capacidade){
                   fim++;
                   if(fim == capacidade){
                       fim = 0;
                    }
                } 
            }
            quantidade--;
        }
        else{
            System.out.println("A Fila não possui elementos.");
        }
        return null;
    }

    @Override
    public int pegarInicio() {
        if(inicio != fim){
            return fila[inicio].getValor();
        }
        else{
            return -1;
        }
    }

    @Override
    public void listar() {
        if(!eVazia()){
            int quant = inicio+quantidade;
            int x=inicio;
            for(int i=inicio; i<quant; i++){
                System.out.println(fila[x].getValor());
                x++;
                if(i == capacidade-1 && fim < inicio){
                    x=0;
                }
            }
            System.out.println("---------------------");
        }
        else{
            System.out.println("A Fila não possui elementos.");
        }
    }
}
