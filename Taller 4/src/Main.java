import Services.SistemaImpl;

public class Main {
    public static void main(String[] args) {



        SistemaImpl sistema = new SistemaImpl();

        //Cargar Archivo
        sistema.cargarArchivo();
        sistema.cargaArchivoDataPlayer();


        // MENU
        sistema.menu();



        //Guardar Archivo
        sistema.guardarArchivoDataPlayer();









    }
}