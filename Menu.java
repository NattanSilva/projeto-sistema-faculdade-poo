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

		System.out.println("Escolha uma opção: \n");
		System.out.println("1 - Cadastrar-se\n");
		System.out.println("2 - Logar\n");
		int opcao = teclado.nextInt();

		switch (opcao) {
			case 1:
				System.out.println("Digite o nome: ");
				nome = teclado.next();
				System.out.println("Digite o CPF: ");
				cpf = teclado.next();
				System.out.println("Digite o email: ");
				email = teclado.next();
				usuario.cadastrar(nome, cpf, email);
				menuInicial(curso);
				break;
			case 2:
				System.out.println("Digite o CPF: ");
				cpf = teclado.next();
				usuario.logar(cpf);
				break;
			default:
				System.out.println("Opção inválida!\n");
				menuInicial(curso);
				break;
		}
	}

	public void menuALuno() {return;}

	public void menuProfessor() {return;}

	public void menuDiciplina() {return;}

	public void menuTurma() {return;}

	public void menuTurmaGeral() {return;}

	public void menuUsuario() {return;}

}
