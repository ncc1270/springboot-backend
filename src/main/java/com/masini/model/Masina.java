package com.masini.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Masina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Marca_")
    private String marca;
    @Column(name="Model_")
    private String model;
    @Column(name="AnFabricatie_")
    private int anFabricatie;
   
    public Masina() {

	}
	public Masina(String marca, String model, int anFabricatie) {
		super();
		this.marca = marca;
		this.model = model;
		this.anFabricatie = anFabricatie;
	}
	// Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getAnFabricatie() { return anFabricatie; }
    public void setAnFabricatie(int anFabricatie) { this.anFabricatie = anFabricatie; }
}
