package InitClass;
import AuxClass.ProdutoClass.Produto;

import java.util.Scanner;

public class Init{
    private int idlog = 1;
    Produto[] produtos = new Produto[1000];

    public Init(){
        Scanner ler = new Scanner(System.in);
        int t = 0;
        Produto initTeste = new Produto(0,"Abertura de caixa",1,"Teste",0);
        while (t == 0){
            System.out.println("____________________PDV PRODUTOS____________________\nOPERAÇÕES :\n1 = Cadastrar novo produto\n2 = Visualizar dados de produto\n3 = Atualizar dados de produto\n4 = Comparar registro de produtos\n5 = Registrar venda de produto\n6 = Registrar compra de produto\n7 = Ver todos os produtos cadastrados\n8 = Finalizar operação\n");
            int option = ler.nextInt();

            switch (option) {
                case 1:
                    int l = 0;
                    while(l == 0){
                        System.out.println("\n-+-+-+-+-+-+-+-+-+-+Formas aceitaveis de cadastro :-+-+-+-+-+-+-+-+-+-+\n1 = somente nome.\n2 = nome, quantidade.\n3 = nome, quantidade, tipo e valor.");
                        option = ler.nextInt();

                        switch (option) {
                            case 1:
                                System.out.println("Digite o nome a ser dado ao produto: ");
                                String nome = ler.next();

                                int id = this.idlog;
                                Produto temp =  novoProduto(nome);
                                produtos[id] = temp;

                                System.out.println("__________Cadastro efetuado__________\n" + temp);
                                
                                break;

                            case 2:
                                int id2 = this.idlog;
                                
                                System.out.println("Digite o nome a ser dado ao produto: ");
                                String nome2 = ler.next();
                                System.out.println(nome2);

                                System.out.println("Digite a quantidade do produto: ");
                                int qnt = ler.nextInt();

                                Produto temp2 =  novoProduto(nome2,qnt);
                                produtos[id2] = temp2;



                                System.out.println("__________Cadastro efetuado__________\n " + temp2);
                                
                                break;                        
                            case 3:
                                
                                int id3 = this.idlog;
                                    
                                System.out.println("Digite o nome a ser dado ao produto: ");
                                String nome3 = ler.next();

                                System.out.println("Digite a quantidade do produto: ");
                                int qnt2 = ler.nextInt();

                                System.out.println("Digite a categoria do produto: ");
                                String tipo = ler.next();

                                System.out.println("Digite o valor do produto: ");
                                float vlt = ler.nextFloat();

                                Produto temp3 =  novoProduto(nome3,qnt2,tipo,vlt);
                                produtos[id3] = temp3;



                                System.out.println("__________Cadastro efetuado__________\n" + temp3 );
                                break;
                        
                            default:
                                System.out.println("----------Opção inválida.----------");
                                break;
                        }
                        System.out.println("--------------------|Deseja cadastrar outro produto?(s ou n)|--------------------\n");
                        String choose = ler.next().toLowerCase();
                        if (choose.equals("n")){
                            l = -1;
                        }
                    }
                    break;
            
                case 2:
                    l = 0;
                    while (l==0){
                        System.out.println("Digite o codigo do produto a ser consultado:");
                        int target  = ler.nextInt();
                        System.out.println(produtos[target]);
                        System.out.println("\n----------Deseja realizar outra consulta?(s ou n)--------------------\n");
                        String resp = ler.next().toLowerCase();
                        if (resp.equals("n")){
                            l = -1;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o codigo do produto a ser atualizado :");
                    int codigo = ler.nextInt();

                    System.out.println("Digite o novo nome do produto :");
                    String nnome = ler.next();

                    System.out.println("Digite a nova quantidade do produto :");
                    int novaqnt = ler.nextInt();
                    
                    System.out.println("Digite o novo valor do produto :");
                    float novovlr = ler.nextFloat();
                    
                    produtos[codigo].inserir(nnome,novaqnt,novovlr);
                    break;
                    
                case 4:
                    System.out.println("Digite o codigo do primeiro produto a ser comparado :\n");
                    int c1 = ler.nextInt();
                    System.out.println("Digite o codigo do segundo produto a ser comparado");
                    int c2 = ler.nextInt();

                    if (produtos[c1].igual(produtos[c2])){
                        System.out.println("\n+-+-+-+-+-+-+-+-+-+-Registros duplicados, consulte a base e altere alguma das gravações-+-+-+-+-+-+-+-+-+-+\n");
                    }else{
                        System.out.println("\n____________________Registros unicos, sem problemas encontrados____________________\n");
                    }

                    break;

                case 5:
                    l = 0;
                    while(l == 0){
                        System.out.println("Digite o codigo do produto a ser registrado a venda :\n");
                        int choose = ler.nextInt();
                        System.out.println("Digite a quantidade desse produtos foram vendidas");
                        int quantos = ler.nextInt();
    
                        produtos[choose].vender(quantos);
                        System.out.println("\nDeseja registrar outra venda ?(s ou n)");
                        String choose1 = ler.next().toLowerCase();
                        if (choose1.equals("n")){
                            l = -1;
                        }
                    } 
                    break;


                case 6:
                l = 0;
                while(l == 0){
                    System.out.println("\nDigite o codigo do produto a ser registrado a compra :\n");
                    int choose = ler.nextInt();
                    System.out.println("\nDigite a quantidade desse produtos foram comprados");
                    int quantos = ler.nextInt();
                    System.out.println("\nDigite o novo valor do produto :");;
                    float nvalue = ler.nextFloat();

                    produtos[choose].comprar(quantos,nvalue);
                    System.out.println("\nDeseja registrar outra venda ?(s ou n)");
                    String choose1 = ler.next().toLowerCase();
                    if (choose1.equals("n")){
                        l = -1;
                    }
                } 
                break;

                case 7:
                    for (int c = 0 ; c < produtos.length ; c++){
                        if (produtos[c]!=null){
                            System.out.println(produtos[c]);
                        }
                    }
                    break;
                case 8:
                    System.out.println("----------ShutDown----------");
                    t = -1;
                    break;

                default:
                    System.out.println("----------Opção invalida----------");
                    break;

            }
            
        }
        ler.close();


    }

    public Produto novoProduto(String nome){
        Produto temp = new Produto(this.idlog,nome);
        this.idlog += 1;
        return temp;
    }
    public Produto novoProduto(){
        Produto temp = new Produto(this.idlog);
        this.idlog += 1;
        return temp;
    }
    

    public Produto novoProduto(String nome, int quantidade){
        Produto temp = new Produto(this.idlog,nome,quantidade);
        this.idlog += 1;
        return temp;
    }
    
    public Produto novoProduto(String nome, int quantidade, String tipo, float valor){
        Produto temp = new Produto(this.idlog, nome, quantidade, tipo, valor);
        this.idlog += 1;
        return temp;
    }
    

    
}