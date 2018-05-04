package br.vo;


import br.fila.FilaLista;

/**
 * @author Vinícius Luis da Silva && Carlos Henrique Ponciano da Silva
 */
public class Calculadora {
    
    public FilaLista<String> extrairTermos(String expressao) {
        
        //Elimina espaços
        expressao = expressao.replace(" ", "");
        
        //Cria variaveis
        FilaLista<String> fila = new FilaLista<String>();
        String digitos = "";
        
        for (int i = 0; i < expressao.length(); i++) {
            if(isOperador(expressao.charAt(i))) {
                
                //Numero negativo
                if(expressao.charAt(i) == '-' && expressao.charAt((i - 1 == -1) ? 0 : i - 1) == '(') {
                    digitos += expressao.charAt(i);
                    continue;
                } else { //Operador
                    if(digitos.length() > 0) {
                        fila.inserir(digitos);
                        digitos = "";
                    }
                    fila.inserir(String.valueOf(expressao.charAt(i)));
                }
                
            }
            
            //Possivel numero
            if(Character.isDigit(expressao.charAt(i)) || expressao.charAt(i) == ',') {
                digitos += expressao.charAt(i);
                continue;
            }
            
            //Insere parenteses e tambem possiveis digitos
            if(expressao.charAt(i) == ')'){
                if(digitos.length() > 0){
                    fila.inserir(digitos);
                    digitos = "";
                }
                fila.inserir(")");
                continue;
            } else if(expressao.charAt(i) == '(') {
                if(digitos.length() > 0){
                    fila.inserir(digitos);
                    digitos = "";
                }
                fila.inserir("(");
                continue;
            }
            
        }
        
        //Insere último elemento
        if(digitos.length() > 0) {
            fila.inserir(digitos);
            digitos = "";
        }
        
        return fila;
    }
    
    private boolean isOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    public FilaLista<String> gerarExprPosfixada(FilaLista<String> exprlnfixada) {
        
        FilaLista<String> fila = new FilaLista<String>();
        
        while(!exprlnfixada.estaVazia()) {
            
            
            
        }
        
        return null;
    }
    
    public double calcularExprPosfixada(FilaLista<String> exprPosfixada) {
        return Double.MIN_VALUE;
    }
    
}
