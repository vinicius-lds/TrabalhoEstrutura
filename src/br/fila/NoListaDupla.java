package br.fila;

/**
 *
 * @author vinic
 */
public class NoListaDupla<T> {

    private T info;
    private NoListaDupla<T> proximo = null;
    private NoListaDupla<T> anterior = null;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoListaDupla<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoListaDupla<T> proximo) {
        this.proximo = proximo;
    }

    public NoListaDupla<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoListaDupla<T> anterior) {
        this.anterior = anterior;
    }
    
}
