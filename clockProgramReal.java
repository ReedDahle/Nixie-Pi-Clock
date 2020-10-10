import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author REEDDAHLE
 */
public class clockProgramReal {
	
	static LocalTime time;
	static DateTimeFormatter formatter;
	static String formattedTime;
	static int h1=0;
	static int h2=0;
	static int m1=0;
	static int m2=0;
	static int s1=0;
	static int s2=0;

    public static void main(String[] args) {
    
    	formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    	final GpioController gpio = GpioFactory.getInstance(); 
            
    	final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "pin1", PinState.HIGH);
    	pin1.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "pin2", PinState.HIGH);
    	pin2.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "pin3", PinState.HIGH);
    	pin3.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "pin4", PinState.HIGH);
    	pin4.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "pin5", PinState.HIGH);
    	pin5.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "pin6", PinState.HIGH);
    	pin6.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "pin7", PinState.HIGH);
    	pin7.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "pin8", PinState.HIGH);
    	pin8.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin9 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "pin9", PinState.HIGH);
    	pin9.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, "pin10", PinState.HIGH);
    	pin10.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "pin11", PinState.HIGH);
    	pin11.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "pin12", PinState.HIGH);
    	pin12.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "pin13", PinState.HIGH);
    	pin13.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin14 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "pin14", PinState.HIGH);
    	pin14.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "pin15", PinState.HIGH);
    	pin15.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "pin16", PinState.HIGH);
    	pin16.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin21 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "pin21", PinState.HIGH);
    	pin21.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin22 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "pin22", PinState.HIGH);
    	pin22.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin23 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "pin23", PinState.HIGH);
    	pin23.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin24 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "pin24", PinState.HIGH);
    	pin24.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin25 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "pin25", PinState.HIGH);
    	pin25.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "pin26", PinState.HIGH);
    	pin26.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin27 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "pin27", PinState.HIGH);
    	pin27.setShutdownOptions(true, PinState.LOW);
    	final GpioPinDigitalOutput pin28 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "pin28", PinState.HIGH);
    	pin28.setShutdownOptions(true, PinState.LOW);
	
    	final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    	executorService.scheduleAtFixedRate(new Runnable() {
		@Override
		public void run() {
			
            
            time = LocalTime.now();
            formattedTime = time.format(formatter);
            h1 = Integer.parseInt(Character.toString(formattedTime.charAt(0)));
            h2 = Integer.parseInt(Character.toString(formattedTime.charAt(1)));
            m1 = Integer.parseInt(Character.toString(formattedTime.charAt(3)));
            m2 = Integer.parseInt(Character.toString(formattedTime.charAt(4)));
            s1 = Integer.parseInt(Character.toString(formattedTime.charAt(6)));
            s2 = Integer.parseInt(Character.toString(formattedTime.charAt(7)));
            
            if (m1 == 0 && m2 == 0)
            {
            	System.out.println("I'M TRIGGERED!!!!!1!!");
            	switch (s2)
            	{
            		case 0:
	                    pin1.low();
	                    pin2.low();
	                    pin3.low();
	                    pin4.low();
	                    pin5.low();
	                    pin6.low();
	                    pin7.low();
	                    pin8.low();
	                    pin9.low();
	                    pin10.low();
	                    pin11.low();
	                    pin12.low();
	                    pin13.low();
	                    pin14.low();
	                    pin15.low();
	                    pin16.low();
	                    pin21.low();
	                    pin22.low();
	                    pin23.low();
	                    pin24.low();
	                    pin25.low();
	                    pin26.low();
	                    pin27.low();
	                    pin28.low();
	                    break;
            		case 1:
 	                    pin1.low();
 	                    pin2.low();
 	                    pin3.low();
 	                    pin4.high();
 	                    pin5.low();
	                    pin6.low();
	                    pin7.low();
	                    pin8.high();
	                    pin9.low();
 	                    pin10.low();
 	                    pin11.low();
 	                    pin12.high();
 	                    pin13.low();
	                    pin14.low();
	                    pin15.low();
	                    pin16.high();
	                    pin21.low();
 	                    pin22.low();
 	                    pin23.low();
 	                    pin24.high();
 	                    pin25.low();
	                    pin26.low();
	                    pin27.low();
	                    pin28.high();
            			break;
            		case 2:
	                    pin1.low();
	                    pin2.low();
	                    pin3.high();
	                    pin4.low();
	                    pin5.low();
	                    pin6.low();
	                    pin7.high();
	                    pin8.low();
	                    pin9.low();
	                    pin10.low();
	                    pin11.high();
	                    pin12.low();
	                    pin13.low();
	                    pin14.low();
	                    pin15.high();
	                    pin16.low();
	                    pin21.low();
	                    pin22.low();
	                    pin23.high();
	                    pin24.low();
	                    pin25.low();
	                    pin26.low();
	                    pin27.high();
	                    pin28.low();
            			break;
            		case 3:
	                    pin1.low();
	                    pin2.low();
	                    pin3.high();
	                    pin4.high();
	                    pin5.low();
	                    pin6.low();
	                    pin7.high();
	                    pin8.high();
	                    pin9.low();
	                    pin10.low();
	                    pin11.high();
	                    pin12.high();
	                    pin13.low();
	                    pin14.low();
	                    pin15.high();
	                    pin16.high();
	                    pin21.low();
	                    pin22.low();
	                    pin23.high();
	                    pin24.high();
	                    pin25.low();
	                    pin26.low();
	                    pin27.high();
	                    pin28.high();
            			break;
            		case 4:
	                    pin1.low();
	                    pin2.high();
	                    pin3.low();
	                    pin4.low();
	                    pin5.low();
	                    pin6.high();
	                    pin7.low();
	                    pin8.low();
	                    pin9.low();
	                    pin10.high();
	                    pin11.low();
	                    pin12.low();
	                    pin13.low();
	                    pin14.high();
	                    pin15.low();
	                    pin16.low();
	                    pin21.low();
	                    pin22.high();
	                    pin23.low();
	                    pin24.low();
	                    pin25.low();
	                    pin26.high();
	                    pin27.low();
	                    pin28.low();
            			break;
            		case 5:
 	                    pin1.low();
 	                    pin2.high();
 	                    pin3.low();
 	                    pin4.high();
 	                    pin5.low();
	                    pin6.high();
	                    pin7.low();
	                    pin8.high();
	                    pin9.low();
 	                    pin10.high();
 	                    pin11.low();
 	                    pin12.high();
 	                    pin13.low();
	                    pin14.high();
	                    pin15.low();
	                    pin16.high();
	                    pin21.low();
 	                    pin22.high();
 	                    pin23.low();
 	                    pin24.high();
 	                    pin25.low();
	                    pin26.high();
	                    pin27.low();
	                    pin28.high();
            			break;
            		case 6:
 	                    pin1.low();
 	                    pin2.high();
 	                    pin3.high();
 	                    pin4.low();
 	                    pin5.low();
	                    pin6.high();
	                    pin7.high();
	                    pin8.low();
	                    pin9.low();
 	                    pin10.high();
 	                    pin11.high();
 	                    pin12.low();
 	                    pin13.low();
	                    pin14.high();
	                    pin15.high();
	                    pin16.low();
	                    pin21.low();
 	                    pin22.high();
 	                    pin23.high();
 	                    pin24.low();
 	                    pin25.low();
	                    pin26.high();
	                    pin27.high();
	                    pin28.low();
            			break;
            		case 7:
 	                    pin1.low();
 	                    pin2.high();
 	                    pin3.high();
 	                    pin4.high();
 	                    pin5.low();
	                    pin6.high();
	                    pin7.high();
	                    pin8.high();
	                    pin9.low();
 	                    pin10.high();
 	                    pin11.high();
 	                    pin12.high();
 	                    pin13.low();
	                    pin14.high();
	                    pin15.high();
	                    pin16.high();
	                    pin21.low();
 	                    pin22.high();
 	                    pin23.high();
 	                    pin24.high();
 	                    pin25.low();
	                    pin26.high();
	                    pin27.high();
	                    pin28.high();
            			break;
            		case 8:
	                    pin1.high();
	                    pin2.low();
	                    pin3.low();
	                    pin4.low();
	                    pin5.high();
	                    pin6.low();
	                    pin7.low();
	                    pin8.low();
	                    pin9.high();
	                    pin10.low();
	                    pin11.low();
	                    pin12.low();
	                    pin13.high();
	                    pin14.low();
	                    pin15.low();
	                    pin16.low();
	                    pin21.high();
	                    pin22.low();
	                    pin23.low();
	                    pin24.low();
	                    pin25.high();
	                    pin26.low();
	                    pin27.low();
	                    pin28.low();
            			break;
            		case 9:
	                    pin1.high();
	                    pin2.low();
	                    pin3.low();
	                    pin4.high();
	                    pin5.high();
	                    pin6.low();
	                    pin7.low();
	                    pin8.high();
	                    pin9.high();
	                    pin10.low();
	                    pin11.low();
	                    pin12.high();
	                    pin13.high();
	                    pin14.low();
	                    pin15.low();
	                    pin16.high();
	                    pin21.high();
	                    pin22.low();
	                    pin23.low();
	                    pin24.high();
	                    pin25.high();
	                    pin26.low();
	                    pin27.low();
	                    pin28.high();
            			break;
            	}
            }
            else
            {
            	System.out.println("not triggered");
            	switch (h1)                         
	            {
	                case 0:
	                    System.out.println(0);
	                    pin1.low();
	                    pin2.low();
	                    pin3.low();
	                    pin4.low();
	                    break;
	                case 1:
	                    System.out.println(1);
	                    pin1.low();
	                    pin2.low();
	                    pin3.low();
	                    pin4.high();
	                    break;
	                case 2:
	                    System.out.println(2);
	                    pin1.low();
	                    pin2.low();
	                    pin3.high();
	                    pin4.low();
	                    break;
	            }
	            switch (h2)
	            {
	                case 0:
	                    System.out.println(0);
	                    pin5.low();
	                    pin6.low();
	                    pin7.low();
	                    pin8.low();
	                    break;
	                case 1:
	                    System.out.println(1);
	                    pin5.low();
	                    pin6.low();
	                    pin7.low();
	                    pin8.high();
	                    break;
	                case 2:
	                    System.out.println(2);
	                    pin5.low();
	                    pin6.low();
	                    pin7.high();
	                    pin8.low();
	                    break;
	                case 3:
	                    System.out.println(3);
	                    pin5.low();
	                    pin6.low();
	                    pin7.high();
	                    pin8.high();
	                    break;
	                case 4:
	                    System.out.println(4);
	                    pin5.low();
	                    pin6.high();
	                    pin7.low();
	                    pin8.low();
	                    break;
	                case 5:
	                    System.out.println(5);
	                    pin5.low();
	                    pin6.high();
	                    pin7.low();
	                    pin8.high();
	                    break;
	                case 6:
	                    System.out.println(6);
	                    pin5.low();
	                    pin6.high();
	                    pin7.high();
	                    pin8.low();
	                    break;
	                case 7:
	                    System.out.println(7);
	                    pin5.low();
	                    pin6.high();
	                    pin7.high();
	                    pin8.high();
	                    break;
	                case 8:
	                    System.out.println(8);
	                    pin5.high();
	                    pin6.low();
	                    pin7.low();
	                    pin8.low();
	                    break;
	                case 9:
	                    System.out.println(9);
	                    pin5.high();
	                    pin6.low();
	                    pin7.low();
	                    pin8.high();
	                    break;
	            }
	            switch (m1)
	            {
	                 case 0:
	                    System.out.println(0);
	                    pin9.low();
	                    pin10.low();
	                    pin11.low();
	                    pin12.low();
	                    break;
	                case 1:
	                    System.out.println(1);
	                    pin9.low();
	                    pin10.low();
	                    pin11.low();
	                    pin12.high();
	                    break;
	                case 2:
	                    System.out.println(2);
	                    pin9.low();
	                    pin10.low();
	                    pin11.high();
	                    pin12.low();
	                    break;
	                case 3:
	                    System.out.println(3);
	                    pin9.low();
	                    pin10.low();
	                    pin11.high();
	                    pin12.high();
	                    break;
	                case 4:
	                    System.out.println(4);
	                    pin9.low();
	                    pin10.high();
	                    pin11.low();
	                    pin12.low();
	                    break;
	                case 5:
	                    System.out.println(5);
	                    pin9.low();
	                    pin10.high();
	                    pin11.low();
	                    pin12.high();
	                    break;
	                case 6:
	                    System.out.println(6);
	                    pin9.low();
	                    pin10.high();
	                    pin11.high();
	                    pin12.low();
	                    break;
	            }
	            switch (m2)
	            {
	                 case 0:
	                    System.out.println(0);
	                    pin13.low();
	                    pin14.low();
	                    pin15.low();
	                    pin16.low();
	                    break;
	                case 1:
	                    System.out.println(1);
	                    pin13.low();
	                    pin14.low();
	                    pin15.low();
	                    pin16.high();
	                    break;
	                case 2:
	                    System.out.println(2);
	                    pin13.low();
	                    pin14.low();
	                    pin15.high();
	                    pin16.low();
	                    break;
	                case 3:
	                    System.out.println(3);
	                    pin13.low();
	                    pin14.low();
	                    pin15.high();
	                    pin16.high();
	                    break;
	                case 4:
	                    System.out.println(4);
	                    pin13.low();
	                    pin14.high();
	                    pin15.low();
	                    pin16.low();
	                    break;
	                case 5:
	                    System.out.println(5);
	                    pin13.low();
	                    pin14.high();
	                    pin15.low();
	                    pin16.high();
	                    break;
	                case 6:
	                    System.out.println(6);
	                    pin13.low();
	                    pin14.high();
	                    pin15.high();
	                    pin16.low();
	                    break;
	                case 7:
	                    System.out.println(7);
	                    pin13.low();
	                    pin14.high();
	                    pin15.high();
	                    pin16.high();
	                    break;
	                case 8:
	                    System.out.println(8);
	                    pin13.high();
	                    pin14.low();
	                    pin15.low();
	                    pin16.low();
	                    break;
	                case 9:
	                    System.out.println(9);
	                    pin13.high();
	                    pin14.low();
	                    pin15.low();
	                    pin16.high();
	                    break;
	            }
	            switch (s1)
	            {
	                 case 0:
	                    System.out.println(0);
	                    pin21.low();
	                    pin22.low();
	                    pin23.low();
	                    pin24.low();
	                    break;
	                case 1:
	                    System.out.println(1);
	                    pin21.low();
	                    pin22.low();
	                    pin23.low();
	                    pin24.high();
	                    break;
	                case 2:
	                    System.out.println(2);
	                    pin21.low();
	                    pin22.low();
	                    pin23.high();
	                    pin24.low();
	                    break;
	                case 3:
	                    System.out.println(3);
	                    pin21.low();
	                    pin22.low();
	                    pin23.high();
	                    pin24.high();
	                    break;
	                case 4:
	                    System.out.println(4);
	                    pin21.low();
	                    pin22.high();
	                    pin23.low();
	                    pin24.low();
	                    break;
	                case 5:
	                    System.out.println(5);
	                    pin21.low();
	                    pin22.high();
	                    pin23.low();
	                    pin24.high();
	                    break;
	                case 6:
	                    System.out.println(6);
	                    pin21.low();
	                    pin22.high();
	                    pin23.high();
	                    pin24.low();
	                    break;
	            }
	            switch (s2)
	            {
	                case 0:
	                    System.out.println(0);
	                    pin25.low();
	                    pin26.low();
	                    pin27.low();
	                    pin28.low();
	                    break;
	                case 1:
	                    System.out.println(1);
	                    pin25.low();
	                    pin26.low();
	                    pin27.low();
	                    pin28.high();
	                    break;
	                case 2:
	                    System.out.println(2);
	                    pin25.low();
	                    pin26.low();
	                    pin27.high();
	                    pin28.low();
	                    break;
	                case 3:
	                    System.out.println(3);
	                    pin25.low();
	                    pin26.low();
	                    pin27.high();
	                    pin28.high();
	                    break;
	                case 4:
	                    System.out.println(4);
	                    pin25.low();
	                    pin26.high();
	                    pin27.low();
	                    pin28.low();
	                    break;
	                case 5:
	                    System.out.println(5);
	                    pin25.low();
	                    pin26.high();
	                    pin27.low();
	                    pin28.high();
	                    break;
	                case 6:
	                    System.out.println(6);
	                    pin25.low();
	                    pin26.high();
	                    pin27.high();
	                    pin28.low();
	                    break;
	                case 7:
	                    System.out.println(7);
	                    pin25.low();
	                    pin26.high();
	                    pin27.high();
	                    pin28.high();
	                    break;
	                case 8:
	                    System.out.println(8);
	                    pin25.high();
	                    pin26.low();
	                    pin27.low();
	                    pin28.low();
	                    break;
	                case 9:
	                    System.out.println(9);
	                    pin25.high();
	                    pin26.low();
	                    pin27.low();
	                    pin28.high();
	                    break;
	            }//end of switch
            }//end of else
		}//end of run
		}, 0, 1, TimeUnit.SECONDS);          
    }//end of main
    
}//end of class