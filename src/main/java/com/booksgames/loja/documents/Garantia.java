package com.booksgames.loja.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Document(collection = "garantia")
public class Garantia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String _id;
    public String descricao;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    public Date inicio;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    public Date fim;

    // Constructors
    public Garantia() {}

    public Garantia(String _id, String descricao, Date inicio, Date fim) {
        this._id = _id;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Garantia)) return false;
        Garantia garantia = (Garantia) o;
        return Objects.equals(get_id(), garantia.get_id()) &&
                Objects.equals(getDescricao(), garantia.getDescricao()) &&
                Objects.equals(getInicio(), garantia.getInicio()) &&
                Objects.equals(getFim(), garantia.getFim());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getDescricao(), getInicio(), getFim());
    }

    @Override
    public String toString() {
        return "Garantia{" +
                "_id='" + _id + '\'' +
                ", descricao='" + descricao + '\'' +
                ", inicio=" + inicio +
                ", fim=" + fim +
                '}';
    }
}
