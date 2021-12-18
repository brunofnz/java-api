package com.informatorio2021.proyectoFinal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/* Definimos la clase */
@Entity
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo Nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "El campo Descripcion no puede estar vacio")
    private String descripcion;

    private String contenido;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate creadoEn;

    private Double objetivo;

    private Boolean publicado;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean activo = true;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario owner;

    private String url;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
                name = "emprendimiento_id",
                joinColumns = @JoinColumn(name = "emprendimiento_id"),
                inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tags> tags = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "emprendimientoId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Voto> votos = new ArrayList<>();

    private Integer contadorVotos = 0;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Evento> eventos;

    /* constructor */

    public Emprendimiento(Long id, String nombre, String descripcion, String contenido, LocalDate creadoEn, Double objetivo, Boolean publicado, Boolean activo, Usuario owner, String url, List<Tags> tags, List<Voto> votos, Integer contadorVotos, List<Evento> eventos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.creadoEn = creadoEn;
        this.objetivo = objetivo;
        this.publicado = publicado;
        this.activo = activo;
        this.owner = owner;
        this.url = url;
        this.tags = tags;
        this.votos = votos;
        this.contadorVotos = contadorVotos;
        this.eventos = eventos;
    }

    public Emprendimiento() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDate creadoEn) {
        this.creadoEn = creadoEn;
    }

    public Double getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Double objetivo) {
        this.objetivo = objetivo;
    }

    public Boolean getPublicado() {
        return publicado;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Usuario getOwner() {
        return owner;
    }

    public void setOwner(Usuario owner) {
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public Integer getContadorVotos() {
        return contadorVotos;
    }

    public void setContadorVotos(Integer contadorVotos) {
        this.contadorVotos = contadorVotos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    /* metodos de la clase*/

    public void agregarTag(Tags tag){
        tags.add(tag);
        tag.getEmprendimientos().add(this);
    }

    public void removerTag(Tags tag) {
        tags.remove(tag);
        tag.getEmprendimientos().remove(null);
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void agregarEvento(Evento evento) {
        if (this.eventos == null) {
            this.eventos = new ArrayList<>();
        }
        this.eventos.add(evento);
    }

    /* to string */

    @Override
    public String toString() {
        return "Emprendimiento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", contenido='" + contenido + '\'' +
                ", creadoEn=" + creadoEn +
                ", objetivo=" + objetivo +
                ", publicado=" + publicado +
                ", activo=" + activo +
                ", owner=" + owner +
                ", url='" + url + '\'' +
                ", tags=" + tags +
                ", votos=" + votos +
                ", contadorVotos=" + contadorVotos +
                ", eventos=" + eventos +
                '}';
    }
}
