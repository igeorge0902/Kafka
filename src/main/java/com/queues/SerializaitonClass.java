package com.queues;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.apache.commons.codec.binary.Base64;
 
public class SerializaitonClass {
 
	public static void main(String[] args) {
		
		Names emp = new Names();
		emp.firstName = "George";
		emp.lastName = "Gaspar";
		
		// Send serialized object as encoded string 
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = null;
		
		try {
		
		out = new ObjectOutputStream(bos);     
		out.writeObject(emp);
		out.flush();
		out.close();
		
		byte[] yourBytes = bos.toByteArray();		
		  
		try {
			    bos.close();
			  } catch (IOException ex) {
			    // ignore close exception
			  }
		  
		String t = new String(Base64.encodeBase64(yourBytes));
		//
		
		// Receive encoded string as message
		Names emp_ = new Names();  
		byte[] yourBytes2 = Base64.decodeBase64(t);
		  
		ByteArrayInputStream bis = new ByteArrayInputStream(yourBytes2);
		ObjectInput in = null;
		  
		try {
			// deserialize the byteArray
		    in = new ObjectInputStream(bis);
		    emp_ = (Names) in.readObject();
		    
		    System.out.println("Deserializing Employee...");
			System.out.println("First Name of Employee: " + emp_.firstName);
			System.out.println("Last Name of Employee: " + emp_.lastName);
			
		  } catch (ClassNotFoundException e) {
			e.printStackTrace();
		  		
		  		} 
				  finally {
				    try {
				    bis.close();
				      if (in != null) {
				        in.close();
				      }
				    } catch (IOException ex) {
				      ex.getMessage();
				    }
				  }
		  
		} catch (IOException e) {
			e.getMessage();
		} 
		
	}
}
