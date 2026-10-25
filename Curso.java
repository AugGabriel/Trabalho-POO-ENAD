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

    public String toString() {
        return this.nome + " - " + this.codigo;
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public double calcularMedia() {
        int soma = 0, quantidade = 0;

        for (Aluno aluno : this.alunos) {
            if (aluno instanceof Concluinte) {
                soma += ((Concluinte)aluno).calcularNota();
                quantidade += 1;
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
