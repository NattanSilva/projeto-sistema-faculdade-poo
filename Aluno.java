public class Aluno {

	private int rgm;

	public String nome;

	public String email;

	public int getRgm() {
		return this.rgm;
	};

	public Aluno cadastrar(String nome, String email, Curso curso) {
		this.rgm = curso.tamanhoAlunos() + 1;
		this.nome = nome;
		this.email = email;

		if(curso.buscarAluno(email) != null) {
			return null;
		}

		curso.adicionarAluno(this);
		System.out.println("Aluno [" + this.rgm + " - " + this.nome + "] cadastrado com sucesso!");
		return this;
	}

	public Aluno buscar(String email, Curso curso) {
		return curso.buscarAluno(email);
	}

	public void deletar(String email, Curso curso) {
		curso.deletarAluno(email);

		System.out.println("Aluno "+ email + " deletado com sucesso!");

	}

	public Aluno atualizar(String email, String novoEmail, String novoNome, Curso curso) {
		Aluno aluno = curso.buscarAluno(email);

		aluno.email = novoEmail;
		aluno.nome = novoNome;

		return aluno;
	}

}
