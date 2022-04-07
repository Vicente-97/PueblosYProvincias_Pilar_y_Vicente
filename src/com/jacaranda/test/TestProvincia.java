package com.jacaranda.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jacaranda.utilities.Provincia;
import com.jacaranda.utilities.ProvinciaException;
import com.jacaranda.utilities.Pueblo;
import com.jacaranda.utilities.PuebloException;

class TestProvincia {

	@Test
	void testCrearProvinciaDatos() {
		Provincia pr= new Provincia("Valencia", "12");
		assertEquals(pr.getClass().getSimpleName(), "Provincia");
	}

	@Test
	void testCrearProvinciaNombresNull() {
		try {
			Provincia pr= new Provincia(null, "15");
			assert(false);
		}catch (ProvinciaException pe) {
			assert(true);
		}
	}
	@Test
	void testCrearProvinciaCodigoNull() {
		try {
			Provincia pr= new Provincia("Valencia", null);
			assert(false);
		}catch (ProvinciaException pe) {
			assert(true);
		}
	}
	@Test
	void testCrearProvinciaUnCaracter() {
		try {
			Provincia pr= new Provincia("Valencia", "5");
			assert(false);
		}catch (ProvinciaException pe) {
			assert(true);
		}
	}
	@Test
	void testCrearProvinciaTresCaracter() {
		try {
			Provincia pr= new Provincia("Valencia", "585");
			assert(false);
		}catch (ProvinciaException pe) {
			assert(true);
		}
	}
	@Test
	void testAñadirPueblo() {
		Provincia pr= new Provincia("Valencia", "58");
		pr.addPueblo​("Barbate", "55555", 20, 20.0, 20.0);
		assertEquals(pr.numPueblos(), 1);
	}
	@Test
	void testAñadirPuebloRepetido() {
		
		Provincia pr= new Provincia("Valencia", "58");
		try {
		pr.addPueblo​("Barbate", "55555", 20, 20.0, 20.0);
		pr.addPueblo​("Barbate", "55555", 20, 20.0, 20.0);
			assert(false);
		}catch (ProvinciaException pe) {
			assert(true);
		}
		
	}
	@Test
	void testProvinciaRentaPerCapitaNegativa() {
		Provincia pr= new Provincia("Valencia", "58");
		try {
		pr.setRentaPerCapita(-522.00);
		assert(false);
		}catch  (ProvinciaException pe) {
			assert(true);
		}	
	}
	@Test
	void testProvinciaSuperficieNegativa() {
		Provincia pr= new Provincia("Valencia", "58");
		pr.addPueblo​("Barbate", "55555", 20, 20.0, 20.0);
		try {
		pr.setSuperficie("Barbate", -15.00);
		assert(false);
		}catch  (ProvinciaException pe) {
			assert(true);
		}	
	}
	@Test
	void testProvinciaNumeroHabitantesNegativo() {
		Provincia pr= new Provincia("Valencia", "58");
		pr.addPueblo​("Barbate", "55555", 20, 20.0, 20.0);
		
		try {
		pr.setNumeroHabitantes("Barbate", -555);
		assert(false);
		}catch  (ProvinciaException pe) {
			assert(true);
		}	
	}
	@Test
	void testCrearUnPuebloCodigNulo() {
		try {
			Pueblo pu = new Pueblo("Barbate", null);
			assert(false);
		}catch (PuebloException pe) {
			assert(true);
		}
	}
	@Test
	void testCrearUnPuebloNombreNulo() {
		try {
			Pueblo pu = new Pueblo(null, "55555");
			assert(false);
		}catch (PuebloException pe) {
			assert(true);
		}
	}
	@Test
	void testObtenerSuperficiePueblo() {
		Pueblo pu = new Pueblo("Barbate", "55555", 20, 50.0, 60.0);
		assertEquals(pu.getSuperficie(), 60.0);
		
	}
}
