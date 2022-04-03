package UI;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import dominio.Vehiculo;
import DAO.ConexionDAO;
import DAO.VehiculoDAO;

public class app {

    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos;
        ConexionDAO conexionDAO = new ConexionDAO();
        VehiculoDAO vehiculoDAO = null;

        //Para la opción 1
        Vehiculo v = null;

        //Para la opción 2
        String matricula = "";

       int opcion;

        //Se pone a true cuando seleccionamos la opción Salir (opción 4)
        //Termina un bucle infinito
        boolean salir = false;

        // Recoge datos del teclado
        Scanner sc= new Scanner(System.in);

        while(!salir)
        {
            try {
                System.out.println("---BÚSQUEDAS DISPONIBLES EN LA BBDD VEHICULOS---:\n");
                System.out.println("1. Mostrar tabla de vehiculos completa.\n");
                System.out.println("2. Filtrar vehiculos por matricula.\n");
                System.out.println("3. Filtrar vehiculos por matricula de forma segura.\n");
                System.out.println("4. Salir.\n");

                System.out.println("Escriba una opcion:");

                //Le pedimos al usuario que introduzca un número (opción a ejecutar)
                opcion = sc.nextInt();

                //Evita el desbordamiento de Buffer
                sc.nextLine();

                switch (opcion)
                {
                    // 1. Mostrar tabla de vehiculos completa
                    case 1:
                        vehiculoDAO = new VehiculoDAO(conexionDAO, 0, null);
                        vehiculos = vehiculoDAO.findAllVehiculos();
                        Iterator<Vehiculo> it1 = vehiculos.iterator();
                        while(it1.hasNext()) {
                            v = it1.next();
                            System.out.println(v.toString());
                        }
                        System.out.println("\n");
                        break;
                    // 2. Filtrar vehiculos por matricula
                    case 2:
                        System.out.println("Introduzca la matricula:");
                        matricula = sc.nextLine();
                        vehiculoDAO = new VehiculoDAO(conexionDAO, 0, matricula);
                        vehiculos = vehiculoDAO.findByMatricula(matricula);
                        System.out.println("\n");
                        vehiculoDAO=null;
                        break;
                    // 3. Filtrar vehiculos por matricula de forma segura
                    case 3:
                        System.out.println("Introduzca la matricula:");
                        matricula = sc.nextLine();
                        vehiculoDAO = new VehiculoDAO(conexionDAO, 1, matricula);
                        vehiculos=vehiculoDAO.findByMatriculaSegura(matricula);
                        System.out.println("\n");
                        vehiculoDAO=null;
                        break;
                     //4. Salir
                    case 4:
                        salir=true;
                        break;
                    default:
                        System.out.println("Opcion numerica invalida.");
                        break;
                }
            } catch(InputMismatchException e) {
                System.out.println("Debes insertar una opcion numerica.");
                sc.next();
            }

        }





    }
}


