/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema2;

/**
 *Clase que nos permite modificar los datos de los asientos en un avión,
 * como lo son número de asiento, el nombre y cédula del pasajero;
 * y mostrar en pantalla información de los asiento disponibles.
 * 
 * @author José Luis Rincón y Diana Marcela Molina
 * @version 1.0
 * since 02/24/2016
 */
public class Problema2 {
    //Estos arreglos guardan la información de los pasajeros
    //asientoDisponible[] marcador para el estado del asiento(0=libre y 1=ocupado)
    static int asientoDisponible[] = new int[51];
    static String nombres[] = new String[51];
    static int cedulas[] = new int[51];
    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        asignarValoresIniciales();
        //salida un boolan que me permite finalizar el ciclo/salir del programa cuando el usuario lo desee.
        boolean salida;
        salida=false;
        int opcionMenu;
        while(salida==false){
            //imprimirMenu() muestra en pantalla las opciones disponibles.
            imprimirMenu();
            opcionMenu = lectura.nextInt();
            System.out.print("\n");//salto de linea.
            if(opcionMenu==0){
                salida=true;
            }
            else if(opcionMenu==1){
                asignarAsiento();
            }
            else if(opcionMenu==2){
                mostrarEstadoDeAsientos();
            }
            else if(opcionMenu==3){
                asientosEjecutivosOcupados();
            }
            else if(opcionMenu==4){
                localizarAsientoPorCedula();
            }
            else if(opcionMenu==5){
                contarAsientosDisponiblesEcono();
            }
            else if(opcionMenu==6){
                asignarAsientoEconomico();
            }
            else if(opcionMenu==7){
                anularReserva();
            }
            else if(opcionMenu==8){
                buscarAsientoEnVentanaEconomica();
            }
            else if(opcionMenu==9){
                compararNombre();
            }else{
                System.out.println("No ha seleccionado una opción válida.");
            }
        }
        System.out.println("\nHasta luego!");
    }
    static void imprimirMenu(){
        System.out.println("\nPor favor, seleccione una opcion:");
        System.out.println("0: Salir");
        System.out.println("1: Asignar asiento");
        System.out.println("2: Mostrar asientos disponibles");
        System.out.println("3: Contar asientos ejecutivos ocupados");
        System.out.println("4: Localizar asiento por cedula de pasajero");
        System.out.println("5: localizar asiento económico disponible");
        System.out.println("6: Asignar asiento económico al pasajero");
        System.out.println("7: Anular reserva");
        System.out.println("8: Contar asientos disponibles en ventana de clase económica");
        System.out.println("9: Buscar pasajero con nombres iguales en clase económica");
    }
    static void asientosEjecutivosOcupados(){
        int ocupados=0;
        for(int i = 1; i < 9; i++){
            if(asientoDisponible[i]==1){
                ocupados++;
            }
        }
        if(ocupados<8){
            System.out.println("Los asientos ejecutivos ocupados son " + ocupados + "/8");
        }else if(ocupados==8){
            System.out.println("Todos los asientos ejecutivos ocupados 8/8");
        } 
    }
    static void asignarValoresIniciales(){
    for(int i = 1; i < 51; i++){
            asientoDisponible[i] = 0;
            nombres[i]=" ";
        }
    }
    static void mostrarEstadoDeAsientos(){
        for(int i = 1; i < 51; i++){
            
           if(asientoDisponible[i]==1){
               if(i>9){
                   System.out.print("x  ");//muestra si el asiento está ocupado.
               }
               else{
                   System.out.print("x ");//muestra si el asiento está ocupado.
               }
           }else{
               System.out.print(i+" ");//muestra el número del asiento.
           }  
           if(i<10){
               System.out.print(" ");//espacio adicional.
           }
           if(i==8){
               System.out.print("\n");//salto de linea.
           }
           if(i<9){
               if(i%4==0){
                   System.out.print("\n");//salto de linea.
               }
               if(i == 2 || i == 6){
                   System.out.print("          ");//espacio adicional.
               }
           }
           else{
               if((i-8)%6==0){
                   System.out.print("\n");//salto de linea.
               }
               if((i+1)%6==0){
                   System.out.print("   ");//espacio adicional.
               }
           }
        }
        System.out.print("\n");//salto de linea.
    }    
    static void anularReserva(){
        int a;
        java.util.Scanner lectura2 = new java.util.Scanner(System.in);
        System.out.print("Escriba el numero de asiento de reserva que va a anular: ");
        a=lectura2.nextInt();
        asientoDisponible[a]=0;
        nombres[a]=" ";
        cedulas[a]=0;
    }    
    static void asignarAsiento(){
        String nombre;
        int cedula;
        boolean clase;
        int ubicacion;
        java.util.Scanner lectura3 = new java.util.Scanner(System.in);
        System.out.println("Ingrese el nombre del pasajero:");
        nombre=lectura3.next();
        System.out.println("Ingrese el numero de cedula del pasajero: ");
        cedula=lectura3.nextInt();
        System.out.println("Seleccione la clase del pasajero:(Ejecutivo=true Economico=false)");
        clase=lectura3.nextBoolean();
        if (clase==true){
            System.out.println("Ingrese la ubicacion de su preferencia: (1: pasillo o 2: ventana)");
            ubicacion=lectura3.nextInt();
            if (ubicacion==1){
                System.out.println("los asientos disponibles en pasillo son:");
                if(asientoDisponible[2]==0){
                    System.out.print(2+"  ");
                }
                if(asientoDisponible[3]==0){
                    System.out.print(3+"  ");
                }
                if(asientoDisponible[6]==0){
                    System.out.print(6+"  ");
                }
                if(asientoDisponible[7]==0){
                    System.out.print(7);
                } 
                System.out.print("\n");//salto de linea.
            }
            else if (ubicacion==2){
                System.out.println("los asientos disponibles en Ventana son:");
                if(asientoDisponible[1]==0){
                    System.out.print(1+"  ");
                }
                if(asientoDisponible[4]==0){
                    System.out.print(4+"  ");
                }
                if(asientoDisponible[5]==0){
                    System.out.print(5+"  ");
                }
                if(asientoDisponible[8]==0){
                    System.out.print(8);
                }  
                System.out.print("\n");//salto de linea.
            }
        }
        else if (clase==false){
            System.out.println("Ingrese la ubicacion de su preferencia: (1: pasillo, 2: ventana o 3:centro)");
            ubicacion=lectura3.nextInt();
            if (ubicacion==1){
                System.out.println("Los asientos disponibles en pasillo son: ");
                for (int i=11; i<51; i=i+6){
                    if (asientoDisponible[i]==0){
                        System.out.print(i+"  ");
                    }
                }
                System.out.print("\n");//salto de linea.
                for (int i=12; i<51; i=i+6){
                    if (asientoDisponible[i]==0){
                        System.out.print(i+"  ");
                    }
                }
                System.out.print("\n");//salto de linea.
            }
            else if(ubicacion==2){
                buscarAsientoEnVentanaEconomica();
            }
            else if (ubicacion==3){
                System.out.println("Los asientos disponibles en el Centro son: ");
                for (int i=10; i<51; i=i+6){
                    if (asientoDisponible[i]==0){
                        System.out.print(i+"  ");
                    }
                }
                System.out.print("\n");//salto de linea.
                for (int i=13; i<51; i=i+6){
                    if (asientoDisponible[i]==0){
                        System.out.print(i+"  ");
                    }
                }
                System.out.print("\n");//salto de linea.
            }
        }
        System.out.print("Por favor ingrese el numero de asiento que desee reservar: ");
        int asiento;
        asiento=lectura3.nextInt();
        asientoDisponible[asiento]=1;
        nombres[asiento]=nombre;
        cedulas[asiento]=cedula;
    }
    static void localizarAsientoPorCedula(){
        int cedula;
        java.util.Scanner lectura4 = new java.util.Scanner(System.in);
        System.out.print("Ingrese el número de cédula del pasajero: ");
        cedula=lectura4.nextInt();
        boolean AsientoNoEncontrado=true;
        for(int i=1; i<51; i++){
            if(cedula==cedulas[i]){
                System.out.println("El asiento del pasajero con la cédula número " + cedula + " es: " + i);
                AsientoNoEncontrado=false;
            }
        }
        if(AsientoNoEncontrado==true){
            System.out.println("No se ha encontrado asiento asignado con el número de cédula " + cedula);
        }
    }
    static void compararNombre(){
        boolean nombreNoDuplicado=true;
        for(int i=9; i<51; i++){
            for(int j=i+1; j<51; j++){
                if(!nombres[i].equalsIgnoreCase(" ")){
                    if(nombres[i].equalsIgnoreCase(nombres[j])){
                        System.out.println("Los pasajeros con nombre " + nombres[i] + " tienen los asientos: " + i + " , " + j);
                        nombreNoDuplicado=false;
                    }
                }
            }
        }
        if(nombreNoDuplicado==true){
            System.out.println("No se han encontrado nombres de pasajeros duplicados.");
        }
    }
    static void buscarAsientoEnVentanaEconomica(){
            System.out.println("Los asientos disponibles en Ventana son: ");
                for (int i=9; i<51; i=i+6){
                    if (asientoDisponible[i]==0){
                        System.out.print(i+"  ");
                    }
                }
                System.out.print("\n");//salto de linea.
                for (int i=14; i<51; i=i+6){
                    if (asientoDisponible[i]==0){
                        System.out.print(i+"  ");
                    }
                }
                System.out.print("\n");//salto de linea.
    }
    static void contarAsientosDisponiblesEcono(){
        System.out.println("Los asientos disponibles en clase economica son:");
        for (int i=9; i<51; i=i+1){
            if (asientoDisponible[i]==0){
                    System.out.print(i+"  ");
                } 
            if ((i-8)%6 == 0){
                System.out.print("\n");//salto de linea.
            }
        }
    }
    static void asignarAsientoEconomico(){
        String nombre;
        int cedula;
        boolean asiento=false;
        java.util.Scanner lectura3 = new java.util.Scanner(System.in);
        System.out.println("Ingrese el nombre del pasajero:");
        nombre=lectura3.next();
        System.out.println("Ingrese el numero de cedula del pasajero: ");
        cedula=lectura3.nextInt();
         for (int i=9; i<51; i=i+1){
            if (asientoDisponible[i]==0 && asiento==false){
                asientoDisponible[i]=1;
                nombres[i]=nombre;
                cedulas[i]=cedula;
                System.out.print("El asiento asignado es: "+i+"\n");
                asiento=true;
            }
         }
        
    }
}
