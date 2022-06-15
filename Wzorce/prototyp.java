package prototyp;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		PrototypY prototyp1 = new PrototypY("I");
		PrototypY klon1 = (PrototypY)prototyp1.Klonuj();
		System.out.printf("Sklonowano: %1$s" + "\r\n", klon1.getId());

		PrototypX prototyp2 = new PrototypX("II");
		PrototypX klon2 = (PrototypX)prototyp2.Klonuj();
		System.out.printf("Sklonowano: %1$s" + "\r\n", klon2.getId());

        Scanner sc = new Scanner(System.in); char ch = sc.next().charAt(0);
	}
	private abstract static class Prototyp
	{
		public Prototyp(String id)
		{
			Id = id;
		}
		private String Id;
		public final String getId()
		{
			return Id;
		}

		public abstract Prototyp Klonuj();
	}
	private static class PrototypX extends Prototyp
	{
		public PrototypX(String id)
		{
			super(id);
		}

		@Override
		public Prototyp Klonuj()
		{
			return (Prototyp)clone();
		}
	}
	private static class PrototypY extends Prototyp
	{
		public PrototypY(String id)
		{
			super(id);
		}

		@Override
		public Prototyp Klonuj()
		{
			return (Prototyp)clone();
		}
	}
}