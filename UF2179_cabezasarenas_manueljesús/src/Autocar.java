import java.util.Objects;

/**
 * 
 */

/**
 * @author MJotaCabezas
 *
 */
public class Autocar {
	private String matrícula;
	private String marca;
	private String modelo;
	private int kilómetros;
	private int num_plazas;
	
	
	public Autocar() {
		
		
	}


	public String getMatrícula() {
		return matrícula;
	}


	public void setMatrícula(String matrícula) {
		this.matrícula = matrícula;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getKilómetros() {
		return kilómetros;
	}


	public void setKilómetros(int kilómetros) {
		this.kilómetros = kilómetros;
	}


	public int getNum_plazas() {
		return num_plazas;
	}


	public void setNum_plazas(int num_plazas) {
		this.num_plazas = num_plazas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(matrícula);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autocar other = (Autocar) obj;
		return Objects.equals(matrícula, other.matrícula);
	}


	@Override
	public String toString() {
		return "Autocar [matrícula=" + matrícula + ", marca=" + marca + ", modelo=" + modelo + ", kilómetros="
				+ kilómetros + ", num_plazas=" + num_plazas + "]";
	}
	
	

}
