package reparebem;

import java.util.Objects;

public class Reparo {
	
	private String id;
	private String dec;
	private double preco;
	
	public Reparo(String id, String dec, double preco) {
		this.id = id;
		this.dec = dec;
		this.preco = preco;
	}
	
	public void ajustePreco(double novoPreco) {
		this.preco = preco * (novoPreco/100);
	}
	
	
	public String getId() {
		return id;
	}

	public String getDec() {
		return dec;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reparo other = (Reparo) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
