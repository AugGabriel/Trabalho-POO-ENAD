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



    public void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
    }
}
