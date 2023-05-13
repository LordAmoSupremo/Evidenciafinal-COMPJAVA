package EVIDENCIACJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {

    private int id;
    private String nombre;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    private List<Doctor> listaDoctores;

 {
        listaDoctores = new ArrayList<Doctor>();
    }

    public void agregarDoctor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del doctor: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la especialidad del doctor: ");
        String especialidad = sc.nextLine();

        Doctor doctor = new Doctor(nombre, especialidad);
        listaDoctores.add(doctor);

        System.out.println("El doctor " + doctor.getNombre() + " ha sido agregado.");
    }

    public List<Doctor> getListaDoctores() {
        return listaDoctores;
    }

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.agregarDoctor();
        List<Doctor> doctores = usuario.getListaDoctores();
        System.out.println("Lista de doctores:");
        for (Doctor doctor : doctores) {
            System.out.println(doctor);
        }
    }
}

