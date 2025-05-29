
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Impressora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila fila = new Fila(5);
        Pilha pilha = new Pilha();
        int opcao;

        do {
            System.out.println("\n1 - Inserir na impressão\n2 - Imprimir\n3 - Mostrar na fila de impressão\n4 - Mostrar posição na solicitação de impressão\n5 - inserir na impressão emergencial\n6 - imprimir na impressão emergencial\n7 - posição na impressão emergencial\n8 - prioridade emergencial\n0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:{
                    if (!fila.filaCheia()) {
                        System.out.print("Digite o nome do arquivo: ");
                        String nomeArquivo = scanner.nextLine();
                        System.out.print("Digite o nome do usuário: ");
                        String nomeUsuario = scanner.nextLine();

                        Documento novoDocumento = new Documento(nomeArquivo, nomeUsuario);
                        fila.enfileira(novoDocumento);
                        System.out.println("Documento enfileirado");
                        break;
                    } else {
                        System.out.println("fila cheia!!!");
                        break;
                    }
                }
                case 2:{
                    if (!fila.filaVazia()) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        LocalDateTime dataHora = LocalDateTime.now();
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
                        System.out.println("Documento impresso: " + fila.desenfileira());
                        System.out.println("impresso às :" + dataHora.format(formato));
                        System.out.println(fila);
                    } else {
                        System.out.println("A fila está vazia!");
                    }
                    break;
                }
                case 3:{
                    System.out.println(fila);
                    break;
                }
                case 4:{
                    System.out.print("Digite o nome do arquivo: ");
                    String nomeArquivo = scanner.nextLine();
                    int posicao = fila.mostrarPosicao(nomeArquivo);
                    if (posicao == -1) {
                        System.out.println("Documento não está na fila de impressão");
                    } else {
                        System.out.println("posição"+ posicao);
                    }
                    break;
                }
                case 5:{
                    if (!pilha.pilhaCheia()) {
                        System.out.print("Digite o nome do arquivo: ");
                        String nomeArquivo = scanner.nextLine();
                        System.out.print("Digite o nome do usuário: ");
                        String nomeUsuario = scanner.nextLine();

                        Documento novoDocumento = new Documento(nomeArquivo, nomeUsuario);
                        pilha.push(novoDocumento);
                        System.out.println(novoDocumento);
                        System.out.println("Documento enfileirado");
                        break;
                    } else {
                        System.out.println("impressão emergencial cheia!!!");
                        break;
                    }
                }
                case 6:{
                    if (!pilha.pilhaVazia()) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        LocalDateTime dataHora = LocalDateTime.now();
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
                        System.out.println("Documento impresso: " + pilha.pop());
                        System.out.println("impresso às :" + dataHora.format(formato));
                    } else {
                        System.out.println("A pilha está vazia!");
                    }
                    break;
                }
                case 7:{
                    System.out.print("Digite o nome do arquivo: ");
                    String nomeArquivo = scanner.nextLine();
                    int posicao = pilha.mostrarPosicao(nomeArquivo);
                    if (posicao == -1) {
                        System.out.println("Documento não está na pilha de impressão");
                    } else {
                        System.out.println(posicao);
                    }
                    break;
                }
                case 8:{
                    System.out.println(pilha);
                    break;
                }
                case 0:
                    System.out.println("saindo");
                    scanner.close();
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while( opcao != 0);
    }
}
