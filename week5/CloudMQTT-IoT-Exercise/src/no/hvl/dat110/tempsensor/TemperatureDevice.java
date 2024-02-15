package no.hvl.dat110.tempsensor;


import no.hvl.dat110.mqtt.brokerclient.MQTTPubClient;

public class TemperatureDevice extends Thread {

	private TemperatureSensor sn;
	
	public TemperatureDevice() {
		this.sn = new TemperatureSensor();
	}
	
	public void run() {

		System.out.println("temperature device started");
		
		// TODO
		//call MQTTPubClient (create a new instance) and make connection
		MQTTPubClient pubClient = new MQTTPubClient();

		pubClient.connect();

		for(int i = 0; i < 10; i++) {
			 int temp = sn.read();
			 String tempString = Integer.toString(temp);
			 try {
				 pubClient.publish(tempString);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		}


		// loop 10 times to read temp values			
			
			// read the temp from the TemperatureSensor
			
			// use the MQTTPubClient instance object to publish the temp to the MQTT Broker 

		throw new RuntimeException("TemperatureDevice Client Not yet implemented...");
		
	}
	
}
