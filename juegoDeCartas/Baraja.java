package juegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que crea una baraja de cartas y las baraja
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class Baraja {

	/**
	 * Baraja de cartas
	 */
	private ArrayList<Carta> baraja = new ArrayList<Carta>();

	public Baraja() {
		for (Palos palo : Palos.values()) {
			for (Figuras figura : Figuras.values()) {
				baraja.add(new Carta(palo, figura));
			}
		}

		Collections.shuffle(baraja); // Baraja las cartas
	}

	/**
	 * Saca una carta de la baraja y la elimina
	 * 
	 * @return Carta sacada
	 * @throws CartasAcabadasException
	 *             Cuando las cartas se han acabado
	 */
	public Carta sacarCarta() throws CartasAcabadasException {
		if (baraja.isEmpty())
			throw new CartasAcabadasException("Se han acabado las cartas");
		System.out.println(baraja.size());
		return baraja.remove(0);
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();

		for (Carta carta : baraja) {
			cadena.append(carta + "\n");
		}

		return cadena.toString();
	}

}
