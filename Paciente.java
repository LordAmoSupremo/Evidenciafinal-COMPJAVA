package EVIDENCIACJ;

import java.util.Date;

public class Paciente {
    private Integer id;
    private String nombre;
    private Integer edad;
    private Date fechaNacimiento;
    private String sexo;
    private Double estatura;
    private Double peso;
    private String tipoSangre;
//construcutor
     private static int proximoId = 1;
    public Paciente(String nombre, int edad, Date fechaNacimiento, String sexo, double estatura, double peso, String tipoSangre) {
        this.id = proximoId++;
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estatura = estatura;
        this.peso = peso;
        this.tipoSangre = tipoSangre;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
}
