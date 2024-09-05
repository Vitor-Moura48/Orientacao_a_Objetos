class Main {
    public static void main(String[] args){
        Pneu pneu1 = new Pneu(132, "VGSM", 110);

        System.out.println("Pneu instanciado: " + pneu1 + "\n");

        if (pneu1.desgastar(4, 14)){
            mostrarPneu(pneu1);
        }else{
            System.out.println("Pneu fora de Uso");
        }

        if (pneu1.desgastar(15, 20)){
            mostrarPneu(pneu1);
        }else{
            System.out.println("Pneu fora de Uso");
        }

        if (pneu1.desgastar(21, 23)){
            mostrarPneu(pneu1);
        }else{
            System.out.println("Pneu fora de Uso");
        }
    }

    public static void mostrarPneu(Pneu pneu) {
        System.out.printf("Índice de Vida: %.2f \n", pneu.getIndiceDeVida());
        System.out.println("Horas de Uso: " + pneu.getHorasDeUso());
        System.out.println("Estado do Pneu: " + pneu.getEstado() + "\n");
    }
}