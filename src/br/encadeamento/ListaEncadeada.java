package br.encadeamento;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinícius Luis da Silva
 */

public class ListaEncadeada<T> {
    private NoLista primeiro;
    private NoLista ultimo;
    
    public ListaEncadeada() {
        this.primeiro = null;
    }
    
    public NoLista<T> getPrimeiro(){
        return this.primeiro;
    }
    
    public NoLista<T> getUltimo(){
        return this.ultimo;
    }
    
    public void inserir(T info){
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }
    
    public void inserirNoFinal(T info){
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(null);
        
        if(this.estaVazia()){
            this.primeiro = novo;
        }else{
            this.ultimo.setProximo(novo);
        }
        ultimo = novo;
    }
    
    public void exibir(){
        NoLista<T> p = this.primeiro;
        while(p != null){
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
    }
    
    public boolean estaVazia(){
        return (this.primeiro == null);
    }
    
    public NoLista<T> buscar(T info){
        NoLista p = this.primeiro;
        while(p != null){
            if(p.getInfo().equals(info)){
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }
    
    public void retirar(T info){
        NoLista anterior = null;
        NoLista p = primeiro;
        
        while (p != null && (p.getInfo() != info)) {            
            anterior = p;
            p = p.getProximo();
        }
        
        if (p != null) {
            if (anterior == null) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }
    
    public int obterComprimento(){
        int qtdNos = 0;
        NoLista<T> p = this.primeiro;
        while(p != null){
            qtdNos++;
            p = p.getProximo();
        }
        return qtdNos;
    }
    
    public NoLista<T> obterNo(int idx){
        NoLista p = this.primeiro;
        int contadorIdx = 0;
        
        while(contadorIdx < idx){
            if((p == null) || (idx < 0)){
                throw new IndexOutOfBoundsException();
            }
            p = p.getProximo();
            contadorIdx++;
        }
        
        return p;
    }
    
    @Override
    public String toString(){
        String str = "";
        NoLista<T> p = this.primeiro;
        
        while(p != null){
            str += p.getInfo()+", ";
            p = p.getProximo();
        }
        return (str.equals("")) ? "" : str.substring(0, str.length()-2);
    }
    
    public ListaEncadeada<T> criarSubLista(int inicio, int fim){
        if((inicio < 0) || (inicio > fim)){
            throw new IndexOutOfBoundsException();
        }
        ListaEncadeada<T> subLista = new ListaEncadeada<>();
        NoLista<T> n = this.primeiro;
        int contador = 0;
        
        while(contador <= fim){
            if(n == null){
                throw new IndexOutOfBoundsException();
            }
            if(contador >= inicio){
                subLista.inserir(n.getInfo());
            }
            n = n.getProximo();
            contador++;
        }
        
        return subLista;
    }
}
