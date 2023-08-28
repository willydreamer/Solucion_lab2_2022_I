package pe.edu.pucp.gtics.lab1221.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "distribuidoras")
@Setter
public class Distributors {
    /** Completar*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddistribuidora;

    @Column(name="nombre",nullable = false,length = 40)
    private String nombre;

    @Column(name="descripcion",nullable = false,length = 200)
    private String descripcion;

    @Column(name="fundacion",nullable = false)
    private Integer fundacion;

    @Column(name="sede",nullable = false,length = 200)
    private String sede;

    public Distributors() {

    }
}
