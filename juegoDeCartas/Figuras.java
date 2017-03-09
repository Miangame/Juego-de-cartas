package juegoDeCartas;

/**
 * Figuras de una baraja española
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public enum Figuras {
	/**
	 * AS
	 */
	AS(1),
	/**
	 * DOS
	 */
	DOS(2),
	/**
	 * TRES
	 */
	TRES(3),
	/**
	 * CUATRO
	 */
	CUATRO(4),
	/**
	 * CINCO
	 */
	CINCO(5),
	/**
	 * SEIS
	 */
	SEIS(6),
	/**
	 * SIETE
	 */
	SIETE(7),
	/**
	 * SOTA
	 */
	SOTA(0.5),
	/**
	 * CABALLO
	 */
	CABALLO(0.5),
	/**
	 * REY
	 */
	REY(0.5);

	/**
	 * Valor de la figura
	 */
	private double valor;

	private Figuras(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
}
