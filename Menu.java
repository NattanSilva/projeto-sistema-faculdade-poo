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
		System.out.println("2 - Menu Professor");
		System.out.println("3 - Menu Diciplina");
		System.out.println("4 - Menu Turma");
		System.out.println("5 - Menu Turma Geral");
		System.out.println("6 - Menu Usuário");
		System.out.println("7 - Menu Curso");
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
				this.menuDiciplina(curso);
				break;
			case 4:
				this.menuTurma(curso);
				break;
			case 5:
					this.menuTurmaGeral(curso);
					break;
			case 6:
				this.menuUsuario(curso);
				break;
			case 7:
				this.menuCurso(curso);
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

		System.out.println("Menu Professor");
		System.out.println("1 - Buscar Professor");
		System.out.println("2 - Atualizar Professor");
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

	public void menuDiciplina(Curso curso) {return;}

	public void menuTurma(Curso curso) {return;}

	public void menuTurmaGeral(Curso curso) {return;}

	public void menuUsuario(Curso curso) {return;}

	public void menuCurso(Curso curso) {}

}
