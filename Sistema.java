import java.util.ArrayList;

public class Sistema {

    private ArrayList<Area> areas = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public void cadastrarArea(Area area) {}

    public void cadastrarCurso(Curso curso, Area area) {}

    public void cadastrarAluno(Aluno aluno, Curso curso) {}

    public void listarResultados(int conceito) {}

    public void listarResultados(String nomeArea) {}

    public void listarAlunosIrregulares() {}
}
