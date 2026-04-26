package com.practica.genericas;


import com.practica.excecption.EmsInvalidNumberOfDataException;

public class PosicionPersona {
    private Coordenada coordenada;
    private String documento;
    private FechaHora fechaPosicion;

	public PosicionPersona(Coordenada coordenada, String documento, FechaHora fechaPosicion){
		this.coordenada = coordenada;
		this.documento = documento;
		this.fechaPosicion = fechaPosicion;
	}

    public static PosicionPersona crearPosicionPersona(String[] data) throws EmsInvalidNumberOfDataException {
        if (data.length != Constantes.MAX_DATOS_LOCALIZACION) {
            throw new EmsInvalidNumberOfDataException("Invalid number of " +
                    "atributes for PosicionPersona");
        }

        String documento = data[1];
        String fecha = data[2];
        String hora = data[3];
        float latitud = Float.parseFloat(data[4]);
		float longitud = Float.parseFloat(data[5]);
		Coordenada coordenada = new Coordenada(latitud,longitud);
		FechaHora fechaPosicion = FechaHora.parsearFecha(fecha,hora);
        return new PosicionPersona(coordenada,documento,fechaPosicion);
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public FechaHora getFechaPosicion() {
        return fechaPosicion;
    }

    public void setFechaPosicion(FechaHora fechaPosicion) {
        this.fechaPosicion = fechaPosicion;
    }

    @Override
    public String toString() {
        String cadena = "";
        cadena += String.format("%s;", getDocumento());
        FechaHora fecha = getFechaPosicion();
        cadena += String.format("%02d/%02d/%04d;%02d:%02d;",
                fecha.getFecha().getDia(),
                fecha.getFecha().getMes(),
                fecha.getFecha().getAnio(),
                fecha.getHora().getHora(),
                fecha.getHora().getMinuto());
        cadena += String.format("%.4f;%.4f\n", getCoordenada().getLatitud(),
                getCoordenada().getLongitud());

        return cadena;
    }

}
