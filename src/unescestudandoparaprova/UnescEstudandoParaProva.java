package unescestudandoparaprova;
import java.util.Random;
import java.util.Scanner;
public class UnescEstudandoParaProva {
    public static int fibonacci(int n){
        int fib=0;
        if (n==1 || n==2){
            fib= 1;
        }
        else{
            fib=fibonacci(n-1)+fibonacci(n-2);
        }
        return fib;
    }
    public static void imprimeinverso(int []vetor){
        int tamanho;
        int i;
        tamanho=vetor.length;
        for (i=tamanho-1;i>=0;i--){
            System.out.print(vetor[i]+" ");
        }
        System.out.printf("\nfim do vetor\n");
    }
    public static void imprime(int []vetor){
        int tamanho;
        int i;
        tamanho=vetor.length;
        for (i=0;i<tamanho;i++){
            System.out.print(vetor[i]+" ");
        }
        System.out.printf("\nfim do vetor\n");
    }
    public static int[] ordenavetor(int []vetor){
        return ordenavetor(vetor,true);
    }
    public static int[] ordenavetor(int []vetor, boolean ordem){
        int i,j,aux;
        int tamanho=vetor.length;
        for (i=0; i<tamanho; i++){
            for (j=i+1; j<tamanho;j++){
                if (ordem){
                    if (vetor[i]>vetor[j]){
                        aux=vetor[i];
                        vetor[i]=vetor[j];
                        vetor[j]=aux;
                    }
                }else{
                    if (vetor[i]<vetor[j]){
                        aux=vetor[i];
                        vetor[i]=vetor[j];
                        vetor[j]=aux;
                    }
                }
            }
        }
        return vetor;
    }
    public static int maiormenor(int[] vetor){
        return maiormenor(vetor,true);
    }
    public static int maiormenor(int[] vetor, boolean ordem){
        int i,maior=0;
        for (i=0;i<vetor.length;i++)
            if (ordem){
                if (vetor[i]>vetor[maior]){
                    maior=i;
                }
            }else{
                if (vetor[i]<vetor[maior]){
                    maior=i;
            }
            }
        return vetor[maior];
    }
    public static float calculanota(char gabarito[], char resposta[]){
        int i,acerto=0;
        float nota;
        int tamanho=gabarito.length;
        //System.out.println(tamanho);
        if (tamanho!=resposta.length){
            nota=0;
        }else{
            System.out.println("+----------+----------+");
            System.out.println("| Cartão de respostas |");
            System.out.println("+----------+----------+");
            System.out.println("| Gabarito | Resposta |");
            System.out.println("+----------+----------+");
            for (i=0;i<tamanho;i++){
                System.out.printf("|     %c    |     %c    |\n",gabarito[i],resposta[i]);
                if (gabarito[i]==resposta[i]){
                    acerto++;
                }
            }
            System.out.println("+----------+----------+");
        }
        //System.out.println("Você acertou: "+acerto);
        nota=(float)(acerto)/(tamanho);
        return (nota*10);
    }
    public static char [] preenchegabarito( int n){
        Scanner input = new Scanner(System.in);
        char [] resposta= new char[n];
        int i;
        for (i=0;i<n;i++){
            System.out.printf("Digite a respostada da %dº questão\n:",i+1);
            resposta[i]=input.nextLine().charAt(0);
        }
        return resposta;
    }
    public static int [] juntalista(int[] lista1, int[] lista2){
        int i=0,j=0;
        int saida[]= new int[lista1.length+lista2.length];
        while(i<lista1.length || j<lista2.length){
            //System.out.println("tamanho: "+lista1.length+" "+lista2.length);
            //System.out.println("indices: "+i+" "+j);
            //System.out.println("element: "+lista1[i]+" "+lista2[j]);
            if (i>=lista1.length){
                saida[i+j]=lista2[j];
                j++;
            }
            else if (j>=lista2.length){
                saida[i+j]=lista1[i];
                i++;
            }
            else if (lista1[i]<lista2[j]){
                saida[i+j]=lista1[i];
                i++;
            }
            else{
                saida[i+j]=lista2[j];
                j++;
            }
        }
        return saida;
    }
    public static void main(String[] args) {
        
        //System.out.println(fibonacci(125));
        int vetor[]= {1,3,4,5,6,7,8,9,0,11,12,14,13,2,10,15,16,17,18,25,24,23,22,20,19,26,27,28,29,30,-2,-4,-5,-3,-1};
        char gabarito[]={'a','b','a','c','d','b','e','a','e','d','c'};
        char resposta[]={'a','b','a','c','c','c','e','a','e','d','a'};
        //char resposta[]=new char[11];
        imprimeinverso(vetor);
        vetor=ordenavetor(vetor);
        imprime(vetor);
        vetor=ordenavetor(vetor,false);
        imprime(vetor);
        System.out.printf("O maior valor é %d\n",maiormenor(vetor));
        System.out.printf("O menor valor é %d\n",maiormenor(vetor,false));
        System.out.println("Vamos calcular sua nota!");
        //resposta=preenchegabarito(11);
        System.out.printf("A nota do aluno é %.1f\n",calculanota(gabarito,resposta));
        System.out.println("\n-------------------------");
        
        int lista1[]={1,2,3,5,6,8,10,12,15,17,19,45,23,4,55,24,0,20,21,22,31,32,33,34,35,36,37,38,39,40,41,42,47,48,49};
        int lista2[]={25,26,27,28,29,30,44,43,56,54,53,52,51,50,46,7,11,13,16,18,9,14};
        imprime(lista1);
        imprime(lista2);
        lista1=ordenavetor(lista1);
        lista2=ordenavetor(lista2);
        imprime(lista1);
        imprime(lista2);
        imprime(juntalista(lista1,lista2));
        Scanner input = new Scanner(System.in);
        float leitura;
        System.out.println("Digita um float");
        leitura=input.nextFloat();
        System.out.println(leitura);
        // numeros aleatório
        Random gerador= new Random();
        int a=gerador.nextInt(101);
        float b=((gerador.nextFloat()*100));
        System.out.println(a+" "+b);
                

    }
}
