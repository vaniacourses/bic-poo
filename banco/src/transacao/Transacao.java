package transacao;

import agencia.Agencia;
import cliente.Cliente;
import conta.Conta;
import interfaceUsuario.dados.DadosTransacao;
import utilsBank.GeracaoAleatoria;
import utilsBank.databank.Data;
import utilsBank.databank.DataBank;

import java.io.Serializable;

public class Transacao implements Serializable {
	private Double valor;
	private String nossoNumero;
	private String idPagamento;
	private Data dataEmissaoTransacao;
	private Cliente destino; //@Lembrando DESTINO EH O DESTINATARIO DO DINHEIRO, QUEM RECEBE
	private Cliente origem; //@Lembrando Origem EH QUEM MANDOU TAL COISA
	private Data dataAgendada;
	private Pagavel tipoDeTransacao;

	public Transacao(DadosTransacao dadosTransacao) {
		this.valor = dadosTransacao.getValor();
		this.nossoNumero = GeracaoAleatoria.gerarNossosNumeros(25);
		this.dataEmissaoTransacao = DataBank.criarData(DataBank.COM_HORA);
		this.idPagamento = Agencia.ID_AGENCIA + Agencia.CODIGO_MOEDA + GeracaoAleatoria.gerarNumeros(4) +
				this.nossoNumero + dadosTransacao.getDataVencimentoString() + dataEmissaoTransacao.toString(DataBank.SEM_HORA);
		this.destino = dadosTransacao.getCobrador();
		this.origem = dadosTransacao.getPagador();
		this.tipoDeTransacao = dadosTransacao.getTipoDaTransacao();
	}

	public Transacao(DadosTransacao dadosTransacao, Data dataAgendada) {
		Transacao transacao = new Transacao(dadosTransacao);
		transacao.dataAgendada = dataAgendada;
	}

	public void gerarComprovante(Transacao transacao) {
		System.out.println(transacao.toString());
	}

	@Override
	public String toString() {
		return "Transacao " +
				"valor =" + valor +
				", idPagamento ='" + idPagamento + '\'' +
				", dataEmissaoTransacao =" + dataEmissaoTransacao.toString(DataBank.COM_HORA) +
				", Cobrador =" + destino.toString() +
				", Pagador =" + origem.toString() +
				", tipoDeTransacao=" + tipoDeTransacao.toString();
	}

	public Data getDataAgendada() {
		return dataAgendada;
	}

	public Conta getContaOrigem() {
		return origem.getConta();
	}

	public Double getValor() {
		return valor;
	}

	public Conta getContaDestino() {
		return destino.getConta();
	}
}
