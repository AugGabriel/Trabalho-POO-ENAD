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
        String mensagem = "" +
            "Escolha uma opção:\n" +
            "1) Cadastro\n" +
            "2) Relatórios\n" +
            "0) Sair\n";

        int operacao = Entrada.lerInteiro(mensagem);

        while (operacao < 0 || operacao > 2) {
            System.out.println("Opção inválida. Tente novamente: ");
            operacao = Entrada.lerInteiro(mensagem);
        }

        System.out.println();
        return operacao;
    }

    public static void menuCadastro(Sistema sistema) {
        String mensagem = "" +
            "1) Cadastrar Área\n" +
            "2) Cadastrar Curso\n" +
            "3) Cadastrar Aluno Ingressante\n" +
            "4) Cadastrar Aluno Concluinte\n" +
            "5) Cadastrar Resposta de Questionário\n" +
            "6) Cadastrar Resultado de Prova\n" +
            "0) Voltar\n";

        int operacao = Entrada.lerInteiro(mensagem);

        switch(operacao) {
            case 1:
                Entrada.cadastrarArea(sistema);
                break;
            case 2:
                Entrada.cadastrarCurso(sistema);
                break;
            case 3:
                Entrada.cadastrarIngressante(sistema);
                break;
            case 4:
                Entrada.cadastrarConcluinte(sistema);
                break;
            case 5:
                Entrada.cadastrarResposta(sistema);
                break;
            case 6:
                Entrada.cadastrarResultadoProva(sistema);
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        System.out.println();
    }

    public static void menuRelatorios(Sistema sistema) {
        String mensagem = "" +
            "1) Listar Resultados por Conceito\n" +
            "2) Listar Resultados por Área\n" +
            "3) Listar Alunos Irregulares\n" +
            "0) Voltar\n";

        int operacao = Entrada.lerInteiro(mensagem);
        System.out.println();

        switch (operacao) {
            case 1:
                Entrada.listarResultadosConceito(sistema);
                break;
            case 2:
                Entrada.listarResultadosArea(sistema);
                break;
            case 3:
                Entrada.listarAlunosIrregulares(sistema);
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida.");
                break;
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

    private static void cadastrarAluno(Sistema sistema, boolean ingressante) {
        // Declaração de variáveis
        int semestreIngresso = -1;
        Aluno aluno;

        String tipo = ingressante ? "ingressante" : "concluinte";

        // Entrada de dados
        String nome = Entrada.lerLinha("Digite o nome do " + tipo + ": ");
        String matricula = Entrada.lerLinha("Digite a matrícula do " + tipo + ": ");

        // Especificidades de ingressantes
        if (ingressante) {
            semestreIngresso = Entrada.lerInteiro("Digite o semestre de " + tipo + ": ");
        }

        // Escolha do curso
        System.out.println("Cursos cadastrados: ");
        sistema.listarCursos();
        String codigoCurso = Entrada.lerLinha("Digite o código do curso do aluno: ");
        Curso curso = sistema.getCurso(codigoCurso);
        
        if (curso == null) {
            System.out.println("Não foi possível encontrar o curso.");
            return;
        }

        // Cadastro dos alunos
        if (ingressante) {
            aluno = new Ingressante(nome, matricula, semestreIngresso);
        }
        else {
            aluno = new Concluinte(nome, matricula);
        }
        
        sistema.cadastrarAluno(aluno, curso);
        System.out.println("Aluno " + tipo + " cadastrado com sucesso!");
    }
    
    public static void cadastrarIngressante(Sistema sistema) {
        Entrada.cadastrarAluno(sistema, true);
    }

    public static void cadastrarConcluinte(Sistema sistema) {
        Entrada.cadastrarAluno(sistema, false);
    }

    public static void cadastrarResposta(Sistema sistema) {
        System.out.println("Alunos cadastrados: ");
        sistema.listarAlunosNaoResponderam(false);

        String matricula = Entrada.lerLinha(
            "Digite a matrícula do aluno que respondeu ao questionário:"
        );
        Aluno aluno = sistema.getAluno(matricula);

        if (aluno == null) {
            System.out.println("Não foi possível encontrar o aluno.");
            return;
        }
        if (aluno.getQuestionarioRespondido()) {
            System.out.println("O aluno informado já respondeu o questionário.");
            return;
        }

        aluno.cadastrarResposta();
        System.out.println("Resposta cadastrada com sucesso!");
    }

    public static void cadastrarResultadoProva(Sistema sistema) {
        System.out.println("Concluintes cadastrados: ");
        sistema.listarAlunosNaoResponderam(true);

        String matricula = Entrada.lerLinha("Digite a matrícula do aluno que realizou a prova: ");
        Concluinte concluinte = sistema.getConcluinte(matricula);

        if (concluinte == null) {
            System.out.println("Não foi possível encontrar o concluinte.");
            return;
        }
        if (concluinte.regular()) {
            System.out.println("O concluinte informado já respondeu o questionário.");
            return;
        }

        double notaFormacaoGeral = Entrada.lerDouble("Digite o valor da nota de formação geral:");
        double notaComponenteEspecifico = Entrada.lerDouble(
            "Digite o valor da nota de conhecimentos específicos:"
        );
        concluinte.cadastrarProva(notaFormacaoGeral, notaComponenteEspecifico);
        System.out.println("Prova cadastrada com sucesso!");
    }

    public static void listarResultadosConceito(Sistema sistema) {
        if (sistema.getCursos().size() == 0) {
            System.out.println("Ainda não há nenhum curso cadastrado.");
            return;
        }

        int conceito;
        conceito = Entrada.lerInteiro("Digite o conceito desejado (1 a 5): ");

        if (conceito < 1 || conceito > 5) {
            System.out.println("Valor inválido.");
            return;
        }

        System.out.println("Cursos com conceito " + conceito);
        sistema.listarResultados(conceito);
    }

    public static void listarResultadosArea(Sistema sistema) {
        if (sistema.getCursos().size() == 0) {
            System.out.println("Ainda não há nenhum curso cadastrado.");
            return;
        }

        System.out.println("Áreas cadastradas: ");
        sistema.listarAreas();

        String codigo = Entrada.lerLinha("Digite o código da área do curso: ");
        Area area = sistema.getArea(codigo);

        if (area == null) {
            System.out.println("Área não encontrada.");
            return;
        }

        System.out.println("Conceitos dos cursos da área " + area.toString() + ": ");
        sistema.listarResultados(area);
    }

    public static void listarAlunosIrregulares(Sistema sistema) {
        if (sistema.getAlunos().size() == 0) {
            System.out.println("Ainda não há nenhum aluno cadastrado.");
            return;
        }

        System.out.println("Alunos irregulares com o ENADE: ");
        sistema.listarAlunosIrregulares();
    }
}
