import java.util.ArrayList;

public class Sistema {

    private ArrayList<Area> areas;
    private ArrayList<Curso> cursos;
    private ArrayList<Aluno> alunos;

    public Sistema() {
        this.areas = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public void cadastrarArea(Area area) {}

    public void cadastrarCurso(Curso curso, Area area) {}

    public void cadastrarAluno(Aluno aluno, Curso curso) {}

    public void listarResultados(int conceito) {}

    public void listarResultados(String nomeArea) {}

    public void listarAlunosIrregulares() {}
}
