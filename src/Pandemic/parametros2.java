package Pandemic;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Scanner;


public class parametros2 {
	  public static void main(String argv[]) {
	    try {
	      File archivo = new File("parametros.xml"); // Obre el fitcher xml
	      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); // Crea una instancia de la fàbrica
	      
	      // Analitza el fitxer xml i el acrga en el document
	      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	      Document doc = dBuilder.parse(archivo); 
	      
	      doc.getDocumentElement().normalize(); // Normalizació en el anàlisis DOM amb Java 
	      
	      
	      // Actualitza el valor del element
	      actualizacioElement(doc);
	      
	      // Sobreescriu el document actualizat en el arxiu
	      escritXMLArxiu(doc);
	      
	      // Agafa i  mostra el element arrel
	      System.out.println("Elemento raíz :" + doc.getDocumentElement().getNodeName());
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

	private static void escritXMLArxiu(Document doc) 
	throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("parametros_actualizat.xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "Sip");
        transformer.transform(source, result);
        System.out.println();
        System.out.println("Fitxer XML actualizat correctament");
        System.out.println();
    }

	private static void actualizacioElement(Document doc) {
		// TODO Auto-generated method stub
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
	          
	          // Sobrescriu el contingut de cada element
	          Scanner sc = new Scanner(System.in);
	          System.out.print("Ingrese un valor para numCiudadesInfectadasInicio: ");
	          String valor = sc.nextLine();
	          element.getElementsByTagName("numCiudadesInfectadasInicio").item(0).setTextContent(valor);

	          System.out.print("Ingrese un valor para numCuidadesInfectadasRonda: ");
	          valor = sc.nextLine();
	          element.getElementsByTagName("numCuidadesInfectadasRonda").item(0).setTextContent(valor);

	          System.out.print("Ingrese un valor para numEnfermedadesActivasDerrota: ");
	          valor = sc.nextLine();
	          element.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).setTextContent(valor);

	          System.out.print("Ingrese un valor para numBrotesDerrota: ");
	          valor = sc.nextLine();
	          element.getElementsByTagName("numBrotesDerrota").item(0).setTextContent(valor);
	    	  }
	      }
	}
}

