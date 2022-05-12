import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {
        Universite bogazici = new Universite("bogazici", "matematik ", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik ", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk ", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh ", 1071, 77);
        Universite ytu = new Universite("yildiz teknik", "gemi ", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, istanbul, itu, marmara, ytu));

        System.out.println(notort74buyuk(unv));
        System.out.print("\n    ***      ");
        ogrSayisi110Azmi(unv);
        System.out.print("\n    ***      ");
        MatBolumVarmi(unv);
        System.out.print("\n    ***      ");
        ogr3enciSayiBkSirala(unv);
        System.out.print("\n    ***      ");
        System.out.println(notOrtBkSirala(unv));
        System.out.print("\n    ***      ");
        System.out.println(ogrenciSayiEnAzSirala(unv));
        System.out.print("\n    ***      ");
        System.out.println(notOrt63BuyukSirala(unv));
        System.out.print("\n    ***      ");
        System.out.println(ogrSayisi333BNotortOrtalamasi(unv));
        System.out.print("\n    ***      ");
        System.out.println(matematikBolSayiPrint(unv));
        System.out.print("\n    ***      ");
        System.out.println(ogrSayisi571BnotOrt(unv));
        System.out.print("\n    ***      ");
        System.out.println(ogrSayiazen1071KucukNotOrt(unv));


    }

    // task 01 not ort 74 den buyuk  olanlari print et


    public static boolean notort74buyuk(List<Universite> unv) {

        return unv.stream().allMatch(t -> t.getNotOrt() > 74);
    }
    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.

    public static boolean ogrSayisi110Azmi(List<Universite> unv) {
        return unv.stream().allMatch(t -> t.getOgrSayisi() > 110);
    }


    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean MatBolumVarmi(List<Universite> unv) {
        return unv.stream().anyMatch(t -> t.getBolum().contains("matematik"));
    }


    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Universite> ogr3enciSayiBkSirala(List<Universite> unv) {
        return unv.stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                collect(Collectors.toList());  ////collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
    }

    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.

    public static List<Universite> notOrtBkSirala(List<Universite> unv) {
        return unv.stream().
                sorted(Comparator.comparing(Universite::getNotOrt).reversed()).
                limit(3).
                collect(Collectors.toList());
    }


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static List<Universite> ogrenciSayiEnAzSirala(List<Universite> unv) {
        return unv.stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi)).limit(2).skip(1).
                collect(Collectors.toList());
    }


    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz.
    public static int notOrt63BuyukSirala(List<Universite> unv) {
        return
                unv.stream().filter(t -> t.getNotOrt() > 63).
                        mapToInt(t -> t.getOgrSayisi()).
                        sum();
        //map(t -> t.getOgrSayisi()).
        //reduce(Math::addExact);
        // reduce(Math::sum);
        //   reduce(0, (t, u) -> t + u));
    }

    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.

    public static OptionalDouble ogrSayisi333BNotortOrtalamasi(List<Universite> unv) {
        return unv.stream().filter(t -> t.getOgrSayisi() > 333).
                mapToDouble(t -> t.getNotOrt()).
                average();  // akistaki elemanlarin ortalamasi alindi
    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.

    public static long matematikBolSayiPrint(List<Universite> unv) {

        return unv.stream().
                filter(t -> t.getBolum().contains("matematik")).
                count();

    }
    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.

    public static OptionalInt ogrSayisi571BnotOrt(List<Universite> unv) {
        return unv.stream().
                filter(t -> t.getOgrSayisi() > 571).
                mapToInt(t -> t.getNotOrt()).
                max();   // akisin en buyuk degerini return eder


    }

    //task 11-->Ogrenci sayilari 150'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogrSayiazen1071KucukNotOrt(List<Universite> unv) {

        return unv.stream().
                filter(t -> t.getOgrSayisi() < 1071).
                mapToInt(t -> t.getNotOrt()).
                min();
    }

}
