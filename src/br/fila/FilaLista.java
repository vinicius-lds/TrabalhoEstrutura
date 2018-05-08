package br.fila;

import br.encadeamento.ListaEncadeada;
import br.encadeamento.NoLista;

/*
 * @author Carlos Henrique Ponciano da Silva && Vinicius Luis da Silva
*/

public class FilaLista<T> implements Fila<T>{
    
    private ListaEncadeada<T> lista;

    public FilaLista() {
        lista = new ListaEncadeada<>();
    } 
    
    @Override
    public void inserir(T info) {
        lista.inserirNoFinal(info);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new RuntimeException("Fila vazia");
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        T info = this.peek();
        lista.retirar(info);
        return info;
    }

    @Override
    public void liberar() {
        while(!estaVazia()){
            this.retirar();
        }
    } 
    
    public String toString(){
        String str = "";
        NoLista<T> p = lista.getPrimeiro();
        
        while(p != null){
            str += p.getInfo()+", ";
            p = p.getProximo();
        }
        return (str.equals("")) ? "" : str.substring(0, str.length()-2);
    }
}
