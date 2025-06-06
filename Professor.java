public class Professor extends Usuario {
    public void cadastrar(String nome, String cpf, String email, Curso curso) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.id = curso.tamanhoAlunos();

        curso.adicionarProfessor(this);

        System.out.println("Professor [" + this.id+ " - " + this.nome +  "] cadastrado com sucesso!");
    }

    public int logar(String cpf, Curso curso) {
        if (curso.buscarProfessor(cpf) == null) {
            System.out.println("Usuário não encontrado");
            return 0;
        }

        return 1;
    }
}
