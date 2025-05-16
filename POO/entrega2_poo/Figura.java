package entrega2_poo;

public abstract class Figura implements Desenho{

    public abstract double calculaArea();
    public abstract double calculaPerimetro();


    public String toString() {
		return "Figura: " + this.getClass() + " - Perimetro : " + this.calculaPerimetro() + " - Area : " + this.calculaArea();
	}
}
