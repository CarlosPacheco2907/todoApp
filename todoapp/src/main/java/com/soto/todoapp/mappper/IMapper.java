package com.soto.todoapp.mappper;
/***
 * Interfaz para todos los mapper dentro de la aplicacion
 */
public interface IMapper <I, O>{

    /***
     *
     * @param in input
     * @return O output
     */
    public O map(I in);


}
