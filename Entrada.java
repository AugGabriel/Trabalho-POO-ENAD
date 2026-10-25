import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior e Gabriel Augusto Pereira
 */
public class Entrada {

    private static Scanner leitor;

    /**
     * Se houver um arquivo input.txt na pasta em que o projeto está sendo executado,
     * define que o Scanner vai ler deste arquivo e não do teclado.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public static void abrirEntrada() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            leitor = new Scanner(new FileInputStream("input.txt")).useLocale(Locale.US);

        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            // Locale.US para que o Java sempre leia double com "pontos" ao invés de "vírgulas"
            leitor = new Scanner(System.in).useLocale(Locale.US);
        }
    }

    /**
     * Fecha o Scanner antes de sair do programa.
     */
    public static void fecharEntrada() {
        leitor.close();
    }

    /**
     * Faz a leitura de uma linha inteira
     * @param mensagem: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    public static String lerLinha(String mensagem) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(mensagem);
        return leitor.nextLine();
    }

    /**
     * Faz a leitura de um número inteiro
     * @param mensagem: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    public static int lerInteiro(String mensagem) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = Entrada.lerLinha(mensagem);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param mensagem: Mensagem que será exibida ao usuário
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     * @return O número digitado pelo usuário convertido para double
     */
    public static double lerDouble(String mensagem) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = Entrada.lerLinha(mensagem);
        return Double.parseDouble(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public static int menu() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
        String mensagem = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastro\n" +
                "2) Relatórios\n" +
                "0) Sair\n";

        int operacao = Entrada.lerInteiro(mensagem);

        while (operacao < 0 || operacao > 2) {
            System.out.println("Opção inválida. Tente novamente: ");
            operacao = Entrada.lerInteiro(mensagem);
        }

        return operacao;
    }

    public static void menuCadastro(Sistema sistema) {
        String mensagem = "*********************\n" +
                "1) Cadastrar Área\n" +
                "2) Cadastrar Curso\n" +
                "3) Cadastrar Aluno Ingressante\n" +
                "4) Cadastrar Aluno Concluinte\n" +
                "5) Cadastrar Resposta de Questionário\n" +
                "6) Cadastrar Resultado de Prova\n" +
                "0) Voltar\n";

        int operacao = Entrada.lerInteiro(mensagem);

        if (operacao == 0) return;

        switch(operacao) {
            case 1:
                Entrada.cadastrarArea(sistema);
                break;
            case 2:
                Entrada.cadastrarCurso(sistema);
                break;
            case 3:
                // Entrada.cadastrarIngressante(sistema);
                break;
            case 4:
                // Entrada.cadastrarConcluinte(sistema);
                break;
            case 5:
                // Entrada.cadastrarResposta(sistema);
                break;
            case 6:
                // Entrada.cadastrarProva(sistema);
                break;
            default:
                System.out.println("Opção Inválida.");
        }

    }

    public static void cadastrarArea(Sistema sistema) {
        String nome = Entrada.lerLinha("Digite o nome da área: ");
        String codigo = Entrada.lerLinha("Digite o código da área: ");

        sistema.cadastrarArea(new Area(nome, codigo));
        System.out.println("Área cadastrada com sucesso!");
    }

    public static void cadastrarCurso(Sistema sistema) {
        String nome = Entrada.lerLinha("Digite o nome do curso: ");
        String codigo = Entrada.lerLinha("Digite o código do curso: ");

        System.out.println("Áreas cadastradas:");
        sistema.listarAreas();
        String codigoArea = Entrada.lerLinha("Digite o código da área do curso: ");
        Area area = sistema.getArea(codigoArea);

        if (area == null) {
            System.out.println("Não foi possível encontrar a área.");
            return;
        }

        sistema.cadastrarCurso(new Curso(codigo, nome), area);
        System.out.println("Curso cadastrado com sucesso!");
    }
}
