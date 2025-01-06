package exercice2;

import java.util.Objects;

public class Cercle {

	private Point ctr;
	private int ry;

	public Cercle() {

	}

	public Cercle(Point centre, int rayon) {
		this.ctr = centre;
		this.ry = rayon;

	}

	@Override
	public String toString() {
		return "Cercle [centre =" + ctr.toString() + ", rayon=" + ry + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ctr, ry);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cercle other = (Cercle) obj;
		return Objects.equals(ctr, other.ctr) && ry == other.ry;
	}

	public Point getCtr() {
		return ctr;
	}

	public void setCtr(Point ctr) {
		this.ctr = ctr;
	}

	public int getRy() {
		return ry;
	}

	public void setRy(int ry) {
		this.ry = ry;
	}

	/*
	 * Cette méthode renvoit le périmètre. Pour cela on cherche le rayon puis on
	 * calcule grâce à la formule suivante : 2* rayon * pi
	 */
	public long perimetre() {
		long res;
		res = Math.round(2 * this.getRy() * Math.PI);
		return res;

	}

	/*
	 * Cette méthode renvoit le surface. Pour cela on cherche le rayon puis on
	 * calcule grâce à la formule suivante : rayon* rayon * pi
	 */
	public long surface() {
		long res;
		res = Math.round(this.getRy() * this.getRy() * Math.PI);
		return res;
	}

	/*
	 * Cette méthode renvoit si un point appartient à un cercle. Pour cela on
	 * cherche les coordonées du centre et du points en question puis on calcule
	 * grâce à la formule suivante ci-dessous(res), la distance du point par rapport
	 * au centre c'est à dire son éloignement par rapport au cercle.
	 * 
	 */
	public boolean appartenir(Point p) {
		long res;
		long cp = 0;
		res = Math.round(((Math.pow(p.getAbs() - this.getCtr().getAbs(), 2)
				+ (Math.pow(p.getOrd() - this.getCtr().getOrd(), 2)))));
		cp = Math.round(Math.pow(this.getRy(), 2));
		System.out.println(res);
		System.out.println(cp);
		/*
		 * puis on compare avec le carré du rayon du cercle pour savoir si le point est
		 * à l'intérieur du cercle ou non
		 */
		return res <= cp;
	}

	/*
	 * Cette méthode calcule si deux cercles s'intersectent . On calcule la distance
	 * entre les deux cercles puis on compare la distance avec la valeure absolu de
	 * la somme et la soustraction des deux rayons.
	 */
	public boolean intersect(Cercle ca) {
		int dis = (int) Math.sqrt((Math.pow(ca.getCtr().getAbs() - this.getCtr().getAbs(), 2))
				+ (Math.pow(ca.getCtr().getOrd() - this.getCtr().getOrd(), 2)));
		return Math.abs(ca.getRy() - this.getRy()) < dis && Math.abs(ca.getRy() + this.getRy()) > dis;

	}
	/*
	 * Cette méthode calcule si un cercle contient un autre cercle. Pour cela, on
	 * calcule la surface des deux cercles. on regarde si la surface du cercle
	 * contenu est plus petit que celui du cercle contenant ensuite on compare si la
	 * distance entre les centres des cercles soient inférieurs à la différence de
	 * leur rayons respectifs
	 */

	public boolean englobe(Cercle ca) {
		if (ca.surface() < this.surface()) {
			int distanceCentre = this.getCtr().distance(ca.getCtr());
			if (distanceCentre < this.ry - ca.ry) {
				return true;
			}
		}
		return false;
	}
}
