package no.hvl.dat110.rpcserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import no.hvl.dat110.rpcinterface.TempSensorInterface;

/**
 * For demonstration purpose in dat110 course
 */

public class TempSensorImpl extends UnicastRemoteObject implements TempSensorInterface{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TempSensorImpl() throws RemoteException {
		super();
	}

	@Override
	public int getTemp() throws RemoteException {
		return 0;
	}

	private int temperatur;
	@Override
	public void setTemp(int temp) throws RemoteException {
		temperatur = temp;

	}

	@Override
	public int getTemperatur() throws RemoteException {
		return temperatur;
	}

	// TODO
	// implement the remote methods defined in the interface here

}
