public abstract class Fabryka {
    public abstract  PieszaJednostka stworzPieszaJednostke(JednostkaTyp typ);
    public abstract NaziemnaJednostka stworzNaziemnaJednostke(JednostkaTyp typ);
    public abstract PowietrznaJednostka stworzPowietrznaJednostke(JednostkaTyp typ);
}
