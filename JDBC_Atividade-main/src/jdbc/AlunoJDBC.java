package jdbc;

import java.io.IOException;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import entities.Aluno;

public class AlunoJDBC {
	
	String sql;
	PreparedStatement pst;
	
	
	public void salvar(Aluno a, Connection con) throws IOException {
		
		try {
			
			sql = "INSERT INTO aluno (nome, sexo, dt_nasc) VALUES (?,  ?, ?)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getSexo());
			
			Date dataSql = new Date(a.getDt_nasc().getTime());
			pst.setDate(3, dataSql);
			
			pst.executeUpdate();
			System.out.println("\nCadastro do aluno realizado com sucesso!");
			
		}
		catch (SQLException e) {
			
			System.out.println(e);
		}
		
	}
	
	public List<Aluno> listar() throws IOException, SQLException {
		List<Aluno> alunos = new ArrayList<>();
		Connection con = DB.getConexao();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = con.prepareStatement("select * from aluno");
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome("nome");
				aluno.setDt_nasc("dt_nasc");
				aluno.setSexo("sexo");
				
				alunos.add(aluno);
				
			}
		} catch (Exception e) {
			System.out.println("ERRO AO LISTA");
		}
		
				
		return null;
	}
	
	public void apagar(int id) throws IOException, SQLException {
		Connection con = DB.getConexao();
		PreparedStatement pstm = null;
		Aluno aluno = new Aluno();
		
		try {
			pstm = con.prepareStatement("delete from aluno where id = ? " );
			
			pstm.setInt(0,aluno.getId());
			pstm.executeUpdate();
			System.out.println("Excluindo com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao excluir");
		}
	}
	
	public void alterar(Aluno a) throws IOException, SQLException {
		Connection con = DB.getConexao();
		PreparedStatement pstm = null;
		Aluno aluno = new Aluno();
		
		try {
			
			pstm = con.prepareStatement("update aluno set nome = ? where id = ?");
			pstm.setString(1, aluno.getNome());
			pstm.setString(2,aluno.getSexo());
			pstm.setString(3,aluno.getDt_nasc());
			
			pstm.executeUpdate();
			System.out.println("Alterando com sucesso");
			
		} catch (Exception e) {
			System.out.println("Erro ao alterar");
		}
		
	}
}

