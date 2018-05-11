package br.vo;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinícius Luis da Silva
 */
public class Multiplicacao extends Operacao{
    
    private static Multiplicacao multiplicacao;
    
    private Multiplicacao(){    
    }
    
    public static Multiplicacao getInstance(){
        if(multiplicacao == null){
            multiplicacao = new Multiplicacao();
        }
        return multiplicacao;
    }
    
    @Override
    public double calcular(double valor1, double valor2) {
        return valor1 * valor2;
    }
}
