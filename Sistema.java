package reparebem;

public class Sistema {
	
	private Reparo[] reparos;
	private OS[] os;
	private int idO;
	private int idR;
	
	public Sistema() {
		this.reparos = new Reparo[100];
		this.os = new OS[500];
		this.idO = 0;
		this.idR = 0;
	}

	public void cadastrarReparo(String id, String descricao, double preco) {
		// nn pode cadastrar reparos que ja existem:
		Reparo r = acharR(id);
		if(r == null) {
			throw new IllegalArgumentException();
		}
		reparos[idR] = new Reparo( id,  descricao,  preco);
		idR++;
	}
	
	//return ++idO; Primeiro aumenta 1 e depois retorna.
	//return idO++; Primeiro retorna o valor atual e depois aumenta 1.
	
	public void reajustarPrecoReparo(String idReparo, double percentual) {
		Reparo r = acharR(idReparo);
		if(r == null) {
			throw new IllegalArgumentException();
		}
		r.ajustePreco(percentual);
	}

	public int cadastrarOrdemDeServico(String nome, String telefone, String roupa) {
		OS o = new OS(nome, telefone, roupa);
		os[idO] = o;
		idO++;
		return idO;
	}

	public String exibirOrdemDeServico(int idOS) {
		return acharOS(idOS).toString();
	}

	public void incluirReparoOrdemDeServico(int idOS, String idReparo) {
		Reparo r = acharR(idReparo);
		if(r == null) {
			throw new IllegalArgumentException();
		}
		OS o = acharOS(idOS);
		o.incluirR(r);
	}

	public void mudarStatusOrdemDeServico(int idOS, String status) {
		acharOS(idOS).mudarStatus(status);;
	}

	public double obterValorOrdemServico(int idOS) {
		return acharOS(idOS).calcularValor();
	}

	public String listarOrdemDeServico(String status) {
		String lista = "Ordens de Serviço - " + status + "\n";
		for(OS o : os) {
			if(o != null && o.getStatus().equals(status)) {
				lista += o.toString() + "\n";
			}
		}
		if(lista.equals("")) {
			return "Não há ordens de serviço do tipo <" + status + ">";
		}
		return lista;
	}

	public String listarOrdensDeServico() {
		String lista = "";
		for(OS o : os) {
			// SEMPRE VERIFICAR SE ESTA NULL
			if(o != null) {
			lista += o.toString()+ "\n";
			}
		}
		return lista;
	}
	
	public OS acharOS(int idO) {
		int id = idO - 1;

		if (id < 0 || id >= os.length) {
			throw new IllegalArgumentException("Indice Invalido");
		}

		if (os[id] == null) {
			throw new IllegalArgumentException("Indice vazio");
		}

		return os[id];
	}
	
	public Reparo acharR(String id) {

		for(int i = 0; i < idR; i++) {

			if(reparos[i].getId().equals(id)) {

				return reparos[i];
			}
		}

		return null;
	}
}
