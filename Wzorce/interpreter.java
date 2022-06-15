package interpreter;

import java.util.*;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Kontekst kontekst = new Kontekst();

		ArrayList wyrazenia = new ArrayList();

		wyrazenia.add(new WyrazenieTerminalne());
		wyrazenia.add(new WyrazenieNieterminalne());
		wyrazenia.add(new WyrazenieTerminalne());
		wyrazenia.add(new WyrazenieTerminalne());

		for (WyrazenieAbstrakcyjne wyrazenie : wyrazenia)
		{
			wyrazenie.Interpretuj(kontekst);
		}

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private static class Kontekst
	{
	}
	private abstract static class WyrazenieAbstrakcyjne
	{
		public abstract void Interpretuj(Kontekst kontekst);
	}
	private static class WyrazenieTerminalne extends WyrazenieAbstrakcyjne
	{
		@Override
		public void Interpretuj(Kontekst kontekst)
		{
			System.out.println("Wywołano WyrazenieTerminalne.Interpretuj()");
		}
	}
	private static class WyrazenieNieterminalne extends WyrazenieAbstrakcyjne
	{
		@Override
		public void Interpretuj(Kontekst kontekst)
		{
			System.out.println("Wywołano WyrazenieNieterminalne.Interpretuj()");
		}
	}
}