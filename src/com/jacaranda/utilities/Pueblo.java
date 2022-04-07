package com.jacaranda.utilities;

import java.util.Objects;

public class Pueblo extends Poblacion implements Comparable<Pueblo> {

	//Atributos de Pueblo
	private static final Integer Longitud=5;
	private String nombre;
	private String codigo;
	private Integer numeroHabitantes;
	private Double rentaPerCapita;
	private Double superficie;
	
	
	
	
	//Constructores de Pueblo
	public Pueblo(String nombre, String codigo, Integer numeroHabitantes, 
			  	  Double rentaPerCapita, Double superficie) 
				  throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();  		//Se debe almacenar en mayus. ok
		
		
		boolean esValido = false;								//5 caracteres numericos. Se lanza Exception. ok
		if (codigo.length() == Longitud) {
			for (int i = 0;i<codigo.length();i++) {
				if (Character.isDigit(codigo.charAt(i))) {
					esValido = true;
				}
				else {
					esValido = false;
				}
				if (esValido == true) {
					this.codigo = codigo;
				}
				else {
				throw new PuebloException("[ERROR] El codigo no es valido");
				}
			}
		}
		else {
			throw new PuebloException("[ERROR] El codigo no es valido");
		}
		
		if (numeroHabitantes>=0) {
			this.numeroHabitantes = numeroHabitantes;	//Lanzar Exception si es negativo.	ok		
		}
		else {
			throw new PuebloException("[ERROR] El numero es negativo");
		}
		
		
		
		if (rentaPerCapita>=0) {						//Valor negativo ==> Exception ok
			this.rentaPerCapita= rentaPerCapita;			
		}
		else {
			throw new PuebloException("[ERROR] El numero es negativo");
		}
		
		
		if (superficie >= 0) {
			this.superficie = superficie;				//Valor negativo ==> Exception	ok	
		}
		else {
			throw new PuebloException("[ERROR] El numero es negativo");
		}
		
	
	}
	//otro constructor//
	public Pueblo(String nombre, String codigo, int numeroHabitantes, double rentaPerCapita, double superficie)
			throws PuebloException {
		super();
		this.nombre = nombre.toUpperCase();
		try {
			this.setCodigo(codigo);
		} catch (Exception e) {
			throw new PuebloException("error");
		}
		this.setNumeroHabitantes(numeroHabitantes);
		this.setRentaPerCapita(rentaPerCapita);
		this.setSuperficie(superficie);
	}
	
	
	
	public Pueblo(String nombre, String codigo) throws PuebloException{
		if(nombre==null||codigo==null) {
			throw new PuebloException("Error, no puede estar nulo");
		}
		this.nombre = nombre.toUpperCase();  		//Se debe almacenar en mayus. ok
		
		
		boolean esValido = false;								//5 caracteres numericos. Se lanza Exception. ok
		if (codigo.length() == Longitud) {
			for (int i = 0;i<codigo.length();i++) {
				if (Character.isDigit(codigo.charAt(i))) {
					esValido = true;
				}
				else {
					esValido = false;
				}
				if (esValido == true) {
					this.codigo = codigo;
				}
				else {
				throw new PuebloException("[ERROR] El codigo no es valido");
				}
			}
		}
		else {
			throw new PuebloException("[ERROR] El codigo no es valido");
		}
	}


	//Methods
	
	
	
		
	
	//Methods
	

	//Getters-Setters de Pueblo
	public Integer getNumeroHabitantes() {
		return numeroHabitantes;
	}


	public void setNumeroHabitantes(Integer numeroHabitantes) {
		//Se lanza Exception aqui si el valor es negativo. ok
		
		if (numeroHabitantes>=0) {
			this.numeroHabitantes = numeroHabitantes;		
		}
		else {
			throw new PuebloException("[ERROR] El numero es negativo");
		}
	}


	public Double getRentaPerCapita() {
		return rentaPerCapita;
	}




	public void setRentaPerCapita(Double rentaPerCapita) {
		//Exception aqui si el numero es negativo. ok
		
		if (rentaPerCapita>=0) {						
			this.rentaPerCapita= rentaPerCapita;			
		}
		else {
			throw new PuebloException("[ERROR] El numero es negativo");
		}
	}


	public Double getSuperficie() {
		return superficie;
	}


	public void setSuperficie(Double superficie) {
		
		//Aqui se debe poner una Exception.
		
		if (superficie>=0) {
			this.superficie = superficie;
		}
		else {
			throw new PuebloException("[ERROR] Valor no aceptado.");
		}
	}


	public String getNombre() {
		return nombre;
	}


	public String getCodigo() {
		return codigo;
	}
	
	
	
	//hashCode() de Pueblo
	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombre, numeroHabitantes, rentaPerCapita, superficie);
	}


	//equals() de Pueblo
	@Override
	public boolean equals(Object obj) {
		boolean sonIguales= false;
		Pueblo other = (Pueblo) obj;
		
		if(obj != null) {
			if (this.codigo.equals(other.getCodigo()))
				sonIguales = true;
			
			}
		return sonIguales;	
		}
	
	@Override
	public int compareTo(Pueblo pueblo) {
		
		int resultado= 0;
		if (pueblo == null) {
			resultado=-1;
				
			}else {
				resultado = this.nombre.compareTo(pueblo.nombre);
			}if (resultado == 0) {
				resultado = this.nombre.compareTo(pueblo.nombre);
			}
			return resultado;
		}
	
	
	
	//toString() de Pueblo
	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", numeroHabitantes=" + numeroHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}
	@Override
	public int getTananno() {
		// TODO Auto-generated method stub
		return Longitud;
	}


	
}
