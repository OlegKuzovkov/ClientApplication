import java.net.*;
/* The java.io package contains the basics needed for IO operations. */
import java.io.*;
/** The SocketClient class is a simple example of a TCP/IP Socket Client.
 */
public class ClientApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String host = args[0];
		    /** Define a port */
		 int port = Integer.parseInt(args[1]);
		 StringBuffer instr = new StringBuffer();
		 try {
		      /** Obtain an address object of the server */
		      InetAddress address = InetAddress.getByName(host);
		      /** Establish a socket connetion */
		      Socket connection = new Socket(address, port);
		      /** Instantiate a BufferedOutputStream object */
		      BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
		          /** Instantiate an OutputStreamWriter object with the optional character
		           * encoding.
		           */
		      OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");
		      /** Write across the socket connection and flush the buffer */
		      String process=args[2] + (char) 10 + args[3] + (char) 13;
		      osw.write(process);
		      osw.flush();

		      /** Instantiate a BufferedInputStream object for reading
		      /** Instantiate a BufferedInputStream object for reading
		       * incoming socket streams.
		       */

		      BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
		      /**Instantiate an InputStreamReader with the optional
		       * character encoding.
		       */
		      InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");
		      /**Read the socket's InputStream and append to a StringBuffer */
		      int c;
		      while ( (c = isr.read()) != 13)
		        instr.append( (char) c);
		      /** Close the socket connection. */
		      connection.close();
		      System.out.println(instr);
		     }
		    catch (IOException f) {
		      System.out.println("IOException: " + f);
		      System.exit(1);
		    }
		    catch (Exception g) {
		      System.out.println("Exception: " + g);
		      System.exit(2);
		    }
		  }
	}

