package vista;

import controlador.CapturaD;
import java.util.ArrayList;

import javax.swing.*;
import modelo.Usuario;

public class VistaU {

    ArrayList<Usuario> lista = new ArrayList<>();
    JOptionPane cap = new JOptionPane();

    CapturaD cd = new CapturaD();
    ArrayList<Usuario> datos = new ArrayList<>();
    Usuario us = new Usuario();
    int dato, c;
    String nombre, apellidos, fechan, correoI, correoP, programaA, corri;
    Long ntCelular, ntFijo;

    public VistaU() {

    }

    public void menuprincipal() {

        do {
            String menu = JOptionPane.showInputDialog(null, "INSTITUTO LA FLORESTA\n"
                    + "Seleccione tarea a realizar:\n"
                    + "1. Ingresar estudiante\n"
                    + "2. Buscar estudiante\n"
                    + "3. Modificar estudiante\n"
                    + "4. Eliminar Estudiante\n"
                    + "5. Ver directorio de estudiantes\n"
                    + "6. Salir\n"
                    + "Opción:\n");

            try {
                dato = Integer.parseInt(menu);
            } catch (Exception e) {
                dato = 0;
            }
            switch (dato) {
                case 1:

                    JOptionPane.showMessageDialog(cap, "Ingresar estudiante");

                    nombre = JOptionPane.showInputDialog(null, "Ingresar nombres:");

                    apellidos = JOptionPane.showInputDialog(null, "Ingresar apellidos:");

                    fechan = JOptionPane.showInputDialog(null, "Ingresar fecha de nacimiento (YYYY-MM-DD):");

                    correoI = JOptionPane.showInputDialog(null, "Ingresar correo institucional:");

                    correoP = JOptionPane.showInputDialog(null, "Ingresar correo personal:");

                    ntCelular = Long.parseLong(JOptionPane.showInputDialog(null, "Ingresar número de celular:"));

                    ntFijo = Long.parseLong(JOptionPane.showInputDialog(null, "Ingresar número fijo:"));

                    programaA = JOptionPane.showInputDialog(null, "Ingresar programa:");

                    cd.capturaDatos(nombre, apellidos, fechan, correoI, correoP, programaA, ntCelular, ntFijo);

                    JOptionPane.showMessageDialog(cap, "Se agregó el estudiante");
                    break;
                case 2:

                    JOptionPane.showMessageDialog(cap, "Buscar estudiante");
                    corri = JOptionPane.showInputDialog(null, "Ingresar correo institucional:");

                    datos = cd.buscarDato(corri);
                    for (int i = 0; i < datos.size(); i++) {
                        us = datos.get(i);
                        JOptionPane.showMessageDialog(cap,"Información del estudiante");
                        JOptionPane.showMessageDialog(cap, "Nombres: " + us.getNombre1()
                                + "\nApellidos: " + us.getApellidos1()
                                + "\nFecha nacimiento: " + us.getFechaN()
                                + "\nCorreo institucional: " + us.getCorreoi()
                                + "\nCorreo personal: " + us.getCorreop()
                                + "\nNúmero de teléfono celular: " + us.getNtcelular()
                                + "\nNúmero de teléfono fijo: " + us.getNtfijo()
                                + "\nPrograma académico: " + us.getProgramaa());

                    }
                    break;
                case 3:

                    JOptionPane.showMessageDialog(cap, "Modificar estudiante");
                    correoI = JOptionPane.showInputDialog(null, "Ingresar correo institucional:");

                    correoP = JOptionPane.showInputDialog(null, "Ingresar correo personal:");

                    ntCelular = Long.parseLong(JOptionPane.showInputDialog(null,"Ingresar número de celular:"));

                    ntFijo = Long.parseLong(JOptionPane.showInputDialog(null,"Ingresar número fijo:"));

                    programaA = JOptionPane.showInputDialog(null, "Ingresar programa:");

                    cd.modificardato(correoI, correoP, ntCelular, ntFijo, programaA);
                    JOptionPane.showMessageDialog(cap, "Se modificó el estudiante");

                    break;

                case 4:

                    JOptionPane.showMessageDialog(cap, "Eliminar estudiante");
                    corri = JOptionPane.showInputDialog(null, "Ingresar correo institucional:");

                    cd.eliminardato(corri);
                    JOptionPane.showMessageDialog(cap, "Se eliminó el estudiante");

                    break;

                case 5:

                    JOptionPane.showMessageDialog(cap, "El directorio de los estudiantes");
                    datos = cd.consultarDatos();
                    for (Usuario us : datos) {
                        JOptionPane.showMessageDialog(cap, (us));

                    }
                    break;
            }
        } while (dato != 6);

        JOptionPane.showMessageDialog(cap, "Hasta pronto!");

    }

}
