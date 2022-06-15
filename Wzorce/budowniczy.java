package budowniczy;

import java.util.*;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{

		Kierownik kierownik = new Kierownik();

		Budowniczy budowniczy1 = new BudowniczyQW();
		Budowniczy budowniczy2 = new BudowniczyXY();


		kierownik.Skladaj(budowniczy1);

		budowniczy1.ZwrocProdukt().Pokaz();

		kierownik.Skladaj(budowniczy2);

		budowniczy2.ZwrocProdukt().Pokaz();

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private static class Produkt
	{
		private ArrayList<String> _czesci = new ArrayList<String>();

		public final void Uzupelnij(String czesc)
		{
			_czesci.add(czesc);
		}

		public final void Pokaz()
		{
			System.out.println("\nCzesci produktu -------");
			for (String czesc : _czesci)
			{
				System.out.println(czesc);
			}
		}
	}
	private abstract static class Budowniczy
	{
		public abstract void ZlozCzescA();
		public abstract void ZlozCzescB();
		public abstract Produkt ZwrocProdukt();
	}
	private static class BudowniczyXY extends Budowniczy
	{
		private Produkt _produkt = new Produkt();

		@Override
		public void ZlozCzescA()
		{
			_produkt.Uzupelnij("Czesc X");
		}

		@Override
		public void ZlozCzescB()
		{
			_produkt.Uzupelnij("Czesc Y");
		}

		@Override
		public Produkt ZwrocProdukt()
		{
			return _produkt;
		}
	}
	private static class BudowniczyQW extends Budowniczy
	{
		private Produkt _produkt = new Produkt();

		@Override
		public void ZlozCzescA()
		{
			_produkt.Uzupelnij("Czesc Q");
		}

		@Override
		public void ZlozCzescB()
		{
			_produkt.Uzupelnij("Czesc W");
		}

		@Override
		public Produkt ZwrocProdukt()
		{
			return _produkt;
		}
	}
	private static class Kierownik
	{
		public final void Skladaj(Budowniczy budowniczy)
		{
			budowniczy.ZlozCzescA();
			budowniczy.ZlozCzescB();
		}
	}
}