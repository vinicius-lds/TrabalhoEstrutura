package br.fila;

public interface Fila<T> {
    public void inserir(T info);
    public boolean estaVazia();
    public T peek();
    public T retirar();
    public void liberar();
}
