package odwiedzajacy;

import java.util.*;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Struktura o = new Struktura();
		o.Dolacz(new SpecyficznyElement());
		o.Dolacz(new InnySpecyficznyElement());

		SpecyficznyOdwiedzajacy v1 = new SpecyficznyOdwiedzajacy();
		InnySpecyficznyOdwiedzajacy v2 = new InnySpecyficznyOdwiedzajacy();

		o.Akceptuj(v1);
		o.Akceptuj(v2);

		Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Element
	{
		public abstract void Akceptuj(Odwiedzajacy odwiedzajacy);
	}
	private static class SpecyficznyElement extends Element
	{
		@Override
		public void Akceptuj(Odwiedzajacy odwiedzajacy)
		{
			odwiedzajacy.OdwiedzSpecyficznyElement(this);
		}

		public final void ZrobCos()
		{
		}
	}
	private static class InnySpecyficznyElement extends Element
	{
		@Override
		public void Akceptuj(Odwiedzajacy odwiedzajacy)
		{
			odwiedzajacy.OdwiedzInnySpecyficznyElement(this);
		}

		public final void ZrobCos()
		{
		}
	}
	private abstract static class Odwiedzajacy
	{
		public abstract void OdwiedzSpecyficznyElement(SpecyficznyElement specyficznyElement);
		public abstract void OdwiedzInnySpecyficznyElement(InnySpecyficznyElement innySpecyficznyElement);
	}
	private static class SpecyficznyOdwiedzajacy extends Odwiedzajacy
	{
		@Override
		public void OdwiedzSpecyficznyElement(SpecyficznyElement specyficznyElement)
		{
			System.out.printf("%1$s odwiedzony przez %2$s" + "\r\n", specyficznyElement.getClass().getSimpleName(), this.getClass().getSimpleName());
		}

		@Override
		public void OdwiedzInnySpecyficznyElement(InnySpecyficznyElement innySpecyficznyElement)
		{
			System.out.printf("%1$s odwiedzony przez %2$s" + "\r\n", innySpecyficznyElement.getClass().getSimpleName(), this.getClass().getSimpleName());
		}
	}
	private static class InnySpecyficznyOdwiedzajacy extends Odwiedzajacy
	{
		@Override
		public void OdwiedzSpecyficznyElement(SpecyficznyElement specyficznyElement)
		{
			System.out.printf("%1$s odwiedzony przez %2$s" + "\r\n", specyficznyElement.getClass().getSimpleName(), this.getClass().getSimpleName());
		}

		@Override
		public void OdwiedzInnySpecyficznyElement(InnySpecyficznyElement innySpecyficznyElement)
		{
			System.out.printf("%1$s odwiedzony przez %2$s" + "\r\n", innySpecyficznyElement.getClass().getSimpleName(), this.getClass().getSimpleName());
		}
	}
	private static class Struktura
	{
		private ArrayList<Element> elementy = new ArrayList<Element>();

		public final void Dolacz(Element element)
		{
			elementy.add(element);
		}

		public final void Odlacz(Element element)
		{
			elementy.remove(element);
		}

		public final void Akceptuj(Odwiedzajacy odwiedzajacy)
		{
			for (Element element : elementy)
			{
				element.Akceptuj(odwiedzajacy);
			}
		}
	}
}