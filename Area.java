import java.util.ArrayList;

public class Area {
    
    private String codigo, nome;
    private ArrayList<Curso> cursos;

    public Area(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.cursos = new ArrayList<>();
    }

    public String getCodigo() { return this.codigo; }
    
    public String getNome() { return this.nome; }

    public ArrayList<Curso> getCursos() { 
        ArrayList<Curso> copia = new ArrayList<>();

        for (Curso curso : this.cursos) {
            copia.add(curso);
        }

        return copia;
    }

    public String toString() {
        return this.nome + " - (" + this.codigo + ")";
    }

    public void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
    }
}
