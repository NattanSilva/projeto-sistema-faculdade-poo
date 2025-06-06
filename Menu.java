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
		System.out.println("Menu Inicial");
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
				this.menuALuno(curso);
				break;
			case 2:
					this.menuProfessor(curso);
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
				break;
			default:
				System.out.println("Opção inválida!");
				this.menuSecundario(curso, professor);
				break;
		}
	}

	public void menuALuno(Curso curso) {return;}

	public void menuProfessor(Curso curso) {return;}

	public void menuDiciplina(Curso curso) {return;}

	public void menuTurma(Curso curso) {return;}

	public void menuTurmaGeral(Curso curso) {return;}

	public void menuUsuario(Curso curso) {return;}

	public void menuCurso(Curso curso) {}

}
