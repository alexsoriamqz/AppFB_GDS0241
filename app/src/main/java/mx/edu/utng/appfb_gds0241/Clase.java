package mx.edu.utng.appfb_gds0241;

public class Clase {
    private String claseId, posicion, estatus, jugador, equipo;

    public Clase(String claseId, String posicion, String estatus, String jugador, String equipo) {
        this.claseId = claseId;
        this.posicion = posicion;
        this.estatus = estatus;
        this.jugador = jugador;
        this.equipo = equipo;
    }

    public String getClaseId() {
        return claseId;
    }

    public void setClaseId(String claseId) {
        this.claseId = claseId;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}
