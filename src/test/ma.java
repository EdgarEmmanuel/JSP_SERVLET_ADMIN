package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import dao.CIndependantImpl;
import dao.ClientMoralImpl;
import dao.ClientSImpl;
import dao.CompteBloqueImpl;
import dao.CompteCourantImpl;
import dao.CompteEpargneImpl;

public class ma {
	public static void main(String[] args) {
		System.out.println(new CompteCourantImpl().getSoldeCreation());
	}
}
