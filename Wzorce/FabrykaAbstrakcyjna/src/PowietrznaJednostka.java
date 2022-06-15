public abstract class PowietrznaJednostka {
    protected  PowietrznaJednostka(int zycie, int doswiadczenie, int silaZniszczen)
    {
        this.Zycie = zycie;
        this.Doswiadczenie = doswiadczenie;
        this.SilaZniszczen = silaZniszczen;
    }

    public int Zycie;
    public int getZycie(){return this.Zycie;}
    public void setZycie(int Zycie) { this.Zycie = Zycie; }

    public int Doswiadczenie;
    public int getDoswiadczenie(){return this.Doswiadczenie;}
    public void setDoswiadczenie(int Doswiadczenie) { this.Doswiadczenie = Doswiadczenie; }

    public int SilaZniszczen;
    public int getSilaZniszczen(){return this.SilaZniszczen;}
    public void setSilaZniszczen(int SilaZniszczen) { this.SilaZniszczen = SilaZniszczen; }
}
