import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyClass {
    
    public static void main(String[] args) {
        
        /*  CONSIDERAÇÕES:
        
            Para rodar o código virtualmente, é possível simplismente copiar tudo e colar no compilador online:
            https://www.jdoodle.com/online-java-compiler/
            Ou usar o código em qualquer outro IDE.
          
            Obs: Não encontrei uma forma de se instanciar LinkedList, Queue e Stack, como fazemos com arrays tradicionais.
            Digo, não daria para usar um formato similar a "Integer[] arrayDeInteiros = new Integer[capacidade]" usando essas classes.
            Sendo assim, segui o exercício normalmente usando as classes próprias de cada tipo de lista.
        */
        
        // Passo 1: Insira os números [1, 2, 3, 4 e 5] em uma lista - com 5 células; 
        LinkedList<Integer> lista = new LinkedList<Integer>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        
        // Passo 2: Remova todos os dados da lista e insira-os em uma Pilha - com 5 células. Deve-se sempre remover os dados da célula inicial da lista; 
        Stack<Integer> pilha = new Stack<Integer>();
        while (!lista.isEmpty()) {
            pilha.push(lista.removeFirst());
        }
        
        // Passo 3: Remova os dados da Pilha e insira-os em uma Fila - com 10 células); 
        Queue<Integer> fila = new LinkedList<Integer>();
        while (!pilha.isEmpty()) {
            fila.add(pilha.pop());
        }
        
        // Passo 4: Insira os números [6, 7, 8, 9 e 10] na lista; 
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(9);
        lista.add(10);
        
        // Passo 5: Repita os passos 2 e 3. 
        while (!lista.isEmpty()) {
            while (!lista.isEmpty()) {
                pilha.push(lista.removeFirst());
            }
            while (!pilha.isEmpty()) {
                fila.add(pilha.pop());
            }
        }
        
        // Passo 6: Exibe os números na fila
        System.out.println("Números na fila:");
        while (!fila.isEmpty()) {
            System.out.print(fila.remove() + " "); //Output: 5 4 3 2 1 10 9 8 7 6 
        }
        
        /*
            Analise a ordem dos números exibidos e verifique se estão na mesma forma que foram inseridos. Se a exibição foi diferente, justifique o ocorrido. 
            
            RESPOSTA:
            
                A ordem dos números exibidos não está na mesma ordem de input. 
                    
                O que é mostrado é que os inputs da primeira parte (relativo aos números 1 ao 5),
                e a segunda parte, (relativo aos números 6 ao 10), estão invertidos, apesar dos dois
                grupos estarem em sequencia. grupo1: (5 4 3 2 1), grupo2: (10 9 8 7 6 ).
                
                O output não está em ordem por causa que os elementos dentro da lista são removidos no sentido
                do início ao fim, e adicionados no topo da pilha. Quando os elementos são removidos da pilha,
                eles são invertidos, por conta que a pilha tem características "last in first out", ou seja:
                
                Ordem de entrada na pilha: 1 > 2 > 3 > 4 > 5
                Ordem de saída na pilha: 5 > 4 > 3 > 2 > 1
                
                Ao repetir os passos 4 e 5, estamos simplesmente repetindo o processo novamente, e é
                por isso que dois grupos com ordens decrescentes são criados.
        */
    }
}
