package entrega2_poo;

public class Quadrado extends Figura {
    protected double lado;
    
    
    Quadrado(double lado){
        this.lado = lado;
    }
    Quadrado(){
        this.lado = 0;
    }

    @Override
    public double calculaArea() {
        return (lado*lado);

    }
    
    @Override
    public double calculaPerimetro() {
        return (lado*4);
    }


    public void setLado(double lado){
        this.lado = lado;
    }

    public double getLado(){
        return this.lado;
    }

    public String desenhar(){
        return "Desenhando a figura Quadrado";
    }
}
