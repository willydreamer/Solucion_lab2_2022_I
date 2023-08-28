package pe.edu.pucp.gtics.lab1221.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name="plataformas")
public class Platforms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idplataforma;

    @Column(name="nombre",nullable = false,length = 40)
    private String nombre;

    @Column(name="descripcion",nullable = false,length = 500)
    private String descripcion;
}
