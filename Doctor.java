package EVIDENCIACJ;

import java.util.Scanner;

public class Doctor {
    private int id;
    private String nombre;
    private String especialidad;

    // Constructor
    private static int proximoId = 1;
    public Doctor(String nombre, String especialidad) {
        
    this.id = proximoId++;
    this.nombre = nombre;
    this.especialidad = especialidad;
}
    public Doctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el ID del doctor:");
        this.id = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea
        System.out.println("Introduzca el nombre del doctor:");
        this.nombre = scanner.nextLine();
        System.out.println("Introduzca la especialidad del doctor:");
        this.especialidad = scanner.nextLine();
    }

    Doctor(String nombre, String apellido, String telefono, String especialidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}