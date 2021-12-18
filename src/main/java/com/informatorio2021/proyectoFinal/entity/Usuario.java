package com.informatorio2021.proyectoFinal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.util.StringUtils.capitalize;

    /* Definicion de la clase */

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "¡Atencion! El campo Nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "¡Atencion! El campo Apellido no puede estar vacio")
    private String apellido;

    @Column(unique = true)
    @NotBlank(message = "¡Atencion! El campo Email Usuario no puede estar vacio")
    @Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;

    @NotBlank(message = "¡Atencion! El campo Contraseña no puede estar vacio")
    @Size( min = 8, max = 20)
    private String password;

    private Boolean activo = true;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    @NotBlank(message = "¡Atencion! El campo Ciudad no puede estar vacio")
    private String ciudad;

    @NotBlank(message = "¡Atencion! El campo Provincia no puede estar vacio")
    private String provincia;

    @NotBlank(message = "¡Atencion! El campo Pais no puede estar vacio")
    private String pais;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Roles roles;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List <Emprendimiento> emprendimientos = new ArrayList<>();

    /* Constructor */


    public Usuario(Long id, String nombre, String apellido, String email, String password, Boolean activo, LocalDateTime fechaCreacion, String ciudad, String provincia, String pais, Roles roles, List<Emprendimiento> emprendimientos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
        this.roles = roles;
        this.emprendimientos = emprendimientos;
    }

    public Usuario() {
    }

    /* getters y setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = capitalize(ciudad.toLowerCase());
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = capitalize(provincia.toLowerCase());
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = capitalize(pais.toLowerCase());
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public List<Emprendimiento> getEmprendimientos() {
        return emprendimientos;
    }

    /* metodos de clase */

    public void setEmprendimientos(List<Emprendimiento> emprendimientos) {
        this.emprendimientos = emprendimientos;
    }

    public void AgregarEmprendimiento(Emprendimiento emprendimiento) {
        emprendimientos.add(emprendimiento);
        emprendimiento.setOwner(this);
    }

    public void EliminarEmprendimiento(Emprendimiento emprendimiento) {
        emprendimientos.remove(emprendimiento);
        emprendimiento.setOwner(null);
    }

    /* TO STRING */

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                ", roles=" + roles +
                ", emprendimientos=" + emprendimientos +
                '}';
    }
}

