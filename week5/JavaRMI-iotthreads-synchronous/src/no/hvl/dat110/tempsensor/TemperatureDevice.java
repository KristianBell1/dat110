package no.hvl.dat110.tempsensor;


import no.hvl.dat110.rpcinterface.TempSensorInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TemperatureDevice extends Thread {

	private TemperatureSensor sn;
	
	public TemperatureDevice() {
		this.sn = new TemperatureSensor();
	}
	
	public void run() {
		
		System.out.println("temperature device started");
		
		// TODO
		
		// Get a reference to the registry using the port
		Registry registry;
        try {
             registry = LocateRegistry.getRegistry(TempSensorInterface.SERVER_PORT);
        } catch (RemoteException e) {
			throw new RuntimeException(e);

		}
        // Look up the registry for the remote object (TempSensorInterface) using the name TempSensorInterface.REMOTE_IFACE_NAME
        TempSensorInterface tsi;
            try {
                 tsi = (TempSensorInterface) registry.lookup(TempSensorInterface.REMOTE_IFACE_NAME);
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            } catch (NotBoundException ex) {
                throw new RuntimeException(ex);
            }

		// loop 10 times and read the temp value from the TemperatureSensor each time
        for(int i = 0; i < 10; i++) {


            try {
                tsi.setTemp(sn.read());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
		
		// set the temperature value by calling the setTemperature remote method via the object of TempSensorInterface
		
		throw new RuntimeException("RPC TemperatureDevice Client not yet implemented...");
		
	}
}
