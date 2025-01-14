package no.hvl.dat110.rmiserver;

import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import no.hvl.dat110.rmiinterface.ComputeInterface;

/**
 * For demonstration purpose in dat110 course
 * This class is the implementation of the exposed addNumbers method in our interface.
 * @author tdoy Tosin D. Oyetoyan
 */

public class ComputeImpl extends UnicastRemoteObject implements ComputeInterface {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected ComputeImpl() throws RemoteException {
		super();
	}

	public int addNumbers(int a, int b) {
		
		int sum = a + b;
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return sum;
	}
	public void stop() throws RemoteException {
		UnicastRemoteObject.unexportObject(this,true);
		System.out.println("Knuse tryne ditt Rojas, også blir serveren shutdown");
	}


}
