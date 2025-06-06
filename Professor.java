public class Professor extends Usuario {
    public void cadastrar(String nome, String cpf, String email, Curso curso) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.id = curso.tamanhoAlunos() + 1;

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

    public Professor buscar(String cpf, Curso curso) {
        return curso.buscarProfessor(cpf);
    }


    public Professor atualizar(String novoNome, String novoEmail, String novoCpf, Curso curso) {
        Professor professor = curso.buscarProfessor(cpf);

        professor.nome = novoNome;
        professor.email = novoEmail;
        professor.cpf = novoCpf;

        return professor;
    }
}
