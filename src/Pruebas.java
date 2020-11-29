import java.util.Arrays;
import java.util.Scanner;

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
	
	public void ordenacionBurbuja1(int numeros[]) {
		long tTnicio;
		long tFin;
		int comparaciones = 0,intercambios = 0,recorridos=0;
		tTnicio=System.nanoTime();
		for(int i=1;i<=numeros.length-1;i++) {
			for(int j=0;j<numeros.length-i;j++) {
				recorridos++;
				if(numeros[j]>numeros[j+1]) {
					comparaciones++;
					int aux=numeros[j];
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
	
	public  void ordenacionBurbuja2(int []numeros) {
		long tTnicio;
		long tFin;
		int comparaciones = 0,intercambios = 0,recorridos=0;
		tTnicio = System.nanoTime();
        for(int i=1; i<numeros.length; i++) {
			
			for(int j=0; j<numeros.length-i; j++) {
				
				if(numeros[j]>numeros[j+1]) {
					int aux = numeros[j];
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
	
	public  void ordenacionBurbuja3(int []numeros) {
		long tTnicio;
		long tFin;
		 int comparaciones = 0,intercambios = 0,recorridos=0;
		 tTnicio = System.nanoTime();
          int i=1;
    	   do {
    		   
    		   for(int j=0; j<numeros.length-i; j++) {
					if(numeros[j]>numeros[j+1]) {
						recorridos++;
						int aux = numeros[j];
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
	
	public int [] ordenamientoQuicksort(int[] numeros,int izq,int der) {
        int pivote = numeros[izq];
        int i = izq, j = der;
        int aux;
        while(i<j) {
        	contador[0]++;
            while(numeros[i]<=pivote && i<j) {
            	i++;
            	contador[0]++;
            }
            while(numeros[j]>pivote) {
            	j--;
            	contador[0]++;
            }
            if(i<j) {
            	contador[1]++;
                aux = numeros[i];
                numeros[i]=numeros[j];
                numeros[j] = aux;
            }
        }
        contador[1]++;
        numeros[izq]=numeros[j];
        numeros[j]=pivote;
        contador[2]++;
        if(izq<j-1)
            ordenamientoQuicksort(numeros,izq,j-1);
        contador[2]++;
        if(j+1<der)
        	ordenamientoQuicksort(numeros, j+1, der);
        return numeros;
}

	public void ordenamientoRadix(int[]numeros) {
		contador[2]++;
	      if(numeros.length == 0)
	          return;
	          int[][] np = new int[numeros.length][2];
	          int[] q = new int[0x100];
	          int i,j,k,l,f = 0;
	          for(k=0;k<4;k++) {
	             for(i=0;i<(np.length-1);i++)
	             np[i][1] = i+1;
	             np[i][1] = -1;
	             for(i=0;i<q.length;i++)
	             q[i] = -1;
	             for(f=i=0;i<numeros.length;i++) {
	                j = ((0xFF<<(k<<3))&numeros[i])>>(k<<3);
	                contador[2]++;
	                if(q[j] == -1)
	                l = q[j] = f;
	             else {
	                l = q[j];
	                while(np[l][1] != -1)
	                l = np[l][1];
	                np[l][1] = f;
	                l = np[l][1];
	                contador[0]++;
	             }
	             f = np[f][1];
	             np[l][0] = numeros[i];
	             np[l][1] = -1;
	             contador[0]++;
	          }
	          for(l=q[i=j=0];i<0x100;i++)
	          for(l=q[i];l!=-1;l=np[l][1])
	        	  numeros[j++] = np[l][0];
	          contador[0]++;
	       }//for
	}//metodo

}
class pruebasEstres{
	public void pruebaEstres(String op) {
		int vector1000elementos[]=new int[1000];
		int vector10000elementos[]=new int[10000];
		int vector100000elementos[]=new int[100000];
		int vector1000000elementos[]=new int[1000000];
		//System.out.println("Acabo el 1");
		for(int i=0;i<vector1000elementos.length;i++) {
			vector1000elementos[i]=(int) (Math.random() * 1000 + 1);
		}
		//System.out.println("Acabo el 2");
		for(int i=0;i<vector10000elementos.length;i++) {
			vector10000elementos[i]=(int) (Math.random() * 1000 + 1);
		}
		//System.out.println("Acabo el 3");
		for(int i=0;i<vector100000elementos.length;i++) {
			vector100000elementos[i]=(int) (Math.random() * 1000 + 1);
		}
		//System.out.println("Acabo el 4");
		for(int i=0;i<vector1000000elementos.length;i++) {
			vector1000000elementos[i]=(int) (Math.random() * 1000 + 1);
		}
		int numerosDesordenados[]= {55,15,78,99,16,1,112,23,1789};
		int copi[];
		if(op.equalsIgnoreCase("1")) {
			pruebaEstres(numerosDesordenados);
		}else if (op.equalsIgnoreCase("2")) {
			pruebaEstres(vector1000elementos);
		}
		else if (op.equalsIgnoreCase("3")) {
			pruebaEstres(vector10000elementos);
		}
		else if (op.equalsIgnoreCase("4")) {
			pruebaEstres(vector10000elementos);
		}
		else if (op.equalsIgnoreCase("5")) {
			pruebaEstres(vector1000000elementos);
		}
	}
	public void pruebaEstres(int vector[]) {
		MetodosOrdenamientos orden=new MetodosOrdenamientos();
		long tTnicio,tFin;
		int copi[];
		copi=null;
		copi=Arrays.copyOf(vector, vector.length-1);
		System.out.println("----------------------------Burbuja 1-----------------------------------");
		tTnicio=System.nanoTime();
		orden.ordenacionBurbuja1(copi);
		tFin=System.nanoTime();
		System.out.println("Tardo: "+(tFin-tTnicio));
		orden.mostrarContador();
		System.out.println("----------------------------Burbuja 2-----------------------------------");
		tTnicio=tFin=0;
		copi=null;
		copi=Arrays.copyOf(vector, vector.length-1);
		tTnicio=System.nanoTime();
		orden.ordenacionBurbuja2(copi);
		tFin=System.nanoTime();
		System.out.println("Tardo: "+(tFin-tTnicio));
		orden.mostrarContador();
		System.out.println("----------------------------Burbuja 3-----------------------------------");
		tTnicio=tFin=0;
		copi=null;
		copi=Arrays.copyOf(vector, vector.length-1);
		tTnicio=System.nanoTime();
		orden.ordenacionBurbuja3(copi);
		tFin=System.nanoTime();
		System.out.println("Tardo: "+(tFin-tTnicio));
		orden.mostrarContador();
		System.out.println("---------------------------- inserccion -----------------------------------");
		tTnicio=tFin=0;
		copi=null;
		copi=Arrays.copyOf(vector, vector.length-1);
		tTnicio=System.nanoTime();
		orden.ordenarInserccion(copi);
		tFin=System.nanoTime();
		System.out.println("Tardo: "+(tFin-tTnicio));
		orden.mostrarContador();
		System.out.println("---------------------------- Seleccion -----------------------------------");
		tTnicio=tFin=0;
		copi=null;
		copi=Arrays.copyOf(vector, vector.length-1);
		tTnicio=System.nanoTime();
		orden.ordenarInserccion(copi);
		tFin=System.nanoTime();
		System.out.println("Tardo: "+(tFin-tTnicio));
		orden.mostrarContador();
	}
}
public class Pruebas {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		String op="";
		boolean bandera=false;
		pruebasEstres pruebas=new pruebasEstres();
		while(bandera==false) {
		long tTnicio,tFin;
		System.out.println("Con que quieres probar?");
		System.out.println("1-> Ordenar elementos precargados");
		System.out.println("2-> Ordenar 1000 elementos");
		System.out.println("3-> Ordenar 10000");
		System.out.println("4-> Ordenar 100000");
		System.out.println("5-> Ordenar 1000000");
		System.out.println("6-> Salir");
		op=entrada.nextLine();
		switch (op) {
		case "1":
			pruebas.pruebaEstres(op);
			break;
		case "2":
			pruebas.pruebaEstres(op);
			break;
		case "3":
			pruebas.pruebaEstres(op);
			break;
		case "4":
			pruebas.pruebaEstres(op);
			break;
		case "5":
			pruebas.pruebaEstres(op);
			break;
		case "6":
			System.out.println("Saliendo");
			bandera=true;
			break;
		default:
			break;
		}
		}
		

	}

}
