package Ejer1;

import java.util.ArrayList;
import java.util.List;

public class SolucionEjercicio1 {
Punto Punto1;
Punto Punto2;
int CantidaddeInstrucciones;
	
	public SolucionEjercicio1(Punto punto1, Punto punto2,
			int cantidaddeInstrucciones) {
		Punto1 = punto1;
		Punto2 = punto2;
		CantidaddeInstrucciones = cantidaddeInstrucciones;
	}	
	
	@SuppressWarnings("rawtypes")
	public List generarlista(){
		
		List<Punto> puntos = new ArrayList<Punto>();
		puntos.add(new Punto(-2, -2));
		puntos.add(new Punto(3, 4));
		puntos.add(new Punto(8, 5));
		puntos.add(new Punto(3, -3));
		puntos.add(new Punto(10, 15));
		puntos.add(new Punto(2, 2));
		//return puntos;
		PuntoSolucion aux = null;
		
		ArrayList<PuntoSolucion> sol = new ArrayList<PuntoSolucion>();
		
		// Hacer apareamientos de puntos
		for(int i = 0; i < puntos.size(); i++)
			for(int j = i + 1; j < puntos.size(); j++){
				aux = new PuntoSolucion(puntos.get(i), puntos.get(j));
				sol.add(aux);
			}
			
		return sol;
	}
}
