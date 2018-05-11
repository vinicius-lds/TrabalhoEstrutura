package br.vo;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinícius Luis da Silva
 */
public class Divisao extends Operacao{    
    
    private static Divisao divisao;
    
    private Divisao(){    
    }
    
    public static Divisao getInstance(){
        if(divisao == null){
            divisao = new Divisao();
        }
        return divisao;
    }
    
    @Override
    public double calcular(double valor1, double valor2) {
        return (valor2 == 0) ? null : valor1/valor2;
    }
    
}
