package br.fila;

/*/
 * @author vinic
/*/
public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;
    
    public ListaDupla() {
        this.primeiro = null;
    }
    
    public NoListaDupla<T> getPrimeiro() {
        return this.primeiro;
    }
    
    public void inserir(T elemento) {
        NoListaDupla<T> novo = new NoListaDupla();
        novo.setInfo(elemento);
        NoListaDupla velho = this.primeiro;
        this.primeiro = novo;
        this.primeiro.setProximo(velho);
        if(velho != null) {
            velho.setAnterior(this.primeiro);
        }
    }
    
    public NoListaDupla<T> getUltimo() {
        NoListaDupla<T> atual = this.primeiro;
        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }
        return atual;
    }
    
    public void exibirOrdemInversa() {
        
        NoListaDupla<T> atual = this.getUltimo();
        
        System.out.print("Elemenos da Lista: { ");
        while (atual != null) {
            System.out.print(atual.getInfo()+ " ");
            atual = atual.getAnterior();
        }
        System.out.println("}");
    }
    
    
    
    public void retirar(T info) {
        
        NoListaDupla<T> noLocalizado = this.getUltimo();
        
        if(noLocalizado != null) {
            if(!noLocalizado.equals(this.primeiro)) {
                noLocalizado.getAnterior().setProximo(noLocalizado.getProximo());
                if(noLocalizado.getProximo() != null) {
                    noLocalizado.getProximo().setAnterior(noLocalizado.getAnterior());
                } else {
                    noLocalizado.getAnterior().setProximo(null);
                }
            } else {
                this.primeiro = this.primeiro.getProximo();
                this.primeiro.setAnterior(null);
            }
        }
        
    }
    
    public void liberar() {
        NoListaDupla<T> atual = this.primeiro;
        NoListaDupla<T> proximo;
        
        while(atual != null) {
            proximo = atual.getProximo();
            atual.setProximo(null);
            atual.setAnterior(null);
            atual.setInfo(null);
            atual = proximo;
        }
    }
    
    @Override
    public String toString() {
        NoListaDupla<T> atual = this.primeiro;
        String str = "";
        while (atual != null) {
            str += atual.getInfo() + ", ";
            atual = atual.getProximo();
        }
        return (str.equals("")) ? str : str.substring(0, str.length() - 2) + ".";
    }
    
    public boolean estaVazia() {
    	return this.primeiro == null;
    }
    
    public void inserirNoFinal(T valor) {
    	if(estaVazia()) {
    		this.inserir(valor);
    	} else{
	    	NoListaDupla<T> noNovo = new NoListaDupla<>();
	    	NoListaDupla<T> ultimo = this.getUltimo();
	    	noNovo.setInfo(valor);
	    	noNovo.setAnterior(ultimo);
	    	ultimo.setProximo(noNovo);
    	}
    }
    
}
