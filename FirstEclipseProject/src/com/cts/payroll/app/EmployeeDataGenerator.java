package com.cts.payroll.app;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class EmployeeDataGenerator {
	
	private static String[] names = {
        "Muhammed Mcknight",
        "Taylan Haines",
        "Maximilian Doyle",
        "Jimi Vo",
        "Elicia Meyers",
        "Erica Brett",
        "Fannie Meyer",
        "Kailan Carver",
        "Dario Gibson",
        "Mylie Seymour",
        "Huda Compton",
        "Leopold Markham",
        "Rudra Waters",
        "Pauline Ho",
        "Sade Pritchard",
        "Zishan Horn",
        "Rory Kumar",
        "Nia Morton",
        "Arandeep Hawes",
        "Thalia Beil",
        "Alaw Neale",
        "Manpreet Gillespie",
        "Taha Koch",
        "Landon Ortiz",
        "Angus Davies",
        "Veronika Simmons",
        "Klara Carter",
        "Luc Justice",
        "Mathew Obrien",
        "Frazer Stone",
        "Derren Schmidt",
        "Sioned Mcmanus",
        "Arielle Howell",
        "Rhodri Field",
        "Julian Crouch",
        "Kieren O'Doherty",
        "Musab Mcculloch",
        "Aleksander Read",
        "Dina Jefferson",
        "Tamzin Kinney",
        "Antoine Conner",
        "Piper Atherton",
        "Oisin Morin",
        "Tyra Fellows",
        "Branden Scott",
        "Clay Almond",
        "Damien Quintero",
        "Nancy Hampton",
        "Dean Butler",
        "Shelby Salas",
        "Ailish Mccallum",
        "Rhianna Best",
        "Aran Branch",
        "Milana Finley",
        "Princess Brook",
        "Neive Coates",
        "Ammar Palacios",
        "Athena Irving",
        "Raj Maldonado",
        "Matthew Milner",
        "Kaine Bateman",
        "Paddy Humphreys",
        "Ann-Marie Bowler",
        "Evan Cooley",
        "Kendra Brandt",
        "Prisha Prentice",
        "Jodie Alston",
        "Jamelia Wynn",
        "Zane Green",
        "Corinne Lancaster",
        "Kareena Galindo",
        "Julien Devlin",
        "Jesus Mcnally",
        "Macauly Conroy",
        "Izaan Herbert",
        "Tyreese Major",
        "Jedd Shelton",
        "Daanyaal Ramirez",
        "Misha Kim",
        "Malcolm Thomson",
        "Elyse George",
        "Albi Odonnell",
        "Imaad Connelly",
        "Mai Dale",
        "Georgina Paine",
        "Bear Le",
        "Shola Dunkley",
        "Keziah Gibbs",
        "Isha Foster",
        "Imogen Woodcock",
        "Angela Gilliam",
        "Marnie Wilkins",
        "Rachelle Stubbs",
        "Leanna Esquivel",
        "Arwa Southern",
        "Fynley Roach",
        "Aras Pruitt",
        "Kaila Cornish",
        "Kourtney Black",
        "Cian Tomlinson"
    };
	
	private static final String COMMA = ",";

	public static void main(String args[]) {
		File file = new File("D:/employee1.csv");
		if (file.exists()) {
			file.delete();
		}
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("D:/employee1.csv"));
			
			for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(i);
				buffer.append(COMMA);
				String name = names[(int) (Math.random() * 99)];
				buffer.append(name);
				buffer.append(COMMA);
				buffer.append("01/01/" + ((int) (Math.random() * 80) + 1918));
				buffer.append(COMMA);
				buffer.append((int) (Math.random() * 10000000));
				buffer.append(COMMA);
				buffer.append(i);
				buffer.append("@abc.com");
				buffer.append(COMMA);
				buffer.append("1 Madley St.,2nd Block,Adyar,Chennai,600111");
				buffer.append(System.getProperty("line.separator"));
				out.append(buffer.toString());
			}
			
			out.flush();
			out.close();
		} catch (IOException exception) {
			exception.printStackTrace();
			System.out.println("File operation failed.");
		}
	}
}
