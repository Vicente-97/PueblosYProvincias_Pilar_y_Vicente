package com.jacaranda.utilities;

import java.util.ArrayList;
import java.util.Collection;

public class Provincia extends Poblacion{
	//Atributos de Provincia
	private static final Integer Longitud=2;
	private String nombre;
	private String codigo;
	private Integer numeroHabitantes;
	private Double rentaPerCapita;
	private Double superficie;
		
	private Collection<Pueblo> pueblos;
		
	
	//Constructores de Provincia
	public Provincia (String nombre, String codigo) throws ProvinciaException {
		if (nombre == null || codigo==null) {
			throw new ProvinciaException("El nombre del pueblo no puede ser nulo");
		}
		this.nombre = nombre.toUpperCase();  //Debe de almacenarse en mayus.
		this.nombre = nombre.toUpperCase();
		try {
			setCodigo(codigo);
		} catch (Exception e) {
			throw new ProvinciaException("Error");
		}
		this.numeroHabitantes = 0;
		this.rentaPerCapita = 0.0;
		this.superficie = 0.0;
		this.pueblos = new ArrayList<>();
	}
	
	
	//Metodos de Provincia 
	public boolean addPueblo​(String nombrePueblo, String codigo, int numeroHabitantes, 
							 double rentaPerCapita, double superficie)  throws ProvinciaException {
		
		boolean anadirPueblo = false;
		//String codigoNuevo = this.codigo + codigo;
		if (nombre == null) {
			throw new ProvinciaException("El codigo no puede ser nulo");
		}
		if (existePueblo(nombrePueblo)) {
			throw new ProvinciaException("El pueblo ya existe");
		} else {
			Pueblo p1 = new Pueblo(nombrePueblo, codigo, numeroHabitantes, rentaPerCapita, superficie );
			pueblos.add(p1);
			anadirPueblo = true;
			this.superficie += superficie;
			this.numeroHabitantes += numeroHabitantes;
			this.rentaPerCapita += rentaPerCapita;
		}
		
		
		return anadirPueblo;
	}
	
	
	public boolean delPueblo(String nombre) {
		boolean eliminado = false;
		if(existePueblo(nombre)) {
			
			for(Pueblo p : this.pueblos) {
				if(p.getNombre().equalsIgnoreCase(nombre)) {
					this.pueblos.remove(p);
					this.superficie -= p.getSuperficie();
					this.rentaPerCapita -= p.getRentaPerCapita();
					this.numeroHabitantes -= p.getNumeroHabitantes();
				}
			}
		}
		return eliminado;
	}
	
	private boolean existePueblo(String nombre) throws ProvinciaException {
		boolean resultado = false;
		if (nombre==null) {
			throw new ProvinciaException("El nombre del pueblo no puede ser nulo");
		}
		for (Pueblo pueblo : this.pueblos) {
			if (pueblo.getNombre().equalsIgnoreCase(nombre)) {
				resultado = true;
			}

		}
		return resultado;
	}

	
	
	public String getInformacionPueblo(String nombre) throws ProvinciaException {
		String resultado="";
		if (!existePueblo(nombre) || nombre==null) {
			resultado=null;
		}else {
			for (Pueblo p:this.pueblos) {
				if (p.getNombre().equalsIgnoreCase(nombre)) {
					resultado=p.toString();
				}
			}
		}
		return resultado;
	}

	
	public String getProvincia() {
		
		return this.nombre;
	}
	
	
	public String listadoNombrePueblo() {
		StringBuilder cadenaNueva = new StringBuilder("");
		for (Pueblo p : this.pueblos) {
			cadenaNueva.append(p.getNombre() + System.lineSeparator());
		}
		return cadenaNueva.toString();
	}
	
	
	public String listadoPueblos() {
		StringBuilder cadenaNueva = new StringBuilder("");
		for (Pueblo p : this.pueblos) {
			cadenaNueva.append(p);
		}
		return cadenaNueva.toString();
	}
	
	
	public Integer numPueblos() {
		
		return pueblos.size();
	}
	
	
	
	//Getters-Setters de Provincia
	public String getCodigo() {
		return codigo;
	}


	


	public Integer getNumeroHabitantes() {
		return numeroHabitantes;
	}


	public void setNumeroHabitantes(String pueblo, Integer numeroHabitantes) throws ProvinciaException{
		if(numeroHabitantes==null || numeroHabitantes<0) {
			throw new ProvinciaException("Los habitantes deben ser positivos, error ");
		}
		this.numeroHabitantes = numeroHabitantes;
	}


	public Double getRentaPerCapita() {
		return rentaPerCapita;
	}


	public void setRentaPerCapita(Double rentaPerCapita) throws ProvinciaException{
		if(rentaPerCapita==null || rentaPerCapita<0) {
			throw new ProvinciaException("La renta per capita debe de ser positiva, error ");
		}
		this.rentaPerCapita = rentaPerCapita;
	}


	public Double getSuperficie() {
		return superficie;
	}

	
	public void setSuperficie(String pueblo, Double superficie) throws ProvinciaException, PuebloException  {
		double resta=0.0;
		if (superficie<0) {
			throw new ProvinciaException("La superficie debe de ser positiva");
		}
		boolean resultado= false;
			if (existePueblo(pueblo)) {
				for(Pueblo pu : pueblos) {
					if(pueblo.equalsIgnoreCase(pu.getNombre())) {
						resta=this.superficie-pu.getSuperficie();
						pu.setSuperficie(superficie);
						
					}
				}
				this.superficie-=resta;
				this.superficie += superficie;
				resultado=true;
			}else {
				throw new ProvinciaException("No existe el pueblo");
			}
			
		//Si se cambia la superficie de un Pueblo, tambien 
		//cambiara la superficie de Provincia.
		
	}

	
	//toString() de Provincia
	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}


	@Override
	public int getTananno() {
		// TODO Auto-generated method stub
		return Longitud;
	}
	
	
	
}
