package javaPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

public abstract class ThreadPool<T>
{

    long expirationtime;
    long TTL = 30000;
    private Hashtable<T, Long> active, inactive;

    public ThreadPool()
    {
        this.expirationtime = TTL;
        this.active = new Hashtable<T, Long>();
        this.inactive = new Hashtable<T, Long>();
    }

    protected abstract T create();

    public abstract boolean validate(T o);

    public abstract void expire(T o);

    public synchronized T getInstance()
    {
        long currTime = System.currentTimeMillis();
        T t;
        if (inactive.size() > 0)
        {
            Enumeration<T> tt = inactive.keys();
            while (tt.hasMoreElements())
            {
                t = tt.nextElement();
                if (currTime - inactive.get(t) > expirationtime)
                {
                    inactive.remove(t);
                    expire(t);
                    t = null;
                }
                else
                {
                    // check if valid, then return with new base expiration time and remove from inactive and sent that to active
                    if (validate(t))
                    {
                        inactive.remove(t);
                        active.put(t, currTime);
                        return t;
                    }
                    else
                    {
                        // if not, then removed from inactive and expire and send that to garbage collector
                        inactive.remove(t);
                        expire(t);
                        t = null;
                    }
                }
            }
        }
        // if none of them found from inactive then create new one and put them in active list and send return
        t = create();
        active.put(t, currTime);
        return t;
    }

    // put in inactive after utilization of object
    public synchronized void putInInactive(T t)
    {
        active.remove(t);
        inactive.put(t, System.currentTimeMillis());
    }
}

class JDBCConnectionPool extends ThreadPool<Connection>
{

    private String dsn, usr, pwd;

    public JDBCConnectionPool(String driver, String dsn, String usr, String pwd)
    {
        super();
        try
        {
            Class.forName(driver).newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        this.dsn = dsn;
        this.usr = usr;
        this.pwd = pwd;
    }

    @Override
    protected Connection create()
    {
        try
        {
            return (DriverManager.getConnection(dsn, usr, pwd));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return (null);
        }
    }

    @Override
    public boolean validate(Connection o)
    {
        try
        {
            return (!((Connection) o).isClosed());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return (false);
        }
    }

    @Override
    public void expire(Connection o)
    {
        try
        {
            ((Connection) o).close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}


class Main {
    public static void main(String args[]) {
      // Do something...

      // Create the ConnectionPool:
      JDBCConnectionPool pool = new JDBCConnectionPool(
        "org.hsqldb.jdbcDriver", "jdbc:hsqldb://localhost/mydb",
        "sa", "secret");

      // Get a connection:
      Connection con = pool.getInstance();

      // Use the connection

      // Return the connection:
      pool.putInInactive(con);
   
    }
  }