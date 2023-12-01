package Modules.Monstruos;



public class Electrico extends Monstruo {


    /**
     * Carga Asociada
     */
    private int cargaAsociada;
    /**
     * Carga Completa
     */
    private boolean cargaCompleta;

    /**
     * Constructor de la clase Electrico
     * @param ID
     * @param nombre
     * @param HP
     * @param genero
     * @param cargaAsociada
     * @param cargaCompleta
     */
    public Electrico(int ID ,String nombre, int HP, String genero, int cargaAsociada , boolean cargaCompleta ) {
        super(ID, nombre, HP, genero);
        this.cargaAsociada = cargaAsociada;
        this.cargaCompleta = cargaCompleta;
    }

    /**
     * get Carga Asociada
     * @return
     */
    public int getCargaAsociada() {
        return cargaAsociada;
    }

    /***
     *  is de Carga Completa
     * @return
     */
    public boolean isCargaCompleta() {
        return cargaCompleta;
    }
}
