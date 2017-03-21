package universalhashing;

import javax.swing.JOptionPane;

public class Test {
	
	public static void main(String[] args) {
		
		HTable tabla = new HTable();
		String in1 = JOptionPane.showInputDialog("¿Cuántos datos guardarás en la tabla?");
		int alumnos = Integer.parseInt(in1);
		
		for(int i = 1; i <= alumnos; i++){
			
			String inn1 = JOptionPane.showInputDialog("Ingresa la key "+i+" de tu lista.");
			String inn2 = JOptionPane.showInputDialog("Ingresa el dato "+i+" de tu lista.");
			int llave = Integer.parseInt(inn1);
			int dato = Integer.parseInt(inn2);
			tabla.write(llave,dato);
			
		}
		
		JOptionPane.showMessageDialog(null, "Las calificaciones de tus alumnos son:");
		JOptionPane.showMessageDialog(null, tabla.print());
	}

}
