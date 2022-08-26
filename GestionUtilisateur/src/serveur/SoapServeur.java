package serveur;
import javax.xml.ws.Endpoint;
import service.GestionUtilisateur;

public class SoapServeur {
	
	
	public static void main(String [] args) {
		String url = "Http://localhost:1235/";
		Endpoint.publish(url, new GestionUtilisateur());
		System.out.println("Serveur a l'ecoute � l'adresse:  "+ url);
	}
}