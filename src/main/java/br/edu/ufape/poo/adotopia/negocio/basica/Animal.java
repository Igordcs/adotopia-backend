package br.edu.ufape.poo.adotopia.negocio.basica;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String avatar;
    private List<String> fotos;
    private String especie;
    private String raca;
    private String porte;
    private String descricao;
    private int idadeAnos;
    private int idadeMeses;

    public Animal(String avatar, List<String> fotos, String especie,String raca, String porte, String descricao, int idadeAnos, int idadeMeses) {
        super();
        this.avatar = avatar;
        this.fotos = fotos;
        this.especie = especie;
        this.raca = raca;
        this.porte = porte;
        this.descricao = descricao;
        this.idadeAnos = idadeAnos;
        this.idadeMeses = idadeMeses;
    }

    public Animal() {
        super();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatar() {
        return this.avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public List<String> getFotos(){
        return this.fotos;
    }
    public void setMeusPets(List<String> fotos){
        this.fotos = fotos;
    }
    public String getEspecie() {
        return this.especie;
    }
    public void setEspecie(String Especie) {
        this.especie = especie;
    }
    public String getRaca() {
        return this.raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public String getPorte() {
        return this.porte;
    }
    public void setPorte(String porte) {
        this.porte = porte;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getIdadeAnos() {
        return this.idadeAnos;
    }
    public void setIdadeAnos(int idadeAnos) {
        this.idadeAnos = idadeAnos;
    }
    public int getIdadeMeses() {
        return this.idadeAnos;
    }
    public void setIdadeMeses(int idadeMeses) {
        this.idadeMeses = idadeMeses;
    }

}
