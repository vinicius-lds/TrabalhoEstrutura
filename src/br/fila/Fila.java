package br.fila;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinícius Luis da Silva
 */
public interface Fila<T> {
    public void inserir(T info);
    public boolean estaVazia();
    public T peek();
    public T retirar();
    public void liberar();
}
