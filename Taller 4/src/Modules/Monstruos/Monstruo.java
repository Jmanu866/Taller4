package Modules.Monstruos;



public abstract class Monstruo {

    /**
     * ID
     */
    private int ID;
    /**
     * Nombre
     */

    private String nombre;
    /**
     * HP
     */

    private int HP;
    /**
     * Genero
     */

    private String Genero; // MACHO HEMBRA O DESCONOCIDO

    /***
     * Constructor de la Clase Monstruo
     * @param ID
     * @param nombre
     * @param HP
     * @param genero
     */
    public Monstruo(int ID, String nombre, int HP, String genero) {
        this.ID = ID;
        this.nombre = nombre;
        this.HP = HP;
        Genero = genero;
    }

    /**
     * Get ID
     *
     * @return
     */
    public int getID() {
        return ID;
    }

    /***
     * get Nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /***
     * get HP
     * @return
     */

    public int getHP() {
        return HP;
    }

    /**
     * get Genero
     *
     * @return
     */
    public String getGenero() {
        return Genero;
    }



}
