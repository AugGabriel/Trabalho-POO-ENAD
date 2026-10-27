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

    public void cadastrarArea(Area area) { this.areas.add(area); }

    public void listarAreas() {
        for (Area area : this.areas) {
            System.out.println(area.getCodigo() + " - " + area.getNome());
        }
    }

    public Area getArea(String codigo) {
        for (Area area : this.areas) {
            if (area.getCodigo().equals(codigo)) {
                return area;
            }
        }
        
        return null;
    }

    public void cadastrarCurso(Curso curso, Area area) { this.cursos.add(curso); }

    public void listarCursos() {
        for (Curso curso : this.cursos) {
            System.out.println(curso.getCodigo() + " - " + curso.getNome());
        }
    }

    public Curso getCurso(String codigo) {
        for (Curso curso : this.cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        
        return null;
    }
    
    public void cadastrarAluno(Aluno aluno, Curso curso) { this.alunos.add(aluno); }
    
    public void listarAlunosIrregulares() {}
    
    public Aluno getAluno(String matricula) {
        for (Aluno aluno : this.alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        
        return null;
    }

    public void listarResultados(int conceito) {}

    public void listarResultados(String nomeArea) {}
}
