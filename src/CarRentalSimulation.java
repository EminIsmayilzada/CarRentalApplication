import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class CarRentalSimulation {

	public static void main(String[] args) {
		QueueArray<Customer>customerQueue= new QueueArray<Customer>();
		DequeArray<Car>availableCars=new DequeArray<Car>();
		DequeArray<Car>carDeque=new DequeArray<Car>();
		ListArray<Car>rentedCarsList=new ListArray<Car>();
		QueueArray<Customer>acceptedCustomers=new QueueArray<Customer>();
		QueueArray<Customer>notAcceptedCustomers=new QueueArray<Customer>();
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		int day=1;
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a value for the number of cars(N): ");
		int N= scanner.nextInt();
		System.out.print("Enter a value for the number of customers(k) : ");
		int k= scanner.nextInt();
		Random random = new Random();
		for (int i = 1; i <= N; i++) {
			double quality = (random.nextDouble()*2)+1;
			carDeque.addToBack(new Car("Car"+i, quality,0));
			}
		for (int i = 1; i <=k; i++) {
			double thresold = (random.nextDouble()*2)+1;
			customerQueue.enqueue(new Customer(thresold,"cust"+i));
		}
		while (!carDeque.isEmpty()&&!customerQueue.isEmpty()) {
			int rentedCars=0;
			
			System.out.println("     ***********Day"+day+"***********");
			
			for (int i = 0; i < N; i++) {
				Car car = null;
				if(!carDeque.isEmpty()) {
					car=carDeque.removeFront();
				}
				if(car != null)	{
					Customer customer =customerQueue.getFront();
					System.out.println("Current " + car.getID() + " " + decimalFormat.format(car.getQuality()) + " is offering to");
					if(customerQueue.size() == 0) {
						break;
					}
					boolean flag = true;					
					while(flag) {
						if(customerQueue.getFront() != null) {
							customer =customerQueue.getFront();
							if (car.getQuality()>=customer.getThersold()) {
								
								int daysLeft=(random.nextInt(5)+1);
								car.setDaysLeft(daysLeft);
								rentedCarsList.add(car);
								acceptedCustomers.enqueue(customer);
								System.out.println("        Current " + customer.getID() + " " + decimalFormat.format(customer.getThersold()) + "     ------accepted");
								rentedCars++;	
								flag =false;
								customerQueue.dequeue();
							}
							else {	
								customer =customerQueue.getFront();
								System.out.println("        Current " + customer.getID() + " " + decimalFormat.format(customer.getThersold()) + "     ------not accepted");
								double thersold=customer.getThersold()*0.9;
								customer.setThersold(thersold);
								notAcceptedCustomers.enqueue(customer);
								customerQueue.dequeue();
								
							}
							
						}
						else {
							carDeque.addToBack(car);
							
							System.out.println("         ---not accepted by any customers---");
							break;
						}
					
					}
					while(!customerQueue.isEmpty()) {
						notAcceptedCustomers.enqueue(customerQueue.dequeue());
					}
					while(!notAcceptedCustomers.isEmpty()) {
						customerQueue.enqueue(notAcceptedCustomers.dequeue());
					}
				}
				else {
					System.out.println("All of the cars are accepted.");
					break;
				}
					
				}
			if (customerQueue.isEmpty()) {
					 System.out.println("All cars have been shown.");
					 System.out.println("All customers rent a car");
					}
			else {
					System.out.println("All cars have been shown.");
					System.out.println("But there are still customers waiting.");
				}
				System.out.println("Rented Cars:");
				for (int j = 1; j <=rentedCarsList.getLength(); j++) {
					Customer acceptedCustomer = acceptedCustomers.getFront();
					 Car rentedCar = rentedCarsList.getEntry(j);
					 if(acceptedCustomers.getFront() != null ) {
						 acceptedCustomer=acceptedCustomers.dequeue();
						 System.out.println("         "+rentedCar.getID()+" by "+acceptedCustomer.getID()+" occupancy= "+rentedCar.getDaysLeft());
						 acceptedCustomers.enqueue(acceptedCustomer);
					 }
					 
				}
				 System.out.println("Available Cars:");
				 if (carDeque.isEmpty()) {
						System.out.println("There are no available cars left");
					}
				while (!carDeque.isEmpty()) {
					
					 Car availableCar= carDeque.removeFront();
					 System.out.println("             "+availableCar.getID());
					 availableCars.addToFront(availableCar);
			   		 
					 }
				int rentedCarsSize = rentedCarsList.getLength();
				for (int i1 = 1; i1 <= rentedCarsSize; i1++) {
				    Car rentedCar = rentedCarsList.getEntry(i1);
				    rentedCar.setDaysLeft(rentedCar.getDaysLeft() - 1);
				    if (rentedCar.getDaysLeft() == 0) {
				        carDeque.addToBack(rentedCar);
				        rentedCarsList.remove(i1);
				        rentedCarsSize--; // Decrement the size since we removed a car
				        i1--; // Decrement the index to account for the shifted elements
				    }
				}
				
				
			
			day++;
					System.out.println("**********End of the Day***********");
					
						 
						 
		
		while (!availableCars.isEmpty()) {
			
			carDeque.addToFront(availableCars.removeFront());
			 
					
					
			}
			
		
	}
		}
	}

			
		
			
		
		
			
		
	


