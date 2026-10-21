public class Concluinte extends Aluno {
    
    private double notaFormacaoGeral, notaComponenteEspecifico;
    private boolean presente;

    public Concluinte(String nome, String matricula) {
        super(nome, matricula);
        this.presente = false;
    }

    public String toString() {
        return this.stringParcial() + "CONCLUINTE";
    }

    public void cadastrarProva(double notaFormacaoGeral, double notaComponenteEspecifico) {
        this.notaFormacaoGeral = notaFormacaoGeral;
        this.notaComponenteEspecifico = notaComponenteEspecifico;
        this.presente = true;
    }

    public double calcularNota() {
        return (this.notaFormacaoGeral * 0.3) + (this.notaComponenteEspecifico * 0.7);
    }

    public boolean regular() {
        return super.regular() && this.presente;
    }
}
