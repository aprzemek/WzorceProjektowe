package obserwator;

import java.util.*;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Amazon amazon = new Amazon("AWS", 340.00);
		amazon.Dolacz(new Inwestor("Kazimierczyk"));
		amazon.Dolacz(new Inwestor("Filipczyk"));

		amazon.setCena(220.50);
		amazon.setCena(312.50);
		amazon.setCena(450.50);
		amazon.setCena(340.50);

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private interface IInwestor
	{
		void Aktualizuj(PapierWartosciowy akcja);
	}
	private abstract static class PapierWartosciowy
	{
		private String _symbol;
		private double _cena;
		private ArrayList<IInwestor> _inwestorzy = new ArrayList<IInwestor>();

		public PapierWartosciowy(String symbol, double cena)
		{
			this._symbol = symbol;
			this._cena = cena;
		}

		public final void Dolacz(IInwestor inwestor)
		{
			_inwestorzy.add(inwestor);
		}

		public final void Odlacz(IInwestor inwestor)
		{
			_inwestorzy.remove(inwestor);
		}

		public final void Powiadom()
		{
			for (IInwestor inwestor : _inwestorzy)
			{
				inwestor.Aktualizuj(this);
			}
		}

		public final double getCena()
		{
			return _cena;
		}
		public final void setCena(double value)
		{
			if (_cena != value)
			{
				_cena = value;
				Powiadom();
			}
		}

		public final String getSymbol()
		{
			return _symbol;
		}
	}
	private static class Amazon extends PapierWartosciowy
	{
		public Amazon(String symbol, double cena)
		{
			super(symbol, cena);
		}
	}
	private static class Inwestor implements IInwestor
	{
		private String _imie;
		private PapierWartosciowy PapierWartosciowy;
		public final PapierWartosciowy getPapierWartosciowy()
		{
			return PapierWartosciowy;
		}
		public final void setPapierWartosciowy(PapierWartosciowy value)
		{
			PapierWartosciowy = value;
		}

		public Inwestor(String imie)
		{
			this._imie = imie;
		}

		public final void Aktualizuj(PapierWartosciowy akcja)
		{
//C# TO JAVA CONVERTER TODO TASK: The '2:C' format specifier is not converted to Java:
			System.out.printf("Poinformowano %1$s z %2$s " + "zmiana wynosi: %3$s" + "\r\n", _imie, akcja.getSymbol(), akcja.getCena());
		}

	}
}