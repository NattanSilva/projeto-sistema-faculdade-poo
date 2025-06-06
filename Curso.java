import java.util.ArrayList;

public class Curso {

	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

	private ArrayList<Professor> professores = new ArrayList<Professor>();

	private ArrayList<Diciplina> diciplinas = new ArrayList<Diciplina>();

	public void adicionarAluno(Aluno aluno) {

	}

	public void adicionarProfessor(Professor professor) {
		for(int i = 0; i < professores.size() ; i++) {
			if(professores.get(i).cpf.equals(professor.cpf) ) {
				System.out.println("CPF ja cadastrado!");
				return;
			}

			if (professores.get(i).email.equals(professor.email)) {
				System.out.println("Email ja cadastrado!");
				return;
			}
		}

		professores.add(professor);
	}


	int tamanhoAlunos() {
		return alunos.size();
	}

	int tamanhoProfessores() {
		return professores.size();
	}

	int tamanhoDiciplinas() {
		return diciplinas.size();
	}

	public void adicionarDiciplina(Diciplina diciplina) {}

	public void listarTodosALunos() {

	}

	public void listarTodosProfessores() {

	}

	public void listarTodasDiciplinas() {

	}
	public Professor buscarProfessor(String cpf) {
        for (Professor professor : professores) {
            if (professor.cpf.equals(cpf)) {
                return professor;
            }
        }

		return null;
	};

}
