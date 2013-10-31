package fr.ensai.EvolutionManager.shared;

public class HitGoogle {

	public static String getHitGoogle(String text){
		String nbRes=""+42;
		/* OK alors voici le problème: apperement GWT et Jsoup ne font pas bon ménage, alors pour l'instant je l'ai laissé en commenté
		 * je n'ai pas encore trouvé la solution, ne vous privez surtout pas ;)
		 */

		// try {
		//
		// // On se connecte au site et on ch6arge le document html
		// Document doc = Jsoup.connect("https://www.google.fr/search?client=ubuntu&channel=fs&q="+text).userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();
		// // System.out.println(doc.outerHtml());
		//
		// // On récupère dans ce document la premiere balise ayant comme nom
		// // h1 et pour attribut class="title"
		// Element nbResultats=doc.select("div#resultStats").first();
		// nbRes=nbResultats.text().replace("\u00a0","").replaceAll("[^\\d.]", "");
		//
		//
		// } catch (Exception c) {
		// System.out.println(c);
		// }
		return nbRes;
	}
}
