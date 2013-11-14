package util;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Datos {

	public static Connection conexion = null;
	public static PreparedStatement stmt = null;
	static ResultSet rs = null;
	static BigDecimal LIMITE = null;
	static Statement Consulta = null;
	
	public static int ResultadoPP = 100;
    
	static boolean iniciado = false;
	
	
//	static MysqlDataSource dataSource = new MysqlDataSource();
	
	public static boolean initDatos() {
		boolean devolver = true;
		
		if (!iniciado) {
//			dataSource.setUser("garanda");
//			dataSource.setPassword("libertad");
//			dataSource.setDatabaseName("gonzalo_twitter");
//			dataSource.setServerName("150.214.140.134");
//			try {
//				conexion = dataSource.getConnection();
//				System.out.println("Conectado");
//				iniciado = true;
//			} catch (SQLException e) {
//				devolver= false;
//				e.printStackTrace();
//			}
		}
		return devolver;
	}
	public static boolean reinitDatos() {
		iniciado = false;
		return initDatos();
	}
	

	public static long ultimoId(String _tag) {
		long devolver = -1;
		try {
			stmt = conexion.prepareStatement("SELECT MAX(mensaje_id) as p FROM mensajes WHERE etiqueta='" + _tag + "'");
			rs = stmt.executeQuery();
			rs.last();
			int numero = rs.getRow();
			if (numero>0){
				rs.first();
				devolver = rs.getLong(1);
//				devolver = rs.getBigDecimal(1).longValue();
			}
		} catch (SQLException ee) {
			System.out.println("Caso de excepcion");
		}
		
		return devolver;
	}
	
	public static long primerId(String _tag) {
		
		long devolver = -1;
		
		try {
			String cadena = "SELECT MIN(mensaje_id) as p FROM mensajes WHERE etiqueta='" + _tag + "'";
			System.out.println("\t" + cadena);
			Consulta = conexion.createStatement();
			rs = Consulta.executeQuery(cadena);
			
			if (rs.wasNull()) {
				devolver = -1;
			} else {
				rs.last();
				int numero = rs.getRow();
				if (numero>0){
					rs.first();//rs.next();
					devolver = rs.getBigDecimal(1).longValue();
//					devolver = rs.getLong(1);
				}
			}
		} catch (SQLException se) {
			System.out.println("RECORDSET VACIO");
		}
		return devolver;
	}
	
}
