package br.vo;

import br.fila.FilaLista;
import br.pilha.PilhaLista;
import javax.swing.JOptionPane;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinícius Luis da Silva
 */
public class Calculadora {

    public FilaLista<String> extrairTermos(String expressao) {

        //Elimina espaços
        expressao = expressao.replace(" ", "");

        //Cria variaveis
        FilaLista<String> fila = new FilaLista<String>();
        String digitos = "";

        for (int i = 0; i < expressao.length(); i++) {
            if (isOperador(expressao.charAt(i))) {

                //Numero negativo
                if (expressao.charAt(i) == '-' && expressao.charAt((i - 1 == -1) ? 0 : i - 1) == '(') {
                    digitos += expressao.charAt(i);
                    continue;
                } else { //Operador
                    if (digitos.length() > 0) {
                        fila.inserir(digitos);
                        digitos = "";
                    }
                    fila.inserir(String.valueOf(expressao.charAt(i)));
                }

            }

            //Possivel numero
            if (Character.isDigit(expressao.charAt(i)) || expressao.charAt(i) == ',') {
                digitos += expressao.charAt(i);
                continue;
            }

            //Insere parenteses e tambem possiveis digitos
            if (expressao.charAt(i) == ')') {
                if (digitos.length() > 0) {
                    fila.inserir(digitos);
                    digitos = "";
                }
                fila.inserir(")");
                continue;
            } else if (expressao.charAt(i) == '(') {
                if (digitos.length() > 0) {
                    fila.inserir(digitos);
                    digitos = "";
                }
                fila.inserir("(");
                continue;
            }

        }

        //Insere último elemento
        if (digitos.length() > 0) {
            fila.inserir(digitos);
            digitos = "";
        }

        return fila;
    }

    private boolean isOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    private int procedenciaOperador(char c){
        if(c == '/' || c == '*'){     
            return 3;
        }
        if(c == '+' || c == '-'){
            return 2;
        }
        return 1;
    }

    public FilaLista<String> gerarExprPosfixada(FilaLista<String> exprlnfixada) {
        
        //Instancia as Listas
        FilaLista<String> fila = new FilaLista<>();
        PilhaLista<String> pilha = new PilhaLista<>();
        
        //Cria duas variais de controle
        String aux, subAux;
        
        while (!exprlnfixada.estaVazia()) {

            //Remove um item da fila em parametro
            aux = exprlnfixada.retirar();
            
            //Verifica se é um operado ou parenteses para , 
            //caso seja um parenteses verifica se o anterior é 
            //um operador caso não seja inserer um operador de multiplicação
            //na pilha
            if(aux.equals("(")){
                
                pilha.push(aux);
                
            }
            else if (((aux.length() == 1) && isOperador(aux.charAt(0)))) {
                
                while(!pilha.estaVazia() && procedenciaOperador(pilha.peek().charAt(0)) >= procedenciaOperador(aux.charAt(0))){
                    fila.inserir(pilha.pop());
                }
                
                pilha.push(aux); 
                
            }
            //Verifica se é um fechar de parenteses, 
            //caso seja remove itens da pilha até achar um abrir e, caso não seja
            //inseri na fila
            else {
                if (aux.equals(")")) {
                    
                    while (!pilha.estaVazia() && !(aux = pilha.pop()).equals("(")) {
                        fila.inserir(aux);
                    }
                    
                } else {
                    
                    //Verifica se é numero negativo, se for elimina os parenteses
                    if(Double.parseDouble(aux.replace(',', '.')) < 0){
                        pilha.pop();//remove a abertura (
                        exprlnfixada.retirar();//remove o fechamento )
                    }                    
                    fila.inserir(aux);
                    
                }
            }
        }
        
        //Remove os ultimos elementos da pilha e insere na fila
        while (!pilha.estaVazia()) {
            subAux = pilha.pop();
            if(!subAux.equals("(")){
                fila.inserir(subAux);
            }
        }
        
        JOptionPane.showMessageDialog(null, fila.toString());
        return fila;
    }

    public double calcularExprPosfixada(FilaLista<String> exprPosfixada) {
        //Cria variavei auxiliares e pilha de operandos
        PilhaLista<Double> operandos  = new PilhaLista<>();
        String strAux;
        double doubleAux;
        
        //Percorre a FilaLista passada como paramentro
        while(!exprPosfixada.estaVazia()) {
            
            //Retira um elemento da Fila
            strAux = exprPosfixada.retirar();
            
            //Ver se o elemento é operador
            if((isOperador(strAux.charAt(0))) && strAux.length() == 1) {
            
                //Caso for passa ele e os dois ultimos elemento da Pilha pro método calcular
                //E coloca o resultado de volta na pilha
                doubleAux = operandos.pop();
                operandos.push(this.calcular(operandos.pop(), doubleAux, strAux));
            } else {
                
                //Se não for só coloca o elemento, que presumidamente é um número
                //na pilha de operandos
                operandos.push(Double.parseDouble(strAux.replace(',', '.')));
            }
        }
        
        //retorna o elemento restante da pilha, que é o resultado final
        return operandos.pop();
    }
    
    private double calcular(double v1, double v2, String operador){
        Operacao op = null;
        
        switch(operador){
            case "+":
                op = Adicao.getInstance();
                break;
            case "-":
                op = Subtracao.getInstance();
                break;
            case "/":
                op = Divisao.getInstance();
                break;
            case "*":
                op = Multiplicacao.getInstance();
                break;
        }
        
        return op.calcular(v1, v2);
    }
}
