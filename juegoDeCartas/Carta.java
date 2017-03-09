package juegoDeCartas;

/**
 * Genera una carta de la baraja española con un palo y una figura
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class Carta {
	/**
	 * Palo de la carta
	 */
	private Palos palo;

	/**
	 * Figura de la carta
	 */
	private Figuras figura;

	public Carta(Palos palo, Figuras figura) {
		setPalo(palo);
		setFigura(figura);
	}

	Palos getPalo() {
		return palo;
	}

	private void setPalo(Palos palo) {
		this.palo = palo;
	}

	Figuras getFigura() {
		return figura;
	}

	private void setFigura(Figuras figura) {
		this.figura = figura;
	}

	/**
	 * Devuelve el valor de la carta generada
	 * 
	 * @return Valor de la carta generada
	 */
	double valorCarta() {
		return getFigura().getValor();
	}

	@Override
	public String toString() {
		return getFigura().name() + " de " + getPalo().name();
	}

}
