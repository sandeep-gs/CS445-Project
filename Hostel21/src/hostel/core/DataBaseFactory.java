package hostel.core;

import hostel.database.SimpleFileDb;


public class DataBaseFactory
{
  private static DataBase Db;
  // Read the type of data base from config file and 
  // create the data base accordingly
  // Hard coding for now
  private static String DBType = "SimpleRamDb";

  public static DataBase getDataBase() 
  {
    if (Db == null) {
      if (DBType == "SimpleRamDb") {
        Db = new SimpleFileDb();
      }
    }
    return Db;
  }
  
  public static void ClearDataBase()
  {
    Db.clear();
  }
}
