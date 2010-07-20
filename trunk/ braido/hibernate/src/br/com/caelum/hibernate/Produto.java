package br.com.caelum.hibernate;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {
	@Id
	@GeneratedValue
	@Column(columnDefinition="serial")
	private Long id;
	
	private String nome;
	private double preco;
	private Calendar dataInicioVenda;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Calendar getDataInicioVenda() {
		return dataInicioVenda;
	}
	public void setDataInicioVenda(Calendar dataInicioVenda) {
		this.dataInicioVenda = dataInicioVenda;
	}
	
	
}
