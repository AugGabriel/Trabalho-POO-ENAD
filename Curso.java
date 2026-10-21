import java.util.ArrayList;

public class Curso {

    private String codigo, nome;
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public String toString() {
        return this.nome + " - " + this.codigo;
    }

    public void adicionarAluno(Aluno aluno) {}

    public double calcularMedia() {}

    public int calcularConceito() {}

    public ArrayList<Ingressante> ingressantes() {}

    public ArrayList<Ingressante> ingressantes(int semestre) {}
}
