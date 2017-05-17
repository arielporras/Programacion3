package Ejer1;

import java.util.ArrayList;
import java.util.List;

class PuntoSolucion{
	Punto puntoA, puntoB;
	double distancia;
	int instrucciones;
	
	PuntoSolucion(Punto a, Punto b){
		puntoA = a;
		puntoB = b;
		instrucciones = 0;
		calcularDistancia();
	}
	
	void calcularDistancia(){
		
		distancia = Math.sqrt((puntoA.x - puntoB.x) * (puntoA.x - puntoB.x) 
						+ (puntoA.y - puntoB.y) * (puntoA.y - puntoB.y));
	}
	
	public static void quicksort(List<PuntoSolucion> lista, int izq, int der) {

	  PuntoSolucion pivote=lista.get(izq); // tomamos primer elemento como pivote
	  int i=izq; // i realiza la búsqueda de izquierda a derecha
	  int j=der; // j realiza la búsqueda de derecha a izquierda
	  PuntoSolucion aux;
	 
	  while(i<j){            // mientras no se crucen las búsquedas
		 while(lista.get(i).distancia<=pivote.distancia && i<j) 
			 i++; // busca elemento mayor que pivote
		 while(lista.get(j).distancia>pivote.distancia) 
			 j--;         // busca elemento menor que pivote
		 if (i<j) {                      // si no se han cruzado                      
			 aux= lista.get(i);                  // los intercambia
			 lista.set(i, lista.get(j));
			// Contar instrucciones
			 ++aux.instrucciones;
			 lista.set(j, aux);
		 }
	   }
	   lista.set(izq, lista.get(j)); // se coloca el pivote en su lugar de forma que tendremos
	   lista.set(j, pivote); // los menores a su izquierda y los mayores a su derecha
	   if(izq < j - 1)
		  quicksort(lista,izq,j-1); // ordenamos subarray izquierdo
	   if(j+1 <der)
		  quicksort(lista,j+1,der); // ordenamos subarray derecho
	}
	
	public static PuntoSolucion minimaDistanciaEntrePuntos(ArrayList<PuntoSolucion> lista) {
	
		//ArrayList<PuntoSolucion> lista = new ArrayList<PuntoSolucion>();
		// Ordeno de menor a mayor por distancia
		quicksort(lista, 0, lista.size() -1);
		
		//Devuelvo la menor distancia (elemento i=1)
		return lista.get(1);
	}
}

public class Main {

	public static ArrayList<PuntoSolucion> testGenerarLista(){
		
		List<Punto> puntos = new ArrayList<Punto>();
		puntos.add(new Punto(-2, -2));
		puntos.add(new Punto(3, 4));
		puntos.add(new Punto(8, 5));
		puntos.add(new Punto(3, -3));
		puntos.add(new Punto(10, 15));
		puntos.add(new Punto(2, 2));

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

	public static void main(String[] args) {

			Punto Punto2 = null;
			Punto Punto1 = null;
			int cantidad = 0;
			double distanciaminima = 9999;
		SolucionEjercicio1 Solucion = new SolucionEjercicio1(Punto1, Punto2, cantidad); 
		
		// Generar lista debería aparear todos los puntos de una colección
		ArrayList<PuntoSolucion> puntos = testGenerarLista();
		
		/*for (int i = 0; i < Puntos.size(); i++) {
			  for (int j = i + 1; j < Puntos.size(); j++) {
			    double distancia = distancia(Puntos.get(i).x, Puntos.get(i).y,
			      Puntos.get(j).x, Puntos.get(j).y); 
			    	cantidad++;
			    if (distancia < distanciaminima) {
			      
			      Punto1 = Puntos.get(i);
			      Punto2 = Puntos.get(j);
			      distanciaminima = distancia;
			    }
			  }
		}*/
		PuntoSolucion minima = PuntoSolucion.minimaDistanciaEntrePuntos(puntos);
		
		System.out.printf("La distancia minima es %.3f\n", minima.distancia);
		System.out.println("Los puntos son: " + minima.puntoA + " y " + minima.puntoB);
		System.out.println("La cantidad de pasos " + minima.instrucciones);
}

	@SuppressWarnings("unused")
	private static double distancia(int x, int y, int x2, int y2) {
		return Math.sqrt((x2 - x) * (x2 - x) + (y2 - y) * (y2 - y));
	}}
