package entrega2_poo;

public class Retangulo extends Quadrado{
    protected double altura;


    Retangulo(){
        super();
        this.altura = 0;
    }

    Retangulo(double lado, double altura){
        super(lado);
        this.altura = altura;
    }

    public void setAltura(double altura){
        this.altura = altura; 
    }

    public double getAltura(){
        return this.altura;
    }

    @Override
    public double calculaArea() {
        return (this.altura*this.altura);
    }

    @Override
    public double calculaPerimetro() {
        return ((this.lado+this.altura)*2);
    }

    @Override
    public String desenhar() {
        return "Desenhando a figura Retangulo";
    }
}
