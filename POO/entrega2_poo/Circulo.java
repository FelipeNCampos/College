package entrega2_poo;

public class Circulo extends Figura{
    protected double pi = 3.14159;
    protected double raio;

    Circulo(double raio){
        this.raio = raio;
    }
    Circulo(){
        this.raio = 0;
    }

    public String desenhar(){
        return "Desenhando a figura Circulo";
    }

    @Override
    public double calculaArea() {
        return (pi*(raio*raio));
    }

    @Override
    public double calculaPerimetro() {
        return (2*pi*raio);
    }


    public double getRaio(){
        return this.raio;
    }

    public void setRaio(double raio){
        this.raio = raio;
    }
    
    public double getPi(){
        return this.pi;
    }

    public void setPi(double pi){
        this.raio = pi;
    }
}
