package hostel.collection;

import java.util.ArrayList;
import java.util.Iterator;

import hostel.exception.*;
import hostel.core.*;

public class Users
{
  private static Users Instance = new Users();
  
  private Users() {}
  
  public static Users getInstance()
  {
    return Instance;
  }
  
  public Identifier create(User info)
    throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    DataBase db = DataBaseFactory.getDataBase();
    return db.addUser(info);
  }
  
  public User get(Identifier id)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException
  {
    DataBase db = DataBaseFactory.getDataBase();
    return db.getUser(id);
  }
  
  public void update(Identifier id, User info)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException
  {
    DataBase db = DataBaseFactory.getDataBase();
    db.updateUser(id, info);
  }

  public void delete(Identifier id)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException
  {
    DataBase db = DataBaseFactory.getDataBase();
    db.removeUser(id);
  }
  
  public ArrayList<Identifier> search(User info) throws DataBaseReadWriteException
  {
    DataBase db = DataBaseFactory.getDataBase();
    ArrayList<Identifier> result = new ArrayList<Identifier>();
    result = db.searchUser(info);
    return result;
  }
}
