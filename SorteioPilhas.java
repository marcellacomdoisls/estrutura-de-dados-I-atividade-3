import java.util.Random;
import java.util.Stack;

public class SorteioPilhas {

  public static void main(String[] args) {
    Stack<Integer> pilha1 = new Stack<>();
    Stack<Integer> pilha2 = new Stack<>();
    Stack<Integer> pilha3 = new Stack<>();

    // Fase 1: Sorteio dos números para as pilhas 1, 2 e 3
    Random random = new Random();
    for (int i = 0; i < 100; i++) {
      int numero = random.nextInt(9) + 1;
      if (numero >= 1 && numero <= 3) {
        pilha1.push(numero);
      } else if (numero >= 4 && numero <= 6) {
        pilha2.push(numero);
      } else {
        pilha3.push(numero);
      }
    }

    // Fase 2: Sorteio dos números para selecionar as pilhas
    int contador = 0;
    while (!pilha1.isEmpty() && !pilha2.isEmpty() && !pilha3.isEmpty() && contador < 100) {
      int sorteio = random.nextInt(3) + 1;
      Stack<Integer> pilhaSelecionada;
      String nomePilha;
      if (sorteio == 1 && !pilha1.isEmpty()) {
        pilhaSelecionada = pilha1;
        nomePilha = "Pilha 1";
      } else if (sorteio == 2 && !pilha2.isEmpty()) {
        pilhaSelecionada = pilha2;
        nomePilha = "Pilha 2";
      } else if (sorteio == 3 && !pilha3.isEmpty()) {
        pilhaSelecionada = pilha3;
        nomePilha = "Pilha 3";
      } else {
        contador++;
        continue;
      }

      int numero1 = pilha1.isEmpty() ? 0 : pilha1.peek();
      int numero2 = pilha2.isEmpty() ? 0 : pilha2.peek();
      int numero3 = pilha3.isEmpty() ? 0 : pilha3.peek();

      System.out.println("Empilhando os números " + numero2 + " e " + numero3 + " na " + nomePilha);

      pilhaSelecionada.push(numero2);
      pilhaSelecionada.push(numero3);

      pilha2.pop();
      pilha3.pop();

      contador++;
    }

    System.out.println();
    System.out.println("Pilha 1: " + pilha1);
    System.out.println("Pilha 2: " + pilha2);
    System.out.println("Pilha 3: " + pilha3);

    if (pilha1.isEmpty() || pilha2.isEmpty() || pilha3.isEmpty()) {
      System.out.println("O programa foi encerrado porque uma das pilhas ficou vazia.");
    } else if (contador >= 100) {
      System.out.println("O programa foi encerrado porque atingiu o total de 100 números sorteados.");
    }
  }
}
