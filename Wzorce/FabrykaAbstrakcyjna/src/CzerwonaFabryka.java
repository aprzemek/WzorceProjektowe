public class CzerwonaFabryka extends  Fabryka{
    @Override
    public PieszaJednostka stworzPieszaJednostke(JednostkaTyp typ) {
        switch (typ)
        {
            case STRZELEC:
                return new Strzelec(80, 0, 500);
            default:
                throw new java.lang.UnsupportedOperationException("Nieznany typ");
        }
    }

    @Override
    public NaziemnaJednostka stworzNaziemnaJednostke(JednostkaTyp typ) {
        switch (typ)
        {
            case CZOLG:
                return new Czolg(200, 0, 8990);
            default:
                throw new java.lang.UnsupportedOperationException("Nieznany typ");
        }
    }

    @Override
    public PowietrznaJednostka stworzPowietrznaJednostke(JednostkaTyp typ) {
        switch (typ)
        {
            case HELIKOPTER:
                return new Helikopter(440, 0, 335);
            default:
                throw new java.lang.UnsupportedOperationException("Nieznany typ");
        }
    }
}
