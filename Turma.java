import java.util.ArrayList;

public class Turma {
	private static int contador = 1;

	private int codigoTurma;
	private Disciplina disciplina;
	private Professor professor;
	private ArrayList<Aluno> alunos;
	private String status;

	public Turma(Disciplina disciplina, Professor professor) {
		this.codigoTurma = contador++;
		this.disciplina = disciplina;
		this.professor = professor;
		this.alunos = new ArrayList<>();
		this.status = "Ativa";
	}

	public int getCodigoTurma() {
		return codigoTurma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Professor getProfessorDisciplina() {
		return professor;
	}

	public Professor getCpfTurma() {
		return this.professor;
	}

	public void adicionarAlunoTurma(Aluno aluno) {
		alunos.add(aluno);
	}

	public void removerAlunoTurma(int rgm) {
		alunos.removeIf(a -> a.getRgm() == rgm);
	}

	public void listarAlunosTurma() {
		if (alunos.isEmpty()) {
			System.out.println("📭 Nenhum aluno nesta turma.");
		} else {
			System.out.println("📚 Alunos na turma de " + disciplina.getNomeDiscplina() + ":");
			for (Aluno a : alunos) {
				System.out.println(" - " + a.getNomeAluno() + " (RGM: " + a.getRgm() + ")");
			}
		}
	}

	@Override
	public String toString() {
		return "Turma #" + codigoTurma + " | Disciplina: " + disciplina.getNomeDiscplina() +
				" | Professor: " + professor.getNomeProfessor() +
				" | Status: " + status + " | Alunos: " + alunos.size();
	}

	public Professor getProfessorTurma() {
        return this.professor;
	}


	/// /////

	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
	}


	public void removerAluno(int rgm) {
		alunos.removeIf(a -> a.getRgm() == rgm);
	}

}
