package br.pilha;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinícius Luis da Silva
 */
public interface Pilha<T> {
    public void push(T info);    
    public T pop();
    public T peek();
    public boolean estaVazia();
    public void liberar();
}
