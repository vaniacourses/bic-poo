package interfaceUsuario.dados;

import agencia.Agencia;
import agencia.exceptions.BuscaException;
import cliente.Cliente;
import utilsBank.databank.Data;
import utilsBank.databank.DataBank;

import java.io.Serial;
import java.io.Serializable;

public class DadosTransacao implements Serializable {
    @Serial
    private static final long serialVersionUID = 9L;
    private final Double valor;
    private final Data dataAgendada;
    private Cliente destino;  //destino o dinheiro vai para o destino
    private Cliente origem; //origem o dinheiro sai da origem

    public DadosTransacao(Double valor, String chaveDestino, String chaveorigem, String tipoChaveDestino, String tipoChaveOrigem) throws BuscaException {
        this.valor = valor;
        this.dataAgendada = null;
        setDestinoPix(chaveDestino, tipoChaveDestino);
        setOrigemPix(chaveorigem, tipoChaveOrigem);
    }

    public DadosTransacao(Double valor, String chaveDestino, String chaveorigem, String tipoChaveDestino, String tipoChaveOrigem, String dataAgendada) throws BuscaException {
        this.valor = valor;
        this.dataAgendada = DataBank.criarData(dataAgendada, DataBank.SEM_HORA);
        setDestinoPix(chaveDestino, tipoChaveDestino);
        setOrigemPix(chaveorigem, tipoChaveOrigem);
    }


    public DadosTransacao(Double valor, Cliente destino) {
        this.valor = valor;
        this.destino = destino;
        this.dataAgendada = null;
    }

    public DadosTransacao(Double valor, Cliente destino, Cliente origem) {
        this.valor = valor;
        this.destino = destino;
        this.origem = origem;
        this.dataAgendada = null;
    }

    public Data getDataAgendada() {
        return this.dataAgendada;
    }

    private void setDestinoPix(String chave, String tipoDaChave) throws BuscaException {
        this.destino = Agencia.getInstance().buscarClientePorChavePix(tipoDaChave, chave);
    }

    private void setOrigemPix(String chave, String tipoDaChave) throws BuscaException {
        this.origem = Agencia.getInstance().buscarClientePorChavePix(tipoDaChave, chave);
    }


    public Cliente getdestino() {
        return this.destino;
    }


    public Cliente getorigem() {
        return this.origem;
    }

    public Double getValor() {
        return valor;
    }

}
