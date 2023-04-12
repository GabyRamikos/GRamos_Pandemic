package Pandemic;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class parametro {
	  public static void main(String argv[]) {
	    try {
	      File archivo = new File("parametros.xml"); // Obre el fitcher xml
	      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); // Crea una instancia de la fàbrica
	      
	      // Analitza el fitxer xml i el acrga en el document
	      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	      Document doc = dBuilder.parse(archivo); 
	      
	      doc.getDocumentElement().normalize(); // Normalizació en el anàlisis DOM amb Java 
	      
	      // Agafa i  mostra el element arrel
	      System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
	      System.out.print("----------------------------");

	      NodeList nList = doc.getElementsByTagName("parametros"); // Agafa/extrae el element arrel actual

	      // Bucle for per extraer cada element o etiqueta dintre del fitxer XML i el mostra en pantalla
	      for (int temp = 0; temp < nList.getLength(); temp++) {
	        
	    	  Node nNode = nList.item(temp); // Obtenció del node del fitxer
	        
	    	  System.out.println("\nElemento actual: " + nNode.getNodeName()); // Mostració del node del arrel
	        
	    	  if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	          
	    		  // Crea el element node per habilitar els métodes de obtenció del text 
	    		  Element element = (Element) nNode;
	          
	          // Creació de las variables para la obtenció del text
	          String numCiudadesInfectadasInicio = element.getElementsByTagName("numCiudadesInfectadasInicio").item(0).getTextContent();
	          String numCuidadesInfectadasRonda = element.getElementsByTagName("numCuidadesInfectadasRonda").item(0).getTextContent();
	          String numEnfermedadesActivasDerrota = element.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).getTextContent();
	          String numBrotesDerrota = element.getElementsByTagName("numBrotesDerrota").item(0).getTextContent();
	          
	          // Mostració en pantalla del contingut del fitxer
	          System.out.println("numCiudadesInfectadasInicio: " + numCiudadesInfectadasInicio);
	          System.out.println("numCuidadesInfectadasRonda: " + numCuidadesInfectadasRonda);
	          System.out.println("numEnfermedadesActivasDerrota: " + numEnfermedadesActivasDerrota);
	          System.out.println("numBrotesDerrota: " + numBrotesDerrota);
	        }
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
}
