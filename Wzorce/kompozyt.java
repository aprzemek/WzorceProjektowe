package kompozyt;

import java.util.*;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Kompozyt root = new Kompozyt("root");
		root.Dodaj(new Lisc("Lisc A"));
		root.Dodaj(new Lisc("Lisc B"));

		Kompozyt comp = new Kompozyt("Kompozyt X");
		comp.Dodaj(new Lisc("Lisc XA"));
		comp.Dodaj(new Lisc("Lisc XB"));

		root.Dodaj(comp);
		root.Dodaj(new Lisc("Lisc C"));

		Lisc leaf = new Lisc("Lisc D");
		root.Dodaj(leaf);
		root.Usun(leaf);

		root.Pokaz(1);

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Element
	{
		protected String nazwa;

		public Element(String nazwa)
		{
			this.nazwa = nazwa;
		}

		public abstract void Dodaj(Element c);
		public abstract void Usun(Element c);
		public abstract void Pokaz(int poziom);
	}
	private static class Kompozyt extends Element
	{
		private ArrayList<Element> _dzieci = new ArrayList<Element>();

		public Kompozyt(String nazwa)
		{
			super(nazwa);
		}

		@Override
		public void Dodaj(Element element)
		{
			_dzieci.add(element);
		}

		@Override
		public void Usun(Element element)
		{
			_dzieci.remove(element);
		}

		@Override
		public void Pokaz(int poziom)
		{
			System.out.println(tangible.StringHelper.repeatChar('-', poziom) + nazwa);

			for (Element element : _dzieci)
			{
				element.Pokaz(poziom + 2);
			}
		}
	}
	private static class Lisc extends Element
	{
		public Lisc(String nazwa)
		{
			super(nazwa);
		}

		@Override
		public void Dodaj(Element c)
		{
			System.out.println("Nie można dodać do liscia");
		}

		@Override
		public void Usun(Element c)
		{
			System.out.println("Nie można usunąć z liścia");
		}

		@Override
		public void Pokaz(int poziom)
		{
			System.out.println(tangible.StringHelper.repeatChar('-', poziom) + nazwa);
		}
	}
}