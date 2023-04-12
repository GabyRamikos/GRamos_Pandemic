package nfds;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class PandemicMenu {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Seleccione una opción:");
		System.out.println("1. Leer archivo parametros.xml y mostrar los datos por pantalla.");
		System.out.println("2. Modificar el archivo parametros.xml con nuevos datos.");
		int opcion = scanner.nextInt();

		if (opcion == 1) {
			// Leer el archivo parametros.xml y mostrar los datos por pantalla
			File inputFile = new File("parametros.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputFile);
			Element root = doc.getDocumentElement();
			System.out.println("numCiudadesInfectadasInicio: "
					+ root.getElementsByTagName("numCiudadesInfectadasInicio").item(0).getTextContent());
			System.out.println("numCuidadesInfectadasRonda: "
					+ root.getElementsByTagName("numCuidadesInfectadasRonda").item(0).getTextContent());
			System.out.println("numEnfermedadesActivasDerrota: "
					+ root.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).getTextContent());
			System.out.println(
					"numBrotesDerrota: " + root.getElementsByTagName("numBrotesDerrota").item(0).getTextContent());
		} else if (opcion == 2) {
			// Modificar el archivo parametros.xml con nuevos datos
			File inputFile = new File("parametros.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputFile);
			Element root = doc.getDocumentElement();

			System.out.println("Ingrese el nuevo valor para numCiudadesInfectadasInicio:");
			int nuevoNumCiudadesInfectadasInicio = scanner.nextInt();
			root.getElementsByTagName("numCiudadesInfectadasInicio").item(0)
					.setTextContent(Integer.toString(nuevoNumCiudadesInfectadasInicio));

			System.out.println("Ingrese el nuevo valor para numCuidadesInfectadasRonda:");
			int nuevoNumCuidadesInfectadasRonda = scanner.nextInt();
			root.getElementsByTagName("numCuidadesInfectadasRonda").item(0)
					.setTextContent(Integer.toString(nuevoNumCuidadesInfectadasRonda));

			System.out.println("Ingrese el nuevo valor para numEnfermedadesActivasDerrota:");
			int nuevoNumEnfermedadesActivasDerrota = scanner.nextInt();
			root.getElementsByTagName("numEnfermedadesActivasDerrota").item(0)
					.setTextContent(Integer.toString(nuevoNumEnfermedadesActivasDerrota));

			System.out.println("Ingrese el nuevo valor para numBrotesDerrota:");
			int nuevoNumBrotesDerrota = scanner.nextInt();
			root.getElementsByTagName("numBrotesDerrota").item(0)
					.setTextContent(Integer.toString(nuevoNumBrotesDerrota));

			// Escribir los cambios en el archivo parametros.xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new FileWriter("parametros.xml"));
			transformer.transform(source, result);

			System.out.println("El archivo parametros.xml ha sido actualizado con los nuevos datos.");
		} else {
			System.out.println("Opción inválida.");
		}

		scanner.close();
	}
}
