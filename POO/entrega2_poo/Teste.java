package entrega2_poo;

public class Teste {
    public static void main(String[] args){
        Quadrado q = new Quadrado(10);
        Triangulo t = new Triangulo(10,10,10,10);
        Circulo c = new Circulo(10);
        Retangulo r = new Retangulo(10,20);
        
        System.out.println(q);
        System.out.println(t);
        System.out.println(c);
        System.out.println(r);
        
        System.out.println(q.desenhar());
        System.out.println(t.desenhar());
        System.out.println(c.desenhar());
        System.out.println(r.desenhar());

    }
}
