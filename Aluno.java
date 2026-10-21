public class Aluno {

    private String nome, matricula;
    private boolean questionarioRespondido;

    protected String stringParcial() {
        return this.nome + " (" + this.matricula + ") - ";
    }

    public boolean regular() {}
    
    public void cadastrarResposta() {}
}
