package Modules.Monstruos;



public class Legendario extends Monstruo{


    /**
     * Superpoder
     */
    private String superpoder;

    /**
     * Constructor Legendario
     * @param ID
     * @param nombre
     * @param HP
     * @param genero
     * @param superpoder
     */
    public Legendario(int ID, String nombre, int HP, String genero, String superpoder) {
        super(ID, nombre, HP, genero);
        this.superpoder = superpoder;
    }

    /**
     * get SuperPoder
     * @return
     */

    public String getSuperpoder() {
        return superpoder;
    }



}
