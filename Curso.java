import java.util.ArrayList;

public class Curso {

	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

	private ArrayList<Professor> professores = new ArrayList<Professor>();

	private ArrayList<Diciplina> diciplinas = new ArrayList<Diciplina>();

	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
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
		if(this.alunos.size() == 0) {
			System.out.println("Nenhum aluno cadastrado!");
		} else {
			for(Aluno aluno: this.alunos) {
				System.out.println("[" + aluno.getRgm()+ " - " + aluno.nome  + " - " + aluno.email + "]");
			}
		}
	}

	public void listarTodosProfessores() {
		if(this.professores.size() == 0){
			System.out.println("Nenhum professor cadastrado!");
		} else {
			for(Professor professor: this.professores) {
				System.out.println("[" + professor.id + " - " + professor.nome + " - " + professor.cpf + " - " +  professor.email + "]");
			}
		}
	}

	public void listarTodasDiciplinas() {
		if(this.diciplinas.size() == 0){
			System.out.println("Nenhuma diciplina cadastrada!");
		}

		for(Diciplina diciplina: this.diciplinas) {
			System.out.println("[" + diciplina.getId() + " - " + diciplina.nome + "]");
		}
	}
	public Professor buscarProfessor(String cpfBuscado) {
		if(cpfBuscado ==  null) return null;

        for (Professor professor : this.professores) {
            if (professor.cpf.equalsIgnoreCase(cpfBuscado)) {
                return professor;
            }
        }

		return null;
	};

	public Aluno buscarAluno(String emailBuscado) {
		if(emailBuscado ==  null) return null;

		for (Aluno aluno : this.alunos) {
			if (aluno.email.equalsIgnoreCase(emailBuscado)) {
				return aluno;
			}
		}

		return null;
	};

	public void deletarAluno(String emailBuscado) {
		this.alunos.remove(buscarAluno(emailBuscado));
	}


}
