import javax.swing.JOptionPane;

public class Test {
	
	public static void main(String[] args) {
		
		HTable tabla = new HTable();
		String in1 = JOptionPane.showInputDialog("Bienvenido Profesor, califiquemos algunos alumnos ¿Cuántos alumnos tiene su clase?");
		int alumnos = Integer.parseInt(in1);
		
		for(int i = 1; i <= alumnos; i++){
			
			String inn1 = JOptionPane.showInputDialog("Ingresa el NOMBRE alumno "+i+" de tu lista.");
			String inn2 = JOptionPane.showInputDialog("Ingresa la CALIFICACIÓN del alumno "+i+" de tu lista.");
			int cal = Integer.parseInt(inn2);
			tabla.Write(inn1,cal);
			
		}
		
		JOptionPane.showMessageDialog(null, "Las calificaciones de tus alumnos son:");
		JOptionPane.showMessageDialog(null, tabla.listaF());
	}

}
