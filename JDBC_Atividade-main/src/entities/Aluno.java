package entities;

import java.sql.Date;

public class Aluno {
	
	private int id;
	private String nome;
	private String sexo;
	private String dt_nasc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(String date) {
		this.dt_nasc = date;
	}

}
