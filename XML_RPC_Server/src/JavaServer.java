import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class JavaServer {
 
    private static int port;
    static Connection con;
    
	public static void main(String[] args) throws Exception {
		
		try (Connection connection = DBUtill.getDataSource().getConnection();){
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter port number : ");
		port = scan.nextInt();

		con = DBUtill.getDataSource().getConnection(); 
		
		WebServer wServer;	
		wServer = new WebServer(port);
        XmlRpcServer xrs = wServer.getXmlRpcServer();
        PropertyHandlerMapping ph = new PropertyHandlerMapping();
        ph.addHandler("handler",JavaServer.class);
        xrs.setHandlerMapping(ph);       
        XmlRpcServerConfigImpl serverConfi =
                (XmlRpcServerConfigImpl) xrs.getConfig();      
        serverConfi.setEnabledForExtensions(true);
        serverConfi.setContentLengthOptional(false);
        wServer.start();     
	}
	
	public String portNum() {
		System.out.println("Port number : "+port);
		return "ClientServer Port number : "+port;
	}
	
	public String execute(int hour, int min, int sec) throws SQLException{
        System.out.println("Got inputs: "+hour+", "+min+", "+sec);
        
		String sql = "insert into `time` (Id,port_address,on_time) values ('0','"+port+"','"+hour+"/"+min+"/"+sec+"');";
		java.sql.Statement st = con.createStatement();
		boolean rs = st.execute(sql);
		((Connection) st).close();		
		((java.sql.Statement) st).executeUpdate(sql);
        return "<test -time passsed to server>";       
    }
}
