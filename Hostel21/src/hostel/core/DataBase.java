package hostel.core;

import hostel.exception.DataBaseReadWriteException;
import hostel.exception.IdentifierAlreadyExistsException;
import hostel.exception.IdentifierNotFoundException;
import hostel.exception.InvalidIdentifierException;
import hostel.exception.InvalidParameterException;

import java.util.ArrayList;

public interface DataBase {
	
  void restore();
  void clear();
  
  Identifier addUser(User info)
	  throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException;
	
	void removeUser(Identifier id)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException;

	User getUser(Identifier id)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException;

	ArrayList<Identifier> searchUser(User info)
	  throws DataBaseReadWriteException;

	void updateUser(Identifier id, User info)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException;
	
	Identifier addHostel(Hostel info)
	  throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException;
	
	void removeHostel(Identifier id)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException;
	
	Hostel getHostel(Identifier id)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException;
	
	ArrayList<Identifier> searchHostel(Hostel info)
	  throws DataBaseReadWriteException;

	void updateHostel(Identifier id, Hostel info)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException;
		
	Identifier addBed(Bed info)
	  throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException;
	
	void removeBed(Identifier id)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException;
	
	Bed getBed(Identifier id)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException;
	
	ArrayList<Identifier> searchBed(Bed info)
	  throws DataBaseReadWriteException;
	
	void updateBed(Identifier id, Bed info)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException;
	
	Identifier addBooking(Booking info)
	  throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException;
	
	void removeBooking(Identifier id)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException;
	
	Booking getBooking(Identifier id)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException;
	
	ArrayList<Identifier> searchBooking(Booking info)
	  throws DataBaseReadWriteException;
	
	void updateBooking(Identifier id, Booking info)
	  throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException;
}
