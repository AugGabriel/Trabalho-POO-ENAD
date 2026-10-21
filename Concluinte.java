public class Concluinte extends Aluno {
    
    private double notaFormacaoGeral, notaComponenteEspecifico;
    private boolean presente;

    public String toString() {
        return this.stringParcial() + "CONCLUINTE";
    }

    public void cadastrarProva(double nota1, double nota2) {}

    public double calcularNota() {}

    public boolean regular() {}
}
