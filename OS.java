package reparebem;

public class OS {
	
	private String nome;
	private String telefone;
	private String roupa;
	private Reparo[] reparos;
	private int idR;
	private String status;
	
	public OS(String nome, String telefone, String roupa) {
		this.nome = nome;
		this.telefone = telefone;
		this.roupa = roupa;
		this.reparos = new Reparo[10];
		this.status = "Não iniciada";
		this.idR = 0;
	}
	
	public void incluirR(Reparo r) {
		reparos[idR] = r;
		idR++;
	}
	
	public void mudarStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public double calcularValor() {
		double total = 0.0;
		for(Reparo r : reparos) {
			total += r.getPreco();
		}
		return total;
	}
}
