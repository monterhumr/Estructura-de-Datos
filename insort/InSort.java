import javax.swing.JOptionPane;				// se importa JOptionPane para inputs y outputs más estéticos

public class InSort {

	public static void main(String[] args) {
		sort(genArray());					//Se usa el método sort con el arreglo que regresó genArray
	}
	
	public static int[] genArray(){		//Genera un arreglo a partir de los inputs del usuario
		String in1 = JOptionPane.showInputDialog("¿Cuantos elementos tiene el arreglo que quieres ordenar?");
		//se pide el largo del arreglo al usuario
		int len = Integer.parseInt(in1);		
		//el resultado obtenido del usuario en la variable in1 se almacena como un int en la variable len
		int tarray[] = new int[len];		//se crea el arreglo tarray vacío aún y se le de el largo que el usuario solicitó
		String darray="[";		//se crea un string que almacenará el arreglo despues del simbolo [, esta variable es la información del arreglo desordenado que se le mostrara al usuario
		
		for(int l=0;l<tarray.length;l++){		//for loop para obtener los elementos del arreglo
			String inn = JOptionPane.showInputDialog("Escribe el número de la posición "+l+".");		//recibe input para cada elemento
			int data = Integer.parseInt(inn);		//el elemento se guarda como int en data
			tarray[l] = data;		//el elemento obtenido se guarda en la posición del índice indicado por la variable l
			darray+=tarray[l];		//se agrega el mismo elemento como un string en la variable darray
			if (l+1<tarray.length){		//condicional para agregar una coma por motivos estéticos
				darray+=", ";		//se agrega la coma
			}
		}
		darray+="]";		//se agrega el corchete de cierre por motivos estéticos
		JOptionPane.showMessageDialog(null,"Tu arreglo desordenado es: "+darray,"Insertion Sort Algorithm",JOptionPane.PLAIN_MESSAGE);		//output del arreglo desordenado
		return tarray;		//se regresa el arreglo para ordenarlo
		
	}
	
	public static void sort(int[] a){		//ordena el arreglo
		
		for(int j=1; j<a.length; j++){		//for loop para tomar comenzar a ordenar
		int key = a[j];						//se toma la carta llave en la posición 1
		int i = j-1;						//la llave se compara con la carta en la posición 0
		
			while(i>=0 && a[i]>key){		//loop para ver si es necesario mover la carta a la posición siguiente
				a[i+1] = a[i];
				i--;
			}
			
		a[i+1] = key;
		}
		
		String oarray = "[";				//lo mismo que darray, almacena el arreglo ORDENADO en un string para mostrarlo al usuario
		
		for(int n=0;n<a.length;n++){		//reccorre el arreglo para almacenarlo en oarray
			oarray+=a[n];
			if (n+1<a.length){
				oarray+=", ";
			}
		}

		oarray+="]";
		JOptionPane.showMessageDialog(null,"Tu arreglo ordenado es: "+oarray,"Insertion Sort Algorithm",JOptionPane.PLAIN_MESSAGE);			//se imprime la respuesta
	}

}
