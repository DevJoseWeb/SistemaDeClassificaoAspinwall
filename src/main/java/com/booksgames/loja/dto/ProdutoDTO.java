package com.booksgames.loja.dto;

import com.booksgames.loja.documents.*;
import com.booksgames.loja.util.JsonDateDeserializer;
import com.booksgames.loja.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mongodb.gridfs.GridFS;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 22 02 2019
 */

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public String _id;
    public UUID uuid;
    public String descricao;
    public Double preco;
    public String durabilidade;
    public Double peso;
    public String rotulagem;
    public String status;
    public Double altura;
    public Double largura;
    public String formato;
    public String estilo;
    public String qualidade;
    public Tamanho tamanho;
    public Devolucao devolucao;
    public Tipo tipo;
    public Garantia garantia;
    public Embalagem embalagem;
    public Grupo grupo;
    public Cor cor;
    public Marca marca;
    public GridFS imagem;
    public Unidade unidade;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy HH:mm:ss",
            locale = "pt-BR",
            timezone = "Brazil/East")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date datacadastro;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy",
            locale = "pt-BR",
            timezone = "Brazil/East")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date fabricacao;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd/MM/yyyy",
            locale = "pt-BR",
            timezone = "Brazil/East")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    public Date vencimento;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto obj) {
        _id = obj.get_id();
        uuid = UUID.randomUUID();
        descricao = obj.getDescricao();
        preco = obj.getPreco();
        embalagem = obj.getEmbalagem();
        durabilidade = obj.getDurabilidade();
        peso = obj.getPeso();
        rotulagem = obj.getRotulagem();
        status = obj.getStatus();
        grupo = obj.getGrupo();
        cor = obj.getCor();
        marca = obj.getMarca();
        imagem = obj.getImagem();
        altura = obj.getAltura();
        largura = obj.getLargura();
        formato = obj.getFormato();
        estilo = obj.getEstilo();
        qualidade = obj.getQualidade();
        tamanho = obj.getTamanho();
        devolucao = obj.getDevolucao();
        tipo = obj.getTipo();
        garantia = obj.getGarantia();
        datacadastro = obj.getDatacadastro();
        fabricacao = obj.getFabricacao();
        vencimento = obj.getVencimento();
        unidade = obj.getUnidade();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(String durabilidade) {
        this.durabilidade = durabilidade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRotulagem() {
        return rotulagem;
    }

    public void setRotulagem(String rotulagem) {
        this.rotulagem = rotulagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public Embalagem getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Embalagem embalagem) {
        this.embalagem = embalagem;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public GridFS getImagem() {
        return imagem;
    }

    public void setImagem(GridFS imagem) {
        this.imagem = imagem;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Date getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(Date fabricacao) {
        this.fabricacao = fabricacao;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoDTO)) return false;
        ProdutoDTO that = (ProdutoDTO) o;
        return Objects.equals(get_id(), that.get_id()) &&
                Objects.equals(getUuid(), that.getUuid()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getPreco(), that.getPreco()) &&
                Objects.equals(getDurabilidade(), that.getDurabilidade()) &&
                Objects.equals(getPeso(), that.getPeso()) &&
                Objects.equals(getRotulagem(), that.getRotulagem()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getAltura(), that.getAltura()) &&
                Objects.equals(getLargura(), that.getLargura()) &&
                Objects.equals(getFormato(), that.getFormato()) &&
                Objects.equals(getEstilo(), that.getEstilo()) &&
                Objects.equals(getQualidade(), that.getQualidade()) &&
                Objects.equals(getTamanho(), that.getTamanho()) &&
                Objects.equals(getDevolucao(), that.getDevolucao()) &&
                Objects.equals(getTipo(), that.getTipo()) &&
                Objects.equals(getGarantia(), that.getGarantia()) &&
                Objects.equals(getEmbalagem(), that.getEmbalagem()) &&
                Objects.equals(getGrupo(), that.getGrupo()) &&
                Objects.equals(getCor(), that.getCor()) &&
                Objects.equals(getMarca(), that.getMarca()) &&
                Objects.equals(getImagem(), that.getImagem()) &&
                Objects.equals(getUnidade(), that.getUnidade()) &&
                Objects.equals(getDatacadastro(), that.getDatacadastro()) &&
                Objects.equals(getFabricacao(), that.getFabricacao()) &&
                Objects.equals(getVencimento(), that.getVencimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getUuid(), getDescricao(), getPreco(), getDurabilidade(), getPeso(), getRotulagem(), getStatus(), getAltura(), getLargura(), getFormato(), getEstilo(), getQualidade(), getTamanho(), getDevolucao(), getTipo(), getGarantia(), getEmbalagem(), getGrupo(), getCor(), getMarca(), getImagem(), getUnidade(), getDatacadastro(), getFabricacao(), getVencimento());
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" +
                "_id='" + _id + '\'' +
                ", uuid=" + uuid +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", durabilidade='" + durabilidade + '\'' +
                ", peso=" + peso +
                ", rotulagem='" + rotulagem + '\'' +
                ", status='" + status + '\'' +
                ", altura=" + altura +
                ", largura=" + largura +
                ", formato='" + formato + '\'' +
                ", estilo='" + estilo + '\'' +
                ", qualidade='" + qualidade + '\'' +
                ", tamanho=" + tamanho +
                ", devolucao=" + devolucao +
                ", tipo=" + tipo +
                ", garantia=" + garantia +
                ", embalagem=" + embalagem +
                ", grupo=" + grupo +
                ", cor=" + cor +
                ", marca=" + marca +
                ", imagem=" + imagem +
                ", unidade=" + unidade +
                ", datacadastro=" + datacadastro +
                ", fabricacao=" + fabricacao +
                ", vencimento=" + vencimento +
                '}';
    }
}