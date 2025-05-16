package entrega2_poo;

public class Triangulo extends Figura {
    protected double base;
    protected double lado1;
    protected double lado2;
    protected double altura;
    
    Triangulo(){
        this.base = 0;
        this.altura = 0;
        this.lado1 = 0;
        this.lado2 = 0;
    }

    Triangulo(double base, double altura, double lado1, double lado2){
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }


    @Override
    public double calculaArea() {
        return (base*altura)/2;
    }

    @Override
    public double calculaPerimetro() {
        return (base+lado1+lado2);
    }

    public void setLado1(double valor){
        this.lado1 = valor;
    }

    public double getLado1(){
        return this.lado1;
    }


    public void setLado2(double valor){
        this.lado2 = valor;
    }

    public double getLado2(){
        return this.lado2;
    }

    public void setBase(double base){
        this.base = base;
    }

    public double getBase(){
        return this.base;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    public double getAltura(){
        return this.altura;
    }

    public String desenhar(){
        return "Desenhando a figura Triangulo";
    }
}
