public class Ingressante extends Aluno {
    
    private int semestreIngresso;

    public Ingressante(String nome, String matricula, int semestreIngresso) {
        super(nome, matricula);
        this.semestreIngresso = semestreIngresso;
    }

    public int getSemestreIngresso() { return this.semestreIngresso; }

    public String toString() {
        return this.stringParcial() + "INGRESSANTE";
    }
}
