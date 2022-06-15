package mediator;

import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		SpecyficznyMediator m = new SpecyficznyMediator();

		SpecyficznyObiekt1 k1 = new SpecyficznyObiekt1(m);
		SpecyficznyObiekt2 k2 = new SpecyficznyObiekt2(m);

		m.setObiektWspolpracownika1(k1);
		m.setObiektWspolpracownika2(k2);

		k1.Wyslij("Poproszę banana i jabłko");
		k2.Wyslij("Niestety nie ma banana");
		k1.Wyslij("W takim razie jabłko wystarczy");
		k2.Wyslij("Proszę");
		k1.Wyslij("Dziękuje");

		Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Mediator
	{
		public abstract void Wyslij(String wiadomosc, ObiektWspolpracownika wspolpracownik);
	}
	private abstract static class ObiektWspolpracownika
	{
		protected Mediator mediator;

		public ObiektWspolpracownika(Mediator mediator)
		{
			this.mediator = mediator;
		}
	}
	private static class SpecyficznyObiekt1 extends ObiektWspolpracownika
	{
		public SpecyficznyObiekt1(Mediator mediator)
		{
			super(mediator);
		}

		public final void Wyslij(String wiadomosc)
		{
			mediator.Wyslij(wiadomosc, this);
		}

		public final void Powiadom(String wiadomosc)
		{
			System.out.println("SpecyficznyObiekt1 dostaje wiadomość: " + wiadomosc);
		}
	}
	private static class SpecyficznyObiekt2 extends ObiektWspolpracownika
	{
		public SpecyficznyObiekt2(Mediator mediator)
		{
			super(mediator);
		}

		public final void Wyslij(String wiadomosc)
		{
			mediator.Wyslij(wiadomosc, this);
		}

		public final void Powiadom(String wiadomosc)
		{
			System.out.println("SpecyficznyObiekt2 dostaje wiadomość: " + wiadomosc);
		}
	}
	private static class SpecyficznyMediator extends Mediator
	{
		private SpecyficznyObiekt1 _wspolpracownik1;
		private SpecyficznyObiekt2 _wspolpracownik2;

		public final void setObiektWspolpracownika1(SpecyficznyObiekt1 value)
		{
			_wspolpracownik1 = value;
		}

		public final void setObiektWspolpracownika2(SpecyficznyObiekt2 value)
		{
			_wspolpracownik2 = value;
		}

		@Override
		public void Wyslij(String wiadomosc, ObiektWspolpracownika wspolpracownik)
		{
			if (wspolpracownik == _wspolpracownik1)
			{
				_wspolpracownik2.Powiadom(wiadomosc);
			}
			else

			{
				_wspolpracownik1.Powiadom(wiadomosc);
			}
		}
	}
}