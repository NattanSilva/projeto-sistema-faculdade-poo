public abstract class Usuario {

	public int id;

	public String nome;

	public String email;

	public String cpf;

	public void cadastrar(String nome, String cpf, String email, Curso curso) {

	}

	public void listarMeusAlunos() {

	}

	public Professor atualizar(Professor novosDados) {
		return null;
	}

	public int logar(String cpf, Curso curso) {
		return 0;
	}

	public Professor buscar(int professorId) {
		return null;
	}

}
