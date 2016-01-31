package com.cater.utils;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.List;

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

import com.cater.dto.beans.Caterer;


public class rsToXML 
{
	public static String getXML(List<Caterer> c) throws ParserConfigurationException, SQLException, Exception
	{
		Document DOMparser = toDocument(c);
		return getStringFromDocument(DOMparser);
	}
	public static String getStringFromDocument(Document doc)
	{
	    try
	    {
	       DOMSource domSource = new DOMSource(doc);
	       StringWriter writer = new StringWriter();
	       StreamResult result = new StreamResult(writer);
	       TransformerFactory tf = TransformerFactory.newInstance();
	       Transformer transformer = tf.newTransformer();
	       transformer.transform(domSource, result);
	       return writer.toString().replaceAll("&", "");
	    }
	    catch(TransformerException ex)
	    {
	       ex.printStackTrace();
	       return null;
	    }
	} 
	public static Document toDocument(List<Caterer> cater) throws ParserConfigurationException, SQLException
{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder        = factory.newDocumentBuilder();
		Document doc                   = builder.newDocument();

		Element results = doc.createElement("markers");
		doc.appendChild(results);

		for(Caterer c:cater)
		{
			Element row = doc.createElement("marker");
//				row.setAttribute("lat", c.getLat());
//				row.setAttribute("lng", c.getLng());
//				row.setAttribute("address", c.getAddress());
				row.setAttribute("name", c.getName());
				results.appendChild(row);
		}
		return doc;
			}}
