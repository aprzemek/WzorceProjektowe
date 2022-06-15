public class Main {
    public static void main(String[] args) {
        Fabryka niebieskaFabryka = new NiebieskaFabryka();
        Fabryka czerwonaFabryka = new CzerwonaFabryka();

        NaziemnaJednostka czerwonyCzolg = czerwonaFabryka.stworzNaziemnaJednostke(JednostkaTyp.CZOLG);
        PieszaJednostka czerwonyWojskowy = czerwonaFabryka.stworzPieszaJednostke(JednostkaTyp.STRZELEC);

        NaziemnaJednostka niebieskiCzolg = niebieskaFabryka.stworzNaziemnaJednostke(JednostkaTyp.CZOLG);
        PieszaJednostka niebieskiWojskowy = niebieskaFabryka.stworzPieszaJednostke(JednostkaTyp.STRZELEC);

        PowietrznaJednostka niebieskiHelikopter = niebieskaFabryka.stworzPowietrznaJednostke(JednostkaTyp.HELIKOPTER);
        PowietrznaJednostka czerwonyHelikopter = czerwonaFabryka.stworzPowietrznaJednostke(JednostkaTyp.HELIKOPTER);

        System.out.println("Czerwony czołg - życie:");
        System.out.println(czerwonyCzolg.Zycie);
        System.out.println("Niebieski czołg - życie:");
        System.out.println(niebieskiCzolg.Zycie);

        System.out.println(czerwonyWojskowy.Zycie);
        System.out.println(niebieskiWojskowy.Zycie);

        System.out.println(niebieskiHelikopter.Zycie);
        System.out.println(czerwonyHelikopter.Zycie);
    }
}
