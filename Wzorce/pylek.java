package pylek;

import java.util.*;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		String s = "bsASWbsd";

		FabrykaZnakow f = new FabrykaZnakow();

		for (var znak : s)
		{
			f.GetZnak(znak).Rysuj();
		}

		System.out.println("\n\n\n");

		FabrykaZnakow f2 = new FabrykaZnakow(24);

		for (var znak : s)
		{
			f2.GetZnak(znak).Rysuj();
		}

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Znak
	{
		private char Symbol;
		private char getSymbol()
		{
			return Symbol;
		}
		private void setSymbol(char value)
		{
			Symbol = value;
		}
		private int Rozmiar;
		private int getRozmiar()
		{
			return Rozmiar;
		}
		private void setRozmiar(int value)
		{
			Rozmiar = value;
		}

		public abstract void Rysuj();
	}
	private static class SpecyficznyZnak extends Znak
	{
		private char Symbol;
		public final char getSymbol()
		{
			return Symbol;
		}
		public final void setSymbol(char value)
		{
			Symbol = value;
		}
		private int Rozmiar;
		public final int getRozmiar()
		{
			return Rozmiar;
		}
		public final void setRozmiar(int value)
		{
			Rozmiar = value;
		}

		public SpecyficznyZnak(char s, int z)
		{
			setSymbol(s);
			setRozmiar(z);
		}

		@Override
		public void Rysuj()
		{
			System.out.println(String.format("%1$s w rozmiarze czcionki %2$s", getSymbol(), getRozmiar()));
		}
	}
	private static class FabrykaZnakow
	{
		private int rozmiar;
		private Hashtable znaki;


		public FabrykaZnakow()
		{
			this(12);
		}


		public FabrykaZnakow(int rozmiar = 12)
		{
			this.rozmiar = rozmiar;
			znaki = new Hashtable();
		}

		public final SpecyficznyZnak GetZnak(char key)
		{
			SpecyficznyZnak znak = znaki.get(key) instanceof SpecyficznyZnak ? (SpecyficznyZnak)znaki.get(key) : null;

			if (znak == null)
			{
				znak = new SpecyficznyZnak(key, rozmiar);
				znaki.put(key, znak);
			}

			return znak;
		}
	}
}