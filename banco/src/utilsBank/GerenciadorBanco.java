package utilsBank;

import cliente.Cliente;
import utilsBank.arquivo.Exception.LeituraArquivoException;
import utilsBank.arquivo.GerenciadorArquivo;

import java.io.FileNotFoundException;
import java.util.HashSet;

public class GerenciadorBanco {
	//Classe para gerenciar o inicio do programa do banco
	//Chega e guarda todos os clientes numa estrutura para a agencia
	private final int QUANTIDADE_DE_CHAVES_MAX = 4;

	//
	public static HashSet<Cliente> inicializarClientes() throws LeituraArquivoException {
		return GerenciadorArquivo.listarSet(GerenciadorArquivo.PATH_CLIENTES);
	}

	public static void salvandoClientes(HashSet<Cliente> clientes) {
		GerenciadorArquivo.inserirSet(GerenciadorArquivo.PATH_CLIENTES, clientes);
	}

	public static boolean intToBoolean(int value) {
		return value != 0;
	}
}
