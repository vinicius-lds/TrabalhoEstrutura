package br.vo;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinícius Luis da Silva
 */
public class Adicao implements Operacao{
    @Override
    public double calcular(double valor1, double valor2) {
        return valor1 + valor2;
    }    
}
