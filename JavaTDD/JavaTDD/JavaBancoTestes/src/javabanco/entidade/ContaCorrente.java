package javabanco.entidade;

import java.util.ArrayList;



public class ContaCorrente {
	private int _numero;
	private String _titular;
	private float _saldo = 0;
	private ArrayList<Float> _operacoes = new ArrayList<Float>();
	
	
	
	public ContaCorrente(int numero, String titular) {
		_numero = numero;
		_titular = titular;
	}
	public float saldo(){
		return _saldo;
	}
	
	public float credito(float valor) {
		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
		_saldo += valor;
		_operacoes.add(valor);
		return _saldo;
	}
	
	public float debito(float valor) {
		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
		_saldo -= valor;
		_operacoes.add(-valor);
		return _saldo;
	}
	
	public ArrayList<Float> extrato() {
		return _operacoes;
	}
	
	public int getNumero() {
		return _numero;
	}
	
	public String getTitular(){
		return _titular;
	}
	
	public float transferencia (float valor , ContaCorrente ccDestino){
		this.debito(valor);
		ccDestino.credito(valor);
		return _saldo;
	}
}