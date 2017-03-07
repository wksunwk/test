package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements IHello {

	protected Hello() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4378179498593891936L;

	@Override
	public String helloWorld() throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello World!"; 
	}

	@Override
	public String sayHelloToSomeone(String someoneName) throws RemoteException {
		// TODO Auto-generated method stub
		return "from rmi, Hello, " + someoneName;
	}

}
