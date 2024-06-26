import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class createCSV {
    private SeatingChart chart;
    private double avgComfort;
    private double unloadingTime;
    private String fileName;
    private Passenger planeSeatingChart[][] = new Passenger[][] {
        new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2], new Passenger[2],
        new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3], 
        new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3],  new Passenger[3], new Passenger[3]

    };

    public createCSV(SeatingChart chart, String fileName)
    {
        this.chart = chart;
        this.fileName = fileName;
    }

    public void getInfo()
    {
        loadingTimes load = new loadingTimes(chart.getPassList());
        load.setEstUnloadingTime();
        unloadingTime = load.getEstUnloadingTime();

        chart.setAvgComfort(chart.getPassList());
        avgComfort = chart.getAvgComfort();

        planeSeatingChart = chart.getPlaneSeatingChart();

    }

    public void randomCsv()
    {
        getInfo();
        writeLoadingTimeFake(fileName);
        writeAvgComfort(fileName);
        writePassengers(fileName, "Passenger Data");
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                Passenger p = planeSeatingChart[i][j];
                String info = p.getSeat() + "," + p.getBourdingGroup() + "," + p.getFirstName() + "," + p.getLastName() + ","+ p.getGender() + ","+ p.getAge() + "," + p.getCarryonSize() + "," + p.getComfort() + "," + p.isFit();
                writePassengers(fileName, info);
                
            }
        }
        for(int i = 0; i < 18; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                Passenger p = planeSeatingChart[i + 8][j];
                String info = p.getSeat() + "," + p.getBourdingGroup() + "," + p.getFirstName() + "," + p.getLastName() + ","+ p.getGender() + ","+ p.getAge() + "," + p.getCarryonSize() + "," + p.getComfort() + "," + p.isFit();
                writePassengers(fileName, info);
            }
        }
        for(int i = 0; i < 32; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                Passenger p = planeSeatingChart[i + 8 + 18][j];
                String info = p.getSeat() + "," + p.getBourdingGroup() + "," + p.getFirstName() + "," + p.getLastName() + ","+ p.getGender() + ","+ p.getAge() + "," + p.getCarryonSize() + "," + p.getComfort() + "," + p.isFit();
                writePassengers(fileName, info);
            }
        }
        

    }

    public void csv()
    {
        getInfo();
        writeLoadingTime(fileName);
        writeAvgComfort(fileName);
        //writePassengers(fileName, "Passenger Data");
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                Passenger p = planeSeatingChart[i][j];
                String info = p.getSeat() + "," + p.getBourdingGroup() + "," + p.getFirstName() + "," + p.getLastName() + ","+ p.getGender() + ","+ p.getAge() + "," + p.getCarryonSize() + "," + p.getComfort() + "," + p.isFit();
                writePassengers(fileName, info);
            }
        }
        for(int i = 8; i < 18 + 8; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                Passenger p = planeSeatingChart[i][j];
                String info = p.getSeat() + "," + p.getBourdingGroup() + "," + p.getFirstName() + "," + p.getLastName() + ","+ p.getGender() + ","+ p.getAge() + "," + p.getCarryonSize() + "," + p.getComfort() + "," + p.isFit();
                writePassengers(fileName, info);
            }
        }
        for(int i = 18 + 8; i < 32 +8 + 18; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                Passenger p = planeSeatingChart[i][j];
                String info = p.getSeat() + "," + p.getBourdingGroup() + "," + p.getFirstName() + "," + p.getLastName() + ","+ p.getGender() + ","+ p.getAge() + "," + p.getCarryonSize() + "," + p.getComfort() + "," + p.isFit();
                writePassengers(fileName, info);
            }
        }
        

    }
    
    public void writeLoadingTime(String filename) {
		
		try {
			File file = new File(filename);
			if(!file.exists()){
	    	 	file.createNewFile();
	    	}
            String inputData = "Estimated Unloading Time: " + unloadingTime;
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (file.length() > 0) {
                bw.newLine();  // Add a new line if the file is not empty
            }	
				bw.write(inputData);
			
			
			
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("!! EXCEPTION IN writeToFile() METHOD !!");
			e.printStackTrace();
		}
		
	}

    public void writeLoadingTimeFake(String filename) {
		
		try {
			File file = new File(filename);
			if(!file.exists()){
	    	 	file.createNewFile();
	    	}
            RandomNumberGen numGen = new RandomNumberGen();
            int unloadingTime = numGen.RandomInt(30, 60);
            String inputData = "Estimated Unloading Time: " + unloadingTime;
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (file.length() > 0) {
                bw.newLine();  // Add a new line if the file is not empty
            }	
				bw.write(inputData);
			
			
			
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("!! EXCEPTION IN writeToFile() METHOD !!");
			e.printStackTrace();
		}
		
	}

    public void writeAvgComfort(String filename) {
		
		try {
			File file = new File(filename);
			if(!file.exists()){
	    	 	file.createNewFile();
	    	}
            String inputData = "Average Plane Comfort: " + avgComfort;
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (file.length() > 0) {
                bw.newLine();  // Add a new line if the file is not empty
            }	
				bw.write(inputData);
			
			
			
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("!! EXCEPTION IN writeToFile() METHOD !!");
			e.printStackTrace();
		}
		
	}

    public void writePassengers(String filename, String inputData) {
		
		try {
			File file = new File(filename);
			if(!file.exists()){
	    	 	file.createNewFile();
	    	}

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (file.length() > 0) {
                bw.newLine();  // Add a new line if the file is not empty
            }	
				bw.write(inputData);
			
			
			
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("!! EXCEPTION IN writeToFile() METHOD !!");
			e.printStackTrace();
		}
		
	}
}
