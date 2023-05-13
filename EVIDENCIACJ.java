package EVIDENCIACJ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class EVIDENCIACJ {
    public static List<Usuario> usuarios = new ArrayList();
    public static List<Citas> citas = new ArrayList();
   public static List<Doctor> listaDoctores = new ArrayList<>();
public static List<Paciente> listaPacientes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        
        boolean existeUsuario;
        String usuario = "";
        String contrasena = "";
        Scanner credenciales = new Scanner(System.in);
        System.out.println("Cargando sistema... ");
        cargarUsuarios();
        System.out.println("-------------------------Inicio de sesion-----------------------");
        System.out.println("Usuario:");
        usuario = credenciales.nextLine();
        System.out.println("Contraseña");
        contrasena = credenciales.nextLine();
        existeUsuario = validarCredenciales(usuario, contrasena);
        if (existeUsuario) {
            System.out.println("existe el usuario");
                 menu();

        } else {
            System.out.println("el usuario no existe");
        }

    }

    public static void cargarUsuarios() {

        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }

        usuarios.add(new Usuario(1, "David", "0206"));
        usuarios.add(new Usuario(2, "Itzell", "0223"));
              System.out.println("Los usuarios han sido cargados: " + usuarios.size());

    }

    public static boolean validarCredenciales(String usuario, String contrasena) {
        return usuarios.stream().anyMatch(x -> x.getNombre().equals(usuario) && x.getContrasena().equals(contrasena));
    }

    public static void menu() {
        Integer opcion = -1;
        while (opcion != 0) {

            Scanner opcionScanner = new Scanner(System.in);
            System.out.println("1.-Dar de alta a medico\n"
                    + "2.-Dar de alta a un paciente\n"
                    + "3.-Crear cita\n"
                    + "3.Ver las citas de todos los medicos\n"
                    + "5.-ver todas las citas\n"
                    + "0.-Salir");
            System.out.println("Opción:");
            opcion = opcionScanner.nextInt();

            switch (opcion) {
                case 1: 
                    Scanner datosScanner = new Scanner(System.in);
                System.out.println("Introduzca el nombre del doctor:");
                String nombre = datosScanner.nextLine();
                System.out.println("Introduzca la especialidad del doctor:");
                String especialidad = datosScanner.nextLine();
                Doctor doctor = new Doctor(nombre, especialidad);
                System.out.println("Se ha creado el siguiente doctor:");
                System.out.println("ID: " + doctor.getId());
                System.out.println("Nombre: " + doctor.getNombre());
                System.out.println("Especialidad: " + doctor.getEspecialidad());
                break;
                case 2: 
                Scanner scannerPaciente = new Scanner(System.in);
    System.out.println("Introduzca el nombre del paciente:");
    String nombrePaciente = scannerPaciente.nextLine();
    System.out.println("Introduzca la edad del paciente:");
    Integer edadPaciente = scannerPaciente.nextInt();
    System.out.println("Introduzca la fecha de nacimiento del paciente (en formato dd/mm/aaaa):");
    scannerPaciente.nextLine(); // Para consumir el salto de línea anterior
    String fechaNacimientoPacienteStr = scannerPaciente.nextLine();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date fechaNacimientoPaciente = null;
    try {
        fechaNacimientoPaciente = dateFormat.parse(fechaNacimientoPacienteStr);
    } catch (ParseException e) {
        System.out.println("Ha ocurrido un error al leer la fecha de nacimiento.");
        break;
    }
    System.out.println("Introduzca el sexo del paciente (M o F):");
    String sexoPaciente = scannerPaciente.nextLine();
    System.out.println("Introduzca la estatura del paciente (en metros):");
    Double estaturaPaciente = scannerPaciente.nextDouble();
    System.out.println("Introduzca el peso del paciente (en kg):");
    Double pesoPaciente = scannerPaciente.nextDouble();
    System.out.println("Introduzca el tipo de sangre del paciente:");
    scannerPaciente.nextLine(); 
    String tipoSangrePaciente = scannerPaciente.nextLine();
    Paciente paciente = new Paciente(nombrePaciente, edadPaciente, fechaNacimientoPaciente, sexoPaciente, estaturaPaciente, pesoPaciente, tipoSangrePaciente);
    System.out.println("Se ha creado el siguiente paciente:");
    System.out.println("ID: " + paciente.getId());
    System.out.println("Nombre: " + paciente.getNombre());
    System.out.println("Edad: " + paciente.getEdad());
    System.out.println("Fecha de nacimiento: " + paciente.getFechaNacimiento());
    System.out.println("Sexo: " + paciente.getSexo());
    System.out.println("Estatura: " + paciente.getEstatura());
    System.out.println("Peso: " + paciente.getPeso());
    System.out.println("Tipo de sangre: " + paciente.getTipoSangre());
    break;
                case 3:
            Scanner scanner = new Scanner(System.in);
System.out.println("Introduzca el motivo de la cita:");
String motivo = scanner.nextLine();
System.out.println("Introduzca la fecha y hora de la cita (en formato dd/MM/yyyy HH:mm):");
String fechaString = scanner.nextLine();
DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
Date fechaHora = null;
try {
    fechaHora = format.parse(fechaString);
} catch (ParseException e) {
    System.out.println("La fecha introducida no tiene el formato correcto.");
}
    // Mostramos la lista de doctores registrados para seleccionar uno
    System.out.println("Doctores disponibles:");
    for (Doctor Doctor : listaDoctores) {
        System.out.println(Doctor.getId() + ": " + Doctor.getNombre());
    }
    System.out.println("Seleccione el ID del doctor:");
    int idDoctor = scanner.nextInt();
    Doctor Doctor = buscarDoctor(idDoctor);
    if (Doctor == null) {
        System.out.println("Doctor no encontrado.");
        break;
    }

    // Mostramos la lista de pacientes registrados para seleccionar uno
    System.out.println("Pacientes disponibles:");
    for (Paciente Paciente : listaPacientes) {
        System.out.println(Paciente.getId() + ": " + Paciente.getNombre());
    }
    System.out.println("Seleccione el ID del paciente:");
    int idPaciente = scanner.nextInt();
    Paciente Paciente = buscarPaciente(idPaciente);
    if (Paciente == null) {
        System.out.println("Paciente no encontrado.");
        break;
    }
// Crear la cita con los datos introducidos
Citas cita = new Citas(motivo, fechaHora,Doctor,Paciente);
System.out.println("Se ha creado la siguiente cita:");
System.out.println("ID: " + cita.getId());
System.out.println("Motivo: " + cita.getMotivo());
System.out.println("Fecha y hora: " + cita.getFecha());
System.out.println("Doctor: " + cita.getDoctor().getNombre());
System.out.println("Paciente: " + cita.getPaciente().getNombre());

           }
            
        }
        
    }

    private static Doctor buscarDoctor(int idDoctor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static Paciente buscarPaciente(int idPaciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    
        




