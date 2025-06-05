public class Principal {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Curso curso = menu.iniciar();

        menu.menuInicial(curso);
    }
}
