public class Aluno {

    private String nome, matricula;
    private boolean questionarioRespondido;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.questionarioRespondido = false;
    }

    protected String stringParcial() {
        return this.nome + " (" + this.matricula + ") - ";
    }

    public boolean regular() {
        return this.questionarioRespondido;
    }
    
    public void cadastrarResposta() {}
}
