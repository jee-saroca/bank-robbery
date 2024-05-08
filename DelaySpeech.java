// The goal is to make a method to delay speech to give user time to read.
public class DelaySpeech {
	public static void main(String[] args) { // This needs get a double
		double duration = 4000;
		try {
			Thread.sleep(duration); //duration measured in milliseconds
		}
		catch (Exception e) { // need this or else it causes errors
			System.out.println(e);
		}
	}
}
