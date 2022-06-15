package iterator;

import java.util.*;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{

		MenadzerImion nm = new MenadzerImion();

		nm.set(0, "Piotr");
		nm.set(1, "Jan");
		nm.set(2, "Marta");
		nm.set(3, "Szymon");
		nm.set(4, "Ania");

		Iterator iterator = nm.StworzIterator();

		System.out.println("Iteracja kolekcji:");

		Object element = iterator.Pierwszy();
		while (element != null)
		{
			System.out.println(element);
			element = iterator.Nastepny();
		}

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Iterator
	{
		public abstract Object Pierwszy();
		public abstract Object Nastepny();
		public abstract boolean CzyKoniec();
		public abstract Object PobierzElement();
	}
	private static class MenadzerImionIterator extends Iterator
	{
		private MenadzerImion _kontener;
		private int _obecny = 0;

		public MenadzerImionIterator(MenadzerImion kontener)
		{
			_kontener = kontener;
		}

		@Override
		public Object Pierwszy()
		{
			return _kontener.get(0);
		}

		@Override
		public Object Nastepny()
		{
			Object ret = null;
			if (_obecny < _kontener.getIlosc() - 1)
			{
				ret = _kontener.get(++_obecny);
			}

			return ret;
		}

		@Override
		public Object PobierzElement()
		{
			return _kontener.get(_obecny);
		}

		@Override
		public boolean CzyKoniec()
		{
			return _obecny >= _kontener.getIlosc();
		}
	}
	private abstract static class Menadzer
	{
		public abstract Iterator StworzIterator();
	}
	private static class MenadzerImion extends Menadzer
	{
		private ArrayList _elementy = new ArrayList();

		@Override
		public Iterator StworzIterator()
		{
			return new MenadzerImionIterator(this);
		}

		public final int getIlosc()
		{
			return _elementy.size();
		}

		public final Object get(int index)
		{
			return _elementy.get(index);
		}
		public final void set(int index, Object value)
		{
			_elementy.add(index, value);
		}
	}
}