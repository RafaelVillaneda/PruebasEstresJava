class MetodosOrdenamientos{
	int [] contador=new int[3];
	public void mostrarContador() {
		System.out.println("Numero de recorridos-> "+contador[0]);
		System.out.println("Numero de Intercambios-> "+contador[1]);
		System.out.println("Numero de Comparaciones-> "+contador[2]);
		contador[0]=0;
		contador[1]=0;
		contador[2]=0;
	}
	
	public void ordenacionBurbuja1(long numeros[]) {
		long tTnicio;
		long tFin;
		int comparaciones = 0,intercambios = 0,recorridos=0;
		tTnicio=System.nanoTime();
		for(int i=1;i<=numeros.length-1;i++) {
			for(int j=0;j<numeros.length-i;j++) {
				recorridos++;
				if(numeros[j]>numeros[j+1]) {
					comparaciones++;
					long aux=numeros[j];
					numeros[j]=numeros[j+1];
					numeros[j+1]=aux;
					intercambios++;
				}//IF
			}//FOR J
		}//FOR I
		tFin=System.nanoTime();
		System.out.println("El tiempo de ejecucion en ordenamiento burbuja1 fue de "+(tFin-tTnicio));
		System.out.println("Recorridos"+recorridos);
		System.out.println("Intercambios: "+intercambios);
		System.out.println("Comparaciones: "+comparaciones);
	}
	
	public  void ordenacionBurbuja2(long []numeros) {
		long tTnicio;
		long tFin;
		int comparaciones = 0,intercambios = 0,recorridos=0;
		tTnicio = System.nanoTime();
        for(int i=1; i<numeros.length; i++) {
			
			for(int j=0; j<numeros.length-i; j++) {
				
				if(numeros[j]>numeros[j+1]) {
					long aux = numeros[j];
					numeros[j] = numeros[j+1];
					numeros[j+1] = aux;
				}
			}
		}
        tFin = System.nanoTime();
		System.out.println("El tiempo de ejecucion en ordenamiento burbuja2 fue de "+(tFin-tTnicio));
		System.out.println("Recorridos"+recorridos);
		System.out.println("Intercambios: "+intercambios);
		System.out.println("Comparaciones: "+comparaciones);
	}
	
	public  void ordenacionBurbuja3(long []numeros) {
		long tTnicio;
		long tFin;
		 int comparaciones = 0,intercambios = 0,recorridos=0;
		 tTnicio = System.nanoTime();
          int i=1;
    	   do {
    		   
    		   for(int j=0; j<numeros.length-i; j++) {
					if(numeros[j]>numeros[j+1]) {
						recorridos++;
						long aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
    		   
    		   i=1+i;
    	   }while(i<numeros.length);
    	    tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento por burbuja3: " + (tFin-tTnicio));
			System.out.println("Recorridos"+recorridos);
			System.out.println("Intercambios: "+intercambios);
			System.out.println("Comparaciones: "+comparaciones);
       }
	
	public void ordenarInserccion(int [] numeros) {
		long tTnicio,tFin = 0;
		int aux;
		int comparaciones = 0,intercambios = 0,recorridos=0;
		for(int i=0;i<numeros.length;i++) {
			recorridos++;
			aux=numeros[i];
			for(int j=i-1;j>=0 &&numeros[j]>aux;j--) {
				comparaciones++;
				recorridos++;
				intercambios++;
				numeros[j+1]=numeros[j];
				numeros[j]=aux;
			}//Segundo for
		}//Primer for
		System.out.println("El tiempo de ejecucion en ordenamiento burbuja1 fue de "+(tFin-tFin));
		System.out.println("Recorridos"+recorridos);
		System.out.println("Intercambios: "+intercambios);
		System.out.println("Comparaciones: "+comparaciones);
	}//Metodo de ordenamiento INseccion
	
	public void ordenamientoSeleccion(int [] numeros) {
		long comparaciones = 0,intercambios = 0,recorridos=0;
		for (int i=0;i<numeros.length-1;i++) {
			
			for(int j=0;j<numeros.length;j++) {
				comparaciones++;
				if(numeros[i]>numeros[j]) {
					int minimo=numeros[i];
					numeros[i]=numeros[j];
					numeros[j]=minimo;
					intercambios++;
				}
				recorridos++;
			}
			recorridos++;
		}
		System.out.println("Recorridos"+recorridos);
		System.out.println("Intercambios: "+intercambios);
		System.out.println("Comparaciones: "+comparaciones);
	}
	
}
public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
