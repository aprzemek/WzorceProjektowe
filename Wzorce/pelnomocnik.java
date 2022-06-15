package pelnomocnik;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Pelnomocnik pelnomocnik = new Pelnomocnik();
		pelnomocnik.Zapytanie();

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Przedmiot
	{
		public abstract void Zapytanie();
	}
	private static class KonkretnyPrzedmiot extends Przedmiot
	{
		@Override
		public void Zapytanie()
		{
			System.out.println("Wywołanie KonkretnyPrzedmiot.Zapytanie()");
		}
	}
	private static class Pelnomocnik extends Przedmiot
	{
		private KonkretnyPrzedmiot _konkretnyPrzedmiot;

		@Override
		public void Zapytanie()
		{
			if (_konkretnyPrzedmiot == null)
			{
				_konkretnyPrzedmiot = new KonkretnyPrzedmiot();
			}

			_konkretnyPrzedmiot.Zapytanie();
		}
	}
}