public class Main
{
	public static void main(String[] args) {
	    double leituraAnterior = 56432;
    	double leituraAtual = 56582;
    	double consumo;
    	
    	double valorHora = 0.48;
    	double conta;
    	
    	consumo = (leituraAtual - leituraAnterior);
    	if (consumo <= 100){
    	    System.out.println("Baixo Consumo");
    	}
    	else if (consumo <= 400){
    	    System.out.println("Médio Consumo");
    	    consumo *= 1.1;
    	}
    	else {
    	    System.out.println("Alto Consumo");
    	    consumo *= 1.3;
    	}
    	conta = consumo * valorHora;
    	System.out.println(conta);
	}
}