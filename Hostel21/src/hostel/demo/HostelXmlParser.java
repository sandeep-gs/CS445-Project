package hostel.demo;
import hostel.collection.Beds;
import hostel.collection.Hostels;
import hostel.core.*;
import hostel.exception.*;
import hostel.utility.GenericUtility;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class HostelXmlParser {

  private File XmlFile;
  public HostelXmlParser(String fileName) throws InvalidParameterException
  {
    try {
      XmlFile = new File(fileName);
    }
    catch(Exception e) {
      throw new InvalidParameterException("File Not Found");
    }
    
  }
  
   
  public void parse() throws InvalidParameterException
  { 
    try {
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(XmlFile);
      doc.getDocumentElement().normalize();
   
      if (doc.getDocumentElement().getNodeName() != "hostel21") {
        System.out.println("THE XML IS MISSING THE ROOT NODE hostel21. STILL PROCEEDING...");
      }

      NodeList hostelList = doc.getElementsByTagName("hostel"); 
      for (int hostelCount = 0; hostelCount < hostelList.getLength(); hostelCount++) {
        Node hostel = hostelList.item(hostelCount);
        if (hostel.getNodeType() == Node.ELEMENT_NODE) {
          Element hostelElement = (Element) hostel;
          createHostel(hostelElement);
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private boolean createHostel(Element hostel)
  {
    NodeList nameList = hostel.getElementsByTagName("name");
    NodeList addressList = hostel.getElementsByTagName("address");
    NodeList contactList = hostel.getElementsByTagName("contact");
    NodeList policyList = hostel.getElementsByTagName("restrictions");
    NodeList bedList = hostel.getElementsByTagName("availability");
    
    if (nameList == null || nameList.getLength() != 1 || addressList == null || addressList.getLength() != 1
        || contactList == null || contactList.getLength() != 1 || policyList == null || policyList.getLength() != 1) {
      return false;
    }
    
    Node nameNode = nameList.item(0);
    Node addressNode = addressList.item(0);
    Node contactNode = contactList.item(0);
    Node policyNode = policyList.item(0);
    
    if (nameNode.getNodeType() != Node.ELEMENT_NODE
        || addressNode.getNodeType() != Node.ELEMENT_NODE
        || contactNode.getNodeType() != Node.ELEMENT_NODE
        || policyNode.getNodeType() != Node.ELEMENT_NODE) {
      return false;
    }
    
    Address address = createAddress((Element)addressNode);
    Contact contact = createContact((Element)contactNode);
    Policy policy = createPolicy((Element)policyNode);
    
    // Create the Hostel.
    Identifier hostelId;
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    Hostel hostelInfo = new Hostel(nameNode.getTextContent(), address, contact, policy, bedIds);
    
    try {
      hostelId = Hostels.getInstance().create(hostelInfo);
    }
    catch (DataBaseReadWriteException | IdentifierAlreadyExistsException
        | InvalidParameterException e) {
      e.printStackTrace();
      return false;
    }
    
    // Create the beds
    for (int bedCount = 0; bedCount < bedList.getLength(); bedCount++) {
      Node bedNode = bedList.item(bedCount);
      if (bedNode.getNodeType() == Node.ELEMENT_NODE) {
        createBed((Element)bedNode, hostelId);
      }
    }
    return true;
  }
  
  private Address createAddress(Element address)
  {
    NodeList streetList = address.getElementsByTagName("street");
    NodeList cityList = address.getElementsByTagName("city");
    NodeList stateList = address.getElementsByTagName("state");
    NodeList postal_codeList = address.getElementsByTagName("postal_code");
    NodeList countryList = address.getElementsByTagName("country");
    
    if (streetList == null || streetList.getLength() != 1 || cityList == null || cityList.getLength() != 1
        || stateList == null || stateList.getLength() != 1 || postal_codeList == null || postal_codeList.getLength() != 1
        || countryList == null || countryList.getLength() != 1) {
      return null;
    }
    
    Node streetNode = streetList.item(0);
    Node cityNode = cityList.item(0);
    Node stateNode = stateList.item(0);
    Node postal_codeNode = postal_codeList.item(0);
    Node countryNode = countryList.item(0);
    
    if (streetNode.getNodeType() != Node.ELEMENT_NODE
        || cityNode.getNodeType() != Node.ELEMENT_NODE
        || stateNode.getNodeType() != Node.ELEMENT_NODE
        || postal_codeNode.getNodeType() != Node.ELEMENT_NODE
        || countryNode.getNodeType() != Node.ELEMENT_NODE) {
      return null;
    }
    
    Element street = (Element)streetNode;
    Element city = (Element)cityNode;
    Element state = (Element)stateNode;
    Element postal_code = (Element)postal_codeNode;
    Element country = (Element)countryNode;
    
    return new Address(street.getTextContent(), city.getTextContent(),
        state.getTextContent(), country.getTextContent(), postal_code.getTextContent());
  }
  
  private Contact createContact(Element contact)
  {
    NodeList phoneList = contact.getElementsByTagName("phone");
    NodeList emailList = contact.getElementsByTagName("email");
    NodeList webUrlList = contact.getElementsByTagName("web");
    NodeList facebookList = contact.getElementsByTagName("facebook");
    
    if (phoneList == null || phoneList.getLength() != 1 || emailList == null || emailList.getLength() != 1
        || webUrlList == null || webUrlList.getLength() != 1 || facebookList == null || facebookList.getLength() != 1) {
      return null;
    }
    
    Node phoneNode = phoneList.item(0);
    Node emailNode = emailList.item(0);
    Node webUrlNode = webUrlList.item(0);
    Node facebookNode = facebookList.item(0);
    
    if (phoneNode.getNodeType() != Node.ELEMENT_NODE
        || emailNode.getNodeType() != Node.ELEMENT_NODE
        || webUrlNode.getNodeType() != Node.ELEMENT_NODE
        || facebookNode.getNodeType() != Node.ELEMENT_NODE) {
      return null;
    }
    
    Element phone = (Element)phoneNode;
    Element email = (Element)emailNode;
    Element webUrl = (Element)webUrlNode;
    Element facebook = (Element)facebookNode;
    
    return new Contact(phone.getTextContent(), email.getTextContent(),
        facebook.getTextContent(), webUrl.getTextContent());
  }
  
  private Policy createPolicy(Element policy)
  {
    NodeList checkInList = policy.getElementsByTagName("check_in_time");
    NodeList chekOutList = policy.getElementsByTagName("check_out_time");
    NodeList smokingList = policy.getElementsByTagName("smoking");
    NodeList alcoholList = policy.getElementsByTagName("alcohol");
    NodeList penaltyList = policy.getElementsByTagName("cancellation_penalty");
    NodeList deadlineList = policy.getElementsByTagName("cancellation_deadline");
    
    if (checkInList == null || checkInList.getLength() != 1 || chekOutList == null || chekOutList.getLength() != 1
        || smokingList == null || smokingList.getLength() != 1 || alcoholList == null || alcoholList.getLength() != 1
        || penaltyList == null || penaltyList.getLength() != 1 || deadlineList == null || deadlineList.getLength() != 1) {
      return null;
    }
    
    Node checkInNode = checkInList.item(0);
    Node checkOutNode = chekOutList.item(0);
    Node smokingNode = smokingList.item(0);
    Node alcoholNode = alcoholList.item(0);
    Node penaltyNode = penaltyList.item(0);
    Node deadlineNode = deadlineList.item(0);
    
    if (checkInNode.getNodeType() != Node.ELEMENT_NODE
        || checkOutNode.getNodeType() != Node.ELEMENT_NODE
        || smokingNode.getNodeType() != Node.ELEMENT_NODE
        || alcoholNode.getNodeType() != Node.ELEMENT_NODE
        || penaltyNode.getNodeType() != Node.ELEMENT_NODE
        || deadlineNode.getNodeType() != Node.ELEMENT_NODE) {
      return null;
    }
    
    Element checkIn = (Element)checkInNode;
    Element chekOut = (Element)checkOutNode;
    Element smoking = (Element)smokingNode;
    Element alcohol = (Element)alcoholNode;
    Element penalty = (Element)penaltyNode;
    Element deadline = (Element)deadlineNode;
    
    String penaltyStr = penalty.getTextContent();
    Integer penaltyInt = new Integer(penaltyStr.substring(0, penaltyStr.length()-1));
    Integer deadlineInt = new Integer(deadline.getTextContent());
    
    return new Policy(checkIn.getTextContent(), chekOut.getTextContent(),
        alcohol.getTextContent(), smoking.getTextContent(), deadlineInt, penaltyInt);
  }
  
  private Identifier createBed(Element bed, Identifier hostelId)
  {
    String dateFormat = "yyyyMMdd";
    SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
    NodeList dateList = bed.getElementsByTagName("date");
    NodeList roomList = bed.getElementsByTagName("room");
    NodeList bedList = bed.getElementsByTagName("bed");
    NodeList priceList = bed.getElementsByTagName("price");
    Identifier bedId = null;
    
    if (dateList == null || dateList.getLength() != 1 || roomList == null || roomList.getLength() != 1
        || bedList == null || bedList.getLength() != 1 || bedList == null || bedList.getLength() != 1) {
      return null;
    }
    
    Node dateNode = dateList.item(0);
    Node roomNode = roomList.item(0);
    Node bedNode = bedList.item(0);
    Node priceNode = priceList.item(0);
    
    if (dateNode.getNodeType() != Node.ELEMENT_NODE
        || roomNode.getNodeType() != Node.ELEMENT_NODE
        || bedNode.getNodeType() != Node.ELEMENT_NODE
        || priceNode.getNodeType() != Node.ELEMENT_NODE) {
      return null;
    }
    
    Element dateEle = (Element)dateNode;
    Element roomEle = (Element)roomNode;
    Element bedEle = (Element)bedNode;
    Element priceEle = (Element)priceNode;
    
    if (!GenericUtility.isNumber(bedEle.getTextContent())
        || !GenericUtility.isNumber(roomEle.getTextContent())
        || !GenericUtility.isNumber(roomEle.getTextContent())) {
      return null;
    }
    
    Date date;
    try {
      date = formatter.parse(dateEle.getTextContent());
    }
    catch (DOMException | ParseException e) {
      e.printStackTrace();
      return null;
    }
    
    Bed info = new Bed();
    info.setHostelId(hostelId);
    info.setNumber(new Integer(bedEle.getTextContent()));
    info.setRoomNo(new Integer(roomEle.getTextContent()));
    
    try {
      ArrayList<Identifier> ids = Beds.getInstance().search(info);
      if (ids.size() != 0) {
        // bed already exists. Update the Tariff
        bedId = ids.get(0);
        info = Beds.getInstance().get(bedId);
        ArrayList<Tariff> tariffs = info.getTariff();
        Tariff tariff = tariffs.get(tariffs.size() -1);
        if (tariff.getEndDate() == null) {
          Calendar cal = Calendar.getInstance();
          cal.setTime(date);
          cal.add(Calendar.DATE, -1);
          tariff.setEndDate(cal.getTime());
          tariffs.set(tariffs.size() -1, tariff);
        }
        tariffs.add(new Tariff(new Integer(priceEle.getTextContent()), date, null));
        info.setTariff(tariffs);
        
      }
      else {
        // create a new bed.
        ArrayList<Tariff> tariffs = new ArrayList<Tariff>();
        // we dont know the end date yet.
        Tariff tariff = new Tariff(new Integer(priceEle.getTextContent()), date, null);
        tariffs.add(tariff);
        info.setTariff(tariffs);
        bedId = Beds.getInstance().create(info);
      }
    }
    catch (DataBaseReadWriteException | IdentifierNotFoundException
           | InvalidIdentifierException | IdentifierAlreadyExistsException
           | InvalidParameterException e) {
      e.printStackTrace();
      return null;
    }
    return bedId;    
  }
}


