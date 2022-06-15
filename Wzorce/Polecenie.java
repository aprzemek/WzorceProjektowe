package polecenie;

import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Odbiorca odbiorca = new Odbiorca();
		Polecenie polecenie = new SpecyficznePolecenie(odbiorca);
		ObiektWywolujacy wywolujacy = new ObiektWywolujacy();

		wywolujacy.UstawPolecenie(polecenie);
		wywolujacy.WykonajPolecenie();

		Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Polecenie
	{
		protected Odbiorca odbiorca;
		public Polecenie(Odbiorca odbiorca)
		{
			this.odbiorca = odbiorca;
		}

		public abstract void Wykonaj();
	}
	private static class SpecyficznePolecenie extends Polecenie
	{

		public SpecyficznePolecenie(Odbiorca odbiorca)
		{
			super(odbiorca);
		}

		@Override
		public void Wykonaj()
		{
			odbiorca.Uruchom();
		}
	}
	private static class Odbiorca
	{
		public final void Uruchom()
		{
			System.out.println("Wywołano Odbiorca.Uruchom()");
		}
	}
	private static class ObiektWywolujacy
	{
		private Polecenie _polecenie;

		public final void UstawPolecenie(Polecenie polecenie)
		{
			this._polecenie = polecenie;
		}

		public final void WykonajPolecenie()
		{
			_polecenie.Wykonaj();
		}
	}
}