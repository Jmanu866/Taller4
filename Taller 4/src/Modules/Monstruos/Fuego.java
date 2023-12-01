package Modules.Monstruos;



public class Fuego extends Monstruo {


    /**
     * Longitud Llamarada
     */

    private int longitudLlamarada; // en metros

    /***
     * Constructor de la clase fuego
     * @param ID
     * @param nombre
     * @param HP
     * @param genero
     * @param longitudLlamarada
     */

    public Fuego(int ID, String nombre, int HP, String genero, int longitudLlamarada) {
        super(ID, nombre, HP, genero);
        this.longitudLlamarada = longitudLlamarada;
    }

    /**
     * get Longitud llamarada
     * @return
     */
    public int getLongitudLlamarada() {
        return longitudLlamarada;
    }

}
