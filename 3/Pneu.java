class Pneu{

    private int idPneu;
    private String modelo;
    private double indiceDeVida;
    private char estado;
    private int horasDeUso;

    Pneu(int idPneu, String modelo, double indiceDeVida){
        this.idPneu = idPneu;
        this.modelo = modelo;
        this.indiceDeVida = indiceDeVida;
        this.estado = 'N';

    }

    public boolean desgastar(int horaInicial, int horaFinal){
        if (this.estado == 'N'){
            this.estado = 'U';
        }
        if (this.estado == 'U'){
            int horasDecorridas = horaFinal - horaInicial;
            this.indiceDeVida -= horasDecorridas * 60 * 0.12345;
            this.horasDeUso += horasDecorridas;

            if (this.indiceDeVida <= 0){
                this.estado = 'F';
            }
        }

        if (this.estado != 'F'){
            return true;
        }
        return false;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public double getIndiceDeVida(){
        return this.indiceDeVida;
    }
    public char getEstado(){
        return this.estado;
    }
    public int getHorasDeUso(){
        return this.horasDeUso;
    }
}