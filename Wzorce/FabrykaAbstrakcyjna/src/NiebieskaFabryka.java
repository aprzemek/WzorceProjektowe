public class NiebieskaFabryka extends Fabryka{
    @Override
    public PieszaJednostka stworzPieszaJednostke(JednostkaTyp typ) {
        switch (typ)
        {
            case STRZELEC:
                return new Strzelec(25, 0, 5);
            default:
                throw new java.lang.UnsupportedOperationException("Nieznany typ");
        }
    }

    @Override
    public NaziemnaJednostka stworzNaziemnaJednostke(JednostkaTyp typ) {
        switch (typ)
        {
            case CZOLG:
                return new Czolg(100, 0, 25);
            default:
                throw new java.lang.UnsupportedOperationException("Nieznany typ");
        }
    }

    @Override
    public PowietrznaJednostka stworzPowietrznaJednostke(JednostkaTyp typ) {
        switch (typ)
        {
            case HELIKOPTER:
                return new Helikopter(50, 0, 25);
            default:
                throw new java.lang.UnsupportedOperationException("Nieznany typ");
        }
    }
}
