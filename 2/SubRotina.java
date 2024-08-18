public class SubRotina
{
    public static double calcularConsumo(double leituraAtual, double leituraAnterior){
        return leituraAtual - leituraAnterior;
    }

    public static void definirStatus(double consumo){
        if (consumo <= 100){
    	    System.out.println("Baixo Consumo");
    	}
    	else if (consumo <= 400){
    	    System.out.println("Médio Consumo");
    	}
    	else {
    	    System.out.println("Alto Consumo");
    	}
    }
    
    public static double calcularConta(double consumo, double valorHora){
        if (consumo > 400){
            valorHora *= 1.3;
        }
        else if (consumo > 100){
            valorHora *= 1.1;
        }
        return consumo * valorHora;
    }
    
	public static void main(String[] args) {
	    double leituraAnterior = 56432;
    	double leituraAtual = 56582;
    	double consumo;

    	double valorHora = 0.48;
    	double conta;

    	consumo = calcularConsumo(leituraAtual, leituraAnterior);
    	definirStatus(consumo);
    	conta = calcularConta(consumo, valorHora);
    	
    	System.out.println("Valor final da conta: " + conta + " R$");
	}
}