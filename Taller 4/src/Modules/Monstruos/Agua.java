package Modules.Monstruos;


public class Agua extends Monstruo{


    /**
     * Tipo de Chorro
     */
    private String tipoChorro; // DEBIL NORMAL O FUERTE

    /**
     * Constructor de la Clase Agua
     * @param ID
     * @param nombre
     * @param HP
     * @param genero
     * @param tipoChorro
     */
    public Agua(int ID , String nombre, int HP, String genero, String tipoChorro) {
        super(ID, nombre, HP, genero);
        this.tipoChorro = tipoChorro;
    }

    /**
     * Get Tipo de Chorro
     * @return
     */

    public String getTipoChorro() {
        return tipoChorro;
    }




}
