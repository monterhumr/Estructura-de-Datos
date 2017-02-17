package linkedlist;
import javax.swing.JOptionPane;

public class LinkedListTest {

	public static void main(String[] args) {
		SLinkedList<Integer> list_test=new SLinkedList<Integer>();		//genera una lista vacia
		JOptionPane.showMessageDialog(null,"Los elementos de tu lista son: "+list(list_test));
		//Muestra al usuario su lista
	}

	public static String list(SLinkedList<Integer> list_test){		//recibe una lista vacia, le agrega los elementos que el usario quiera y la convierte en string para regresarla
		String in1 = JOptionPane.showInputDialog("¿Cuantos elementos guardará tu lista?") ;
		int len = Integer.parseInt(in1);		//recibe el largo de la lista
		len = len-1;
		
		for (int i=0; i<=len; i++){		//Recibe cada elemento de la lista y lo intoduce a la misma
			String inn = JOptionPane.showInputDialog("¿Ingresa el elemento "+i+" de tu lista");
			int datan = Integer.parseInt(inn);
			list_test.add(i,datan);
		}
		String list = list_test.toString();		//Convertir a String
		return list;		//Regresar la lista
	}
}
