package br.vo;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinícius Luis da Silva
 */
public class Divisao implements Operacao{
    @Override
    public double calcular(double valor1, double valor2) {
        return (valor2 == 0) ? null : valor1/valor2;
    }
    
}
