import java.util.Scanner;

public class Menu {

	public Curso iniciar() {
		Curso curso = new Curso();
		return curso;
	}

	public void menuInicial(Curso curso) {
		Professor usuario = new Professor();
		Scanner teclado = new Scanner(System.in);
		String nome, cpf, email;

		System.out.println("Menu Inicial");
		System.out.println("1 - Cadastrar-se");
		System.out.println("2 - Logar");
		System.out.println("0 - Sair");
		System.out.print("Escolha uma opção: ");
		int opcao = teclado.nextInt();

		switch (opcao) {
			case 1:
				System.out.println("Digite o nome: ");
				nome = teclado.next();
				System.out.println("Digite o CPF: ");
				cpf = teclado.next();
				System.out.println("Digite o email: ");
				email = teclado.next();
				usuario.cadastrar(nome, cpf, email, curso);
				menuInicial(curso);
				break;
			case 2:
				System.out.println("Digite o CPF: ");
				cpf = teclado.next();
				int resultado = usuario.logar(cpf, curso);

				if(resultado == 0) {
					this.menuInicial(curso);
					break;
				}

				this.menuSecundario(curso, curso.buscarProfessor(cpf));
				break;
			case 0:
				System.out.println("Obrigado por usar nosso sistema!");
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida!\n");
				menuInicial(curso);
				break;
		}
	}

	public void menuSecundario(Curso curso, Professor professor) {;
		Scanner teclado = new Scanner(System.in);

		System.out.println("Bem vindo, " + professor.nome + "!");
		System.out.println("Menu Geral");
		System.out.println("1 - Menu Aluno");
		System.out.println("2 - Menu Usuário");
		System.out.println("3 - Menu Diciplina");
		System.out.println("4 - Menu Turma");
		System.out.println("5 - Menu Turma Geral");
		System.out.println("6 - Menu Curso");
		System.out.println("0 - Sair");
		System.out.print("Escolha uma opção: ");
		int opcao = teclado.nextInt();

		switch (opcao) {
			case 1:
				this.menuAluno(curso, professor);
				break;
			case 2:
					this.menuProfessor(curso, professor);
					break;
			case 3:
				this.menuDiciplina(curso, professor);
				break;
			case 4:
				this.menuTurma(curso, professor);
				break;
			case 5:
				this.menuTurmaGeral(curso, professor);
				break;
			case 6:
				this.menuCurso(curso, professor);
				break;
			case 0:
				System.out.println("Saindo...");
				this.menuInicial(curso);
				break;
			default:
				System.out.println("Opção inválida!");
				this.menuSecundario(curso, professor);
				break;
		}
	}

	public void menuAluno(Curso curso, Professor professor) {
		Scanner teclado = new Scanner(System.in);
		String nome , email;
		Aluno aluno = new Aluno();

		System.out.println("Menu Aluno");
		System.out.println("1 - Cadastrar Aluno");
		System.out.println("2 - Buscar Aluno");
		System.out.println("3 - Atualizar Aluno");
		System.out.println("4 - Deletar Aluno");
		System.out.println("0 - Sair");
		System.out.print("Escolha uma opção: ");
		int opcao = teclado.nextInt();

		switch (opcao) {
			case 1:
				System.out.println("Digite o nome do aluno: ");
				nome = teclado.next();
				System.out.println("Digite o email: ");
				email = teclado.next();
				Aluno novoAluno = aluno.cadastrar(nome, email, curso);

				if(novoAluno == null) {
					System.out.println("Email " + email + " já cadastrado!");
					this.menuAluno(curso, professor);
					break;
				}

				this.menuAluno(curso, professor);
				break;
			case 2:
				System.out.println("Digite o email do aluno buscado: ");
				email = teclado.next();
				Aluno alunoBuscado = aluno.buscar(email, curso);

				if(alunoBuscado == null) {
					System.out.println("Aluno não encotrado!");

				} else {
					System.out.println("[" + alunoBuscado.nome + " - " + alunoBuscado.email + "]");
				}

				this.menuAluno(curso, professor);
				break;
			case 3:
				System.out.println("Digite o email do aluno: ");
				email = teclado.next();

				if(aluno.buscar(email, curso) == null) {
					System.out.println("Aluno não encontrado!");
					this.menuAluno(curso, professor);
					break;
				}

				System.out.println("Digite o novo email do aluno: ");
				String novoEmail = teclado.next();
				System.out.println("Digite o novo nome do aluno: ");
				String novoNome = teclado.next();
				Aluno novosDados = aluno.atualizar(email, novoEmail, novoNome, curso);

				System.out.println("[" + novosDados.nome + " - " + novosDados.email + "]");
				this.menuAluno(curso, professor);
				break;
			case 4:
				System.out.println("Digite o email do aluno: ");
				email = teclado.next();
				aluno.deletar(email, curso);
				this.menuAluno(curso, professor);
				break;
			case 0:
				System.out.println("Saindo...");
				menuSecundario(curso, professor);
				break;
			default:
				System.out.println("Opção inválida!");
				this.menuAluno(curso, professor);
				break;
		}
	}

	public void menuProfessor(Curso curso, Professor usuario) {
		Scanner teclado = new Scanner(System.in);
		String cpf;

		System.out.println("Menu Usuário");
		System.out.println("1 - Buscar Professor");
		System.out.println("2 - Atualizar Usuário");
		System.out.println("3 - Listar Meus Alunos");
		System.out.println("0 - Sair");
		System.out.print("Escolha uma opção: ");
		int opcao = teclado.nextInt();

		switch (opcao) {
			case 1:
				System.out.println("Digite o cpf do professor: ");
				cpf = teclado.next();
				Professor professorBuscado = usuario.buscar(cpf, curso);
				if(professorBuscado == null) {
					System.out.println("Professor não encontrado!");
					this.menuProfessor(curso, usuario);
					break;
				}

				System.out.println("Professor: [" + professorBuscado.cpf+ " - " + professorBuscado.nome + " - " + professorBuscado.email + "]");
				this.menuProfessor(curso, usuario);
				break;
			case 2:
				System.out.println("Digite o novo nome professor: ");
				String novoNome = teclado.next();
				System.out.println("Digite o novo email  professor: ");
				String novoEmail = teclado.next();
				System.out.println("Digite o novo cpf professor: ");
				String novoCpf = teclado.next();
				Professor usuarioAtualizado = usuario.atualizar(novoNome, novoEmail, novoCpf, curso);

				System.out.println("[" + usuarioAtualizado.nome + " - " + usuarioAtualizado.cpf + " - " + usuarioAtualizado.email + "]");
				this.menuProfessor(curso, usuarioAtualizado);
				break;
			case 3:
				break;
			case 0:
				System.out.println("Saindo...");
				menuSecundario(curso, usuario);
				break;
			default:
					System.out.println("Opção inválida!");
					this.menuProfessor(curso, usuario);
					break;
		}

	}

	public void menuDiciplina(Curso curso, Professor usuario) {
		Scanner teclado = new Scanner(System.in);
		String nome;

		System.out.println("Menu Disciplina");
		System.out.println("1 - Cadastrar Disciplina");
		System.out.println("2 - Atualizar Disciplina");
		System.out.println("3 - Remover Disciplina");
		System.out.println("4 - Listar Disciplinas");
		System.out.println("0 - Voltar");
		System.out.print("Escolha uma opção: ");
		int opcao = teclado.nextInt();
		teclado.nextLine(); // limpar buffer

		switch (opcao) {
			case 1:
				System.out.println("Digite o nome da disciplina: ");
				nome = teclado.nextLine();
				curso.getDisciplinaCurso().add(new Disciplina(nome));
				System.out.println("Disciplina cadastrada com sucesso!");
				break;
			case 2:
				System.out.println("Digite o ID da disciplina: ");
				int id = teclado.nextInt();
				teclado.nextLine();
				for (Disciplina d : curso.getDisciplinaCurso()) {
					if (d.getCodigoDisciplina() == id) {
						System.out.println("Digite o novo nome da disciplina: ");
						d.atualizarDisciplna(teclado.nextLine());
						System.out.println("Disciplina atualizada.");
						break;
					}
				}
				break;
			case 3:
				System.out.println("Digite o ID da disciplina para remover: ");
				int idRemover = teclado.nextInt();
				Disciplina.removerDisciplina(curso, idRemover);
				System.out.println("Disciplina removida.");
				break;
			case 4:
				System.out.println("Disciplinas cadastradas:");
				for (Disciplina d : curso.getDisciplinaCurso()) {
					System.out.println(d);
				}
				break;
			case 0:
				menuSecundario(curso, usuario);
				return;
			default:
				System.out.println("Opção inválida!");
		}
		menuDiciplina(curso, usuario);
	}


	public void menuTurma(Curso curso, Professor usuario) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Menu Turma");
		System.out.println("1 - Listar Turmas do Professor");
		System.out.println("2 - Listar Alunos de uma Turma");
		System.out.println("3 - Adicionar Aluno em uma Turma");
		System.out.println("4 - Remover Aluno de uma Turma");
		System.out.println("0 - Voltar");
		System.out.print("Escolha uma opção: ");
		int opcao = teclado.nextInt();

		switch (opcao) {
			case 1:
				for (Turma t : curso.getTurmaGeral().getTurmasTurmaGeral()) {
					if (t.getCpfTurma().cpf.equals(usuario.cpf)) {
						System.out.println(t);
					}
				}
				break;

			case 2:
				System.out.println("Digite o ID da turma:");
				int idListar = teclado.nextInt();
				for (Turma t : curso.getTurmaGeral().getTurmasTurmaGeral()) {
					if (t.getCodigoTurma() == idListar &&
							t.getProfessorTurma().getCpfProfessor().equals(usuario.cpf)) {
						t.listarAlunosTurma();
					}
				}
				break;

			case 3:
				System.out.println("Digite o ID da turma:");
				int idAdd = teclado.nextInt();
				System.out.println("Digite o RGM do aluno:");
				int rgmAdd = teclado.nextInt();

				for (Turma t : curso.getTurmaGeral().getTurmasTurmaGeral()) {
					if (t.getCodigoTurma() == idAdd &&
							t.getProfessorTurma().getCpfProfessor().equals(usuario.cpf)) {

						Aluno aluno = curso.buscar(rgmAdd);
						if (aluno != null) {
							t.adicionarAluno(aluno);
							System.out.println("Aluno adicionado com sucesso.");
						} else {
							System.out.println("Aluno não encontrado.");
						}
					}
				}
				break;

			case 4:
				System.out.println("Digite o ID da turma:");
				int idRemover = teclado.nextInt();
				System.out.println("Digite o RGM do aluno:");
				int rgmRemover = teclado.nextInt();

				for (Turma t : curso.getTurmaGeral().getTurmasTurmaGeral()) {
					if (t.getCodigoTurma() == idRemover &&
							t.getProfessorTurma().getCpfProfessor().equals(usuario.cpf)) {

						t.removerAluno(rgmRemover);
						System.out.println("Aluno removido com sucesso (se existia).");
					}
				}
				break;

			case 0:
				menuSecundario(curso, usuario);
				return;

			default:
				System.out.println("Opção inválida!");
		}

		menuTurma(curso, usuario); // Chamada recursiva para manter o menu ativo
	}

	public void menuTurmaGeral(Curso curso, Professor usuario) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Menu Turma Geral");
		System.out.println("1 - Criar nova Turma");
		System.out.println("2 - Deletar Turma");
		System.out.println("3 - Listar Todas as Turmas");
		System.out.println("0 - Voltar");
		System.out.print("Escolha uma opção: ");
		int opcao = teclado.nextInt();

		switch (opcao) {
			case 1:
				System.out.println("ID da disciplina: ");
				int disciplinaId = teclado.nextInt();
				Disciplina disc = null;

				for (Disciplina d : curso.getDisciplinaCurso()) {
					if (d.getCodigoDisciplina() == disciplinaId) {
						disc = d;
						break;
					}
				}

				if (disc != null) {
					Turma nova = new Turma(disc, usuario);
					curso.getTurmaGeral().cadastrarTurmaTurmaGeral(nova);
					System.out.println("Turma criada com sucesso!");
				} else {
					System.out.println("Disciplina não encontrada.");
				}
				break;

			case 2:
				System.out.println("Digite o ID da turma para deletar:");
				int idRemover = teclado.nextInt();
				curso.getTurmaGeral().deletarTurmaTurmaGeral(idRemover);
				System.out.println("Turma removida.");
				break;

			case 3:
				curso.getTurmaGeral().listarTurmasTurmaGeral();
				break;

			case 0:
				menuSecundario(curso, usuario);
				return;

			default:
				System.out.println("Opção inválida!");
		}
		menuTurmaGeral(curso, usuario);
	}

	public void menuCurso(Curso curso, Professor usuario) {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Menu Professor");
		System.out.println("1 - Listar Todos os Professores");
		System.out.println("2 - Listar Todos os Alunos");
		System.out.println("3 - Listar Todas as Diciplinas");
		System.out.println("0 - Sair");
		System.out.print("Escolha uma opcao: ");
		int opcao = teclado.nextInt();

		switch (opcao) {
			case 1:
				curso.listarTodosProfessores();
				this.menuCurso(curso, usuario);
				break;
			case 2:
				curso.listarTodosALunos();
				this.menuCurso(curso, usuario);
				break;
			case 3:
				curso.listarTodasDiciplinas();
				this.menuCurso(curso, usuario);
				break;
			case 0:
				System.out.println("Saindo...");
				this.menuSecundario(curso, usuario);
				break;
			default:
				System.out.println("Opção inválida!");
				this.menuCurso(curso, usuario);
		}
	}

}
