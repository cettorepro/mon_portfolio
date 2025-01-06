package exercice2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Point {
	private int ord;
	private int abs;

	public Point() {

	}

	public Point(int abscisse, int ordonne) {
		this.abs = abscisse;
		this.ord = ordonne;

	}

	public int getOrd() {
		return ord;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abs, ord);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else if (obj == null)
			return false;
		else if (this.getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return other.abs == this.abs && other.ord == this.ord;
	}

	/*
	 * @Override public boolean equals(Object obj){ if (obj instanceof Point) //si
	 * un object est une instance de Point) Point p= (Point) obj;
	 * if(this.abs==obj.abs && this.ord==obj.ord return true} return false;
	 */

	@Override
	public String toString() {
		return " [ordonnée=" + ord + ", abscisse=" + abs + "] ";
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}

	public int getAbs() {
		return abs;
	}

	public void setAbs(int abs) {
		this.abs = abs;
	}

	/*
	 * Il s'agit d'une méthode, qui effectue sur le point, une translation avec les
	 * valeurs (tx, ty) qui sont passées en paramètre. une méthode qui calcule la
	 * distance du point à un autre point, une méthode qui calcule la distance du
	 * point à l'origine du repère de l'espace.
	 */

	public Point translation(int tx, int ty) {
		Point p = new Point();
		p.setAbs(p.getAbs() + tx);
		p.setOrd(p.getOrd() + ty);
		return p;


	}

	public int distance(Point pp) {
		int dis = (int) Math.sqrt((Math.pow(pp.getAbs() - abs, 2)) + (Math.pow(pp.getOrd() - ord, 2)));

		return dis;
	}

	public int distanceE() {
		Point p = new Point(0, 0);
		return this.distance(p);
	}

}



//Exercice de reflexion : 
/*
 * Si l'on a qu'une seule propriétés de type String alors on aura deux chaine de caractère de type
 * int dans le string séparer par une virgule (12,34) par exemple. Le premier représente les abscisses et
 * le deuxième les ordonnées.
 * Il suffit alors dans la methode getAbs de diviser en deux la chaine de caractère à partir de la virgule.
 * Transformer la chaine  de caractère en int et renvoyer l'abscisse. Idem pour les ordonnées.
 * Dans ce cas, on changerait rien à la méthode Cercle et on aurait une classe Point avec un String.
 */
