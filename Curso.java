import java.util.ArrayList;

public class Curso {

    private String codigo, nome;
    private ArrayList<Aluno> alunos;

    public Curso(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public String getCodigo() { return this.codigo; }

    public String getNome() { return this.nome; }

    public ArrayList<Aluno> getAlunos() { 
        ArrayList<Aluno> copia = new ArrayList<>();

        for (Aluno aluno : this.alunos) {
            copia.add(aluno);
        }

        return copia;
     }

    /**
     * Implementação de toString() conforme PDF de especificação da Atividade 2.
     */
    public String toString() {
        return this.nome + " - " + this.codigo;
    }

    /**
     * Implementação de toString() conforme a "Saída correta", especificada na tarefa do AVA do Atividade 2.
     * Usado nas listagens.
     */
    public String toStringListagem() {
        return this.nome + " (" + this.codigo + ")";
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public double calcularMedia() {
        double soma = 0;
        int quantidade = 0;

        for (Aluno aluno : this.alunos) {
            if (aluno instanceof Concluinte) {
                Concluinte concluinte = (Concluinte) aluno;
                if (concluinte.getPresente()) {
                    soma += concluinte.calcularNota();
                    quantidade++;
                }
            }
        }

        return (quantidade > 0) ? (soma / quantidade) : 0;
    }

    public int calcularConceito() {
        double media = this.calcularMedia();

        if (media < 2.0) { return 1; }
        if (media < 4.0) { return 2; }
        if (media < 6.0) { return 3; }
        if (media < 8.0) { return 4; }
        return 5;
    }

    public ArrayList<Ingressante> ingressantes() {
        ArrayList<Ingressante> ingressantes = new ArrayList<>();
        
        for (Aluno aluno : this.alunos) {
            if (aluno instanceof Ingressante) {
                ingressantes.add((Ingressante)aluno);
            }
        }
        
        return ingressantes;
    }
    
    public ArrayList<Ingressante> ingressantes(int semestre) {
        ArrayList<Ingressante> ingressantes = this.ingressantes();
        ArrayList<Ingressante> ingressantesSemestre = new ArrayList<>();

        for (Ingressante ingressante : ingressantes) {
            if (ingressante.getSemestreIngresso() == semestre) {
                ingressantesSemestre.add(ingressante);
            }
        }

        return ingressantesSemestre;
    }
}
