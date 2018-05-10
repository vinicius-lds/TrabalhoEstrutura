package br.vo;

import br.fila.FilaLista;
import br.pilha.PilhaLista;
import java.awt.List;
import java.util.regex.Pattern;

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

    public FilaLista<String> gerarExprPosfixada(FilaLista<String> exprlnfixada) {
        
        //Instancia as Listas
        FilaLista<String> fila = new FilaLista<>();
        PilhaLista<String> pilha = new PilhaLista<>();
        
        //Cria duas variais de controle
        String aux, auxAnterior = "";

        while (!exprlnfixada.estaVazia()) {
            //Remove um item da fila em parametro
            aux = exprlnfixada.retirar();
            
            //Verifica se é um operado ou parenteses para , 
            //caso seja um parenteses verifica se o anterior é 
            //um operador caso não seja inserer um operador de multiplicação
            //na pilha.
            if (((aux.length() == 1) && isOperador(aux.charAt(0))) || aux.equals("(")) {
                if (!(auxAnterior.isEmpty()) && (aux.equals("(")) && !((auxAnterior.length() == 1) && isOperador(auxAnterior.charAt(0)))) {
                    pilha.push("*");
                }
                pilha.push(aux);
            }
            //Verifica se é um fechar de parenteses, 
            //caso seja remove itens da pilha até achar um abrir e, caso não seja
            //inseri na fila
            else {
                if (aux.equals(")")) {
                    while (!pilha.estaVazia()) {
                        aux = pilha.pop();
                        if (!aux.equals("(")) {
                            fila.inserir(aux);
                        }
                    }
                } else {
                    fila.inserir(aux);
                }
            }
            //Atribui o aux atual para anterior
            auxAnterior = aux;
        }
        
        //Remove os ultimos elementos da pilha e insere na fila
        while (!pilha.estaVazia()) {
            fila.inserir(pilha.pop());
        }
        
        return fila;
    }

    public double calcularExprPosfixada(FilaLista<String> exprPosfixada) {
        return Double.MIN_VALUE;
    }

}
