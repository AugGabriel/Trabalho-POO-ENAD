public class Main {

    public static void main(String[] args) {
        Entrada.abrirEntrada();
        Sistema sistema = new Sistema();

        while (true) {
            int operacao = Entrada.menu();

            if (operacao == 0) {
                break;
            }

            switch(operacao) {
                case 1:
                    Entrada.menuCadastro(sistema);
                    break;
                case 2:
                    Entrada.menuRelatorios(sistema);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        Entrada.fecharEntrada();
    }
}
