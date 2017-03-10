import javax.swing.JOptionPane;

public class MergeSort {
	
	public static int[] genArray(){				//Genera un arreglo a partir de los inputs del usuario
		String in1 = JOptionPane.showInputDialog("¿Cuantos elementos tiene el arreglo que quieres ordenar?");//se pide el largo del arreglo al usuario
		int len = Integer.parseInt(in1);		//el resultado obtenido del usuario en la variable in1 se almacena como un int en la variable len
		int tarray[] = new int[len];			//se crea el arreglo tarray vacío aún y se le de el largo que el usuario solicitó
		String darray = "";						//se crea un string que almacenará el arreglo despues del simbolo [, esta variable es la información del arreglo desordenado que se le mostrara al usuario
		
		for(int l=0;l<tarray.length;l++){		//for loop para obtener los elementos del arreglo
			String inn = JOptionPane.showInputDialog("Escribe el número de la posición "+l+".");
			int element = Integer.parseInt(inn);
			darray+=inn+"  ";
			tarray[l] = element;
			
			}
		JOptionPane.showMessageDialog(null,"Tu arreglo desordenado es: "+darray,"Merge Sort Algorithm",JOptionPane.PLAIN_MESSAGE);	//Se imprime el string con los valores del arreglo desordenado
		return tarray;							//se regresa el arreglo para ordenarlo
	}
	
/*------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	public static int[] mSort(int[] a){			//Divide el arreglo en 2 hasta que los arreglos tengan lenght de 1
		
		if (a.length <= 1){						//Si el arreglo es length 1 lo regresa
			return a;
		}
		
		int mid = a.length / 2;					//mid será el largo de los arreglos divididos para lenght par
		int[] left = new int[mid];				//se crea el arreglo izquierdo
		int[] right;							//se crea el arreglo derecho, pero...
		if(a.length % 2 == 0){					
			right = new int[mid];				//si el length del arreglo a es par, su length será mid
		}
		else{
			right = new int[mid + 1];			//si es impar su length será mid + 1
		}
		
		int[] result = new int[a.length];		//se crea un arreglo para guardar el resultado
		
		for(int i = 0; i < mid; i++){			//se guardan los resultados de la primera mitad del arreglo a en el arreglo izquierdo
			left[i] = a[i];
		}
		
		int iR = 0;								
		for(int j = mid; j < a.length; j++){	//se guardan los resultados de la segunda mitad del arreglo a en el arreglo derecho
			right[iR] = a[j];
			iR++;
		}
		
		left = mSort(left);						//De manera recursiva se llama a este mismo metodo para dividir el arreglo a la mitad hasta que los arreglos tengan length de 1
		right = mSort(right);					//"
		
		result = merge(left, right);			//se llama a la función merge para crear el arreglo final juntando los valores ordenados de izq. y der.
		return  result;							//se regresa el arreglo ordenado
		
	}
	
/*------------------------------------------------------------------------------------------------------------------------------------------------------*/
	

	public static int[] merge(int[] left, int[] right){				//Regresa un arreglo ordenado a partir de los arreglos separados izquierdo y derecho
		int[] ordered = new int[left.length + right.length];		//Se crea el arreglo con las longitudes del izquierdo y el derecho sumadas
		int iL = 0;												
		int iR = 0;												//Se inicializan en 0 los indices para cada uno de los 3 arreglos
		int iO = 0;
		
		while (iL < left.length || iR < right.length){		//Mientras aun haya ALGUN elemento en CUALQUIERA de los arreglos izq. y der. se hace:
			if(iL < left.length && iR < right.length){							//mientras haya UN elemento en CADA UNO de los arreglos izq. y der.
				if(left[iL] <= right[iR]){
					ordered[iO] = left[iL];
					iO++;
					iL++;
				}
				else{
					ordered[iO] = right[iR];
					iO++;
					iR++;
				}
			}
			else if(iL < left.length){
				ordered[iO] = left[iL];
				iO++;
				iL++;
			}
			else if(iR < right.length){
				ordered[iO] = right[iR];
				iO++;
				iR++;
			}
		}
	return ordered;
	}
	
	public static void main(String[] args){
		int[] intArray = mSort(genArray());
		String strArray = "";
		String data;
		
		for(int c = 0; c < intArray.length; c++){
			data = Integer.toString(intArray[c]) + "  ";
			strArray += data;
		}
		
	JOptionPane.showMessageDialog(null, "Tu arreglo ordenado es: "+strArray);
		
	}
	
	
}
