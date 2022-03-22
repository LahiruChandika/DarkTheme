import java.net.URL;
import java.util.Scanner;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class ServerClient {
	
	static String port;
	public static  URL url;
	
	static XmlRpcClientConfigImpl ccf;
	static XmlRpcClient clnt;
	
	public ServerClient(){
		ccf = new XmlRpcClientConfigImpl();
        ccf.setServerURL(url);
        ccf.setBasicUserName("admin");
        ccf.setBasicPassword("m_demo");
        ccf.setConnectionTimeout(60000);
        clnt = new XmlRpcClient();
        clnt.setConfig(ccf);
	}
	
	public static void destroy(){
		clnt = null;
		ccf = null;
	}
	

	public static void main(String[] args) throws Exception {
		 ServerClient.input(port);
		 ServerClient sc = new ServerClient();
		 sc.connect(); 
	}
	
	public boolean connect() throws XmlRpcException, Exception {

        Object[] parp = new Object[] {};
        String ss =(String)clnt.execute("hand.portNum", parp);
        System.out.println(ss);
       
        ServerClient.destroy();
        
        return true;
	}
	
	public static void input(String port) throws Exception {
		Scanner scn = new Scanner(System.in);
        System.out.print("Enter port number : ");
        port = scn.next();
        url = new URL("http://localhost:"+port+"/xmlrpc/object");

	}	
}
