package no.hvl.dat110.rpcserver;

import no.hvl.dat110.rpcinterface.TempSensorInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * dat110: DS Lab 2
 */


public class TempRPCServer {
	
	public static void main(String args[]) {
		
		TempRPCServer server = new TempRPCServer();
		server.start();
	}
	
	public void start() {
		Registry registry = null;
		try {
			// TODO

			 registry = LocateRegistry.createRegistry(TempSensorInterface.SERVER_PORT);
			// create registry and start it on a port (e.g. 9091)
			TempSensorInterface stub = new TempSensorImpl();
			// Make a new instance (stub) of the implementation class
			registry.bind(TempSensorInterface.REMOTE_IFACE_NAME, stub);
			// Bind the remote object (stub) in the registry using the name TempSensorInterface.REMOTE_IFACE_NAME

		}catch(Exception e) {
			System.err.println("Temp RPCServer: "+e.getMessage());
			e.printStackTrace();
		}
	}

}
