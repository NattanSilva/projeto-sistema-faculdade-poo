public class Disciplina {
    private static int contador = 100;
    private int codigoDisciplina;
    String nome;

    public Disciplina(String nome) {
        this.codigoDisciplina = contador++;
        this.nome = nome;
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public String getNomeDiscplina() {
        return nome;
    }

    public void atualizarDisciplna(String novoNome) {
        this.nome = novoNome;
    }

    @Override
    public String toString() {
        return "[Disciplina #" + codigoDisciplina + "] " + nome;
    }

    public static void removerDisciplina(Curso curso, int codigo) {
        curso.getDisciplinaCurso().removeIf(d -> d.getCodigoDisciplina() == codigo);
    }
}
