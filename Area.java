import java.util.ArrayList;

public class Area {
    
    private String codigo, nome;
    private ArrayList<Curso> cursos = new ArrayList<>();

    public String toString() {
        return this.nome + " - " + this.codigo;
    }

    public void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
    }
}
