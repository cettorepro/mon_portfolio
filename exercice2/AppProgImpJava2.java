package exercice2;

public class AppProgImpJava2 {

	public static void main(String[] args) {

		// Déclaration et instanciation d'un tableau de 20 points.
		Point[] tab = new Point[20];
		for (int i = 0; i <= tab.length - 1; i++) {
			Point p = tab[i];
			p = new Point();
			p.setAbs((int) ((Math.random() * (100 - 1 + 1)) + 1));
			p.setOrd((int) ((Math.random() * (100 - 1 + 1)) + 1));
			tab[i] = p;
		}
		for (int i = 0; i <= tab.length - 1; i++) {
			System.out.println("Point " + i + " = " + tab[i].toString());
		}

		/*
		 * Cette fonction retourne une table des deux points les plus proches du
		 * tableau. La logique est la suivante : on prend le premier point et on calcule
		 * la distance grâce à la méthode distance.
		 * 
		 */

		Point[] res = new Point[2];
		int dist = 0;
		int min = 0;
		Point p1 = new Point();
		Point p2 = new Point();

		for (int i = 0; i <= tab.length - 1; i++) {
			Point dep;
			dep = new Point();
			dep = tab[i];
			/*
			 * Afin d'avoir un point de départ au niveau du stockage de la distance minimum,
			 * on prend la distance des deux premiers points comparés.
			 */
			if (i == 0) {
				min = dep.distance(tab[i + 1]);
			}
			for (int y = i + 1; y < tab.length - 1; y++) {
				Point arr;
				arr = new Point();
				arr = tab[y];
				dist = dep.distance(arr);
				System.out.println(dist);
				/*
				 * Ensuite, il suffit de voir s'il existe une distance plus petite afin que la
				 * variable change de valeur. Si on a une valeur plus petite que celle de départ
				 * alors le tableau prends les deux valeurs des points comparés.
				 */
				if (dist < min) {
					min = dist;
					p1 = dep;
					p2 = arr;

				}

			}

		}
		System.out.println("Distance minimum : " + min);
		System.out.println(p1.toString() + " -->  Pour le point p1");
		System.out.println(p2.toString() + " -->  Pour le point p2");

		Point pp = new Point(2, 3);
		Point p = new Point(2, 3);
		Cercle c = new Cercle(p, 2);
		Cercle ca = new Cercle(p, 1);
		// System.out.println(c.intersect(ca));

		System.out.println(c.englobe(ca));

	}

}
