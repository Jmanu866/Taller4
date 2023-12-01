package Modules.Monstruos;



public class Volador extends Monstruo{

    /**
     * Dureza
     */
    private String dureza;

    /**
     * Constructor Volador
     * @param ID
     * @param nombre
     * @param HP
     * @param genero
     * @param dureza
     */
    public Volador(int ID , String nombre, int HP, String genero, String dureza) {
        super(ID, nombre, HP, genero);
        this.dureza = dureza;
    }

    /**
     * Constructor Dureza
     * @return
     */

    public String getDureza() {
        return dureza;
    }

}
