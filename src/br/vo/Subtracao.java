package br.vo;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinícius Luis da Silva
 */
public class Subtracao extends Operacao{  
    
    private static Subtracao subtracao;
    
    private Subtracao(){    
    }
    
    public static Subtracao getInstance(){
        if(subtracao == null){
            subtracao = new Subtracao();
        }
        return subtracao;
    }  
    
    @Override
    public double calcular(double valor1, double valor2) {
        return valor1 - valor2;
    }
}
