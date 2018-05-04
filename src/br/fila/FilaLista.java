package br.fila;

import br.fila.ListaDupla;

public class FilaLista<T> implements Fila<T> {

    ListaDupla<T> info = new ListaDupla<T>();

    @Override
    public void inserir(T valor) {
        this.info.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return info.estaVazia();
    }

    @Override
    public T peek() {
        return info.getUltimo().getInfo();
    }

    @Override
    public T retirar() {
        T ultimo = this.info.getUltimo().getInfo();
        this.info.retirar(ultimo);
        return ultimo;
    }

    @Override
    public void liberar() {
        this.info = new ListaDupla<T>();

    }

    @Override
    public String toString() {
        return this.info.toString();
    }

    public static void main(String[] args) {
        FilaLista<Integer> fila = new FilaLista<Integer>();
        for (int i = 1; i <= 5; i++) {
            fila.inserir(i);
        }
        System.out.println(fila.toString());
        fila.retirar();
        fila.retirar();
        System.out.println(fila.toString());;
        //FilaLista<Integer> fila3 = fila.criaFilaConcatenada(fila2);
        //System.out.println(fila3.toString());
    }

}
