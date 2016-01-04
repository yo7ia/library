package com.nichepharma.mylibrary;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;


public class Categoryclass {

	public ArrayList<Categoryclass> children;
	public ArrayList<String> selection;
	
	public static int x=0;
	public String name;
	public String id;
	public Categoryclass() {
		children = new ArrayList<Categoryclass>();
		selection = new ArrayList<String>();
	}
	
	public Categoryclass(String name, String id) {
		this();
		this.name = name;
		this.id = id;
	}
	
	public String toString() {
		return this.name;
	}
	///////// START FROM HEREEEEE 
	// generate some random amount of child objects (1..10)
	private void generateChildren(String id, ArrayList<String> List) {
		
		//Random rand = new Random();
		for(int i=0; i < List.size(); i++) {
						String x=List.get(i).substring(List.get(i).indexOf("//")+2, List.get(i).length());
						Log.d("idsss", x+"--"+id);
						if(x.trim().equalsIgnoreCase(id.trim()))
						{
							
							Categoryclass cat = new Categoryclass(List.get(i).substring(0, List.get(i).indexOf("-")),List.get(i).substring(List.get(i).indexOf("--")+2, List.get(i).length()));
							this.children.add(cat);
						}
			
		}
		
	}

	public static ArrayList<Categoryclass> getCategories(ArrayList<String> List, ArrayList<String> List2) {
		ArrayList<Categoryclass> categories = new ArrayList<Categoryclass>();
		for(int i = 0; i < List.size() ; i++) {
			String id=List.get(i).substring(List.get(i).indexOf("--")+2, List.get(i).length());
			Categoryclass cat = new Categoryclass(List.get(i).substring(0, List.get(i).indexOf("-")),List.get(i).substring(List.get(i).indexOf("--")+2, List.get(i).length()));
			cat.generateChildren(id,List2);
			
			categories.add(cat);
		}
		return categories;
	}

	public static Categoryclass get(String name, ArrayList<String> List, ArrayList<String> List2)
	{
		ArrayList<Categoryclass> collection = Categoryclass.getCategories(List,List2);
		for (Iterator<Categoryclass> iterator = collection.iterator(); iterator.hasNext();) {
			Categoryclass cat = (Categoryclass) iterator.next();
			if(cat.name.equals(name)) {
				return cat;
			}
			
		}
		return null;
	}
	
}
