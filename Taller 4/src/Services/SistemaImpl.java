package Services;
import Modules.Cofres.Cofre;
import Modules.Monstruos.*;
import edu.princeton.cs.stdlib.In;
import edu.princeton.cs.stdlib.Out;
import java.text.SimpleDateFormat;
import java.util.*;

public class SistemaImpl implements Sistema{

    List<Monstruo> listaMonstruos = new ArrayList<>();
    List<Volador> listaVolador = new ArrayList<>();
    List<Normal> listaNormal = new ArrayList<>();
    List<Agua> listaAgua = new ArrayList<>();
    List<Legendario> listaLegendario = new ArrayList<>();
    List<Fuego> listaFuego = new ArrayList<>();
    List<Electrico> listaElectrico = new ArrayList<>();
    List<Cofre> listaCofres = new ArrayList<>();


    Random random = new Random();
    String Usuario = "";
    int cantidadCofres = 0;
    int cofresDisponibles = 0;

    long tiempoActual = System.currentTimeMillis();

    List<String> Miacartas = new ArrayList<>(); // Mis Cartas (Fue Intencional)

    /**
     * Metodo cargar Archivo
     */

    public void cargarArchivo(){


        In in = new In("monsters.txt");

        while (in.hasNextLine()){
            String linea = in.readLine();
            String[] campos = linea.split("/");
            if(campos.length >= 3) {
                int ID = Integer.parseInt(campos[0]);
                String Nombre = campos[1];
                String Tipo = campos[2];
                if (Tipo.equals("Normal")){
                    int HP  = Integer.parseInt(campos[3]);
                    String Genero = campos[4];
                    Normal normal = new Normal(ID,Nombre,HP,Genero);
                    listaMonstruos.add(normal);
                    listaNormal.add(normal);


                }
                if (Tipo.equals("Agua")){
                    int HP  = Integer.parseInt(campos[3]);
                    String Genero = campos[4];
                    String Chorro = campos[5];
                    Agua agua = new Agua(ID,Nombre,HP,Genero,Chorro);
                    listaMonstruos.add(agua);
                    listaAgua.add(agua);

                }
                if (Tipo.equals("Fuego")){
                    int HP  = Integer.parseInt(campos[3]);
                    String Genero = campos[4];
                    int Llamarada = Integer.parseInt(campos[5]);

                    Fuego fuego = new Fuego(ID,Nombre,HP,Genero,Llamarada);
                    listaMonstruos.add(fuego);
                    listaFuego.add(fuego);
                }
                if (Tipo.equals("Eléctrico")){
                    int HP  = Integer.parseInt(campos[3]);
                    String Genero = campos[4];
                    int CargaA = Integer.parseInt(campos[5]);
                    boolean cargaCompleta = Boolean.parseBoolean(campos[6]);



                    Electrico electrico = new Electrico(ID,Nombre,HP,Genero,CargaA,cargaCompleta);
                    listaMonstruos.add(electrico);
                    listaElectrico.add(electrico);
                }
                if (Tipo.equals("Volador")){
                    int HP  = Integer.parseInt(campos[3]);
                    String Genero = campos[4];
                    String dureza = campos[5];
                    Volador volador = new Volador(ID,Nombre,HP,Genero,dureza);
                    listaMonstruos.add(volador);
                    listaVolador.add(volador);

                }
                if (Tipo.equals("Legendario")){
                    int HP  = Integer.parseInt(campos[3]);
                    String Genero = campos[4];
                    String superpoder = campos[5];
                    Legendario legendario = new Legendario(ID,Nombre,HP,Genero,superpoder);
                    listaMonstruos.add(legendario);
                    listaLegendario.add(legendario);

                }




            }
        }
    }

    /**
     * Metodo cargar Archivo Data Player
     */

    public void cargaArchivoDataPlayer(){

        In in = new In("data_player.txt");
        int contador = 0;
        int lineadeseada = 0;


        while (in.hasNextLine()){

            String linea = in.readLine();
            if(lineadeseada == contador){
                String[] campos = linea.split("/");
                Usuario = campos[0];

                String[] MisCartas = campos[1].split(",");

                Miacartas.addAll(Arrays.asList(MisCartas));




                cantidadCofres = Integer.parseInt(campos[2]);
                cofresDisponibles = Integer.parseInt(campos[3]);


            } else {

                if (cofresDisponibles >= 1){
                    String[] campos = linea.split(";");
                    String ID  = campos[0];
                    String Tipo = campos[1];
                    long TiempoRestante = Long.parseLong(campos[2]);

                    Cofre cofre = new Cofre(ID,TiempoRestante,Tipo);
                    listaCofres.add(cofre);


                } if (cofresDisponibles == 0) {
                    continue;
                }

            }

            contador ++;

        }


    }

    /**
     * Metodo menu
     */

    public void menu() {

        Scanner s = new Scanner(System.in);
        imprimirMenu();
        String opcion = s.nextLine();

        while (!opcion.equals("4")) {

            switch (opcion) {
                case "1" -> opcionMenu1();
                case "2" -> opcionMenu2();
                case "3" -> opcionMenu3();
                default -> System.out.println("ERROR INGRESE UNA DE LAS OPCIONES CORRRECTAS");
            }
            imprimirMenu();
            opcion = s.nextLine();
        }

        System.out.println("**********************************");
        System.out.println("Cerrando sesion y saliendo del Sistema");
        System.out.println("GRACIAS POR JUGAR MonSter V ");
        System.out.println("**********************************");

    }

    /**
     * metodo opcionMenu 1
     */

    public void opcionMenu1() {

        Scanner s = new Scanner(System.in);
        imprimirOpcionMenu1();
        String opcion = s.nextLine();

        while (!opcion.equals("3")) {

            switch (opcion) {
                case "1" -> opcionMenu11();
                case "2" -> System.out.println("*******Nueva Actualizacion en la Modica Suma de 2 cuotas Rey JASDASDJDAJDS************");
                default -> System.out.println("ERROR INGRESE UNA DE LAS OPCIONES CORRRECTAS");
            }
            imprimirOpcionMenu1();
            opcion = s.nextLine();
        }

        System.out.println("**********************************");
        System.out.println("Volviendo Menu principal");
        System.out.println("**********************************");

    }

    /***
     * metodo opcion menu 2
     */

    public void opcionMenu2(){
        Scanner s = new Scanner(System.in);
        int paginaActual = 0;
        int cartasPorPagina = 4;

        mostrarCartas(listaMonstruos, paginaActual, cartasPorPagina);
        imprimirOpcionMenuPaginado();

        String opcion = s.nextLine();


        while (!opcion.equals("3")) {

            switch (opcion) {
                case "1" -> {
                    if (paginaActual > 0) {
                        paginaActual--;
                    }
                }
                case "2" -> {
                    if (paginaActual < listaMonstruos.size() / cartasPorPagina - 1) {
                        paginaActual++;
                    }
                }
                default -> System.out.println("ERROR INGRESE UNA DE LAS OPCIONES CORRRECTAS");
            }
            mostrarCartas(listaMonstruos, paginaActual, cartasPorPagina);
            imprimirOpcionMenuPaginado();
            opcion = s.nextLine();
        }


        System.out.println("**********************************");
        System.out.println("Volviendo....");
        System.out.println("**********************************");





    }

    /**
     * metodo imprimir menu
     */
    public void imprimirMenu() {

        System.out.println("--------->[MonsterV]<---------");
        System.out.println("[1] Mis cartas");
        System.out.println("[2] Todas las cartas");
        System.out.println("[3] Cofres ");
        System.out.println("[4] Salir ");


    }

    /**
     * metodo imprimir menu opcion  1
     */

    public void imprimirOpcionMenu1() {

        System.out.println("--------->["+Usuario+"]<---------");
        System.out.println("Mis Cofres abiertos : " + cantidadCofres );
        System.out.println("[1] Ver mis cartas");
        System.out.println("[2] Ver mis cartas ordenadas por tipo");
        System.out.println("[3] Volver ");
    }

    /**
     * metodo imprimir opcion menu paginado
     */

    public void imprimirOpcionMenuPaginado(){
        System.out.println("[1] Pagina Atras");
        System.out.println("[2] Pagina Avanza");
        System.out.println("[3] Volver ");


    }

    /**
     * metodo imprimir menu 3
     */

    public void imprimirOpcionMenu3() {

        System.out.println("--------->[Cofres]<---------");
        System.out.println("[1] Ver cofres");
        System.out.println("[2] Abrir cofre");
        System.out.println("[3] Nuevo cofre");
        System.out.println("[4] Volver");

    }

    /**
     * metodo mostrar Cartas
     * @param listaCartas
     * @param paginaActual
     * @param cartasPorPagina
     */

    public void mostrarCartas(List<Monstruo> listaCartas, int paginaActual, int cartasPorPagina){
        System.out.println("Página " + (paginaActual + 1) + ":");
        int inicio = paginaActual * cartasPorPagina;
        int fin = Math.min(inicio + cartasPorPagina, listaCartas.size());
        System.out.println("**********************************");

        for (int i = inicio; i < fin; i++) {

            Monstruo cartaActual = listaCartas.get(i);

            System.out.println("---------Nombre: " + listaCartas.get(i).getNombre() + "----");
            System.out.println("ID: " + listaCartas.get(i).getID());
            System.out.println("Nombre: " + listaCartas.get(i).getNombre());
            System.out.println("HP: " + listaCartas.get(i).getHP());
            System.out.println("Genero: " + listaCartas.get(i).getGenero());
            String ID = String.valueOf(listaCartas.get(i).getID());


            if(cartaActual instanceof Agua ){
                System.out.println("Tipo: Agua");
                System.out.println("Tipo de chorro: " + ((Agua) cartaActual).getTipoChorro());

                if(Miacartas.contains(ID)){
                    System.out.println("Carta: Obtenida");
                } else {
                    System.out.println("Carta: NO Obtenida");
                }
                System.out.println("**********************************");

            }
            if(cartaActual instanceof  Electrico){
                System.out.println("Tipo: Electrico");
                System.out.println("Carga Asociada: " + ((Electrico) cartaActual).getCargaAsociada() );
                System.out.println("Completamente Cargado: " + ((Electrico) cartaActual).isCargaCompleta());

                if(Miacartas.contains(ID)){
                    System.out.println("Carta: Obtenida");
                } else {
                    System.out.println("Carta: NO Obtenida");
                }

                System.out.println("**********************************");
            }
            if(cartaActual instanceof   Fuego){
                System.out.println("Tipo: Fuego");
                System.out.println("Longitud de Llamarada: " + ((Fuego) cartaActual).getLongitudLlamarada());

                if(Miacartas.contains(ID)){
                    System.out.println("Carta: Obtenida");
                } else {
                    System.out.println("Carta: NO Obtenida");
                }

                System.out.println("**********************************");
            }
            if(cartaActual instanceof  Normal) {
                System.out.println("Tipo: Normal");


                if(Miacartas.contains(ID)){
                    System.out.println("Carta: Obtenida");
                } else {
                    System.out.println("Carta: NO Obtenida");
                }

                System.out.println("**********************************");


            }
            if(cartaActual instanceof   Volador){
                System.out.println("Tipo: Volador");
                System.out.println("Dureza de Alas: " + ((Volador) cartaActual).getDureza());

                if(Miacartas.contains(ID)){
                    System.out.println("Carta: Obtenida");
                } else {
                    System.out.println("Carta: NO Obtenida");
                }

                System.out.println("**********************************");
            }
            if(cartaActual instanceof  Legendario){
                System.out.println("Tipo: Legendario");
                System.out.println("SuperPoder: " + ((Legendario) cartaActual).getSuperpoder());

                if(Miacartas.contains(ID)){
                    System.out.println("Carta: Obtenida");
                } else {
                    System.out.println("Carta: NO Obtenida");
                }

                System.out.println("**********************************");
            }
        }



    }

    /**
     * metodo de opcion Menu 1.1
     */


    public void opcionMenu11(){



        Scanner s = new Scanner(System.in);
        int paginaActual = 0;
        int cartasPorPagina = 4;

        mostrarMisCartas(listaMonstruos, paginaActual, cartasPorPagina);
        imprimirOpcionMenuPaginado();

        String opcion = s.nextLine();


        while (!opcion.equals("3")) {

            switch (opcion){
                case "1" -> {
                    if (paginaActual > 0) {
                        paginaActual--;
                    }
                }
                case "2" -> {
                    if (paginaActual < (listaMonstruos.size() / cartasPorPagina) - 1) {
                        paginaActual++;
                    }
                }
                default -> System.out.println("ERROR INGRESE UNA DE LAS OPCIONES CORRRECTAS");
            }
            mostrarMisCartas(listaMonstruos, paginaActual, cartasPorPagina);
            imprimirOpcionMenuPaginado();
            opcion = s.nextLine();
        }


        System.out.println("**********************************");
        System.out.println("Volviendo....");
        System.out.println("**********************************");






    }

    /**
     * metodo mostrar Mis cartas
     * @param listaCartas
     * @param paginaActual
     * @param cartasPorPagina
     */

    public void mostrarMisCartas(List<Monstruo> listaCartas , int paginaActual, int cartasPorPagina) {



        System.out.println("Página " + (paginaActual + 1) + ":");
        int inicio = paginaActual * cartasPorPagina;
        int fin = Math.min(inicio + cartasPorPagina, listaCartas.size());

        System.out.println("**********************************");

        for (int i = inicio; i < fin; i++) {
            String ID = String.valueOf(listaCartas.get(i).getID());
            if(Miacartas.contains(ID)) {
                Monstruo cartaActual = listaCartas.get(i);

                System.out.println("---------Nombre: " + listaCartas.get(i).getNombre() + "----");
                System.out.println("ID: " + listaCartas.get(i).getID());
                System.out.println("Nombre: " + listaCartas.get(i).getNombre());
                System.out.println("HP: " + listaCartas.get(i).getHP());
                System.out.println("Genero: " + listaCartas.get(i).getGenero());



                if (cartaActual instanceof Agua) {
                    System.out.println("Tipo: Agua");
                    System.out.println("Tipo de chorro: " + ((Agua) cartaActual).getTipoChorro());

                    if (Miacartas.contains(ID)) {
                        System.out.println("Carta: Obtenida");
                    } else {
                        System.out.println("Carta: NO Obtenida");
                    }
                    System.out.println("**********************************");

                }
                if (cartaActual instanceof Electrico) {
                    System.out.println("Tipo: Electrico");
                    System.out.println("Carga Asociada: " + ((Electrico) cartaActual).getCargaAsociada());
                    System.out.println("Completamente Cargado: " + ((Electrico) cartaActual).isCargaCompleta());

                    if (Miacartas.contains(ID)) {
                        System.out.println("Carta: Obtenida");
                    } else {
                        System.out.println("Carta: NO Obtenida");
                    }

                    System.out.println("**********************************");
                }
                if (cartaActual instanceof Fuego) {
                    System.out.println("Tipo: Fuego");
                    System.out.println("Longitud de Llamarada: " + ((Fuego) cartaActual).getLongitudLlamarada());

                    if (Miacartas.contains(ID)) {
                        System.out.println("Carta: Obtenida");
                    } else {
                        System.out.println("Carta: NO Obtenida");
                    }

                    System.out.println("**********************************");
                }
                if (cartaActual instanceof Normal) {
                    System.out.println("Tipo: Normal");

                    if (Miacartas.contains(ID)) {
                        System.out.println("Carta: Obtenida");
                    } else {
                        System.out.println("Carta: NO Obtenida");
                    }

                    System.out.println("**********************************");


                }
                if (cartaActual instanceof Volador) {
                    System.out.println("Tipo: Volador");
                    System.out.println("Dureza de Alas: " + ((Volador) cartaActual).getDureza());

                    if (Miacartas.contains(ID)) {
                        System.out.println("Carta: Obtenida");
                    } else {
                        System.out.println("Carta: NO Obtenida");
                    }

                    System.out.println("**********************************");
                }
                if (cartaActual instanceof Legendario) {
                    System.out.println("Tipo: Legendario");
                    System.out.println("SuperPoder: " + ((Legendario) cartaActual).getSuperpoder());

                    if (Miacartas.contains(ID)) {
                        System.out.println("Carta: Obtenida");
                    } else {
                        System.out.println("Carta: NO Obtenida");
                    }

                    System.out.println("**********************************");
                }
            } else {
                System.out.println();
                System.out.println("**********************************");
                System.out.println("CARTA NO DISPONIBLE");
                System.out.println("**********************************");
            }
        }









    }

    /**
     * metodo de opcion menu3
     */


    public void opcionMenu3() {

        Scanner s = new Scanner(System.in);
        imprimirOpcionMenu3();
        String opcion = s.nextLine();

        while (!opcion.equals("4")) {

            switch (opcion) {
                case "1" -> verCofres();
                case "2" -> abrirCofre();
                case "3" -> nuevoCofre();
                default -> System.out.println("ERROR INGRESE UNA DE LAS OPCIONES CORRRECTAS");
            }
            imprimirOpcionMenu3();
            opcion = s.nextLine();
        }

        System.out.println("**********************************");
        System.out.println("Volviendo Menu principal");
        System.out.println("**********************************");

    }


    /**
     * metodo ver cofres
     */

    public void verCofres(){
        System.out.println("MIS COFRES");
        System.out.println("[--------------------------]");
        for(Cofre cofre : listaCofres){
            System.out.println("ID: " +  cofre.getID());
            System.out.println("Tipo: " + cofre.getTipo());


            Date fecha = new Date(cofre.getFechaFinal());

            SimpleDateFormat formato = new SimpleDateFormat("dd MMM yyyy HH:mm");

            String fechaFormateada = formato.format(fecha);

            System.out.println("Fecha de finalizacion: " + fechaFormateada);


            System.out.println("[--------------------------]");
        }
    }

    /**
     * metodo abrir cofre
     */
    public void abrirCofre(){
        int[] rango2a4 = {2,3,4}; // rango cartas cofre normal
        int[] rango3a5 = {3, 4, 5}; //rango cartas cofre plata
        int[] rango4a6 = {4,5,6}; //rango cartas cofre diamante

        Scanner s = new Scanner(System.in);
        System.out.println("[--------------------------]");
        System.out.print("Ingrese el Code del Cofre que desee abrir: (si vuelve al menu es por que no encontro el cofre)");
        String Code = s.nextLine();



        for(Cofre cofres : listaCofres){
            if (cofres.getID().equals(Code)) {

                if(cofres.getFechaFinal() < tiempoActual) {

                    if (cofres.getTipo().equals("normal")) {

                        int rangoindex = random.nextInt(rango2a4.length);
                        int rango = rango2a4[rangoindex];
                        abrircofreNormal(rango);
                        listaCofres.remove(cofres);
                        break;


                    }
                    if (cofres.getTipo().equals("plata")) {
                        int rangoindex = random.nextInt(rango3a5.length);
                        int rango = rango3a5[rangoindex];
                        abrircofreplata(rango);

                        listaCofres.remove(cofres);
                        break;


                    }
                    if (cofres.getTipo().equals("diamante")) {
                        int rangoindex = random.nextInt(rango3a5.length);
                        int rango = rango4a6[rangoindex];
                        abrircofrediamante(rango);

                        listaCofres.remove(cofres);
                        break;


                    }


                } else {
                    System.out.println("[--------------------------]");
                    System.out.println("Error Aun no puede abrir este Cofre:( ");
                    System.out.println("[--------------------------]");
                     break;
                }













            }
        }














    }

    /**
     * metodo abrir cofre normal
     * @param rango
     */
    public void abrircofreNormal(int rango){

        System.out.println("NUMERO DE CARTAS EN EL COFRE " + rango);
        for(int i = 0 ; i < rango  ; i++ ){

            int randoms = (int) (Math.random() * 100 + 1); //random 1 a 100

            if (randoms == 1) {
                // 1% de probabilidad legendario
                int resultado = random.nextInt(listaLegendario.size());

                Legendario legendario = listaLegendario.get(resultado);

                System.out.println("FELICIDADES OBTUVISTE UNA CARTA LEGENDARIO");
                System.out.println("ID: " + legendario.getID());
                System.out.println("Nombre: " + legendario.getNombre());
                System.out.println("HP: " + legendario.getHP());
                System.out.println("Genero: " + legendario.getGenero());
                System.out.println("SuperPoder: " + legendario.getSuperpoder());

                String ID = String.valueOf(legendario.getID());


                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }
                System.out.println("[--------------------------]");


            } if (randoms >= 2 && randoms <= 16) {
                // 15% de probabilidad electrico
                int resultado = random.nextInt(listaElectrico.size());
                Electrico electrico = listaElectrico.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA ELECTRICO");
                System.out.println("ID: " + electrico.getID());
                System.out.println("Nombre: " + electrico.getNombre());
                System.out.println("HP: " + electrico.getHP());
                System.out.println("Genero: " + electrico.getGenero());
                System.out.println("Carga Asociada: " + electrico.getCargaAsociada());
                System.out.println("Completamente Cargado: " + electrico.isCargaCompleta() );

                String ID = String.valueOf(electrico.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }
                System.out.println("[--------------------------]");

            } if (randoms >= 17 && randoms <= 31) {
                // 15% de probabilidad Fuego
                int resultado = random.nextInt(listaFuego.size());
                Fuego fuego = listaFuego.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA FUEGO");
                System.out.println("ID: " + fuego.getID());
                System.out.println("Nombre: " + fuego.getNombre());
                System.out.println("HP: " + fuego.getHP());
                System.out.println("Genero: " + fuego.getGenero());
                System.out.println("Longitud de Llamarada: " + fuego.getLongitudLlamarada());
                System.out.println("[--------------------------]");
                String ID = String.valueOf(fuego.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }



            } if (randoms >= 32 && randoms <= 46) {
                // 15% de probabilidad agua
                int resultado = random.nextInt(listaAgua.size());
                Agua agua = listaAgua.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA AGUA");
                System.out.println("ID: " + agua.getID());
                System.out.println("Nombre: " + agua.getNombre());
                System.out.println("HP: " + agua.getHP());
                System.out.println("Genero: " + agua.getGenero());
                System.out.println("Tipo de chorro: + " + agua.getTipoChorro());
                System.out.println("[--------------------------]");

                String ID = String.valueOf(agua.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }



            } if(randoms >= 47 && randoms <= 61){
                // 15% de probabilidad volador
                int resultado = random.nextInt(listaVolador.size());
                Volador volador = listaVolador.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA VOLADOR");
                System.out.println("ID: " + volador.getID());
                System.out.println("Nombre: " + volador.getNombre());
                System.out.println("HP: " + volador.getHP());
                System.out.println("Genero: " + volador.getGenero());
                System.out.println("Dureza de Alas: " + volador.getDureza());
                System.out.println("[--------------------------]");

                String ID = String.valueOf(volador.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }



            }
            else {
                // 39% de probabilidad normal
                int resultado = random.nextInt(listaNormal.size());
                Normal normal = listaNormal.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA NORMAL");
                System.out.println("ID: " + normal.getID());
                System.out.println("Nombre: " + normal.getNombre());
                System.out.println("HP: " + normal.getHP());
                System.out.println("Genero: " + normal.getGenero());
                System.out.println("[--------------------------]");

                String ID = String.valueOf(normal.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }



            }


        }

        cofresDisponibles --;












    }

    /**
     * metodo abrir cofre plata
     * @param rango
     */
    public void abrircofreplata(int rango){
        for(int i = 0 ; i < rango ; i++ ){

            int randoms = (int) (Math.random() * 100 + 1);

            if (randoms <= 5){
                //5% legendario

                int resultado = random.nextInt(listaLegendario.size());

                Legendario legendario = listaLegendario.get(resultado);

                System.out.println("FELICIDADES OBTUVISTE UNA CARTA LEGENDARIO");
                System.out.println("ID: " + legendario.getID());
                System.out.println("Nombre: " + legendario.getNombre());
                System.out.println("HP: " + legendario.getHP());
                System.out.println("Genero: " + legendario.getGenero());
                System.out.println("SuperPoder: " + legendario.getSuperpoder());
                System.out.println("[--------------------------]");
                String ID = String.valueOf(legendario.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }


            }
            if (randoms >= 6 && randoms <= 23) {
                //18% Volador

                int resultado = random.nextInt(listaVolador.size());
                Volador volador = listaVolador.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA VOLADOR");
                System.out.println("ID: " + volador.getID());
                System.out.println("Nombre: " + volador.getNombre());
                System.out.println("HP: " + volador.getHP());
                System.out.println("Genero: " + volador.getGenero());
                System.out.println("Dureza de Alas: " + volador.getDureza());
                System.out.println("[--------------------------]");

                String ID = String.valueOf(volador.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }


            }
            if (randoms >= 24 && randoms <= 42 ){
                // 18% Electrico
                int resultado = random.nextInt(listaElectrico.size());
                Electrico electrico = listaElectrico.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA ELECTRICO");
                System.out.println("ID: " + electrico.getID());
                System.out.println("Nombre: " + electrico.getNombre());
                System.out.println("HP: " + electrico.getHP());
                System.out.println("Genero: " + electrico.getGenero());
                System.out.println("Carga Asociada: " + electrico.getCargaAsociada());
                System.out.println("Completamente Cargado: " + electrico.isCargaCompleta() );
                System.out.println("[--------------------------]");
                String ID = String.valueOf(electrico.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }

            }
            if(randoms >= 43 && randoms <= 60){
                // 18% Fuego

                int resultado = random.nextInt(listaFuego.size());
                Fuego fuego = listaFuego.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA FUEGO");
                System.out.println("ID: " + fuego.getID());
                System.out.println("Nombre: " + fuego.getNombre());
                System.out.println("HP: " + fuego.getHP());
                System.out.println("Genero: " + fuego.getGenero());
                System.out.println("Longitud de Llamarada: " + fuego.getLongitudLlamarada());
                System.out.println("[--------------------------]");
                String ID = String.valueOf(fuego.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }



            } if(randoms >= 61 && randoms <= 78){
                // 18% Agua
                int resultado = random.nextInt(listaAgua.size());
                Agua agua = listaAgua.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA AGUA");
                System.out.println("ID: " + agua.getID());
                System.out.println("Nombre: " + agua.getNombre());
                System.out.println("HP: " + agua.getHP());
                System.out.println("Genero: " + agua.getGenero());
                System.out.println("Tipo de chorro: " + agua.getTipoChorro());
                System.out.println("[--------------------------]");

                String ID = String.valueOf(agua.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }


            } else {
                //23% Normal
                int resultado = random.nextInt(listaNormal.size());
                Normal normal = listaNormal.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA NORMAL");
                System.out.println("ID: " + normal.getID());
                System.out.println("Nombre: " + normal.getNombre());
                System.out.println("HP: " + normal.getHP());
                System.out.println("Genero: " + normal.getGenero());
                System.out.println("[--------------------------]");

                String ID = String.valueOf(normal.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }

            }



        }

        cofresDisponibles --;
    }

    /**
     * metodo abrir cofre diamante
     * @param rango
     */
    public void abrircofrediamante(int rango){

        for(int i = 0 ; i < rango ; i++ ){
            int randoms = (int) (Math.random() * 100 + 1);

            if(randoms <= 12){
                // 12% legendario

                int resultado = random.nextInt(listaLegendario.size());

                Legendario legendario = listaLegendario.get(resultado);

                System.out.println("FELICIDADES OBTUVISTE UNA CARTA LEGENDARIO");
                System.out.println("ID: " + legendario.getID());
                System.out.println("Nombre: " + legendario.getNombre());
                System.out.println("HP: " + legendario.getHP());
                System.out.println("Genero: " + legendario.getGenero());
                System.out.println("SuperPoder: " + legendario.getSuperpoder());
                System.out.println("[--------------------------]");
                String ID = String.valueOf(legendario.getID());
                Miacartas.add(ID);

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }


            } if(randoms >= 13 && randoms <= 31){
                // 19% de probabilidad Volador
                int resultado = random.nextInt(listaVolador.size());
                Volador volador = listaVolador.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA VOLADOR");
                System.out.println("ID: " + volador.getID());
                System.out.println("Nombre: " + volador.getNombre());
                System.out.println("HP: " + volador.getHP());
                System.out.println("Genero: " + volador.getGenero());
                System.out.println("Dureza de Alas: " + volador.getDureza());
                System.out.println("[--------------------------]");

                String ID = String.valueOf(volador.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }

            } if (randoms >= 32 && randoms <= 51){
                // 19% de Probabilidad Electrico
                int resultado = random.nextInt(listaElectrico.size());
                Electrico electrico = listaElectrico.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA ELECTRICO");
                System.out.println("ID: " + electrico.getID());
                System.out.println("Nombre: " + electrico.getNombre());
                System.out.println("HP: " + electrico.getHP());
                System.out.println("Genero: " + electrico.getGenero());
                System.out.println("Carga Asociada: " + electrico.getCargaAsociada());
                System.out.println("Completamente Cargado: " + electrico.isCargaCompleta() );
                System.out.println("[--------------------------]");
                String ID = String.valueOf(electrico.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }

            } if(randoms >= 52 && randoms <= 69){
                // 19% de Probabilidad Fuego

                int resultado = random.nextInt(listaFuego.size());
                Fuego fuego = listaFuego.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA FUEGO");
                System.out.println("ID: " + fuego.getID());
                System.out.println("Nombre: " + fuego.getNombre());
                System.out.println("HP: " + fuego.getHP());
                System.out.println("Genero: " + fuego.getGenero());
                System.out.println("Longitud de Llamarada: " + fuego.getLongitudLlamarada());
                System.out.println("[--------------------------]");
                String ID = String.valueOf(fuego.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }


            } if(randoms >= 70 && randoms <= 88){
                // 19% de Probabilidad Agua
                int resultado = random.nextInt(listaAgua.size());
                Agua agua = listaAgua.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA AGUA");
                System.out.println("ID: " + agua.getID());
                System.out.println("Nombre: " + agua.getNombre());
                System.out.println("HP: " + agua.getHP());
                System.out.println("Genero: " + agua.getGenero());
                System.out.println("Tipo de chorro: + " + agua.getTipoChorro());
                System.out.println("[--------------------------]");

                String ID = String.valueOf(agua.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }

            } else{
                // 12% de Probabilidad Normal
                int resultado = random.nextInt(listaNormal.size());
                Normal normal = listaNormal.get(resultado);
                System.out.println("FELICIDADES OBTUVISTE UNA CARTA NORMAL");
                System.out.println("ID: " + normal.getID());
                System.out.println("Nombre: " + normal.getNombre());
                System.out.println("HP: " + normal.getHP());
                System.out.println("Genero: " + normal.getGenero());
                System.out.println("[--------------------------]");

                String ID = String.valueOf(normal.getID());

                if(Miacartas.contains(ID)){
                    System.out.println(ID + " CARTA REPETIDA");
                } else{
                    Miacartas.add(ID);
                }
            }
        }
        cofresDisponibles --;

    }


    /**
     * metodo abrir nuevo cofre
     */
    public void nuevoCofre(){
        String ID;
        String Tipo;
        if (cofresDisponibles < 4) {
            System.out.println("Generando Cofre");


            ID = obtenerCaracter();

            Tipo = obtenerTipoCofre();

            if(Tipo.equals("normal")){
                long tiempoDespues5Min = tiempoActual + (5 * 60 * 1000);
                Cofre nuevoCofre = new Cofre(ID,tiempoDespues5Min,Tipo);
                System.out.println("[--------------------------]");
                System.out.println("FELICIDADES TU NUEVO COFRE ES " + Tipo);
                System.out.println("ID: " + ID);


                Date fecha = new Date(nuevoCofre.getFechaFinal());

                SimpleDateFormat formato = new SimpleDateFormat("dd MMM yyyy HH:mm");

                String fechaFormateada = formato.format(fecha);

                System.out.println("Fecha de finalizacion: " + fechaFormateada);


                System.out.println("[--------------------------]");

                listaCofres.add(nuevoCofre);

                cofresDisponibles++;


            }
            if(Tipo.equals("plata")){
                long tiempoDespues15Min = tiempoActual + (15 * 60 * 1000);
                Cofre nuevoCofre = new Cofre(ID,tiempoDespues15Min,Tipo);

                System.out.println("[--------------------------]");
                System.out.println("FELICIDADES TU NUEVO COFRE ES " + Tipo);
                System.out.println("ID: " + ID);


                Date fecha = new Date(nuevoCofre.getFechaFinal());

                SimpleDateFormat formato = new SimpleDateFormat("dd MMM yyyy HH:mm");

                String fechaFormateada = formato.format(fecha);

                System.out.println("Fecha de finalizacion: " + fechaFormateada);

                System.out.println("[--------------------------]");

                listaCofres.add(nuevoCofre);

                cofresDisponibles++;


            }
            if(Tipo.equals("diamante")){
                long tiempoDespues30Min = tiempoActual + (30 * 60 * 1000);
                Cofre nuevoCofre = new Cofre(ID,tiempoDespues30Min,Tipo);

                System.out.println("[--------------------------]");
                System.out.println("FELICIDADES TU NUEVO COFRE ES " + Tipo);
                System.out.println("ID: " + ID);


                Date fecha = new Date(nuevoCofre.getFechaFinal());

                SimpleDateFormat formato = new SimpleDateFormat("dd MMM yyyy HH:mm");

                String fechaFormateada = formato.format(fecha);

                System.out.println("Fecha de finalizacion: " + fechaFormateada);


                System.out.println("[--------------------------]");

                listaCofres.add(nuevoCofre);
                cofresDisponibles++;
            }





        } else {
            System.out.println("[--------------------------]");
            System.out.println("ERROR actualmente tienes el maximo de cofres ....");
            System.out.println("[--------------------------]");
        }











    }

    /**
     * metodo obtener caracter
     * @return
     */

    public String obtenerCaracter(){

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random r = new Random();
        char[] chars = new char[5];

        for (int i = 0; i < 5; i++) {
            chars[i] = alphabet.charAt(r.nextInt(alphabet.length()));
        }


        String Caracter = new String(chars);

        return Caracter;

    }

    /**
     * metodo obtener tipo cofre
     * @return
     */

    public String obtenerTipoCofre() {


        String[] Lista = {"normal", "plata", "diamante"};

        Random r = new Random();

        String eleccion = Lista[r.nextInt(Lista.length)];



        return eleccion ;
    }


    /**
     * metodo guardar archivo data player
     */

    public void guardarArchivoDataPlayer(){
        Out out = new Out("data_player.txt");


        String lineaMisCofres = String.join("," , Miacartas);




        String UsuarioGuardar = Usuario + "/" + lineaMisCofres + "/" + cantidadCofres + "/"+cofresDisponibles ;

        out.println(UsuarioGuardar);

        for(Cofre cofres : listaCofres){
            out.println(cofres.getID() + ";" + cofres.getTipo() + ";" + cofres.getFechaFinal());
        }
        




    }









}
