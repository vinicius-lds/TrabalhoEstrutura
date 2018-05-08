package br.pilha;

import br.encadeamento.NoLista;
import br.encadeamento.ListaEncadeada;


public class PilhaLista<T> implements Pilha<T>{
    private ListaEncadeada<T> lista = new ListaEncadeada<>();
    
    @Override
    public void push(T info) {
        this.lista.inserir(info);
    }

    @Override
    public T pop() {
        T info = this.peek();
        this.lista.retirar(info);
        return info;
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new RuntimeException("Vazia");
        }
        return this.lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return this.lista.estaVazia();
    }

    @Override
    public void liberar() {
        while(!this.estaVazia()){
            this.pop();
        }
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
