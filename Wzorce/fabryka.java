package fabryka;
import java.util.Scanner;
public class Program
{
	public static void main(String[] args)
	{
		Fabryka fabryka = new JednostkaFabryka();

		Jednostka czolg = fabryka.stworzJednostke(JednostkaTyp.CZOLG);
		Jednostka wojskowy = fabryka.stworzJednostke(JednostkaTyp.STRZELEC);

		System.out.println(czolg.getSilaZniszczen());
		System.out.println(wojskowy.getSilaZniszczen());
		System.out.println(czolg.getZycie());
		System.out.println(wojskowy.getZycie());

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	public abstract static class Jednostka
	{
		protected Jednostka(int zycie, int doswiadczenie, int silaZniszczen)
		{
			this.setZycie(zycie);
			this.setDoswiadczenie(doswiadczenie);
			this.setSilaZniszczen(silaZniszczen);
		}

		private int zycie;
		public final int getZycie()
		{
			return zycie;
		}
		public final void setZycie(int value)
		{
			zycie = value;
		}

		private int doswiadczenie;
		public final int getDoswiadczenie()
		{
			return doswiadczenie;
		}
		public final void setDoswiadczenie(int value)
		{
			doswiadczenie = value;
		}

		private int silaZniszczen;
		public final int getSilaZniszczen()
		{
			return silaZniszczen;
		}
		public final void setSilaZniszczen(int value)
		{
			silaZniszczen = value;
		}
	}
	public static class Strzelec extends Jednostka
	{

		public Strzelec(int zycie, int doswiadczenie, int silaZniszczen)
		{
			super(zycie, doswiadczenie, silaZniszczen);
		}
	}

	public static class Czolg extends Jednostka
	{

		public Czolg(int zycie, int doswiadczenie, int silaZniszczen)
		{
			super(zycie, doswiadczenie, silaZniszczen);
		}
	}
	public abstract static class Fabryka
	{
		public abstract Jednostka stworzJednostke(JednostkaTyp type);
	}

	public enum JednostkaTyp
	{
		STRZELEC,
		CZOLG;

		public static final int SIZE = java.lang.Integer.SIZE;

		public int getValue()
		{
			return this.ordinal();
		}

		public static JednostkaTyp forValue(int value)
		{
			return values()[value];
		}
	}
	public static class JednostkaFabryka extends Fabryka
	{

		@Override
		public Jednostka stworzJednostke(JednostkaTyp jednostkaTyp)
		{

			switch (jednostkaTyp)
			{
				case CZOLG:
					return new Czolg(100, 0, 20);
				case STRZELEC:
					return new Strzelec(25, 0, 10);
				default:
					throw new UnsupportedOperationException("Nie ma takiego typu");
			};
		}

	}
}