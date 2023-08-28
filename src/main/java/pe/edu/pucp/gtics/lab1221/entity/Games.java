package pe.edu.pucp.gtics.lab1221.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="juegos")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idjuego;

    @Column(name="nombre",nullable = false,length = 40)
    private String nombre;

    @Column(name="descripcion",nullable = false,length = 500)
    private String descripcion;

    @Column(name="precio",nullable = false)
    private Float precio;

}
