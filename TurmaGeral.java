import java.util.ArrayList;

public class TurmaGeral {
	private ArrayList<Turma> turmas = new ArrayList<>();

	public void cadastrarTurmaTurmaGeral(Turma turma) {
		turmas.add(turma);
	}

	public void deletarTurmaTurmaGeral(int codigoTurma) {
		turmas.removeIf(t -> t.getCodigoTurma() == codigoTurma);
	}

	public void listarTurmasTurmaGeral() {
		if (turmas.isEmpty()) {
			System.out.println("Nenhuma turma cadastrada.");
			return;
		}
		for (Turma t : turmas) {
			System.out.println(t);
		}
	}

	public ArrayList<Turma> getTurmasTurmaGeral() {
		return turmas;
	}
}
