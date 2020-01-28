package br.barretuino.advanced;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.barretuino.utils.Tuple4;

public class Metadata {
	
	public static void main(String[] args) {
		Map<String, Tuple4<String, Boolean, Integer, Integer>> retorno = inspecionaPropriedades("disciplina");
		
		for(String key : retorno.keySet()) {
			Tuple4<String, Boolean, Integer, Integer> info = retorno.get(key);
			System.out.println("COLUMN_NAME " + key 
						+ " \tDATA_TYPE "  + info.getA()
						+ "\tNULLABLE " + info.getB() 
						+ "\tCOLUMN_SIZE " + info.getC() 
						+ "\tDECIMAL_DIGITS " + info.getD());			
		}
	}	
	
	public static Connection getConnection(String url, String usuario, String senha) {
        Connection connection = null;
        try {
            /* Obtém o driver de conexÃ£o com o banco de dados */
            Class.forName("oracle.jdbc.driver.OracleDriver");
            /* Tenta se conectar */
            connection = DriverManager.getConnection(url, usuario, senha);
            /* Caso a conexão ocorra com sucesso, a conexão é retornada */
            return connection;
        } catch (ClassNotFoundException e) {            
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao banco de dados.");
            System.out.println(e);
            return null;
        }
    }
	
	/**
	 * Implemente um método que retorne um Map<String, Tuple4<String, Boolean, Integer, Integer>> contendo as propriedades de uma tabela:
	 * "COLUMN_NAME", "DATA_TYPE", "NULLABLE", "COLUMN_SIZE" e "DECIMAL_DIGITS" (se for do tipo decimal) 
	 * a partir de uma tabela passada como argumento.  
	 */
	class TableDef {
		
		/** O fields. */
		ArrayList<FieldDef> fields;
		
		/** O sql insert. */
		String sqlInsert;
		
		/** O sql update. */
		String sqlUpdate;
		
		/** O sql delete. */
		String sqlDelete;
		
		/** O sql select. */
		String sqlSelect;
	}
	class FieldDef {
		
		/** O name. */
		String name;
		
		/** O type. */
		String type;
		
		/** O size. */
		int size;
		
		/** O decimal. */
		int decimal;
		
		/** O nullable. */
		boolean nullable;
		
		/** O primary key. */
		boolean primaryKey;
		
		/** O pos sel del. */
		int posSelDel;
		
		/** O pos ins up. */
		int posInsUp;
	}
	public static Map<String, Tuple4<String, Boolean, Integer, Integer>> inspecionaPropriedades(String nomeTabela){ 
		Map<String, Tuple4<String, Boolean, Integer, Integer>> mapa = new HashMap<String, Tuple4<String, Boolean, Integer, Integer>>();
		String server = "localhost";
		String porta = "1521";
		String instancia = "xe";
		
		String url = "jdbc:oracle:thin:@" + server + ":" + porta + ":" + instancia;
		String usuario = "root";
		String senha = "admin";
		
		Connection conn = getConnection(url, usuario, senha);

		TableDef ret = null;
		if (ret == null) {
			DatabaseMetaData metadata = null;
			try {
				metadata = conn.getMetaData();				
			} catch (SQLException e) {
				System.out.println("Erro com a conexao: " + e);;
			}			
			try {
				ResultSet columns = metadata.getColumns(null, "CURSO", nomeTabela.toUpperCase(), null);
				ret = new Metadata().new TableDef();
				ret.fields = new ArrayList<FieldDef>();
				
				while (columns.next()) {
					FieldDef fd = new Metadata().new FieldDef();
					fd.name = columns.getString("COLUMN_NAME");
					fd.type = columns.getString("DATA_TYPE");
					fd.nullable =  columns.getInt("NULLABLE") == 1;
					fd.size = columns.getInt("COLUMN_SIZE");
					fd.primaryKey = false;
					Object dec = columns.getObject("DECIMAL_DIGITS");
					if (dec != null){
						fd.decimal = columns.getInt("DECIMAL_DIGITS");
					}
					else{
						fd.decimal = 0;
					}
					fd.posInsUp = -1;
					fd.posSelDel = -1;
					ret.fields.add(fd);
					
					mapa.put(fd.name, new Tuple4<String, Boolean, Integer, Integer>(fd.type, fd.nullable, fd.size, fd.decimal));
				}				
			}catch(SQLException erro) {
				System.out.println(erro);
			}
		}
		return mapa;
	}
}