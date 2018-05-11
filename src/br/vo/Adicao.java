package br.vo;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinícius Luis da Silva
 */
public class Adicao extends Operacao{    
    private static Adicao adicao;
    
    private Adicao(){    
    }
    
    public static Adicao getInstance(){
        if(adicao == null){
            adicao = new Adicao();
        }
        return adicao;
    }
    
    @Override
    public double calcular(double valor1, double valor2) {
        return valor1 + valor2;
    }    
}
