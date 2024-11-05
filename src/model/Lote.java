package model;

import java.sql.Date;

public class Lote {
    private int id;
    private int quantidade;
    private java.sql.Date dataEntrada;
    private int racaoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public int getRacaoId() {
        return racaoId;
    }

    public void setRacaoId(int racaoId) {
        this.racaoId = racaoId;
    }
}