package com.jacaranda.utilities;

public abstract class Poblacion {

	public String nombre;
	public String codigo;
	public Integer numeroHabitantes;
	public Double rentaPerCapita;
	public Double superficie;
	
	

	public String getProvincia() {
		
		return this.nombre;
	}
	
	
	//Getters-Setters de Provincia
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) throws Exception {
		if (codigo==null) {
			throw new Exception("El nombre no puede ser nulo");
		}
		boolean esValido = false;//2 caracteres numericos. Se lanza Exception. ok
		if (codigo.length() == getTananno()) {
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
				throw new Exception("[ERROR] El codigo no es valido");
				}
		}
		}else {
			throw new Exception("[ERROR] El codigo no es valido");
		}
	}

	public abstract int getTananno();

	public Integer getNumeroHabitantes() {
		return numeroHabitantes;
	}


	public void setNumeroHabitantes(String pueblo, Integer numeroHabitantes) throws Exception{
		if(numeroHabitantes==null || numeroHabitantes<0) {
			throw new Exception("Los habitantes deben ser positivos, error ");
		}
		this.numeroHabitantes = numeroHabitantes;
	}


	public Double getRentaPerCapita() {
		return rentaPerCapita;
	}


	public void setRentaPerCapita(Double rentaPerCapita) throws Exception{
		if(rentaPerCapita==null || rentaPerCapita<0) {
			throw new Exception("La renta per capita debe de ser positiva, error ");
		}
		this.rentaPerCapita = rentaPerCapita;
	}


	public Double getSuperficie() {
		return superficie;
	}

	
}
